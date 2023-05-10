package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlusMinus {
	/*
	 * Given an array of integers, calculate the ratios of its elements that are
	 * positive, negative, and zero. Print the decimal value of each fraction on a
	 * new line with places after the decimal.
	 * 
	 * Note: This challenge introduces precision problems. The test cases are scaled
	 * to six decimal places, though answers with absolute error of up to are
	 * acceptable.
	 * 
	 * Example
	 * 
	 * There are elements, two positive, two negative and one zero. Their ratios are
	 * , and . Results are printed as:
	 * 
	 * 0.400000 0.400000 0.200000 Input Format
	 * 
	 * The first line contains an integer, , the size of the array. The second line
	 * contains space-separated integers that describe .
	 * 
	 * Constraints
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * Print the following lines, each to decimals:
	 * 
	 * proportion of positive values proportion of negative values proportion of
	 * zeros
	 * 
	 * test case 6 -4 3 -9 0 4 1
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());

		PlusMinus.plusMinus(arr);

		bufferedReader.close();
	}

	public static void plusMinus(List<Integer> arr) {
		if (arr.size() == 0) {
			String temp = String.format("%06f", 0);
			System.out.println(temp);
			System.out.println(temp);
			System.out.println(temp);
		}
		int numsZeros = 0, numPos = 0, numNeg = 0;
		for (int i = 0; i < arr.size(); i++) {
			int curr = arr.get(i);
			if (curr == 0) {
				numsZeros++;
			} else if (curr > 0) {
				numPos++;
			} else {
				numNeg++;
			}
		}
		System.out.println(String.format("%06f", (float) numPos / arr.size()));
		System.out.println(String.format("%06f", (float) numNeg / arr.size()));
		System.out.println(String.format("%06f", (float) numsZeros / arr.size()));
	}
}
