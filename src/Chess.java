import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
	// empty block
	public static final int empty = 0;
	public static final int white = 20;
	public static final int black = -20;
	public static int players = 0;
	public static int wcount = 0;
	public static int bcount = 0;
	public static boolean checkmate = false;
	public static boolean invalidMove = false;
	public static boolean invalidBoard = false;
	public static String imove = "";
	public static String castlingline = "";
	public static String playline = "";
	public static int clocking = 0;
	// white pieces (positive)
	public static final int whiteKing = 1;
	public static final int whiteQueen = 2;
	public static final int whiteRook = 3;
	public static final int whiteBishop = 4;
	public static final int whiteKnight = 5;
	public static final int whitePawn = 6;
	public static final int whiteHiddenTrap = 7;
	public static final int whiteOpenTrap = 8;
	public static final int whiteMine = 9;
	public static final int whiteSouthWall = 10;
	public static final int whiteWestWall = 11;
	public static final int whiteWSWall = 12;
	public static final int X = 13;
	// black pieces (negative)
	public static final int blackKing = -1;
	public static final int blackQueen = -2;
	public static final int blackRook = -3;
	public static final int blackBishop = -4;
	public static final int blackKnight = -5;
	public static final int blackPawn = -6;
	public static final int blackHiddenTrap = -7;
	public static final int blackOpenTrap = -8;
	public static final int blackMine = -9;
	public static final int blackSouthWall = -10;
	public static final int blackWestWall = -11;
	public static final int blackWSWall = -12;
	// initializing board
	public static int[][] board = new int[9][9];
	public static int[][] saveBoard = new int[9][9];

	// setting up board at the start of a game
	public static void boardSetup() {
		// making the board
		for (int r = 0; r <= 8; r++) {
			for (int c = 0; c <= 8; c++) {
				if (r >= 2 && r <= 6) {
					board[r][c] = 0;
				}
				if (r == 1) {
					board[r][c] = -6;

				}
				if (r == 6) {
					board[r][c] = 6;

				}
			}
		}
		board[0][0] = -3;
		board[0][1] = -5;
		board[0][2] = -4;
		board[0][3] = -1;
		board[0][4] = -2;
		board[0][5] = -4;
		board[0][6] = -5;
		board[0][7] = -3;
		board[7][0] = 3;
		board[7][1] = 5;
		board[7][2] = 4;
		board[7][3] = 1;
		board[7][4] = 2;
		board[7][5] = 4;
		board[7][6] = 5;
		board[7][7] = 3;

	}

	// printing the board in the terminal
	public static void boardPrint() {

		// Giving the pieces symbols

		// White
		String WhiteKing = "K";
		String WhiteQueen = "Q";
		String WhiteRook = "R";
		String WhiteBishop = "B";
		String WhiteKnight = "N";
		String WhitePawn = "P";
		String WhiteHiddenTrap = "D";
		String WhiteOpenTrap = "O";
		String WhiteMine = "M";
		String WhiteSouthWall = "_";
		String WhiteWestWall = "|";
		String WhiteWSWall = "|_";
		// Black
		String BlackKing = "k";
		String BlackQueen = "q";
		String BlackRook = "r";
		String BlackBishop = "b";
		String BlackKnight = "n";
		String BlackPawn = "p";
		String BlackHiddenTrap = "d";
		String BlackOpenTrap = "o";
		String BlackMine = "m";
		String BlackSouthWall = "_";
		String BlackWestWall = "|";
		String BlackWSWall = "|_";

		// setting up files and ranks
		String letters = "  a  b  c  d  e  f  g  h ";
		String numbers = "87654321";
		// printing letters to represent pieces
		for (int r = 0; r <= 7; r++) {
			System.out.print("" + numbers.charAt(r) + " ");
			for (int c = 0; c <= 7; c++) {
				if (board[r][c] == 0) {
					System.out.print("  .");
				} else if (board[r][c] == 1) {
					System.out.print("  " + WhiteKing + "");
				} else if (board[r][c] == 2) {
					System.out.print("  " + WhiteQueen + "");
				} else if (board[r][c] == 3) {
					System.out.print("  " + WhiteRook + "");
				} else if (board[r][c] == 4) {
					System.out.print("  " + WhiteBishop + "");
				} else if (board[r][c] == 5) {
					System.out.print("  " + WhiteKnight + "");
				} else if (board[r][c] == 6) {
					System.out.print("  " + WhitePawn + "");
				} else if (board[r][c] == 7) {
					System.out.print("  " + WhiteHiddenTrap + "");
				} else if (board[r][c] == 8) {
					System.out.print("  " + WhiteOpenTrap + "");
				} else if (board[r][c] == 9) {
					System.out.print("  " + WhiteMine + "");
				} else if (board[r][c] == 10) {
					System.out.print("  " + WhiteSouthWall + "");
				} else if (board[r][c] == 11) {
					System.out.print("  " + WhiteWestWall);
				} else if (board[r][c] == 12) {
					System.out.print("  " + WhiteWSWall);
				} else if (board[r][c] == -1) {
					System.out.print("  " + BlackKing + "");
				} else if (board[r][c] == -2) {
					System.out.print("  " + BlackQueen + "");
				} else if (board[r][c] == -3) {
					System.out.print("  " + BlackRook + "");
				} else if (board[r][c] == -4) {
					System.out.print("  " + BlackBishop + "");
				} else if (board[r][c] == -5) {
					System.out.print("  " + BlackKnight + "");
				} else if (board[r][c] == -6) {
					System.out.print("  " + BlackPawn + "");
				} else if (board[r][c] == -7) {
					System.out.print("  " + BlackHiddenTrap + "");
				} else if (board[r][c] == -8) {
					System.out.print("  " + BlackOpenTrap + "");
				} else if (board[r][c] == -9) {
					System.out.print("  " + BlackMine + "");
				} else if (board[r][c] == -10) {
					System.out.print("  " + BlackSouthWall + "");
				} else if (board[r][c] == -11) {
					System.out.print("  " + BlackWestWall + "");
				} else if (board[r][c] == -12) {
					System.out.print("  " + BlackWSWall + "");
				} // west walls
				if (board[r][c] == 20) {
					System.out.print(" |" + WhiteKing + "");
				} else if (board[r][c] == 21) {
					System.out.print(" |" + WhiteQueen + "");
				} else if (board[r][c] == 22) {
					System.out.print(" |" + WhiteRook + "");
				} else if (board[r][c] == 23) {
					System.out.print(" |" + WhiteBishop + "");
				} else if (board[r][c] == 24) {
					System.out.print(" |" + WhiteKnight + "");
				} else if (board[r][c] == 25) {
					System.out.print(" |" + WhitePawn + "");
				} else if (board[r][c] == 26) {
					System.out.print(" |" + WhiteHiddenTrap);
				} else if (board[r][c] == 27) {
					System.out.print(" |" + WhiteOpenTrap);
				} else if (board[r][c] == 28) {
					System.out.print(" |" + WhiteMine);
				} else if (board[r][c] == 29) {
					System.out.print("" + WhiteWSWall + "  ");
				} else if (board[r][c] == 30) {
					System.out.print(" " + WhiteWestWall + " ");
				} else if (board[r][c] == 31) {
					System.out.print("" + WhiteWSWall + "  ");
				} else if (board[r][c] == -20) {
					System.out.print(" |" + BlackKing + "");
				} else if (board[r][c] == -21) {
					System.out.print(" |" + BlackQueen + "");
				} else if (board[r][c] == -22) {
					System.out.print(" |" + BlackRook + "");
				} else if (board[r][c] == -23) {
					System.out.print(" |" + BlackBishop + "");
				} else if (board[r][c] == -24) {
					System.out.print(" |" + BlackKnight + "");
				} else if (board[r][c] == -25) {
					System.out.print(" |" + BlackPawn + "");
				} else if (board[r][c] == -26) {
					System.out.print(" |" + BlackHiddenTrap);
				} else if (board[r][c] == -27) {
					System.out.print(" |" + BlackOpenTrap + "");
				} else if (board[r][c] == -28) {
					System.out.print(" |" + BlackMine + "");
				} else if (board[r][c] == -29) {
					System.out.print("" + BlackWSWall + "  ");
				} else if (board[r][c] == -30) {
					System.out.print(" " + BlackWestWall + " ");
				} else if (board[r][c] == -31) {
					System.out.print("" + BlackWSWall + "  ");
				}

				// south walls
				if (board[r][c] == 40) {
					System.out.print(" _" + WhiteKing + "");
				} else if (board[r][c] == 41) {
					System.out.print(" _" + WhiteQueen + "");
				} else if (board[r][c] == 42) {
					System.out.print(" _" + WhiteRook + "");
				} else if (board[r][c] == 43) {
					System.out.print(" _" + WhiteBishop + "");
				} else if (board[r][c] == 44) {
					System.out.print(" _" + WhiteKnight + "");
				} else if (board[r][c] == 45) {
					System.out.print(" _" + WhitePawn + "");
				} else if (board[r][c] == 46) {
					System.out.print(" _" + WhiteHiddenTrap);
				} else if (board[r][c] == 47) {
					System.out.print(" _" + WhiteOpenTrap);
				} else if (board[r][c] == 48) {
					System.out.print(" _" + WhiteMine);
				} else if (board[r][c] == 49) {
					System.out.print(" " + WhiteSouthWall + " ");
				} else if (board[r][c] == 50) {
					System.out.print(" " + WhiteWSWall + " ");
				} else if (board[r][c] == 51) {
					System.out.print(" " + WhiteWSWall + " ");
				} else if (board[r][c] == -40) {
					System.out.print(" _" + BlackKing + "");
				} else if (board[r][c] == -41) {
					System.out.print(" _" + BlackQueen + "");
				} else if (board[r][c] == -42) {
					System.out.print(" _" + BlackRook + "");
				} else if (board[r][c] == -43) {
					System.out.print(" _" + BlackBishop + "");
				} else if (board[r][c] == -44) {
					System.out.print(" _" + BlackKnight + "");
				} else if (board[r][c] == -45) {
					System.out.print(" _" + BlackPawn + "");
				} else if (board[r][c] == -46) {
					System.out.print(" _" + BlackHiddenTrap);
				} else if (board[r][c] == -47) {
					System.out.print(" _" + BlackOpenTrap + "");
				} else if (board[r][c] == -48) {
					System.out.print(" _" + BlackMine + "");
				} else if (board[r][c] == -49) {
					System.out.print(" " + BlackSouthWall + " ");
				} else if (board[r][c] == -50) {
					System.out.print(" " + BlackWSWall + " ");
				} else if (board[r][c] == -51) {
					System.out.print(" " + BlackWSWall + " ");
				}

				// west south walls
				if (board[r][c] == 60) {
					System.out.print("|_" + WhiteKing + "");
				} else if (board[r][c] == 61) {
					System.out.print("|_" + WhiteQueen + "");
				} else if (board[r][c] == 62) {
					System.out.print("|_" + WhiteRook + "");
				} else if (board[r][c] == 63) {
					System.out.print("|_" + WhiteBishop + "");
				} else if (board[r][c] == 64) {
					System.out.print("|_" + WhiteKnight + "");
				} else if (board[r][c] == 65) {
					System.out.print("|_" + WhitePawn + "");
				} else if (board[r][c] == 66) {
					System.out.print("|_" + WhiteHiddenTrap);
				} else if (board[r][c] == 67) {
					System.out.print("|_" + WhiteOpenTrap);
				} else if (board[r][c] == 68) {
					System.out.print("|_" + WhiteMine);
				} else if (board[r][c] == 69) {
					System.out.print(" " + WhiteWSWall + " ");
				} else if (board[r][c] == 70) {
					System.out.print(" " + WhiteWSWall + " ");
				} else if (board[r][c] == 71) {
					System.out.print(" " + WhiteWSWall + " ");
				} else if (board[r][c] == -60) {
					System.out.print("|_" + BlackKing + "");
				} else if (board[r][c] == -61) {
					System.out.print("|_" + BlackQueen + "");
				} else if (board[r][c] == -62) {
					System.out.print("|_" + BlackRook + "");
				} else if (board[r][c] == -63) {
					System.out.print("|_" + BlackBishop + "");
				} else if (board[r][c] == -64) {
					System.out.print("|_" + BlackKnight + "");
				} else if (board[r][c] == -65) {
					System.out.print("|_" + BlackPawn + "");
				} else if (board[r][c] == -66) {
					System.out.print("|_" + BlackHiddenTrap);
				} else if (board[r][c] == -67) {
					System.out.print("|_" + BlackOpenTrap + "");
				} else if (board[r][c] == -68) {
					System.out.print("|_" + BlackMine + "");
				} else if (board[r][c] == -69) {
					System.out.print(" " + BlackWSWall + " ");
				} else if (board[r][c] == -70) {
					System.out.print(" " + BlackWSWall + " ");
				} else if (board[r][c] == -71) {
					System.out.print(" " + BlackWSWall + " ");
				}

			}
			System.out.println();
			System.out.println();
		}
		System.out.println();
		System.out.println("  " + letters);
	}

	// moving pieces
	public static void makeMove(int fromRank, int fromFile, int toRank, int toFile) {
		// moving
		// making move
		int p = Math.abs(board[fromRank][fromFile]);
		if ((p >= 20 && p <= 31) || (p >= 40 && p <= 51)
				|| (p >= 60 && p <= 71) && Chess.isValidMove(fromRank, fromFile, toRank, toFile, 20, false)) {
			Move.fromWall(fromRank, fromFile, toRank, toFile, board, 20);
		} else if ((p <= -20 && p >= -31) || (p <= -40 && p >= -51)
				|| (p <= -60 && p >= -71) && Move.pieceType(board, fromRank, fromFile, toRank, toFile, -20)) {
			Move.fromWall(fromRank, fromFile, toRank, toFile, board, -20);
		} else {
			board[toRank][toFile] = board[fromRank][fromFile];
			board[fromRank][fromFile] = 0;
		}

	}

	// placing an obstacle
	public static void obstaclePlace(int obsRank, int obsFile, int obstacle, int player, int wsWall) {
		// 1 for wall, 2 for trap and 3 for mine

		// white players obstacles
		if (player == 20) {
			// wall

			if (obstacle == 1) {

				// west
				if (wsWall == 1 && board[obsRank][obsFile] == 0) {
					board[obsRank][obsFile] = 11;
				} else if (wsWall == 1 && ((board[obsRank][obsFile] > 0 && board[obsRank][obsFile] < 13)
						|| (board[obsRank][obsFile] < 0 && board[obsRank][obsFile] > -13))) {
					board[obsRank][obsFile] = board[obsRank][obsFile] + 19;

				} // south
				else if (wsWall == 2 && board[obsRank][obsFile] == 0) {

					board[obsRank][obsFile] = 10;
				} else if (wsWall == 2 && board[obsRank][obsFile] > 0 && board[obsRank][obsFile] < 13) {
					board[obsRank][obsFile] = board[obsRank][obsFile] + 39;
				}
				// south west from west
				else if (wsWall == 2 && board[obsRank][obsFile] > 19 && board[obsRank][obsFile] < 32) {
					board[obsRank][obsFile] = board[obsRank][obsFile] + 40;
				}
				// south west from south
				else if (wsWall == 2 && board[obsRank][obsFile] > 39 && board[obsRank][obsFile] < 52) {
					board[obsRank][obsFile] = board[obsRank][obsFile] + 20;
				}
			}
			// trap
			if (obstacle == 2) {
				if (Math.abs(board[obsRank][obsFile]) == 9) {
					board[obsRank][obsFile] = 13;
				}

				else {
					board[obsRank][obsFile] = 7;
				}
			} // mine
			if (obstacle == 3) {
				if (Math.abs(board[obsRank][obsFile]) == 7 || Math.abs(board[obsRank][obsFile]) == 8) {
					board[obsRank][obsFile] = 13;
				}

				else {
					board[obsRank][obsFile] = 9;
				}
			}
		}

		// black players obstacles
		if (player == -20) {
			// wall
			if (obstacle == 1) {
				// west
				if (wsWall == 1 && board[obsRank][obsFile] == 0) {
					board[obsRank][obsFile] = -11;
				} else if (wsWall == 1 && board[obsRank][obsFile] < 0 && board[obsRank][obsFile] > -13) {
					board[obsRank][obsFile] = board[obsRank][obsFile] - 19;
				} // south
				else if (wsWall == 2 && board[obsRank][obsFile] == 0) {
					board[obsRank][obsFile] = -10;
				} else if (wsWall == 2 && board[obsRank][obsFile] < 0 && board[obsRank][obsFile] > -13) {
					board[obsRank][obsFile] = board[obsRank][obsFile] - 39;
				} // south west from west
				else if (board[obsRank][obsFile] < -19 && board[obsRank][obsFile] > -32) {
					board[obsRank][obsFile] = board[obsRank][obsFile] - 40;
				}
				// south west from south
				else if (board[obsRank][obsFile] < -39 && board[obsRank][obsFile] > -52) {
					board[obsRank][obsFile] = board[obsRank][obsFile] - 20;
				}
			} // trap
			if (obstacle == 2) {
				if (Math.abs(board[obsRank][obsFile]) == 9) {
					board[obsRank][obsFile] = 13;
				}

				else {
					board[obsRank][obsFile] = -7;
				}
			} // mine
			if (obstacle == 3) {
				if (Math.abs(board[obsRank][obsFile]) == 7 || Math.abs(board[obsRank][obsFile]) == 8) {
					board[obsRank][obsFile] = 13;
				}

				else {
					board[obsRank][obsFile] = -9;
				}
			}
		}

	}

	// checking if move is valid
	public static boolean isValidMove(int fromRank, int fromFile, int toRank, int toFile, int player, boolean valid) {
		// wall valid
		if (valid == true) {
			// player = player * (-1);
			return false;
		}
		if ((fromRank < 8 && fromFile < 8)) {
			// check that from block has a piece
			if ((fromRank < 8 && fromFile < 8)) {
				if (board[fromRank][fromFile] == 0) {

					return false;
				}
			}
			// can't move an obstacle
			int ob = board[fromRank][fromFile];
			if ((ob >= 7 && ob <= 12) || (ob <= -7 && ob >= -12)) {
				return false;
			}

			// Check if the player is valid
			if ((player > 20) || (player < -20) || (player == 0)) {
				return false;
			}
			// check who's turn it is
			if ((player == 20) && (board[fromRank][fromFile] < 0)) {

				return false;
			}
			if ((player == -20) && (board[fromRank][fromFile] > 0)) {

				return false;
			}
			// Check if the from and to squares are valid
			if ((fromRank < 0) || (fromRank > 7) || (toRank < 0) || (toRank > 7)) {

				return false;
			}
			if ((fromFile < 0) || (fromFile > 7) || (toFile < 0) || (toFile > 7)) {

				return false;
			}

			// can't take own piece
			int to = board[toRank][toFile];
			int q = board[toRank][toFile];
			if ((q >= -6 && q <= 6) || (q >= 20 && q <= 26) || (q >= -26 && q <= -20) || (q >= 40 && q <= 46)
					|| (q >= -46 && q <= -40) || (q >= 60 && q <= 66) || (q >= -66 && q <= -60))
				if ((q >= -6 && q <= 6) || (q >= 20 && q <= 26) || (q >= -26 && q <= -20) || (q >= 40 && q <= 46)
						|| (q >= -46 && q <= -40) || (q >= 60 && q <= 66) || (q >= -66 && q <= -60)) {
					if ((ob > 0 && to > 0) || (ob < 0 && to < 0)) {
						return false;
					}
				}

			// check what piece can make what move
			if (Move.pieceType(board, fromRank, fromFile, toRank, toFile, player) == false) {

				return false;
			}
			if (Math.abs(board[toRank][toFile]) == 9 || Math.abs(board[toRank][toFile]) == 7
					|| Math.abs(board[toRank][toFile]) == 8 || Math.abs(board[toRank][toFile]) == 13) {
				return true;
			}
			// check that pieces are not jumping over other pieces
			if (PathChecker.selectChecker(fromRank, fromFile, toRank, toFile, player, board) == false) {

				return false;
			}
			return true;
		}
		return false;
	}

	public static boolean lineCheck(String line, int c) {
		boolean wall = true;
		for (int a = 0; a < line.length(); a++) {

			if (line.charAt(a) == '_' || line.charAt(a) == '|') {
				wall = false;
			}
		}
		if (wall == true && line.length() != 8) {
			Chess.imove = "h" + c;
			// System.out.println("here");
			return false;
		}

		return true;
	}

	public static boolean boardCheck(int ww, int bw) {
		int wwall = 0;
		int bwall = 0;
		int bp = 0;
		int wp = 0;
		int pCount = 0;
		for (int a = 0; a < 8; a++) {
			for (int b = 0; b < 8; b++) {
				if (Math.abs(board[a][b]) < 7 && board[a][b] != 0) {
					pCount++;
				}
				if (board[a][b] == 6) {
					wp++;
				}
				if (board[a][b] == -6) {
					bp++;
				}
				if (Math.abs(board[a][b]) == 7 && (a < 2 || a > 5)) {
					return false;
				}
				if (Math.abs(board[a][b]) == 9 && (a < 3 || a > 4)) {
					return false;
				}
				if (board[a][b] > 19 || board[a][b] == 11) {
					wwall++;
				}
				if (board[a][b] > 19 || board[a][b] == 12) {
					wwall = wwall + 2;
				}
				if (board[a][b] == -10 || board[a][b] == -11) {
					bwall++;
				}
				if (board[a][b] < -19 || board[a][b] == -12) {
					bwall = bwall + 2;
				}

			}
		}
		// System.out.println(wwall + " " + bwall);
		bw = 3 - bw;
		ww = 3 - ww;
		if (wp > 8 || bp > 8) {
			// find invalid piece
			for (int a = 2; a < 7; a++) {
				for (int b = 2; b < 7; b++) {
					if (Math.abs(board[a][b]) != 0 && Math.abs(board[a][b]) < 7) {
						// a = 8-a;
						Chess.imove = "h" + (8 - a);
						return false;
					}
				}
			}

			return false;
		}
		if (bw + ww != bwall + wwall) {

			Chess.invalidBoard = true;
			Chess.imove = "status line";

			return false;
		} else {
			Chess.wcount = 3 - ww;
			Chess.bcount = 3 - bw;
		}
		return true;
	}

	public static String status(int player, int ww, int bw, int clock) {
		String wks = "-";
		String wqs = "-";
		String bks = "-";
		String bqs = "-";
		String play = "w";

		String passant = "-";
		clock = 0;
		if (player == -20) {
			play = "b";
		}

		// white castle kingside
		if (board[7][4] == 1 && board[7][7] == 3) {
			wks = "+";
		}
		// white castle queenside
		if (board[7][4] == 1 && board[7][0] == 3) {
			wqs = "+";
		}
		// black castle kingside
		if (board[0][4] == -1 && board[0][7] == -3) {
			bks = "+";
		}
		// blaack castle queenside
		if (board[0][4] == -1 && board[0][0] == -3) {
			bqs = "+";
		}
		Chess.castlingline = wks + wqs + bks + bqs;
		return play + " " + (ww) + " " + (bw) + " " + wks + wqs + bks + bqs + " " + passant + " " + Chess.clocking;
	}

	public static void castling(int player) {
		// white
		if (player == 20) {
			// kingside
			if (board[7][3] == 1 && board[7][2] == 0 && board[7][1] == 0 && board[7][0] == 3) {
			}
			// queenside
			if (board[7][3] == 1 && board[7][4] == 0 && board[7][5] == 0 && board[7][6] == 0 && board[7][7] == 3) {
			}
		} else {
			// black
			// kingside
			if (board[1][3] == -1 && board[1][2] == 0 && board[1][1] == 0 && board[1][0] == -3) {
			}
			// queenside
			if (board[1][3] == -1 && board[1][4] == 0 && board[1][5] == 0 && board[1][6] == 0 && board[1][7] == -3) {
			}
		}
	}

	public static boolean playerId(int player, int rank, int file) {
		if ((board[rank][file] > 0 && player > 0) || (board[rank][file] < 0 && player < 0)) {
			return true;
		}
		return false;
	}

	public static void drawBoard(int player) {

		// boarders
		StdDraw.setPenColor(54, 69, 79);
		StdDraw.filledRectangle(45, 2.5, 45, 2.5);
		StdDraw.filledRectangle(2.5, 45, 2.5, 45);
		StdDraw.filledRectangle(40, 87.5, 45, 2.5);
		StdDraw.filledRectangle(87.5, 45, 2.5, 45);
		// bottom and right space
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.filledRectangle(95, 50, 5, 50);

		// checkered board
		for (int a = 1; a <= 8; a++) {
			for (int b = 1; b <= 8; b++) {
				if ((a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0)) {
					StdDraw.setPenColor(255, 248, 220);
					StdDraw.filledSquare(a * 10, b * 10, 5);
				}
				if ((a % 2 == 0 && b % 2 != 0) || (a % 2 != 0 && b % 2 == 0)) {
					StdDraw.setPenColor(212, 188, 163);
					StdDraw.filledSquare(a * 10, b * 10, 5);
				}
			}
		}
		// boarder lines
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(5, 5, 5, 85);
		StdDraw.line(5, 85, 85, 85);
		StdDraw.line(5, 5, 85, 5);
		StdDraw.line(85, 5, 85, 85);

		// rank and file labels
		String rank = "87654321";
		String file = "abcdefgh";
		StdDraw.setPenColor(245, 245, 245);
		Font label = new Font("Aharoni", Font.BOLD, 30);
		StdDraw.setFont(label);
		for (int a = 0; a <= 7; a++) {
			char r = rank.charAt(a);
			char f = file.charAt(a);
			String newR = Character.toString(r);
			String newF = Character.toString(f);
			StdDraw.text(2.5, a * 10 + 10, newR);
			StdDraw.text(87.5, a * 10 + 10, newR);
			StdDraw.text(a * 10 + 10, 2.5, newF);
			StdDraw.text(a * 10 + 10, 87.5, newF);
		}
		// player turn
		String white = "white.png";
		String black = "black.png";
		Font turn = new Font("SansSerif", Font.BOLD, 20);
		StdDraw.setFont(turn);

		if (player == 20) {
			StdDraw.picture(5, 96, white, 8, 8);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(5, 91.5, "PLAYER");

		} else {
			StdDraw.picture(5, 96, black, 12, 11);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(5, 91.5, "PLAYER");

		}

		// quit
		String quit = "quit.png";
		StdDraw.picture(94, 95, quit, 10, 10);

		// undo
		String undo = "undo.png";
		StdDraw.picture(40, 95, undo, 13, 13);

		// wall
		String wall = "wall.png";
		StdDraw.picture(20, 95, wall, 10, 6);

		// chess pieces
		String wk = "wk.png";
		String wq = "wq.png";
		String wb = "wb.png";
		String wr = "wr.png";
		String wn = "wn.png";
		String wp = "wp.png";
		String bk = "bk.png";
		String bq = "bq.png";
		String bb = "bb.png";
		String br = "br.png";
		String bn = "bn.png";
		String bp = "bp.png";
		//String mine = "explosion1.png";
		String mine = "";
	//	String hiddentrap = "trap.png";
		String hiddentrap = "";
		String opentrap = "opentrap.png";
		String southwall = "southwall.png";
		String westwall = "westwall.png";

		// drawing the pieces on the board
		for (int r = 0; r <= 7; r++) {
			for (int c = 0; c <= 7; c++) {
				if (board[r][c] == 1) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wk, 8, 8);
				} else if (board[r][c] == 2) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wq, 8, 8);
				} else if (board[r][c] == 3) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wr, 8, 8);
				} else if (board[r][c] == 4) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wb, 8, 8);
				} else if (board[r][c] == 5) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wn, 8, 8);
				} else if (board[r][c] == 6) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wp, 8, 8);
				} else if (board[r][c] == 7) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == 8) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == 9) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == 10) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == 11) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == 12) {

				} else if (board[r][c] == -1) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bk, 8, 8);
				} else if (board[r][c] == -2) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bq, 8, 8);
				} else if (board[r][c] == -3) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, br, 8, 8);
				} else if (board[r][c] == -4) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bb, 8, 8);
				} else if (board[r][c] == -5) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bn, 8, 8);
				} else if (board[r][c] == -6) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bp, 8, 8);
				} else if (board[r][c] == -7) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == -8) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == -9) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == -10) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == -11) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -12) {

				}
				// west
				if (board[r][c] == 20) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wk, 8, 8);
				} else if (board[r][c] == 21) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wq, 8, 8);
				} else if (board[r][c] == 22) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wr, 8, 8);
				} else if (board[r][c] == 23) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wb, 8, 8);
				} else if (board[r][c] == 24) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wn, 8, 8);
				} else if (board[r][c] == 25) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wp, 8, 8);
				} else if (board[r][c] == 26) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == 27) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == 28) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == 29) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == 30) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					// StdDraw.picture(c * 10 + 10-5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == 31) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);

				} else if (board[r][c] == -20) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bk, 8, 8);
				} else if (board[r][c] == -21) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bq, 8, 8);
				} else if (board[r][c] == -22) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, br, 8, 8);
				} else if (board[r][c] == -23) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bb, 8, 8);
				} else if (board[r][c] == -24) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bn, 8, 8);
				} else if (board[r][c] == -25) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bp, 8, 8);
				} else if (board[r][c] == -26) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == -27) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == -28) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == -29) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == -30) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -31) {
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);

				}
				// south
				if (board[r][c] == 40) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wk, 8, 8);
				} else if (board[r][c] == 41) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wq, 8, 8);
				} else if (board[r][c] == 42) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wr, 8, 8);
				} else if (board[r][c] == 43) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wb, 8, 8);
				} else if (board[r][c] == 44) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wn, 8, 8);
				} else if (board[r][c] == 45) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wp, 8, 8);
				} else if (board[r][c] == 46) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == 47) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == 48) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == 49) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == 50) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == 51) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);

				} else if (board[r][c] == -40) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bk, 8, 8);
				} else if (board[r][c] == -41) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bq, 8, 8);
				} else if (board[r][c] == -42) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, br, 8, 8);
				} else if (board[r][c] == -43) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bb, 8, 8);
				} else if (board[r][c] == -44) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bn, 8, 8);
				} else if (board[r][c] == -45) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bp, 8, 8);
				} else if (board[r][c] == -46) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == -47) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == -48) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == -49) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
				} else if (board[r][c] == -50) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -51) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);

				}
				// west south
				if (board[r][c] == 60) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wk, 8, 8);
				} else if (board[r][c] == 61) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wq, 8, 8);
				} else if (board[r][c] == 62) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wr, 8, 8);
				} else if (board[r][c] == 63) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wb, 8, 8);
				} else if (board[r][c] == 64) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wn, 8, 8);
				} else if (board[r][c] == 65) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, wp, 8, 8);
				} else if (board[r][c] == 66) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == 67) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == 68) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == 69) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == 70) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == 71) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -60) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bk, 8, 8);
				} else if (board[r][c] == -61) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bq, 8, 8);
				} else if (board[r][c] == -62) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, br, 8, 8);
				} else if (board[r][c] == -63) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bb, 8, 8);
				} else if (board[r][c] == -64) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bn, 8, 8);
				} else if (board[r][c] == -65) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, bp, 8, 8);
				} else if (board[r][c] == -66) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, hiddentrap, 8, 8);
				} else if (board[r][c] == -67) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, opentrap, 8, 8);
				} else if (board[r][c] == -68) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
					StdDraw.picture(c * 10 + 10, r * 10 + 10, mine, 8, 8);
				} else if (board[r][c] == -69) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -70) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				} else if (board[r][c] == -71) {
					StdDraw.picture(c * 10 + 10, r * 10 + 10 + 5, southwall, 10, 10);
					StdDraw.picture(c * 10 + 10 - 5, r * 10 + 10, westwall, 10, 10);
				}
			}
		}

	}

	public static String logConvert(int a) {

		if (a == 0) {
			return "a";
		} else if (a == 1) {
			return "b";
		} else if (a == 2) {
			return "c";
		} else if (a == 3) {
			return "d";
		} else if (a == 4) {
			return "e";
		} else if (a == 5) {
			return "f";
		} else if (a == 6) {
			return "g";
		} else if (a == 7) {
			return "h";
		}
		return "";
	}

	public static int wWall(char a) {
		int b = (int) a;
		int c = 0;
		if (b == 46) {
			c = 0;
		} else if (b == 75) {
			c = 1 + 19;
		} else if (b == 81) {
			c = 2 + 19;
		} else if (b == 82) {
			c = 3 + 19;
		} else if (b == 66) {
			c = 4 + 19;
		} else if (b == 78) {
			c = 5 + 19;
		} else if (b == 80) {
			c = 6 + 19;
		}

		else if (b == 107) {
			c = -1 - 19;
		} else if (b == 113) {
			c = -2 - 19;
		} else if (b == 114) {
			c = -3 - 19;
		} else if (b == 98) {
			c = -4 - 19;
		} else if (b == 110) {
			c = -5 - 19;
		} else if (b == 112) {
			c = -6 - 19;
		}
		return c;
	}

	public static int sWall(char a) {
		int b = (int) a;
		int c = 0;
		if (b == 46) {
			c = 0;
		} else if (b == 75) {
			c = 1 + 39;
		} else if (b == 81) {
			c = 2 + 39;
		} else if (b == 82) {
			c = 3 + 39;
		} else if (b == 66) {
			c = 4 + 39;
		} else if (b == 78) {
			c = 5 + 39;
		} else if (b == 80) {
			c = 6 + 39;
		}

		else if (b == 107) {
			c = -1 - 39;
		} else if (b == 113) {
			c = -2 - 39;
		} else if (b == 114) {
			c = -3 - 39;
		} else if (b == 98) {
			c = -4 - 39;
		} else if (b == 110) {
			c = -5 - 39;
		} else if (b == 112) {
			c = -6 - 39;
		}
		return c;
	}

	public static int wsWall(char a) {
		int b = (int) a;
		int c = 0;
		if (b == 46) {
			c = 0;
		} else if (b == 75) {
			c = 1 + 59;
		} else if (b == 81) {
			c = 2 + 59;
		} else if (b == 82) {
			c = 3 + 59;
		} else if (b == 66) {
			c = 4 + 59;
		} else if (b == 78) {
			c = 5 + 59;
		} else if (b == 80) {
			c = 6 + 59;
		}

		else if (b == 107) {
			c = -1 - 59;
		} else if (b == 113) {
			c = -2 - 59;
		} else if (b == 114) {
			c = -3 - 59;
		} else if (b == 98) {
			c = -4 - 59;
		} else if (b == 110) {
			c = -5 - 59;
		} else if (b == 112) {
			c = -6 - 59;
		}
		return c;
	}

	public static void convert(String line1, String line2, String line3, String line4, String line5, String line6,
			String line7, String line8) {
		int num = 0;
		// line1
		for (int a = 0, b = 0; b < line1.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line1.length() > 8) {
				if (line1.charAt(b) == '_' && line1.charAt(b + 1) != '.') {
					Chess.board[0][a] = Chess.sWall(line1.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line1.charAt(b) == '|') {
					if (line1.charAt(b + 1) != '.' && line1.charAt(b + 2) == '.') {
						Chess.board[0][a] = Chess.wWall(line1.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line1.charAt(b + 1) == '_') {

						if (line1.charAt(b + 2) != '.') {
							Chess.board[0][a] = Chess.wsWall(line1.charAt(b + 2));

						} else {
							Chess.board[0][a] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line1.charAt(b);
				if (num == 46) {
					Chess.board[0][a] = 0;
				} else if (num == 75) {
					Chess.board[0][a] = 1;
				} else if (num == 81) {
					Chess.board[0][a] = 2;
				} else if (num == 82) {
					Chess.board[0][a] = 3;
				} else if (num == 66) {
					Chess.board[0][a] = 4;
				} else if (num == 78) {
					Chess.board[0][a] = 5;
				} else if (num == 80) {
					Chess.board[0][a] = 6;
				} else if (num == 68) {
					Chess.board[0][a] = 7;
				} else if (num == 79) {
					Chess.board[0][a] = 8;
				} else if (num == 77) {
					Chess.board[0][a] = 9;
				} else if (num == 95) {
					Chess.board[0][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[0][a] = -1;
				} else if (num == 113) {
					Chess.board[0][a] = -2;
				} else if (num == 114) {
					Chess.board[0][a] = -3;
				} else if (num == 98) {
					Chess.board[0][a] = -4;
				} else if (num == 110) {
					Chess.board[0][a] = -5;
				} else if (num == 112) {
					Chess.board[0][a] = -6;
				} else if (num == 100) {
					Chess.board[0][a] = -7;
				} else if (num == 111) {
					Chess.board[0][a] = -8;
				} else if (num == 109) {
					Chess.board[0][a] = -9;
				} else if (num == 88) {
					Chess.board[0][a] = 13;
				} else {
					Chess.board[0][a] = 11;
				}
			}
		}

		// line2

		for (int a = 0, b = 0; b < line2.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line2.length() > 8) {
				if (line2.charAt(b) == '_' && line2.charAt(b + 1) != '.') {
					Chess.board[1][a] = Chess.sWall(line2.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line2.charAt(b) == '|') {
					if (line2.charAt(b + 1) != '.' && line2.charAt(b + 2) == '.') {
						Chess.board[1][a] = Chess.wWall(line2.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line2.charAt(b + 1) == '_') {

						if (line2.charAt(b + 2) != '.') {
							Chess.board[1][a] = Chess.wsWall(line2.charAt(b + 2));

						} else {
							Chess.board[1][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line2.charAt(b);
				if (num == 46) {
					Chess.board[1][a] = 0;
				} else if (num == 75) {
					Chess.board[1][a] = 1;
				} else if (num == 81) {
					Chess.board[1][a] = 2;
				} else if (num == 82) {
					Chess.board[1][a] = 3;
				} else if (num == 66) {
					Chess.board[1][a] = 4;
				} else if (num == 78) {
					Chess.board[1][a] = 5;
				} else if (num == 80) {
					Chess.board[1][a] = 6;
				} else if (num == 68) {
					Chess.board[1][a] = 7;
				} else if (num == 79) {
					Chess.board[1][a] = 8;
				} else if (num == 77) {
					Chess.board[1][a] = 9;
				} else if (num == 95) {
					Chess.board[1][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[1][a] = -1;
				} else if (num == 113) {
					Chess.board[1][a] = -2;
				} else if (num == 114) {
					Chess.board[1][a] = -3;
				} else if (num == 98) {
					Chess.board[1][a] = -4;
				} else if (num == 110) {
					Chess.board[1][a] = -5;
				} else if (num == 112) {
					Chess.board[1][a] = -6;
				} else if (num == 100) {
					Chess.board[1][a] = -7;
				} else if (num == 111) {
					Chess.board[1][a] = -8;
				} else if (num == 109) {
					Chess.board[1][a] = -9;
				} else if (num == 88) {
					Chess.board[1][a] = 13;
				} else {
					Chess.board[1][a] = 11;
				}
			}
		}

		// line3
		for (int a = 0, b = 0; b < line3.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line3.length() > 8) {
				if (line3.charAt(b) == '_' && line3.charAt(b + 1) != '.') {
					Chess.board[2][a] = Chess.sWall(line3.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line3.charAt(b) == '|') {
					if (line3.charAt(b + 1) != '.' && line3.charAt(b + 2) == '.') {
						Chess.board[2][a] = Chess.wWall(line3.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line3.charAt(b + 1) == '_') {

						if (line3.charAt(b + 2) != '.') {
							Chess.board[2][a] = Chess.wsWall(line3.charAt(b + 2));

						} else {
							Chess.board[2][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line3.charAt(b);
				if (num == 46) {
					Chess.board[2][a] = 0;
				} else if (num == 75) {
					Chess.board[2][a] = 1;
				} else if (num == 81) {
					Chess.board[2][a] = 2;
				} else if (num == 82) {
					Chess.board[2][a] = 3;
				} else if (num == 66) {
					Chess.board[2][a] = 4;
				} else if (num == 78) {
					Chess.board[2][a] = 5;
				} else if (num == 80) {
					Chess.board[2][a] = 6;
				} else if (num == 68) {
					Chess.board[2][a] = 7;
				} else if (num == 79) {
					Chess.board[2][a] = 8;
				} else if (num == 77) {
					Chess.board[2][a] = 9;
				} else if (num == 95) {
					Chess.board[2][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[2][a] = -1;
				} else if (num == 113) {
					Chess.board[2][a] = -2;
				} else if (num == 114) {
					Chess.board[2][a] = -3;
				} else if (num == 98) {
					Chess.board[2][a] = -4;
				} else if (num == 110) {
					Chess.board[2][a] = -5;
				} else if (num == 112) {
					Chess.board[2][a] = -6;
				} else if (num == 100) {
					Chess.board[2][a] = -7;
				} else if (num == 111) {
					Chess.board[2][a] = -8;
				} else if (num == 109) {
					Chess.board[2][a] = -9;
				} else if (num == 88) {
					Chess.board[2][a] = 13;
				} else {
					Chess.board[2][a] = 11;
				}
			}
		}

		// line4
		for (int a = 0, b = 0; b < line4.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line4.length() > 8) {
				if (line4.charAt(b) == '_' && line4.charAt(b + 1) != '.') {
					Chess.board[3][a] = Chess.sWall(line4.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line4.charAt(b) == '|') {
					if (line4.charAt(b + 1) != '.' && line4.charAt(b + 2) == '.') {
						Chess.board[3][a] = Chess.wWall(line4.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line4.charAt(b + 1) == '_') {

						if (line4.charAt(b + 2) != '.') {
							Chess.board[3][a] = Chess.wsWall(line4.charAt(b + 2));

						} else {
							Chess.board[3][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line4.charAt(b);
				if (num == 46) {
					Chess.board[3][a] = 0;
				} else if (num == 75) {
					Chess.board[3][a] = 1;
				} else if (num == 81) {
					Chess.board[3][a] = 2;
				} else if (num == 82) {
					Chess.board[3][a] = 3;
				} else if (num == 66) {
					Chess.board[3][a] = 4;
				} else if (num == 78) {
					Chess.board[3][a] = 5;
				} else if (num == 80) {
					Chess.board[3][a] = 6;
				} else if (num == 68) {
					Chess.board[3][a] = 7;
				} else if (num == 79) {
					Chess.board[3][a] = 8;
				} else if (num == 77) {
					Chess.board[3][a] = 9;
				} else if (num == 95) {
					Chess.board[3][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[3][a] = -1;
				} else if (num == 113) {
					Chess.board[3][a] = -2;
				} else if (num == 114) {
					Chess.board[3][a] = -3;
				} else if (num == 98) {
					Chess.board[3][a] = -4;
				} else if (num == 110) {
					Chess.board[3][a] = -5;
				} else if (num == 112) {
					Chess.board[3][a] = -6;
				} else if (num == 100) {
					Chess.board[3][a] = -7;
				} else if (num == 111) {
					Chess.board[3][a] = -8;
				} else if (num == 109) {
					Chess.board[3][a] = -9;
				} else if (num == 88) {
					Chess.board[3][a] = 13;
				} else {
					Chess.board[3][a] = 11;
				}
			}
		}

		// line5
		for (int a = 0, b = 0; b < line5.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line5.length() > 8) {
				if (line5.charAt(b) == '_' && line5.charAt(b + 1) != '.') {
					Chess.board[4][a] = Chess.sWall(line5.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line5.charAt(b) == '|') {
					if (line5.charAt(b + 1) != '.' && line5.charAt(b + 2) == '.') {
						Chess.board[4][a] = Chess.wWall(line5.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line5.charAt(b + 1) == '_') {

						if (line5.charAt(b + 2) != '.') {
							Chess.board[4][a] = Chess.wsWall(line5.charAt(b + 2));

						} else {
							Chess.board[4][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line5.charAt(b);
				if (num == 46) {
					Chess.board[4][a] = 0;
				} else if (num == 75) {
					Chess.board[4][a] = 1;
				} else if (num == 81) {
					Chess.board[4][a] = 2;
				} else if (num == 82) {
					Chess.board[4][a] = 3;
				} else if (num == 66) {
					Chess.board[4][a] = 4;
				} else if (num == 78) {
					Chess.board[4][a] = 5;
				} else if (num == 80) {
					Chess.board[4][a] = 6;
				} else if (num == 68) {
					Chess.board[4][a] = 7;
				} else if (num == 79) {
					Chess.board[4][a] = 8;
				} else if (num == 77) {
					Chess.board[4][a] = 9;
				} else if (num == 95) {
					Chess.board[4][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[4][a] = -1;
				} else if (num == 113) {
					Chess.board[4][a] = -2;
				} else if (num == 114) {
					Chess.board[4][a] = -3;
				} else if (num == 98) {
					Chess.board[4][a] = -4;
				} else if (num == 110) {
					Chess.board[4][a] = -5;
				} else if (num == 112) {
					Chess.board[4][a] = -6;
				} else if (num == 100) {
					Chess.board[4][a] = -7;
				} else if (num == 111) {
					Chess.board[4][a] = -8;
				} else if (num == 109) {
					Chess.board[4][a] = -9;
				} else if (num == 88) {
					Chess.board[4][a] = 13;
				} else {
					Chess.board[4][a] = 11;
				}
			}
			
		}

		// line6
		for (int a = 0, b = 0; b < line6.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line6.length() > 8) {
				if (line6.charAt(b) == '_' && line6.charAt(b + 1) != '.') {
					Chess.board[5][a] = Chess.sWall(line6.charAt(b + 1));
					be = false;
					b = b + 1;
				}

				if (line6.charAt(b) == '|') {
					if (line6.charAt(b + 1) != '.' && line6.charAt(b + 2) == '.') {
						Chess.board[5][a] = Chess.wWall(line6.charAt(b + 1));
						be = false;
						b = b + 1;
					}

					if (line6.charAt(b + 1) == '_') {

						if (line6.charAt(b + 2) != '.') {
							Chess.board[5][a] = Chess.wsWall(line6.charAt(b + 2));

						} else {
							Chess.board[5][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line6.charAt(b);
				if (num == 46) {
					Chess.board[5][a] = 0;
				} else if (num == 75) {
					Chess.board[5][a] = 1;
				} else if (num == 81) {
					Chess.board[5][a] = 2;
				} else if (num == 82) {
					Chess.board[5][a] = 3;
				} else if (num == 66) {
					Chess.board[5][a] = 4;
				} else if (num == 78) {
					Chess.board[5][a] = 5;
				} else if (num == 80) {
					Chess.board[5][a] = 6;
				} else if (num == 68) {
					Chess.board[5][a] = 7;
				} else if (num == 79) {
					Chess.board[5][a] = 8;
				} else if (num == 77) {
					Chess.board[5][a] = 9;
				} else if (num == 95) {
					Chess.board[5][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[5][a] = -1;
				} else if (num == 113) {
					Chess.board[5][a] = -2;
				} else if (num == 114) {
					Chess.board[5][a] = -3;
				} else if (num == 98) {
					Chess.board[5][a] = -4;
				} else if (num == 110) {
					Chess.board[5][a] = -5;
				} else if (num == 112) {
					Chess.board[5][a] = -6;
				} else if (num == 100) {
					Chess.board[5][a] = -7;
				} else if (num == 111) {
					Chess.board[5][a] = -8;
				} else if (num == 109) {
					Chess.board[5][a] = -9;
				} else if (num == 88) {
					Chess.board[5][a] = 13;
				} else {
					Chess.board[5][a] = 11;
				}
			}
		}

		// line7
		for (int a = 0, b = 0; b < line7.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line7.length() > 8) {
				if (line7.charAt(b) == '_' && line7.charAt(b + 1) != '.') {
					Chess.board[6][a] = Chess.sWall(line7.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line7.charAt(b) == '|') {
					if (line7.charAt(b + 1) != '.' && line7.charAt(b + 2) == '.') {
						Chess.board[6][a] = Chess.wWall(line7.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line7.charAt(b + 1) == '_') {

						if (line7.charAt(b + 2) != '.') {
							Chess.board[6][a] = Chess.wsWall(line7.charAt(b + 2));

						} else {
							Chess.board[6][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line7.charAt(b);
				if (num == 46) {
					Chess.board[6][a] = 0;
				} else if (num == 75) {
					Chess.board[6][a] = 1;
				} else if (num == 81) {
					Chess.board[6][a] = 2;
				} else if (num == 82) {
					Chess.board[6][a] = 3;
				} else if (num == 66) {
					Chess.board[6][a] = 4;
				} else if (num == 78) {
					Chess.board[6][a] = 5;
				} else if (num == 80) {
					Chess.board[6][a] = 6;
				} else if (num == 68) {
					Chess.board[6][a] = 7;
				} else if (num == 79) {
					Chess.board[6][a] = 8;
				} else if (num == 77) {
					Chess.board[6][a] = 9;
				} else if (num == 95) {
					Chess.board[6][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[6][a] = -1;
				} else if (num == 113) {
					Chess.board[6][a] = -2;
				} else if (num == 114) {
					Chess.board[6][a] = -3;
				} else if (num == 98) {
					Chess.board[6][a] = -4;
				} else if (num == 110) {
					Chess.board[6][a] = -5;
				} else if (num == 112) {
					Chess.board[6][a] = -6;
				} else if (num == 100) {
					Chess.board[6][a] = -7;
				} else if (num == 111) {
					Chess.board[6][a] = -8;
				} else if (num == 109) {
					Chess.board[6][a] = -9;
				} else if (num == 88) {
					Chess.board[6][a] = 13;
				} else {
					Chess.board[6][a] = 11;
				}
			}
		}

		// line8
		for (int a = 0, b = 0; b < line8.length() && a < 8; a++, b++) {

			boolean be = true;
			if (line8.length() > 8) {
				if (line8.charAt(b) == '_' && line8.charAt(b + 1) != '.') {
					Chess.board[7][a] = Chess.sWall(line8.charAt(b + 1));
					be = false;
					b = b + 1;
				}
				if (line8.charAt(b) == '|') {
					if (line8.charAt(b + 1) != '.' && line8.charAt(b + 2) == '.') {
						Chess.board[7][a] = Chess.wWall(line8.charAt(b + 1));
						be = false;
						b = b + 1;
					}
					if (line8.charAt(b + 1) == '_') {

						if (line8.charAt(b + 2) != '.') {
							Chess.board[7][a] = Chess.wsWall(line8.charAt(b + 2));

						} else {
							Chess.board[7][b] = 12;

						}
						b = b + 2;
						be = false;
					}
				}

			}
			if (be) {
				num = (int) line8.charAt(b);

				if (num == 46) {
					Chess.board[7][a] = 0;
				} else if (num == 75) {
					Chess.board[7][a] = 1;
				} else if (num == 81) {
					Chess.board[7][a] = 2;
				} else if (num == 82) {
					Chess.board[7][a] = 3;
				} else if (num == 66) {
					Chess.board[7][a] = 4;
				} else if (num == 78) {
					Chess.board[7][a] = 5;
				} else if (num == 80) {
					Chess.board[7][a] = 6;
				} else if (num == 68) {
					Chess.board[7][a] = 7;
				} else if (num == 79) {
					Chess.board[7][a] = 8;
				} else if (num == 77) {
					Chess.board[7][a] = 9;
				} else if (num == 95) {
					Chess.board[7][a] = 10;
					b++;
				}

				else if (num == 107) {
					Chess.board[7][a] = -1;
				} else if (num == 113) {
					Chess.board[7][a] = -2;
				} else if (num == 114) {
					Chess.board[7][a] = -3;
				} else if (num == 98) {
					Chess.board[7][a] = -4;
				} else if (num == 110) {
					Chess.board[7][a] = -5;
				} else if (num == 112) {
					Chess.board[7][a] = -6;
				} else if (num == 100) {
					Chess.board[7][a] = -7;
				} else if (num == 111) {
					Chess.board[7][a] = -8;
				} else if (num == 109) {
					Chess.board[7][a] = -9;
				} else if (num == 88) {
					Chess.board[7][a] = 13;
				} else {
					Chess.board[7][a] = 11;
				}
			}
		}
	}

	public static void promotion(char piece, int frank, int ffile, int trank, int tfile, int player) {

		if (Chess.isValidMove(frank, ffile, trank, tfile, player, false)) {

			board[frank][ffile] = 0;

			// graphics
			int rank = 0;
			int file = 0;
			if (piece == 'g') {
				StdDraw.show(500);
				String promotion = "promotion.png";
				String wq = "wq.png";
				String wb = "wb.png";
				String wr = "wr.png";
				String wn = "wn.png";
				String bq = "bq.png";
				String bb = "bb.png";
				String br = "br.png";
				String bn = "bn.png";
				StdDraw.setPenColor(54, 69, 79);
				StdDraw.filledRectangle(45, 45, 38, 30);
				StdDraw.picture(45, 25, promotion);
				StdDraw.setPenColor();
				StdDraw.text(65, 95, "SELECT A PROMOTION");
				if (player == 20) {
					StdDraw.picture(30, 40, wq, 10, 10);
					StdDraw.picture(30, 60, wr, 10, 10);
					StdDraw.picture(60, 40, wb, 10, 10);
					StdDraw.picture(60, 60, wn, 10, 10);
				} else {
					StdDraw.picture(30, 40, bq, 10, 10);
					StdDraw.picture(30, 60, br, 10, 10);
					StdDraw.picture(60, 40, bb, 10, 10);
					StdDraw.picture(60, 60, bn, 10, 10);
				}
				StdDraw.show();
				boolean wallss = true;

				while (wallss) {

					if (StdDraw.mousePressed()) {

						rank = (int) (StdDraw.mouseY() - 5) / 10;
						file = (int) (StdDraw.mouseX() - 5) / 10;
						wallss = false;

					}

				}

			}
			// white
			if (player == 20) {
				if (piece == 'Q' || (rank == 3 && file == 2)) {
					board[trank][tfile] = 2;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=Q", false);
				} else if (piece == 'B' || (rank == 3 && file == 5)) {
					board[trank][tfile] = 4;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=B", false);
				} else if (piece == 'R' || (rank == 5 && file == 2)) {
					board[trank][tfile] = 3;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=R", false);
				} else if (piece == 'N' || (rank == 5 && file == 5)) {
					board[trank][tfile] = 5;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=N", false);
				}
			}
			// black
			else {
				if (piece == 'Q' || (rank == 3 && file == 2)) {
					board[trank][tfile] = -2;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=Q", false);
				} else if (piece == 'B' || (rank == 3 && file == 5)) {
					board[trank][tfile] = -4;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=B", false);
				} else if (piece == 'R' || (rank == 5 && file == 2)) {
					board[trank][tfile] = -3;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=R", false);
				} else if (piece == 'N' || (rank == 5 && file == 5)) {
					board[trank][tfile] = -5;
					GamePlay.gamelog('\n' + Chess.logConvert(ffile) + (8 - frank) + "-" + Chess.logConvert(tfile)
							+ (8 - trank) + "=N", false);
				}
			}
		}
	}

	public static void moveRead(String move, int player) {
		int whiteWallCounter = 0;
		int blackWallCounter = 0;
		int a = (int) move.charAt(0);
		// System.out.println("a=" + a);
		int fFile, fRank, tFile, tRank, obsRank, obsFile;
		obsRank = (int) move.charAt(2) - 48;
		obsRank = 8 - obsRank;
		obsFile = ((int) (move.charAt(1))) - 97;

		// obstacle
		if (move.length() == 3) {
			if (move.charAt(0) == '.') {

			}
			// mine
			else if (a == 77) {

				obstaclePlace(obsRank, obsFile, 3, player, 0);
			}
			// trap
			else if (a == 68) {
				obstaclePlace(obsRank, obsFile, 2, player, 0);
			}
			// south wall
			else if (a == 95 && ((player == 20 && Chess.wcount > 0) || (player == -20 && Chess.bcount >0))) {
				if (player == 20) {
					Chess.wcount--;
				} else {
					Chess.bcount--;
				}
				if (board[obsRank][obsFile] == 0) {
					obstaclePlace(obsRank, obsFile, 1, player, 2);

				} else if (board[obsRank][obsFile] > 0) {
					obstaclePlace(obsRank, obsFile, 1, 20, 2);
				} else {
					obstaclePlace(obsRank, obsFile, 1, -20, 2);
				}
			}
			// west wall
			else if (((player == 20 && Chess.wcount < 3) || (player == -20 && Chess.bcount < 3))) {
				if (player == 20) {
					Chess.wcount++;
				} else {
					Chess.bcount++;
				}
				if (board[obsRank][obsFile] == 0) {
					obstaclePlace(obsRank, obsFile, 1, player, 1);
				} else if (board[obsRank][obsFile] > 0) {
					obstaclePlace(obsRank, obsFile, 1, 20, 1);
				} else {
					obstaclePlace(obsRank, obsFile, 1, -20, 1);
				}
			}
		} // promotion
		if (move.length() == 7) {
			fRank = (int) move.charAt(1) - 48;
			fRank = 8 - fRank;
			fFile = ((int) (move.charAt(0))) - 97;
			tRank = (int) move.charAt(4) - 48;
			tRank = 8 - tRank;
			tFile = ((int) (move.charAt(3))) - 97;
			char piece = move.charAt(6);
			if (Math.abs(board[fRank][fFile]) == 6) {
				Chess.promotion(piece, fRank, fFile, tRank, tFile, player);
			} else {
				System.out.println("invalid promotion");
			}

		}
		// normal move
		if (move.length() == 5) {
			fRank = (int) move.charAt(1) - 48;
			fRank = 8 - fRank;
			fFile = ((int) (move.charAt(0))) - 97;
			tRank = (int) move.charAt(4) - 48;
			tRank = 8 - tRank;
			tFile = ((int) (move.charAt(3))) - 97;
			boolean playerchange = false;
			if (Chess.board[tRank][tFile] == 0) {
				Chess.clocking++;
			} else {
				Chess.clocking = 0;
			}
			if (ObstacleCheck.obsType(fRank, fFile, tRank, tFile, player, Chess.board, playerchange) == false) {
				if (Chess.isValidMove(fRank, fFile, tRank, tFile, player, false)) {
					Chess.makeMove(fRank, fFile, tRank, tFile);

				} else {
					Chess.invalidMove = true;
					Chess.imove = move;
					// System.out.println("fr= "+fRank+"ff="+fFile+"tr="+tRank+"tf="+tFile);
				}
			}
		}
	}

	public static boolean checkmate() {

		return false;
	}

	public static boolean check(boolean check) {
		// checkmate check
		int wkr = 0;
		int wkf = 0;
		int bkr = 0;
		int bkf = 0;
		// finding king
		for (int r = 0; r < 8; r++) {
			for (int s = 0; s < 8; s++) {

				if (Chess.board[r][s] == -1) {
					bkr = r;
					bkf = s;
				}

				if (Chess.board[r][s] == 1) {
					wkr = r;
					wkf = s;
				}

			}
		} // check?
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {

				if (Chess.isValidMove(x, y, wkr, wkf, -20, false) == true) {

					check = true;

				} else if (Chess.isValidMove(x, y, bkr, bkf, 20, false) == true) {
					check = true;

				} else {
					check = false;

				}
			}
		}
		if (check == true) {
			return true;
		}
		return false;
	}

	public static void filePrint() {
		// Giving the pieces symbols

		// White
		String WhiteKing = "K";
		String WhiteQueen = "Q";
		String WhiteRook = "R";
		String WhiteBishop = "B";
		String WhiteKnight = "N";
		String WhitePawn = "P";
		String WhiteHiddenTrap = "D";
		String WhiteOpenTrap = "O";
		String WhiteMine = "M";
		String WhiteSouthWall = "_";
		String WhiteWestWall = "|";
		String WhiteWSWall = "|_";
		// Black
		String BlackKing = "k";
		String BlackQueen = "q";
		String BlackRook = "r";
		String BlackBishop = "b";
		String BlackKnight = "n";
		String BlackPawn = "p";
		String BlackHiddenTrap = "d";
		String BlackOpenTrap = "o";
		String BlackMine = "m";
		String BlackSouthWall = "_";
		String BlackWestWall = "|";
		String BlackWSWall = "|_";
		String X = "X";

		// printing letters to represent pieces
		for (int r = 0; r <= 7; r++) {

			for (int c = 0; c <= 7; c++) {
				if (board[r][c] == 0) {
					System.out.print(".");
				} else if (board[r][c] == 1) {
					System.out.print("" + WhiteKing + "");
				} else if (board[r][c] == 2) {
					System.out.print("" + WhiteQueen + "");
				} else if (board[r][c] == 3) {
					System.out.print("" + WhiteRook + "");
				} else if (board[r][c] == 4) {
					System.out.print("" + WhiteBishop + "");
				} else if (board[r][c] == 5) {
					System.out.print("" + WhiteKnight + "");
				} else if (board[r][c] == 6) {
					System.out.print("" + WhitePawn + "");
				} else if (board[r][c] == 7) {
					System.out.print("" + WhiteHiddenTrap + "");
				} else if (board[r][c] == 8) {
					System.out.print("" + WhiteOpenTrap + "");
				} else if (board[r][c] == 9) {
					System.out.print("" + WhiteMine + "");
				} else if (board[r][c] == 10) {
					System.out.print("" + WhiteSouthWall + ".");
				} else if (board[r][c] == 11) {
					System.out.print("" + WhiteWestWall + ".");
				} else if (board[r][c] == 12) {
					System.out.print("" + WhiteWSWall + ".");
				} else if (board[r][c] == -1) {
					System.out.print("" + BlackKing + "");
				} else if (board[r][c] == -2) {
					System.out.print("" + BlackQueen + "");
				} else if (board[r][c] == -3) {
					System.out.print("" + BlackRook + "");
				} else if (board[r][c] == -4) {
					System.out.print("" + BlackBishop + "");
				} else if (board[r][c] == -5) {
					System.out.print("" + BlackKnight + "");
				} else if (board[r][c] == -6) {
					System.out.print("" + BlackPawn + "");
				} else if (board[r][c] == -7) {
					System.out.print("" + BlackHiddenTrap + "");
				} else if (board[r][c] == -8) {
					System.out.print("" + BlackOpenTrap + "");
				} else if (board[r][c] == -9) {
					System.out.print("" + BlackMine + "");
				} else if (board[r][c] == -10) {
					System.out.print("" + BlackSouthWall + ".");
				} else if (board[r][c] == -11) {
					System.out.print("" + BlackWestWall + ".");
				} else if (board[r][c] == -12) {
					System.out.print("" + BlackWSWall + ".");
				} else if (board[r][c] == 13) {
					System.out.print("" + X + "");
				} // west walls
				if (board[r][c] == 20) {
					System.out.print("|" + WhiteKing + "");
				} else if (board[r][c] == 21) {
					System.out.print("|" + WhiteQueen + "");
				} else if (board[r][c] == 22) {
					System.out.print("|" + WhiteRook + "");
				} else if (board[r][c] == 23) {
					System.out.print("|" + WhiteBishop + "");
				} else if (board[r][c] == 24) {
					System.out.print("|" + WhiteKnight + "");
				} else if (board[r][c] == 25) {
					System.out.print("|" + WhitePawn + "");
				} else if (board[r][c] == 26) {
					System.out.print("|" + WhiteHiddenTrap);
				} else if (board[r][c] == 27) {
					System.out.print("|" + WhiteOpenTrap);
				} else if (board[r][c] == 28) {
					System.out.print("|" + WhiteMine);
				} else if (board[r][c] == 29) {
					System.out.print("" + WhiteWSWall + "");
				} else if (board[r][c] == 30) {
					System.out.print(" " + WhiteWestWall + "");
				} else if (board[r][c] == 31) {
					System.out.print("" + WhiteWSWall + "");
				} else if (board[r][c] == -20) {
					System.out.print("|" + BlackKing + "");
				} else if (board[r][c] == -21) {
					System.out.print("|" + BlackQueen + "");
				} else if (board[r][c] == -22) {
					System.out.print("|" + BlackRook + "");
				} else if (board[r][c] == -23) {
					System.out.print("|" + BlackBishop + "");
				} else if (board[r][c] == -24) {
					System.out.print("|" + BlackKnight + "");
				} else if (board[r][c] == -25) {
					System.out.print("|" + BlackPawn + "");
				} else if (board[r][c] == -26) {
					System.out.print("|" + BlackHiddenTrap);
				} else if (board[r][c] == -27) {
					System.out.print("|" + BlackOpenTrap + "");
				} else if (board[r][c] == -28) {
					System.out.print("|" + BlackMine + "");
				} else if (board[r][c] == -29) {
					System.out.print("" + BlackWSWall + "");
				} else if (board[r][c] == -30) {
					System.out.print(" " + BlackWestWall + "");
				} else if (board[r][c] == -31) {
					System.out.print("" + BlackWSWall + "");
				}

				// south walls
				if (board[r][c] == 40) {
					System.out.print("_" + WhiteKing + "");
				} else if (board[r][c] == 41) {
					System.out.print("_" + WhiteQueen + "");
				} else if (board[r][c] == 42) {
					System.out.print("_" + WhiteRook + "");
				} else if (board[r][c] == 43) {
					System.out.print("_" + WhiteBishop + "");
				} else if (board[r][c] == 44) {
					System.out.print("_" + WhiteKnight + "");
				} else if (board[r][c] == 45) {
					System.out.print("_" + WhitePawn + "");
				} else if (board[r][c] == 46) {
					System.out.print("_" + WhiteHiddenTrap);
				} else if (board[r][c] == 47) {
					System.out.print("_" + WhiteOpenTrap);
				} else if (board[r][c] == 48) {
					System.out.print("_" + WhiteMine);
				} else if (board[r][c] == 49) {
					System.out.print("" + WhiteSouthWall + " ");
				} else if (board[r][c] == 50) {
					System.out.print("" + WhiteWSWall + " ");
				} else if (board[r][c] == 51) {
					System.out.print("" + WhiteWSWall + " ");
				} else if (board[r][c] == -40) {
					System.out.print("_" + BlackKing + "");
				} else if (board[r][c] == -41) {
					System.out.print("_" + BlackQueen + "");
				} else if (board[r][c] == -42) {
					System.out.print("_" + BlackRook + "");
				} else if (board[r][c] == -43) {
					System.out.print("_" + BlackBishop + "");
				} else if (board[r][c] == -44) {
					System.out.print("_" + BlackKnight + "");
				} else if (board[r][c] == -45) {
					System.out.print("_" + BlackPawn + "");
				} else if (board[r][c] == -46) {
					System.out.print("_" + BlackHiddenTrap);
				} else if (board[r][c] == -47) {
					System.out.print("_" + BlackOpenTrap + "");
				} else if (board[r][c] == -48) {
					System.out.print("_" + BlackMine + "");
				} else if (board[r][c] == -49) {
					System.out.print("" + BlackSouthWall + " ");
				} else if (board[r][c] == -50) {
					System.out.print("" + BlackWSWall + "");
				} else if (board[r][c] == -51) {
					System.out.print("" + BlackWSWall + "");
				}

				// west south walls
				if (board[r][c] == 60) {
					System.out.print("|_" + WhiteKing + "");
				} else if (board[r][c] == 61) {
					System.out.print("|_" + WhiteQueen + "");
				} else if (board[r][c] == 62) {
					System.out.print("|_" + WhiteRook + "");
				} else if (board[r][c] == 63) {
					System.out.print("|_" + WhiteBishop + "");
				} else if (board[r][c] == 64) {
					System.out.print("|_" + WhiteKnight + "");
				} else if (board[r][c] == 65) {
					System.out.print("|_" + WhitePawn + "");
				} else if (board[r][c] == 66) {
					System.out.print("|_" + WhiteHiddenTrap);
				} else if (board[r][c] == 67) {
					System.out.print("|_" + WhiteOpenTrap);
				} else if (board[r][c] == 68) {
					System.out.print("|_" + WhiteMine);
				} else if (board[r][c] == 69) {
					System.out.print("" + WhiteWSWall + "");
				} else if (board[r][c] == 70) {
					System.out.print("" + WhiteWSWall + "");
				} else if (board[r][c] == 71) {
					System.out.print("" + WhiteWSWall + "");
				} else if (board[r][c] == -60) {
					System.out.print("|_" + BlackKing + "");
				} else if (board[r][c] == -61) {
					System.out.print("|_" + BlackQueen + "");
				} else if (board[r][c] == -62) {
					System.out.print("|_" + BlackRook + "");
				} else if (board[r][c] == -63) {
					System.out.print("|_" + BlackBishop + "");
				} else if (board[r][c] == -64) {
					System.out.print("|_" + BlackKnight + "");
				} else if (board[r][c] == -65) {
					System.out.print("|_" + BlackPawn + "");
				} else if (board[r][c] == -66) {
					System.out.print("|_" + BlackHiddenTrap);
				} else if (board[r][c] == -67) {
					System.out.print("|_" + BlackOpenTrap + "");
				} else if (board[r][c] == -68) {
					System.out.print("|_" + BlackMine + "");
				} else if (board[r][c] == -69) {
					System.out.print("" + BlackWSWall + "");
				} else if (board[r][c] == -70) {
					System.out.print("" + BlackWSWall + "");
				} else if (board[r][c] == -71) {
					System.out.print("" + BlackWSWall + "");
				}

			}
			System.out.println();
			// System.out.println();
		}

	}
}
