import java.util.Scanner;

public class Obstacles {
	// white players obstacles
	public static void whiteObstacle() {

		int player = 20;
		int wsWall = 0;
		Scanner question1 = new Scanner(System.in);
		System.out.println("White player would you like to place a trap? (y/n)");
		String answer1 = question1.next();
		int number1 = (int) answer1.charAt(0);

		// white trap
		if (number1 == 121) {
			boolean wTrap = true;
			while (wTrap) {
				int obstacle = 2;
				System.out.println("Where would you like to place your trap? ");
				String whiteTrap = question1.next();
				int obsFile = (int) whiteTrap.charAt(0) - 97;
				int obsRank = (int) whiteTrap.charAt(1) - 48;
				
				if (obsRank >= 3 && obsRank <= 6) {
					obsRank = 8 - obsRank;
					Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
					Chess.boardPrint();
					wTrap = false;
				} else {
					System.out.println("Invalid Rank... try again.");
				}
			}
		}

		System.out.println("White player would you like to place a mine? (y/n)");
		String answer2 = question1.next();
		int number2 = (int) answer2.charAt(0);

		// white mine
		if (number2 == 121) {
			boolean wMine = true;
			while (wMine) {
				int obstacle = 3;
				System.out.println("Where would you like to place your mine? ");
				String whiteMine = question1.next();
				int obsFile = (int) whiteMine.charAt(0) - 97;
				int obsRank = (int) whiteMine.charAt(1) - 48;
				
				if (obsRank <= 5 && obsRank >= 4) {
					obsRank = 8 - obsRank;
					Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
					Chess.boardPrint();
					wMine = false;
				} else {
					System.out.println("Invalid Rank... try again.");
				}
			}
		}
	}

	// black players obstacles
	public static void blackObstacle() {
		int player = -20;
		int wsWall = 0;
		Scanner question1 = new Scanner(System.in);
		System.out.println("Black player would you like to place a trap? (y/n)");
		String answer1 = question1.next();
		int number1 = (int) answer1.charAt(0);

		// Black trap
		if (number1 == 121) {
			int obstacle = 2;
			boolean bTrap = true;
			while (bTrap) {
				System.out.println("Where would you like to place your trap? ");
				String blackTrap = question1.next();
				int obsFile = (int) blackTrap.charAt(0) - 97;
				int obsRank = (int) blackTrap.charAt(1) - 48;
				
				if (obsRank >= 3 && obsRank <= 6) {
					obsRank = 8 - obsRank;
					Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
					Chess.boardPrint();
					bTrap = false;
				} else {
					System.out.println("Invalid Rank... try again.");
				}
			}
		}

		System.out.println("Black player would you like to place a mine? (y/n)");
		String answer2 = question1.next();
		int number2 = (int) answer2.charAt(0);

		// Black mine
		if (number2 == 121) {
			boolean bMine = true;
			while (bMine) {
				int obstacle = 3;
				System.out.println("Where would you like to place your mine? ");
				String blackMine = question1.next();
				int obsFile = (int) blackMine.charAt(0) - 97;
				int obsRank = (int) blackMine.charAt(1) - 48;
				
				if (obsRank <= 5 && obsRank >= 4) {
					obsRank = 8 - obsRank;
					Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
					Chess.boardPrint();
					bMine = false;
				} else {
					System.out.println("Invalid Rank... try again.");
				}
			}
		}
	}

	// placing of walls for both players
	public static void walls(int player, int whiteWallCounter, int blackWallCounter) {
		if (whiteWallCounter > 3|| blackWallCounter>3) {
			System.out.println("no walls left");
		}
		int obstacle = 1;
		int wsWall = 0;/* west =1 and south =2 */
		Scanner wall = new Scanner(System.in);
		System.out.println("West wall or South wall? (w/s)");
		String wallType = wall.next();
		int wallTypeNum = (int) wallType.charAt(0);
		// west
		if (wallTypeNum == 119) {
			wsWall = 1;
		} // south
		if (wallTypeNum == 115) {
			wsWall = 2;
		}
		System.out.println("Where would you like to place the wall?");

		String wallMove = wall.next();
		int obsRank = (int) wallMove.charAt(1) - 48;
		obsRank = 8 - obsRank;
		int obsFile = (int) wallMove.charAt(0) - 97;
		// white wall
		if (player == 20) {
			Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
			Chess.boardPrint();
		}
		// black wall
		if (player == -20) {
			Chess.obstaclePlace(obsRank, obsFile, obstacle, player, wsWall);
			Chess.boardPrint();
		}
	}

}
