import java.awt.Font;

public class GraphicObstacle {

	public static void obs() {
		int player = 20;
		String yes = "yes.jpg";
		String no = "no.jpg";
		String black = "black.png";
		String white = "white.png";

		// white
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(45, 40, 30, 15);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.picture(45, 45, white, 15, 15);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(45, 30, "Would you like to place a trap?");
		StdDraw.picture(25, 45, yes, 20, 20);
		StdDraw.picture(65, 45, no, 20, 20);
		// StdDraw.show(100);

		boolean t1 = true;
		int r1 = 0;
		int f1 = 0;
		while (t1) {

			if (StdDraw.mousePressed()) {
				r1 = (int) (StdDraw.mouseY() - 5) / 10;
				f1 = (int) (StdDraw.mouseX() - 5) / 10;
				t1 = false;
			}

		}
		if ((r1 == 3 || r1 == 4) && (f1 == 1 || f1 == 2)) {
			// place a trap

			Chess.drawBoard(player);
			whiteTrap();
		} else {
			GamePlay.gamelog('\n' + "...", false);
		}
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(45, 40, 30, 15);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.picture(45, 45, white, 15, 15);
		StdDraw.setFont(obsta);
		StdDraw.text(45, 30, "Would you like to place a mine?");
		StdDraw.picture(25, 45, yes, 20, 20);
		StdDraw.picture(65, 45, no, 20, 20);
		StdDraw.show(500);

		boolean m1 = true;
		int r2 = 0;
		int f2 = 0;
		while (m1) {

			if (StdDraw.mousePressed()) {
				r2 = (int) (StdDraw.mouseY() - 5) / 10;
				f2 = (int) (StdDraw.mouseX() - 5) / 10;
				m1 = false;
			}

		}
		if ((r2 == 3 || r2 == 4) && (f2 == 1 || f2 == 2)) {
			// place a mine
			Chess.drawBoard(player);
			whiteMine();
		} else {
			GamePlay.gamelog('\n' + "...", false);
		}

		// black
		player = -20;
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		Chess.drawBoard(player);
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(45, 40, 30, 15);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.picture(45, 45, black, 20, 20);
		StdDraw.setFont(obsta);
		StdDraw.text(45, 30, "Would you like to place a trap?");
		StdDraw.picture(25, 45, yes, 20, 20);
		StdDraw.picture(65, 45, no, 20, 20);
		StdDraw.show(500);

		boolean t2 = true;
		int r3 = 0;
		int f3 = 0;
		while (t2) {

			if (StdDraw.mousePressed()) {
				r3 = (int) (StdDraw.mouseY() - 5) / 10;
				f3 = (int) (StdDraw.mouseX() - 5) / 10;
				t2 = false;
			}

		}
		if ((r3 == 3 || r3 == 4) && (f3 == 1 || f3 == 2)) {
			// place a trap
			Chess.drawBoard(player);
			blackTrap();
		} else {
			GamePlay.gamelog('\n' + "...", false);
		}
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(45, 40, 30, 15);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		StdDraw.picture(45, 45, black, 20, 20);
		StdDraw.setFont(obsta);
		StdDraw.text(45, 30, "Would you like to place a mine?");
		StdDraw.picture(25, 45, yes, 20, 20);
		StdDraw.picture(65, 45, no, 20, 20);
		StdDraw.show(500);

		boolean m2 = true;
		int r4 = 0;
		int f4 = 0;
		while (m2) {

			if (StdDraw.mousePressed()) {
				r4 = (int) (StdDraw.mouseY() - 5) / 10;
				f4 = (int) (StdDraw.mouseX() - 5) / 10;
				m2 = false;
			}

		}
		if ((r4 == 3 || r4 == 4) && (f4 == 1 || f4 == 2)) {
			// place a mine
			Chess.drawBoard(player);
			blackMine();

		} else {
			GamePlay.gamelog('\n' + "...", false);
			Chess.drawBoard(20);
		}
	}

	public static void whiteTrap() {
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "Select a block between rank 3 and 6");
		StdDraw.show(500);
		boolean select = false;
		int r1 = 0;
		int f1 = 0;
		while (!select) {
			boolean t1 = true;

			while (t1) {

				if (StdDraw.mousePressed()) {
					r1 = (int) (StdDraw.mouseY() - 5) / 10;
					f1 = (int) (StdDraw.mouseX() - 5) / 10;
					t1 = false;
				}
				if ((r1 >= 2 && r1 <= 5)) {
					select = true;
				}

			}
		}
		Chess.obstaclePlace(r1, f1, 2, 20, 0);
		Chess.drawBoard(20);
		GamePlay.gamelog('\n' + "D" + Chess.logConvert(f1) + (8 - r1), false);
	}

	public static void whiteMine() {
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "Select a block between rank 4 and 5");
		StdDraw.show(500);
		int r2 = 0;
		int f2 = 0;
		boolean select = false;
		while (!select) {
			boolean m1 = true;

			while (m1) {

				if (StdDraw.mousePressed()) {
					r2 = (int) (StdDraw.mouseY() - 5) / 10;
					f2 = (int) (StdDraw.mouseX() - 5) / 10;
					m1 = false;
				}
				if ((r2 >= 3 && r2 <= 4)) {
					select = true;
				}

			}
		}
		Chess.obstaclePlace(r2, f2, 3, 20, 0);
		GamePlay.gamelog('\n' + "M" + Chess.logConvert(f2) + (8 - r2), false);
	}

	public static void blackTrap() {
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "Select a block between rank 3 and 6");
		StdDraw.show(500);
		int r3 = 0;
		int f3 = 0;
		boolean select = false;
		while (!select) {
			boolean t2 = true;

			while (t2) {

				if (StdDraw.mousePressed()) {
					r3 = (int) (StdDraw.mouseY() - 5) / 10;
					f3 = (int) (StdDraw.mouseX() - 5) / 10;
					t2 = false;
				}
				if ((r3 >= 2 && r3 <= 5)) {
					select = true;
				}

			}
		}
		Chess.obstaclePlace(r3, f3, 2, -20, 0);
		GamePlay.gamelog('\n' + "D" + Chess.logConvert(f3) + (8 - r3), false);
	}

	public static void blackMine() {
		StdDraw.setPenColor(192, 192, 192);
		StdDraw.filledRectangle(50, 95, 50, 5);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "Select a block between rank 4 and 5");
		StdDraw.show(500);
		int r4 = 0;
		int f4 = 0;
		boolean select = false;
		while (!select) {
			boolean m2 = true;

			while (m2) {

				if (StdDraw.mousePressed()) {
					r4 = (int) (StdDraw.mouseY() - 5) / 10;
					f4 = (int) (StdDraw.mouseX() - 5) / 10;
					m2 = false;
				}
				if ((r4 >= 3 && r4 <= 4)) {
					select = true;
				}

			}
		}
		Chess.obstaclePlace(r4, f4, 3, -20, 0);
		GamePlay.gamelog('\n' + "M" + Chess.logConvert(f4) + (8 - r4), false);
		Chess.drawBoard(20);
	}

	public static void walls(int player, int whiteWallCounter, int blackWallCounter) {

		String button = "button.png";
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledRectangle(45, 40, 30, 15);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.picture(25, 45, button, 20, 20);
		StdDraw.picture(65, 45, button, 20, 20);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 30);
		StdDraw.setFont(obsta);
		StdDraw.text(45, 30, "West wall or South wall?");
		StdDraw.text(25, 45, "WEST");
		StdDraw.text(65, 45, "South");
		StdDraw.show();
		boolean wallss = true;
		int rank = 0;
		int file = 0;
		while (wallss) {

			if (StdDraw.mousePressed()) {
				rank = (int) (StdDraw.mouseY() - 5) / 10;
				file = (int) (StdDraw.mouseX() - 5) / 10;
				wallss = false;
			}

		}
		// Chess.drawBoard(player);

		// west
		if ((rank == 3 || rank == 4) && (file == 1 || file == 2)) {
			wallPlace(player, 1);
		}
		// south
		if ((rank == 3 || rank == 4) && (file == 5 || file == 6)) {
			wallPlace(player, 2);
		}
	}

	public static void wallPlace(int player, int sw) {
		Chess.drawBoard(player);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		Font obsta = new Font("Aharoni", Font.BOLD, 25);
		StdDraw.setFont(obsta);
		StdDraw.text(57, 95, "Select an empty block");
		StdDraw.show(500);
		boolean wallsss = true;
		int rank2 = 0;
		int file2 = 0;
		while (wallsss) {

			if (StdDraw.mousePressed()) {
				rank2 = (int) (StdDraw.mouseY() - 5) / 10;
				file2 = (int) (StdDraw.mouseX() - 5) / 10;
				wallsss = false;
			}

		}

		// west
		if (sw == 1) {
			Chess.obstaclePlace(rank2, file2, 1, player, 1);
			GamePlay.gamelog('\n' + "|" + Chess.logConvert(file2) + (8 - rank2), false);
			Chess.drawBoard(player);
		}
		// south
		if (sw == 2) {
			Chess.obstaclePlace(rank2, file2, 1, player, 2);
			GamePlay.gamelog('\n' + "_" + Chess.logConvert(file2) + (8 - rank2), false);
			Chess.drawBoard(player);

		}
	}
}
