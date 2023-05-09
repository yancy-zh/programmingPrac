package algorithms;

public class SurroundedRegions {
	public char[][] solve(char[][] board) {
		if (board == null || board.length == 0) {
			return board;
		}
		int m = board.length;
		int n = board[0].length;
		// "O" is at the border
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean isborder = i == 0 || j == 0 || i == m - 1 || j == n - 1;
				if (isborder && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
		return board;
	}

	public void dfs(char[][] board, int i, int j) {
		if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] == 'X'
				|| board[i][j] == '#') {
			return;
		}
		board[i][j] = '#';
		dfs(board, i + 1, j);// below
		dfs(board, i - 1, j);// above
		dfs(board, i, j - 1);// left
		dfs(board, i, j + 1);// right

	}

}
