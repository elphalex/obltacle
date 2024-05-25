
public class PathChecker {

	// what checker to use for each move
	public static boolean selectChecker(int fromRank, int fromFile, int toRank, int toFile, int player, int[][] board) {
		// horizontal
		if (Math.abs(fromRank - toRank) == 0) {
			if (horizontalCheck(fromRank, fromFile, toRank, toFile, player, board) == true) {
				return true;
			}
		}
		// vertical
		if (Math.abs(fromFile - toFile) == 0) {
			if (verticalCheck(fromRank, fromFile, toRank, toFile, player, board) == true) {
				return true;
			}
		}
		// diagonal
		if (Math.abs(fromRank - toRank) == Math.abs(fromFile - toFile)) {
			;
			if (diagonalCheck(fromRank, fromFile, toRank, toFile, player, board) == true) {
				return true;
			}
		}
		// knight
		int p = board[fromRank][fromFile];
		
		if ((p == 5 || p == -5 || p == 24 || p == -24 || p == 44 || p == -44 || p == 64 || p == -64)) {
			return true;
		}
		return false;
	}

	// checks that no pieces are in the way when moving horizontally
	public static boolean horizontalCheck(int fromRank, int fromFile, int toRank, int toFile, int player,
			int[][] board) {
		int counter = 0;
		// east horizontal move
		if (fromFile < toFile) {
			for (int a = fromFile + 1; a <= (toFile - 1); a++) {
				int p = board[fromRank][a];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}

			}
		}
		// west horizontal move
		if (fromFile > toFile) {
			for (int a = fromFile - 1; a >= (toFile + 1); a--) {
				int p = board[fromRank][a];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// stopping player from taking own piece
		if (board[toRank][toFile] > 0 && player == 20) {
			return false;
		}
		if (board[toRank][toFile] < 0 && player == -20) {
			return false;
		}

		if (counter == 0) {
			return true;
		}
		return false;
	}

	// checks that no pieces are in the way when moving vertically
	public static boolean verticalCheck(int fromRank, int fromFile, int toRank, int toFile, int player, int[][] board) {
		int counter = 0;
		// south vertical move
		if (fromRank < toRank) {
			for (int a = fromRank + 1; a <= (toRank); a++) {
				int p = board[a][fromFile];
				
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// north vertical move
		if (fromRank > toRank) {
			for (int a = fromRank - 1; (a >= toRank + 1); a--) {
				int p = board[a][fromFile];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// stopping player from taking own piece
		if (board[toRank][toFile] > 0 && player == 20) {
			return false;
		}
		if (board[toRank][toFile] < 0 && player == -20) {
			return false;
		}
		if (counter == 0) {
			return true;
		}
		return false;
	}

	// checks that no pieces or walls are in the way when moving diagonally
	public static boolean diagonalCheck(int fromRank, int fromFile, int toRank, int toFile, int player, int[][] board) {
		int counter = 0;
		// north east
		if ((fromRank > toRank) && (fromFile < toFile)) {
			for (int a = fromRank - 1, b = fromFile + 1; (a >= (toRank + 1)) && (b <= (toFile - 1)); a--, b++) {
				int p = board[a][b];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// north west
		if ((fromRank > toRank) && (fromFile > toFile)) {
			for (int a = fromRank - 1, b = fromFile - 1; (a >= (toRank + 1)) && (b >= (toFile + 1)); a--, b--) {
				int p = board[a][b];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// south east
		if ((fromRank < toRank) && (fromFile < toFile)) {
			for (int a = fromRank + 1, b = fromFile + 1; (a <= (toRank - 1)) && (b <= (toFile - 1)); a++, b++) {
				int p = board[a][b];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// south west
		if ((fromRank < toRank) && (fromFile > toFile)) {
			for (int a = fromRank + 1, b = fromFile - 1; (a <= (toRank - 1)) && (b >= (toFile + 1)); a++, b--) {
				int p = board[a][b];
				if (p != 0 && (p < 7 || p > 12) && (p > -7 || p < -12) && (p < 26 || p > 31) && (p > -26 || p < -31)
						&& (p < 46 || p > 51) && (p > -46 || p < -51) && (p < 66 || p > 71) && (p > -66 || p < -71)) {
					counter++;
				}
			}
		}
		// stopping player from taking own piece
		if (board[toRank][toFile] > 0 && player == 20) {
			return false;
		}
		if (board[toRank][toFile] < 0 && player == -20) {
			return false;
		}

		if (counter == 0) {
			return true;
		}
		return false;
	}
}
