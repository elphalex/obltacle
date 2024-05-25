
public class Move {
	// finds the type of piece being moves
	public static boolean pieceType(int[][] board, int fromRank, int fromFile, int toRank, int toFile, int player) {
		if (board[fromRank][fromFile] == 1 || board[fromRank][fromFile] == -1) {

			if (king(fromRank, fromFile, toRank, toFile) == false) {
				return false;
			}
		}
		if (board[fromRank][fromFile] == 2 || board[fromRank][fromFile] == -2) {
			if (queen(fromRank, fromFile, toRank, toFile) == false) {
				return false;
			}
		}
		if (board[fromRank][fromFile] == 3 || board[fromRank][fromFile] == -3) {
			if (rook(fromRank, fromFile, toRank, toFile) == false) {
				return false;
			}
		}
		if (board[fromRank][fromFile] == 4 || board[fromRank][fromFile] == -4) {
			if (bishop(fromRank, fromFile, toRank, toFile) == false) {
				return false;
			}
		}
		if (board[fromRank][fromFile] == 5 || board[fromRank][fromFile] == -5) {
			if (knight(fromRank, fromFile, toRank, toFile) == false) {
				return false;
			}
		}
		if (board[fromRank][fromFile] == 6 || board[fromRank][fromFile] == -6) {
			if (pawn(fromRank, fromFile, toRank, toFile, board, player) == false) {
				return false;
			}
		}
		return true;
	}

	// parameters for king
	public static boolean king(int fromRank, int fromFile, int toRank, int toFile) {
		// horizontal move
		if (Math.abs(fromRank - toRank) == 0) {
			if (Math.abs(fromFile - toFile) == 1) {

				return true;
			} else {

				return false;
			}
		}
		// vertical
		if (Math.abs(fromFile - toFile) == 0) {
			if (Math.abs(fromRank - toRank) == 1) {

				return true;
			} else {

				return false;
			}
		}
		// diagonal
		if (Math.abs(fromRank - toRank) == Math.abs(fromFile - toFile)) {
			if ((Math.abs(fromFile - toFile) == 1) && (Math.abs(fromRank - toRank) == 1)) {

				return true;
			} else {

				return false;
			}
		}

		return false;
	}

	// parameters for queen
	public static boolean queen(int fromRank, int fromFile, int toRank, int toFile) {
		// horizontal move
		if (Math.abs(fromRank - toRank) == 0) {

			return true;
		}
		// vertical
		if (Math.abs(fromFile - toFile) == 0) {

			return true;
		}

		// diagonal
		if (Math.abs(fromRank - toRank) == Math.abs(fromFile - toFile)) {
			return true;
		}
		return false;
	}

	// parameters for rook
	public static boolean rook(int fromRank, int fromFile, int toRank, int toFile) {
		// horizontal move
		if (Math.abs(fromRank - toRank) == 0) {

			return true;
		}
		// vertical
		if (Math.abs(fromFile - toFile) == 0) {

			return true;
		}
		return false;
	}

	// parameters for bishop
	public static boolean bishop(int fromRank, int fromFile, int toRank, int toFile) {
		// diagonal
		if (Math.abs(fromRank - toRank) == Math.abs(fromFile - toFile)) {
			return true;
		}
		return false;
	}

	// parameters for knight
	public static boolean knight(int fromRank, int fromFile, int toRank, int toFile) {
		// diagonal
		if (Math.abs(fromRank - toRank) == 2 && Math.abs(fromFile - toFile) == 1) {

			return true;
		}
		if (Math.abs(fromRank - toRank) == 1 && Math.abs(fromFile - toFile) == 2) {

			return true;
		}
		return false;
	}

	// parameters for pawn
	public static boolean pawn(int fromRank, int fromFile, int toRank, int toFile, int[][] board, int player) {
		// vertical move
		int p = board[toRank][toFile];

		if (Math.abs(fromFile - toFile) == 0 && (p == 0 || (p >= 7 && p <= 12) || (p <= -7 && p >= -12)
				|| (p >= 26 && p <= 31) || (p <= -26 && p >= -31) || (p >= 46 && p <= 51) || (p <= -46 && p >= -51)
				|| (p >= 66 && p <= 71) || (p <= -66 && p >= -71))) {

			if (board[fromRank][fromFile] == 6 && (fromRank - toRank) == 1 && (board[toRank][toFile] == 0 || Math.abs(p)==10)) {

				return true;
			}
			if (board[fromRank][fromFile] == -6 && (fromRank - toRank) == -1) {

				return true;
			} else if ((Math.abs(fromRank - toRank) == 2) && board[fromRank][fromFile] == 6 && fromRank == 6) {

				return true;
			} else if ((Math.abs(fromRank - toRank) == 2) && board[fromRank][fromFile] == -6 && fromRank == 1) {

				return true;
			} else {

				return false;
			}
		}
		// white capturing black north east
		if ((player == 20) && (fromRank - toRank == 1) && (fromFile - toFile == -1) && (board[toRank][toFile] < 0)) {
			return true;
		}
		// white capturing black north west
		if ((player == 20) && (fromRank - toRank == 1) && (fromFile - toFile == 1) && (board[toRank][toFile] < 0)) {
			return true;
		}
		// Black capturing white south east
		if ((player == -20) && (fromRank - toRank == -1) && (fromFile - toFile == -1) && (board[toRank][toFile] > 0)) {
			return true;
		}
		// Black capturing white south west
		if ((player == -20) && (fromRank - toRank == -1) && (fromFile - toFile == 1) && (board[toRank][toFile] > 0)) {
			return true;
		}

		return false;
	}

	public static boolean fromWall(int fromRank, int fromFile, int toRank, int toFile, int[][] board, int player) {
		int p = Math.abs(board[fromRank][fromFile]);
		int t = board[toRank][toFile];
		
		if (player == 20) {
			// west walls
			if ((p >= 20 && p <= 31)) {
				if (toFile >= fromFile || p==24) {
					board[toRank][toFile] = p - 19;
					board[fromRank][fromFile] = 11;
					return true;
				}
			}
			// south walls
			if ((p >= 40 && p <= 51)) {
				if (toRank >= fromRank|| p==44) {
					board[toRank][toFile] = p - 39;
					board[fromRank][fromFile] = 10;
					return true;
				}
			}
			//south west walls
			if ((p >= 60 && p <= 71)) {
			
				if ((toRank >= fromRank && toFile>= fromFile)|| p==64) {
					
					board[toRank][toFile] = p - 59;
					board[fromRank][fromFile] = 12;
					return true;
				}
			}
		} else {
			// west walls
			if ((p >= 20 && p <= 31)) {
				if (toFile >= fromFile|| p==24) {
					board[toRank][toFile] = (-1)*(p - 19);
					board[fromRank][fromFile] = -11;
					return true;
				}
			} // south walls
			if ((p >= 40 && p <= 51)) {
				if (toRank >= fromRank|| p==44) {
					board[toRank][toFile] = (-1)*( p - 39);
					board[fromRank][fromFile] = -10;
					return true;
				}
			}
			//south west walls
			if ((p >= 60 && p <= 71)) {
				if ((toRank >= fromRank && toFile>= fromFile)|| p==64) {
					board[toRank][toFile] = (-1)*(p - 59);
					board[fromRank][fromFile] = -12;
					return true;
				}
			}
		}
		return false;
	}
}
