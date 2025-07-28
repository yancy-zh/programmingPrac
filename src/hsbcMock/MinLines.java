package hsbcMock;

import java.util.HashSet;
import java.util.Scanner;

public class MinLines {
	// the minimum num of lines to reach tim's friends houses.
	// thejoboverflow.com/p/p1251
	double getSlope(int[] pt, int tim_x, int tim_y) {
		// slope is positive if
		if (pt[0] == tim_x) {
			return Double.POSITIVE_INFINITY; // 垂直线，斜率无穷大
		}
		return ((double) pt[1] - (double) tim_y) / (pt[0] - tim_x);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String[] words = sc.nextLine().split(" ");
			int n = Integer.parseInt(words[0]);
			int m = Integer.parseInt(words[1]);
			int[][] coords = new int[n][m];
			for (int i = 0; i < n; i++) {
				String[] temp = sc.nextLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				coords[i][0] = x;
				coords[i][1] = y;
			}
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			MinLines sol = new MinLines();
			System.out.print(sol.minLines(coords, x0, y0));
		}
	}

	public int minLines(int[][] coords, int timX, int timY) {
		if (coords == null || coords.length == 0) {
			return 0;
		}
		double ratioInit = getSlope(coords[0], timX, timY);
		HashSet<Double> set = new HashSet<>();
		set.add(ratioInit);
		for (int[] line : coords) {
			double currRatio = getSlope(line, timX, timY);
			if (!set.contains(currRatio)) {
				set.add(currRatio);
			}
		}
		return set.size();
	}
}
