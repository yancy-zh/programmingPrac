package hsbcMock;

import java.util.HashSet;

public class MinLines {
	// the minimum num of lines to reach tim's friends houses.
	// thejoboverflow.com/p/p1251
	double getSlope(int[] line1, int[] line2) {
		if (line1[0] == line2[0]) {
			return Double.POSITIVE_INFINITY; // 垂直线，斜率无穷大
		}
		return ((double) line2[1] - (double) line1[1]) / (line2[0] - line1[0]);
	}

	public int minLines(int[][] coords, int timX, int timY) {
		if (coords == null || coords.length == 0) {
			return 0;
		}
		double ratioInit = getSlope(coords[0], new int[] { timX, timY });
		HashSet<Double> set = new HashSet<>();
		set.add(ratioInit);
		for (int[] line : coords) {
			double currRatio = getSlope(line, new int[] { timX, timY });
			if (!set.contains(currRatio)) {
				set.add(currRatio);
			}
		}
		return set.size();
	}
}
