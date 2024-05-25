import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GamePlay {
	public static String log = "";
	public static String oldlog = "";

	// game in non graphics mode
	public static void nonGraphic() {
		// setup board
		Chess.boardSetup();
		// showing board for first time
		Chess.boardPrint();
		// placing initial obstacles
		Obstacles.whiteObstacle();
		Obstacles.blackObstacle();

		System.out.println();
		// white player starts
		int player = 20;
		int whiteWallCounter = 0;
		int blackWallCounter = 0;
		int checkR = 0;
		int checkF = 0;
		boolean checks = false;
		while (true) {
			System.out.println();
			System.out.println("If you would like to place an wall type 'wall' ");
			System.out.println();
			if (player == 20) {
				System.out.println("Whites turn");
			} else {
				System.out.println("Blacks turn");
			}

			Chess.boardPrint();
			System.out.println();
			if (player == 20) {
				System.out.println("White player please make a move");
			} else {
				System.out.println("Black player please make a move");
			}
			Scanner nameless = new Scanner(System.in);
			String block = nameless.next();
			int obs = (int) block.charAt(0);
			// choice to place a wall
			if (obs == 119 && ((player == 20 && whiteWallCounter < 3) || (player == -20 && blackWallCounter < 3))) {

				Obstacles.walls(player, whiteWallCounter, blackWallCounter);
				if (player == 20) {
					whiteWallCounter++;
				}
				if (player == -20) {
					blackWallCounter++;
				}

				// changing player
				player = player * (-1);
			} else {
				int fRank, tRank, fFile, tFile;
				if (obs == 119
						&& ((player == 20 && whiteWallCounter >= 3) || (player == -20 && blackWallCounter >= 3))) {
					System.out.println("You have no walls left...Please enter a move");

					String piece = nameless.next();
					char fromFile, fromRank, toFile, toRank;
					fromRank = piece.charAt(1);
					fromFile = piece.charAt(0);
					toRank = piece.charAt(3);
					toFile = piece.charAt(2);

					fRank = (int) piece.charAt(1) - 48;
					fRank = 8 - fRank;
					fFile = ((int) (piece.charAt(0))) - 97;
					tRank = (int) piece.charAt(3) - 48;
					tRank = 8 - tRank;
					tFile = ((int) (piece.charAt(2))) - 97;
				}
				// making a move for both players
				else {
					char fromFile, fromRank, toFile, toRank;
					fromRank = block.charAt(1);
					fromFile = block.charAt(0);
					toRank = block.charAt(3);
					toFile = block.charAt(2);

					fRank = (int) block.charAt(1) - 48;
					fRank = 8 - fRank;
					fFile = ((int) (block.charAt(0))) - 97;
					tRank = (int) block.charAt(3) - 48;
					tRank = 8 - tRank;
					tFile = ((int) (block.charAt(2))) - 97;
				}
				// System.out.println(fRank);
				// System.out.println(fFile);
				// System.out.println(tRank);
				// System.out.println(tFile);
				if (ObstacleCheck.obsType(fRank, fFile, tRank, tFile, player, Chess.board, false) == false) {
					if (Chess.isValidMove(fRank, fFile, tRank, tFile, player, false)) {
						Chess.makeMove(fRank, fFile, tRank, tFile);
						Chess.boardPrint();
						// changing player
						player = player * (-1);
					} else {
						System.out.println("INVALID MOVE!");
					}
				} else {
					// changing player
					player = player * (-1);
					System.out.println("Oops...there was an obstacle in the way :(");
				}
			} // check
				// find king
			checks = false;
			String check = "check.png";
			int kingR = 0;
			int kingF = 0;
			for (int k = 0; k <= 8; k++) {
				for (int q = 0; q <= 8; q++) {
					if (Chess.board[k][q] == 1) {

						for (int a = 0; a <= 7; a++) {
							for (int b = 0; b <= 7; b++) {

								if (Chess.isValidMove(a, b, k, q, player * (-1), false) == true) {

									StdDraw.setPenColor(StdDraw.RED);
									StdDraw.square(b * 10 + 10, a * 10 + 10, 5);
									StdDraw.picture(50, 95, check);
									StdDraw.show();
									checks = true;
									kingR = k;
									kingF = q;
									checkR = a;
									checkF = b;
								}
							}

						}

					}
					if (Chess.board[k][q] == -1) {
						for (int a = 0; a <= 7; a++) {
							for (int b = 0; b <= 7; b++) {

								if (Chess.isValidMove(a, b, k, q, player * (-1), false) == true) {

									StdDraw.setPenColor(StdDraw.RED);
									StdDraw.square(b * 10 + 10, a * 10 + 10, 5);
									StdDraw.picture(50, 95, check);
									StdDraw.show();
									checks = true;
									kingR = k;
									kingF = q;
									checkR = a;
									checkF = b;
								}
							}

						}
					}
				}
			}
		}

	}

	// game in graphic mode
	public static void Graphic() {
		int player = 20;
		int pixel = 800;
		int saveToRank = 0;
		int saveToFile = 0;
		int saveFromRank = 0;
		int saveFromFile = 0;
		int undoCount = 0;

		String oldLog = "";
		StdDraw.setCanvasSize(pixel, pixel);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(100, 0);
		Chess.boardSetup();
		Chess.drawBoard(player);

		// traps and mines
		GraphicObstacle.obs();
		StdDraw.show(200);
		Chess.drawBoard(player);

		// making a move

		boolean checks = false;
		boolean game = true;
		int whiteWallCounter = 0;
		int blackWallCounter = 0;
		int checkR = 0;
		int checkF = 0;
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "BEGIN GAME: WHITE STARTS");
		StdDraw.show(2000);
		Chess.drawBoard(20);
		while (game) {
			StdDraw.show(200);
			Chess.players = 0;

			//System.out.println(log);

			int fromRank = 0;
			int fromFile = 0;
			if (checks == true) {
				for (int k = 0; k <= 8; k++) {
					for (int q = 0; q <= 8; q++) {
						if ((Chess.board[k][q] == 1 && player == 20) || (Chess.board[k][q] == -1 && player == -20)) {
							fromRank = k;
							fromFile = q;
						}
					}
				}

			} else {
				boolean from = true;

				fromRank = 0;
				fromFile = 0;
				while (from) {
					if (StdDraw.mousePressed()) {
						fromRank = (int) (StdDraw.mouseY() - 5) / 10;
						fromFile = (int) (StdDraw.mouseX() - 5) / 10;
						from = false;

					}
				}
			}
			// System.out.println(fromRank + " " + fromFile);
			StdDraw.show(200);
			// undo
			if ((fromRank == 8 || fromRank == 9) && (fromFile == 3 || fromFile == 3) && undoCount == 0) {
				for (int a = 0; a < 9; a++) {
					for (int b = 0; b < 9; b++) {
						Chess.board[a][b] = Chess.saveBoard[a][b];
					}
				}

				undoCount++;
				player = player * (-1);
				Chess.drawBoard(player);
				StdDraw.show(1000);
				GamePlay.gamelog("", true);
			}

			else {

				if ((fromRank == 8 || fromRank == 9) && (fromFile == 8 || fromFile == 9)) {
					System.exit(0);
				}
				// highlight move options
				int checkmate;
				if (checks == true) {
					checkmate = 0;
					for (int r = 0; r <= 7; r++) {
						for (int c = 0; c <= 7; c++) {
							if ((Chess.isValidMove(fromRank, fromFile, r, c, player, false) == true)
									&& ((Chess.isValidMove(checkR, checkF, r, c, player * (-1), false) == false))) {

								StdDraw.setPenColor(StdDraw.BLUE);
								StdDraw.square(c * 10 + 10, r * 10 + 10, 5);
								StdDraw.show();
								checkmate++;

							}
						}

					}
					if (checkmate == 0) {
						String checkMate = "checkmate.png";
						String whitewin = "wwin.png";
						String blackwin = "bwin.png";
						String white = "white.png";
						String black = "black.png";
						Chess.drawBoard(player * (-1));
						StdDraw.picture(55, 95, checkMate);
						StdDraw.show();
						StdDraw.setPenColor(54, 69, 79);
						StdDraw.filledRectangle(45, 45, 30, 30);
						if (player == 20) {
							StdDraw.picture(45, 35, blackwin);
							StdDraw.picture(45, 60, black, 20, 20);
						} else {
							StdDraw.picture(45, 35, whitewin);
							StdDraw.picture(45, 60, white, 20, 20);
						}
						StdDraw.show(5000);
						System.exit(0);
					}
				} else {
					for (int r = 0; r <= 7; r++) {
						for (int c = 0; c <= 7; c++) {
							if (Chess.isValidMove(fromRank, fromFile, r, c, player, false) == true) {

								StdDraw.setPenColor(StdDraw.GREEN);
								StdDraw.square(c * 10 + 10, r * 10 + 10, 5);
								StdDraw.show();
							}
						}

					}
				}
				// walls
				if ((fromRank == 8 || fromRank == 9) && (fromFile == 1 || fromFile == 1)
						&& ((player == 20 && whiteWallCounter <= 3) || (player == -20 && blackWallCounter <= 3))) {

					if ((player == 20 && whiteWallCounter >= 3) || (player == -20 && blackWallCounter >= 3)) {
						Font wall = new Font("Aharoni", Font.BOLD, 30);
						StdDraw.setFont(wall);
						StdDraw.text(45, 95, "OUT OF WALLS!");
					} else {
						GraphicObstacle.walls(player, whiteWallCounter, blackWallCounter);

						if (player == 20) {
							whiteWallCounter++;
						}
						if (player == -20) {
							blackWallCounter++;
						}
						player = player * (-1);
						Chess.drawBoard(player);
					}
					StdDraw.show(700);
				} else {
					boolean to = true;
					int toRank = 0;
					int toFile = 0;
					while (to) {
						if (StdDraw.mousePressed()) {
							toRank = (int) (StdDraw.mouseY() - 5) / 10;
							toFile = (int) (StdDraw.mouseX() - 5) / 10;
							to = false;

						}

					}
					// save board
					for (int a = 0; a < 9; a++) {
						for (int b = 0; b < 9; b++) {
							Chess.saveBoard[a][b] = Chess.board[a][b];
						}
					}
					boolean playerchange = false;
					// promotion
					if ((Chess.board[fromRank][fromFile] == 6 || Chess.board[fromRank][fromFile] == -6)
							&& ((player == 20 && toRank == 0) || (player == -20 && toRank == 7))) {
						if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
							Chess.promotion('g', fromRank, fromFile, toRank, toFile, player);
							player = player * (-1);
						}
					} else if (ObstacleCheck.obsType(fromRank, fromFile, toRank, toFile, player, Chess.board,
							playerchange) == false) {
						if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
							Chess.makeMove(fromRank, fromFile, toRank, toFile);
							saveFromRank = toRank;
							saveFromFile = toFile;
							saveToRank = fromRank;
							saveToFile = fromFile;
							undoCount = 0;
							player = player * (-1);
							GamePlay.gamelog( Chess.logConvert(fromFile) + (8 - fromRank) + "-"
									+ Chess.logConvert(toFile) + (8 - toRank)+'\n' , false);
							// log = log + '\n' + Chess.logConvert(fromFile) + (8 - fromRank) + "-"
							// + Chess.logConvert(toFile) + (8 - toRank);
							// log =Chess.logConvert(fromFile)+fromRank+"-"+Chess.logConvert(toFile)+toRank;

						} else {
							StdDraw.setPenColor(StdDraw.BLACK);
							Font invalidMove = new Font("Aharoni", Font.BOLD, 30);
							StdDraw.setFont(invalidMove);
							StdDraw.text(50, 95, "ERROR: INVALID MOVE");
							StdDraw.show(1500);

						}
					} else {
						if (Chess.players == 0) {
							player = player * (-1);
						}
						StdDraw.setPenColor(StdDraw.BLACK);
						Font elseobs = new Font("Aharoni", Font.BOLD, 30);
						StdDraw.setFont(elseobs);
						StdDraw.text(45, 95, "OBSTACLE!!!");
						StdDraw.show(1500);
					}
					StdDraw.show(5);
					Chess.drawBoard(player);
					StdDraw.show(500);
				}
				// check
				// find king
				checks = false;
				String check = "check.png";
				int kingR = 0;
				int kingF = 0;
				for (int k = 0; k <= 8; k++) {
					for (int q = 0; q <= 8; q++) {
						if (Chess.board[k][q] == 1) {

							for (int a = 0; a <= 7; a++) {
								for (int b = 0; b <= 7; b++) {

									if (Chess.isValidMove(a, b, k, q, player * (-1), false) == true) {

										StdDraw.setPenColor(StdDraw.RED);
										StdDraw.square(b * 10 + 10, a * 10 + 10, 5);
										StdDraw.picture(50, 95, check);
										StdDraw.show();
										checks = true;
										kingR = k;
										kingF = q;
										checkR = a;
										checkF = b;
									}
								}

							}

						}
						if (Chess.board[k][q] == -1) {
							for (int a = 0; a <= 7; a++) {
								for (int b = 0; b <= 7; b++) {

									if (Chess.isValidMove(a, b, k, q, player * (-1), false) == true) {

										StdDraw.setPenColor(StdDraw.RED);
										StdDraw.square(b * 10 + 10, a * 10 + 10, 5);
										StdDraw.picture(50, 95, check);
										StdDraw.show();
										checks = true;
										kingR = k;
										kingF = q;
										checkR = a;
										checkF = b;
									}
								}

							}
						}
					}
				}

			}

		}

	}

	// test mode for files
	public static void testMode(String set, File game, File output, int a, int b, int c, int d, int e, int f, int g,
			int h, int statuslength) throws FileNotFoundException {
		boolean validBoard = true;
		// reading board file
		// System.out.println(set);
		String line1 = set.substring(0, a);
		String line2 = set.substring(0 + a, a + b);
		String line3 = set.substring(a + b, a + b + c);
		String line4 = set.substring(a + b + c, a + b + c + d);
		String line5 = set.substring(a + b + c + d, a + b + c + d + e);
		String line6 = set.substring(a + b + c + d + e, a + b + c + d + e + f);
		String line7 = set.substring(a + b + c + d + e + f, a + b + c + d + e + f + g);
		String line8 = set.substring(a + b + c + d + e + f + g, a + b + c + d + e + f + g + h);
		String statusline = set.substring(a + b + c + d + e + f + g + h, a + b + c + d + e + f + g + h + statuslength);

		// System.out.println(statusline);
		if (statuslength != 14) {
			validBoard = false;
			Chess.invalidBoard = true;
			Chess.imove = "status line";
			statusline = statusline + "              ";
		} else if (statusline.charAt(12) != ' ') {
			validBoard = false;
			Chess.invalidBoard = true;
			Chess.imove = "status line";
		}
		int ww = statusline.charAt(2) - 48;
		int bw = statusline.charAt(4) - 48;
	 //System.out.println(ww +"   "+bw);

		Chess.convert(line1, line2, line3, line4, line5, line6, line7, line8);
		//Chess.filePrint();
		if (Chess.boardCheck(ww, bw) == false && validBoard == true) {
			
			validBoard = false;
			Chess.invalidBoard = true;
			
		}
		if (!Chess.lineCheck(line1, 8) || !Chess.lineCheck(line2, 7) || !Chess.lineCheck(line3, 6)
				|| !Chess.lineCheck(line4, 5) || !Chess.lineCheck(line5, 4) || !Chess.lineCheck(line6, 3)
				|| !Chess.lineCheck(line7, 2) || !Chess.lineCheck(line8, 1)) {
			validBoard = false;
			Chess.invalidMove = true;
			
		}
		String statuscheck = Chess.status(20, ww, bw, 0);

		// System.out.println(statuscheck);
		int s1 = (int) statuscheck.substring(6, 10).charAt(0) + (int) statuscheck.substring(6, 10).charAt(1)
				+ (int) statuscheck.substring(6, 10).charAt(2) + (int) statuscheck.substring(6, 10).charAt(3);
		int s2 = (int) statusline.substring(6, 10).charAt(0) + (int) statusline.substring(6, 10).charAt(1)
				+ (int) statusline.substring(6, 10).charAt(2) + (int) statusline.substring(6, 10).charAt(3);
		// System.out.println(s1);
		// System.out.println(s2);
		if (s1 != s2) {
			validBoard = false;
			Chess.invalidBoard = true;
			Chess.imove = "status line";
		// System.out.println("ss");

		}
		// Chess.boardPrint();

		// reading file moves
		int player = 20;
		int clockvalue = 0;
		// Create a stream to hold the output
		ByteArrayOutputStream bord = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bord);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;

		Scanner mov = new Scanner(game);
		//System.out.println(validBoard);
		if (validBoard) {
			
			boolean check = false;
			while (mov.hasNextLine()) {
				//System.out.println(check);
				String move = mov.nextLine();
				if (Chess.check(check) == true) {
					check = true;
				} else {
					check = false;
				}
				// System.out.println(move);
				Chess.moveRead(move, player);
				if (check == true) {
					if (Chess.check(check) == true) {
						Chess.invalidMove = true;
						Chess.imove = move;
					}
				}
				// changing player
				player = player * (-1);

				// Chess.boardPrint();
				// System.out.println(move);
			}
		}
		// Tell Java to use your special stream
		System.setOut(ps);
		if (Chess.invalidMove == true) {
			System.out.println("ERROR: illegal move " + Chess.imove);

		} else if (Chess.invalidBoard) {
			System.out.println("ERROR: illegal board at " + Chess.imove);
		} else {
			Chess.filePrint();
			System.out.println(Chess.status(player, Chess.wcount, Chess.bcount, clockvalue));
		}
		// Put things back
		System.out.flush();
		System.setOut(old);
		String boord = bord.toString();
		System.out.println(boord);
		// writing to output file

		PrintWriter name = new PrintWriter(output);
		name.print(boord);
		name.close();

	}
// gamelog
	public static void gamelog(String newest, boolean undo) {
		
		if (undo == false) {
			oldlog = log;
		} else if (undo == true) {
			log = oldlog;
		}
		log = log + newest;

		// log
		File logging = new File("gamelog.txt");
		try {
			if (!logging.exists()) {
				logging.createNewFile();
			}
			PrintWriter name = new PrintWriter(logging);
			// name.println(oldLog);
			name.println(log);
			;
			name.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // oldLog = oldLog+System.getProperty("file.separator")+log;
	}
}
