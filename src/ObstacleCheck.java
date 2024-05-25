
public class ObstacleCheck {
	// identifies the type of obstacle if any
	public static boolean obsType(int fromRank, int fromFile, int toRank, int toFile, int player, int[][] board,
			boolean playerchange) {
		// check if move is valid first
		if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false) == false) {

			return false;
		}
		// horizontal
		if (Math.abs(fromRank - toRank) == 0) {
			if (horizontalObsCheck(fromRank, fromFile, toRank, toFile, player, board, playerchange) == true) {
				return true;
			}
		} // vertical
		if (Math.abs(fromFile - toFile) == 0) {
			if (verticalObsCheck(fromRank, fromFile, toRank, toFile, player, board, playerchange) == true) {
				return true;
			}
		}
		// diagonal
		if (Math.abs(fromRank - toRank) == Math.abs(fromFile - toFile)) {
			if (diagonalObsCheck(fromRank, fromFile, toRank, toFile, player, board, playerchange) == true) {
				return true;
			}

		}
		// knight
		int p = board[fromRank][fromFile];

		if ((p == 5 || p == -5 || p == 24 || p == -24 || p == 44 || p == -44 || p == 64 || p == -64)) {
			if (horseCheck(fromRank, fromFile, toRank, toFile, player, board, playerchange) == true) {
				return true;
			}
		}

		return false;
	}

	// horse
	public static boolean horseCheck(int fromRank, int fromFile, int toRank, int toFile, int player, int[][] board,
			boolean playerchange) {
		int q = board[fromRank][fromFile];
		int p = board[toRank][toFile];
		// trap
		if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66 || p == 67
				|| p == -66 || p == -67) {
			if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
				board[fromRank][fromFile] = 0;

				// changing closed trap to open trap
				if (board[toRank][toFile] == 7) {
					board[toRank][toFile] = 8;
				}
				if (board[toRank][toFile] == -7) {
					board[toRank][toFile] = -8;
				}
				if (board[toRank][toFile] == 46) {
					board[toRank][toFile] = 47;
				}
				if (board[toRank][toFile] == -46) {
					board[toRank][toFile] = -47;
				} // changing player
				player = player * (-1);
			}
			return true;
		} // mine
		if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68) {
			if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
				board[fromRank][fromFile] = 0;
				int wn = 0;
				int w = 0;
				int ws = 0;
				int ne = 0;
				int e = 0;
				int se = 0;
				/* center */ board[toRank][toFile] = 0;
				/* NW */ if (toFile != 0) {
					wn = board[toRank - 1][toFile - 1];
				}
				/* W */if (toFile != 0) {
					w = board[toRank][toFile - 1];
				}
				/* SW */if (toFile != 0) {
					ws = board[toRank + 1][toFile - 1];
				}
				/* N */ int n = board[toRank - 1][toFile];
				/* S */ int s = board[toRank + 1][toFile];
				/* NE */if (toFile != 7) {
					ne = board[toRank - 1][toFile + 1];
				}
				/* E */if (toFile != 7) {
					e = board[toRank][toFile + 1];
				}
				/* SE */if (toFile != 7) {
					se = board[toRank + 1][toFile + 1];
				}

				// stopping mines from destroying walls
				if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
						&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && toFile != 0) {
					board[toRank - 1][toFile - 1] = 0;
				}
				if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
						&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
						&& (w < 20 || w > 31) && (w > -20 || w < -31) && toFile != 0) {
					board[toRank][toFile - 1] = 0;
				}
				if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
						&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && toFile != 0) {
					board[toRank + 1][toFile - 1] = 0;
				}
				if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
						&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
						&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
					board[toRank - 1][toFile] = 0;
				}
				if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
						&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
						&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
					board[toRank + 1][toFile] = 0;
				}
				if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
						&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && toFile != 7) {
					board[toRank - 1][toFile + 1] = 0;
				}
				if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
						&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
						&& (e < 20 || e > 31) && (e > -20 || e < -31) && toFile != 7) {
					board[toRank][toFile + 1] = 0;
				}
				if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
						&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && toFile != 7) {
					board[toRank + 1][toFile + 1] = 0;
				}
				// changing player
				player = player * (-1);
			}
			return true;

		}
		return false;
	}

	// checks for obstacles when moving horizontally
	public static boolean horizontalObsCheck(int fromRank, int fromFile, int toRank, int toFile, int player,
			int[][] board, boolean playerchange) {

		// east horizontal move
		if (fromFile < toFile) {
			for (int a = fromFile + 1; a <= (toFile); a++) {
				int p = board[fromRank][a];
				int counter1 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;

						// changing closed trap to open trap
						if (board[fromRank][a] == 7) {
							board[fromRank][a] = 8;
						}
						if (board[fromRank][a] == -7) {
							board[fromRank][a] = -8;
						}
						if (board[fromRank][a] == 46) {
							board[fromRank][a] = 47;
						}
						if (board[fromRank][a] == -46) {
							board[fromRank][a] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 11 || p == -11 || p == 12 || p == -12 || (p >= 20 && p <= 31) || (p >= 50 && p <= 51)
						|| (p <= -20 && p >= -31) || (p <= -50 && p >= -51) || (p >= 60 && p <= 71)
						|| (p <= -60 && p >= -71)) {
					Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, true);
					Chess.players = 1;

					return true;

				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68 || p == 13) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */ if (board[fromRank][a] != 13) {
							board[fromRank][a] = 0;
						} else {
							board[fromRank][a] = 8;
						}
						/* NW */ if (a != 0) {
							wn = board[fromRank - 1][a - 1];
						}
						/* W */if (a != 0) {
							w = board[fromRank][a - 1];
						}
						/* SW */if (a != 0) {
							ws = board[fromRank + 1][a - 1];
						}
						/* N */ int n = board[fromRank - 1][a];
						/* S */ int s = board[fromRank + 1][a];
						/* NE */if (a != 7) {
							ne = board[fromRank - 1][a + 1];
						}
						/* E */if (a != 7) {
							e = board[fromRank][a + 1];
						}
						/* SE */if (a != 7) {
							se = board[fromRank + 1][a + 1];
						}

						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && a != 0) {
							board[fromRank - 1][a - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && a != 0) {
							board[fromRank][a - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && a != 0) {
							board[fromRank + 1][a - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[fromRank - 1][a] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[fromRank + 1][a] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && a != 7) {
							board[fromRank - 1][a + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && a != 7) {
							board[fromRank][a + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && a != 7) {
							board[fromRank + 1][a + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;

				}
			}
		}
		// west horizontal move
		if (fromFile > toFile) {
			for (int a = fromFile - 1; a >= (toFile); a--) {
				int p = board[fromRank][a];
				int counter2 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[fromRank][a] == 7) {
							board[fromRank][a] = 8;
						}
						if (board[fromRank][a] == -7) {
							board[fromRank][a] = -8;
						}
						if (board[fromRank][a] == 46) {
							board[fromRank][a] = 47;
						}
						if (board[fromRank][a] == -46) {
							board[fromRank][a] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 11 || p == -11 || p == 12 || p == -12 || (p >= 20 && p <= 31) || (p >= 50 && p <= 51)
						|| (p <= -20 && p >= -31) || (p <= -50 && p >= -51) || (p >= 60 && p <= 71)
						|| (p <= -60 && p >= -71)) {
					// if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
					// board[fromRank][a + 1] = board[fromRank][fromFile];
					// board[fromRank][fromFile] = 0;
					// // changing player
					// player = player * (-1);
					// }
					if (board[fromRank][a] == board[toRank][toFile]) {
						board[fromRank][fromFile] = 0;
						if (board[toRank][toFile] == 11 || board[toRank][toFile] == -11) {
							if (board[fromRank][fromFile] > 0) {
								board[toRank][toFile] = board[fromRank][fromFile] + 19;
							} else {
								board[toRank][toFile] = board[fromRank][fromFile] - 19;
							}
						}
					} else {
						Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, true);
						Chess.players = 1;
					}
					return true;

				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68 || p == 13) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */ if (board[fromRank][a] != 13) {
							board[fromRank][a] = 0;
						} else {
							board[fromRank][a] = 8;
						}
						/* NW */ if (a != 0) {
							wn = board[fromRank - 1][a - 1];
						}
						/* W */if (a != 0) {
							w = board[fromRank][a - 1];
						}
						/* SW */if (a != 0) {
							ws = board[fromRank + 1][a - 1];
						}
						/* N */ int n = board[fromRank - 1][a];
						/* S */ int s = board[fromRank + 1][a];
						/* NE */if (a != 7) {
							ne = board[fromRank - 1][a + 1];
						}
						/* E */if (a != 7) {
							e = board[fromRank][a + 1];
						}
						/* SE */if (a != 7) {
							se = board[fromRank + 1][a + 1];
						}
						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && a != 0) {
							board[fromRank - 1][a - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && a != 0) {
							board[fromRank][a - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && a != 0) {
							board[fromRank + 1][a - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[fromRank - 1][a] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[fromRank + 1][a] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && a != 7) {
							board[fromRank - 1][a + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && a != 7) {
							board[fromRank][a + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && a != 7) {
							board[fromRank + 1][a + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		return false;
	}

	// checks for obstacles when moving vertically
	public static boolean verticalObsCheck(int fromRank, int fromFile, int toRank, int toFile, int player,
			int[][] board, boolean playerchange) {

		// south vertical move
		if (fromRank < toRank) {

			for (int a = fromRank + 1; a <= (toRank); a++) {
				int p = board[a][fromFile];
				int counter1 = 0;

				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {

					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {

						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[a][fromFile] == 7) {
							board[a][fromFile] = 8;
						}
						if (board[a][fromFile] == -7) {
							board[a][fromFile] = -8;
						}
						if (board[a][fromFile] == 46) {
							board[a][fromFile] = 47;
						}
						if (board[a][fromFile] == -46) {
							board[a][fromFile] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 10 || p == -10 || p == 12 || p == -12 || (p >= 40 && p <= 51) || (p >= 29 && p <= 31)
						|| (p <= -40 && p >= -51) || (p <= -29 && p >= -31) || (p >= 60 && p <= 71)
						|| (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						int j = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						board[a - 1][fromFile] = j;
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68 || p == 13) {

					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {

						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */if (board[a][fromFile] != 13) {
							board[a][fromFile] = 0;
						} else {
							board[a][fromFile] = 8;
						}
						/* NW */ if (fromFile != 0) {
							wn = board[a - 1][fromFile - 1];
						}
						/* W */if (fromFile != 0) {
							w = board[a][fromFile - 1];
						}
						/* SW */if (fromFile != 0) {
							ws = board[a + 1][fromFile - 1];
						}
						/* N */ int n = board[a - 1][fromFile];
						/* S */ int s = board[a + 1][fromFile];
						/* NE */if (fromFile != 7) {
							ne = board[a - 1][fromFile + 1];
						}
						/* E */if (fromFile != 7) {
							e = board[a][fromFile + 1];
						}
						/* SE */if (fromFile != 7) {
							se = board[a + 1][fromFile + 1];
						}

						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71)
								&& fromFile != 0) {

							board[a - 1][fromFile - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && fromFile != 0) {
							board[a][fromFile - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71)
								&& fromFile != 0) {
							board[a + 1][fromFile - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][fromFile] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][fromFile] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71)
								&& fromFile != 7) {
							board[a - 1][fromFile + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && fromFile != 7) {
							board[a][fromFile + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71)
								&& fromFile != 7) {
							board[a + 1][fromFile + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}
		// north vertical move
		if (fromRank > toRank) {
			for (int a = fromRank - 1; (a >= toRank); a--) {
				int p = board[a][fromFile];
				int counter2 = 0;

				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {

					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {

						board[fromRank][fromFile] = 0;
						if (board[a][fromFile] == 7) {
							board[a][fromFile] = 8;
						}
						if (board[a][fromFile] == -7) {
							board[a][fromFile] = -8;
						}
						if (board[a][fromFile] == 46) {
							board[a][fromFile] = 47;
						}
						if (board[a][fromFile] == -46) {
							board[a][fromFile] = -47;
						}
						// changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 10 || p == -10 || p == 12 || p == -12 || (p >= 40 && p <= 51) || (p >= 29 && p <= 31)
						|| (p <= -40 && p >= -51) || (p <= -29 && p >= -31) || (p >= 60 && p <= 71)
						|| (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[a + 1][fromFile] = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68 || p == 13) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */if (board[a][fromFile] != 13) {
							board[a][fromFile] = 0;
						} else {
							board[a][fromFile] = 8;
						}
						/* NW */ if (fromFile != 0) {
							wn = board[a - 1][fromFile - 1];
						}
						/* W */if (fromFile != 0) {
							w = board[a][fromFile - 1];
						}
						/* SW */if (fromFile != 0) {
							ws = board[a + 1][fromFile - 1];
						}
						/* N */ int n = board[a - 1][fromFile];
						/* S */ int s = board[a + 1][fromFile];
						/* NE */if (fromFile != 7) {
							ne = board[a - 1][fromFile + 1];
						}
						/* E */if (fromFile != 7) {
							e = board[a][fromFile + 1];
						}
						/* SE */if (fromFile != 7) {
							se = board[a + 1][fromFile + 1];
						}

						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71)
								&& fromFile != 0) {
							board[a - 1][fromFile - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && fromFile != 0) {
							board[a][fromFile - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71)
								&& fromFile != 0) {
							board[a + 1][fromFile - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][fromFile] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][fromFile] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71)
								&& fromFile != 7) {
							board[a - 1][fromFile + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && fromFile != 7) {
							board[a][fromFile + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71)
								&& fromFile != 7) {
							board[a + 1][fromFile + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		return false;
	}

	// checks for obstacles when moving diagonally
	public static boolean diagonalObsCheck(int fromRank, int fromFile, int toRank, int toFile, int player,
			int[][] board, boolean playerchange) {

		// north east
		if ((fromRank > toRank) && (fromFile < toFile)) {
			for (int a = fromRank - 1, b = fromFile + 1; (a >= (toRank)) && (b <= (toFile)); a--, b++) {
				int p = board[a][b];
				int counter1 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[a][b] == 7) {
							board[a][b] = 8;
						}
						if (board[a][b] == -7) {
							board[a][b] = -8;
						}
						if (board[a][b] == 46) {
							board[a][b] = 47;
						}
						if (board[a][b] == -46) {
							board[a][b] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 12 || p == -12 || p == 29 || p == -29 || p == 31 || p == -31 || p == 50 || p == -50 || p == 51
						|| p == -51 || (p >= 60 && p <= 71) || (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[a + 1][b - 1] = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */if (board[a][b] != 13) {
							board[a][b] = 0;
						} else {
							board[a][b] = 8;
						}
						/* NW */ if (b != 0) {
							wn = board[a - 1][b - 1];
						}
						/* W */if (b != 0) {
							w = board[a][b - 1];
						}
						/* SW */if (b != 0) {
							ws = board[a + 1][b - 1];
						}
						/* N */ int n = board[a - 1][b];
						/* S */ int s = board[a + 1][b];
						/* NE */if (b != 7) {
							ne = board[a - 1][b + 1];
						}
						/* E */if (b != 7) {
							e = board[a][b + 1];
						}
						/* SE */if (b != 7) {
							se = board[a + 1][b + 1];
						}
						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && b != 0) {
							board[a - 1][b - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && b != 0) {
							board[a][b - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && b != 0) {
							board[a + 1][b - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][b] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][b] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && b != 7) {
							board[a - 1][b + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && b != 7) {
							board[a][b + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && b != 7) {
							board[a + 1][b + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		// north west
		if ((fromRank > toRank) && (fromFile > toFile)) {
			for (int a = fromRank - 1, b = fromFile - 1; (a >= (toRank)) && (b >= (toFile)); a--, b--) {
				int p = board[a][b];
				int counter2 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[a][b] == 7) {
							board[a][b] = 8;
						}
						if (board[a][b] == -7) {
							board[a][b] = -8;
						}
						if (board[a][b] == 46) {
							board[a][b] = 47;
						}
						if (board[a][b] == -46) {
							board[a][b] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 12 || p == -12 || p == 29 || p == -29 || p == 31 || p == -31 || p == 50 || p == -50 || p == 51
						|| p == -51 || (p >= 60 && p <= 71) || (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[a + 1][b + 1] = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */ if (board[a][b] != 13) {
							board[a][b] = 0;
						} else {
							board[a][b] = 8;
						}
						/* NW */ if (b != 0) {
							wn = board[a - 1][b - 1];
						}
						/* W */if (b != 0) {
							w = board[a][b - 1];
						}
						/* SW */if (b != 0) {
							ws = board[a + 1][b - 1];
						}
						/* N */ int n = board[a - 1][b];
						/* S */ int s = board[a + 1][b];
						/* NE */if (b != 7) {
							ne = board[a - 1][b + 1];
						}
						/* E */if (b != 7) {
							e = board[a][b + 1];
						}
						/* SE */if (b != 7) {
							se = board[a + 1][b + 1];
						}
						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && b != 0) {
							board[a - 1][b - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && b != 0) {
							board[a][b - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && b != 0) {
							board[a + 1][b - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][b] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][b] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && b != 7) {
							board[a - 1][b + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && b != 7) {
							board[a][b + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && b != 7) {
							board[a + 1][b + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		// south east
		if ((fromRank < toRank) && (fromFile < toFile)) {
			for (int a = fromRank + 1, b = fromFile + 1; (a <= (toRank)) && (b <= (toFile)); a++, b++) {
				int p = board[a][b];
				int counter3 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[a][b] == 7) {
							board[a][b] = 8;
						}
						if (board[a][b] == -7) {
							board[a][b] = -8;
						}
						if (board[a][b] == 46) {
							board[a][b] = 47;
						}
						if (board[a][b] == -46) {
							board[a][b] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 12 || p == -12 || p == 29 || p == -29 || p == 31 || p == -31 || p == 50 || p == -50 || p == 51
						|| p == -51 || (p >= 60 && p <= 71) || (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[a - 1][b - 1] = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */ if (board[a][b] != 13) {
							board[a][b] = 0;
						} else {
							board[a][b] = 8;
						}
						/* NW */ if (b != 0) {
							wn = board[a - 1][b - 1];
						}
						/* W */if (b != 0) {
							w = board[a][b - 1];
						}
						/* SW */if (b != 0) {
							ws = board[a + 1][b - 1];
						}
						/* N */ int n = board[a - 1][b];
						/* S */ int s = board[a + 1][b];
						/* NE */if (b != 7) {
							ne = board[a - 1][b + 1];
						}
						/* E */if (b != 7) {
							e = board[a][b + 1];
						}
						/* SE */if (b != 7) {
							se = board[a + 1][b + 1];
						}
						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && b != 0) {
							board[a - 1][b - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && b != 0) {
							board[a][b - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && b != 0) {
							board[a + 1][b - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][b] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][b] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && b != 7) {
							board[a - 1][b + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && b != 7) {
							board[a][b + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && b != 7) {
							board[a + 1][b + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		// south west
		if ((fromRank < toRank) && (fromFile > toFile)) {
			for (int a = fromRank + 1, b = fromFile - 1; (a <= (toRank)) && (b >= (toFile)); a++, b--) {
				int p = board[a][b];
				int counter3 = 0;
				// trap
				if (p == 7 || p == 8 || p == -7 || p == -8 || p == 46 || p == 47 || p == -46 || p == -47 || p == 66
						|| p == 67 || p == -66 || p == -67) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						// changing closed trap to open trap
						if (board[a][b] == 7) {
							board[a][b] = 8;
						}
						if (board[a][b] == -7) {
							board[a][b] = -8;
						}
						if (board[a][b] == 46) {
							board[a][b] = 47;
						}
						if (board[a][b] == -46) {
							board[a][b] = -47;
						} // changing player
						player = player * (-1);
					}
					return true;

				} // wall
				if (p == 12 || p == -12 || p == 29 || p == -29 || p == 31 || p == -31 || p == 50 || p == -50 || p == 51
						|| p == -51 || (p >= 60 && p <= 71) || (p <= -60 && p >= -71)) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[a - 1][b + 1] = board[fromRank][fromFile];
						board[fromRank][fromFile] = 0;
						// changing player
						player = player * (-1);
					}
					return true;
				}
				// mine
				if (p == 9 || p == -9 || p == 28 || p == -28 || p == 48 || p == -48 || p == 68 || p == -68) {
					if (Chess.isValidMove(fromRank, fromFile, toRank, toFile, player, false)) {
						board[fromRank][fromFile] = 0;
						int wn = 0;
						int w = 0;
						int ws = 0;
						int ne = 0;
						int e = 0;
						int se = 0;
						/* center */ if (board[a][b] != 13) {
							board[a][b] = 0;
						} else {
							board[a][b] = 8;
						}
						/* NW */ if (b != 0) {
							wn = board[a - 1][b - 1];
						}
						/* W */if (b != 0) {
							w = board[a][b - 1];
						}
						/* SW */if (b != 0) {
							ws = board[a + 1][b - 1];
						}
						/* N */ int n = board[a - 1][b];
						/* S */ int s = board[a + 1][b];
						/* NE */if (b != 7) {
							ne = board[a - 1][b + 1];
						}
						/* E */if (b != 7) {
							e = board[a][b + 1];
						}
						/* SE */if (b != 7) {
							se = board[a + 1][b + 1];
						}
						// stopping mines from destroying walls
						if (Math.abs(wn) != 12 && Math.abs(wn) != 29 && Math.abs(wn) != 31 && Math.abs(wn) != 50
								&& Math.abs(wn) != 51 && (wn < 60 || wn > 71) && (wn > -60 || wn < -71) && b != 0) {
							board[a - 1][b - 1] = 0;
						}
						if (Math.abs(w) != 12 && Math.abs(w) != 29 && Math.abs(w) != 31 && Math.abs(w) != 50
								&& Math.abs(w) != 51 && (w < 60 || w > 71) && (w > -60 || w < -71) && Math.abs(w) != 11
								&& (w < 20 || w > 31) && (w > -20 || w < -31) && b != 0) {
							board[a][b - 1] = 0;
						}
						if (Math.abs(ws) != 12 && Math.abs(ws) != 29 && Math.abs(ws) != 31 && Math.abs(ws) != 50
								&& Math.abs(ws) != 51 && (ws < 60 || ws > 71) && (ws > -60 || ws < -71) && b != 0) {
							board[a + 1][b - 1] = 0;
						}
						if (Math.abs(n) != 12 && Math.abs(n) != 29 && Math.abs(n) != 31 && Math.abs(n) != 50
								&& Math.abs(n) != 51 && (n < 60 || n > 71) && (n > -60 || n < -71) && Math.abs(n) != 10
								&& (n < 40 || n > 51) && (n > -40 || n < -51)) {
							board[a - 1][b] = 0;
						}
						if (Math.abs(s) != 12 && Math.abs(s) != 29 && Math.abs(s) != 31 && Math.abs(s) != 50
								&& Math.abs(s) != 51 && (s < 60 || s > 71) && (s > -60 || s < -71) && Math.abs(s) != 10
								&& (s < 40 || s > 51) && (s > -40 || s < -51)) {
							board[a + 1][b] = 0;
						}
						if (Math.abs(ne) != 12 && Math.abs(ne) != 29 && Math.abs(ne) != 31 && Math.abs(ne) != 50
								&& Math.abs(ne) != 51 && (ne < 60 || ne > 71) && (ne > -60 || ne < -71) && b != 7) {
							board[a - 1][b + 1] = 0;
						}
						if (Math.abs(e) != 12 && Math.abs(e) != 29 && Math.abs(e) != 31 && Math.abs(e) != 50
								&& Math.abs(e) != 51 && (e < 60 || e > 71) && (e > -60 || e < -71) && Math.abs(e) != 11
								&& (e < 20 || e > 31) && (e > -20 || e < -31) && b != 7) {
							board[a][b + 1] = 0;
						}
						if (Math.abs(se) != 12 && Math.abs(se) != 29 && Math.abs(se) != 31 && Math.abs(se) != 50
								&& Math.abs(se) != 51 && (se < 60 || se > 71) && (se > -60 || se < -71) && b != 7) {
							board[a + 1][b + 1] = 0;
						}
						// changing player
						player = player * (-1);
					}
					return true;
				}
			}
		}

		return false;
	}
}
