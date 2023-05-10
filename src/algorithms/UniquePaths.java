package algorithms;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] pathsCount = new int[m][n];
		for (int i = 0; i < m; ++i) {
			pathsCount[i][0] = 1;
		}
		for (int j = 0; j < n; ++j) {
			pathsCount[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				pathsCount[i][j] = pathsCount[i - 1][j] + pathsCount[i][j - 1];
			}
		}
		return pathsCount[m - 1][n - 1];
	}
}
