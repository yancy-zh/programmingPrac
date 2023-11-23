package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ArrangeCards {
	public Integer[] parseString(String instr) {
		String[] cardStrings = instr.split(",");
		int ind = 0;
		Integer[] cardInts = new Integer[cardStrings.length];
		for (String string : cardStrings) {
			cardInts[ind] = Integer.parseInt(string);
			ind++;
		}
//		int[] nums = new int[cardStrings.length];
		return cardInts;
	}
	
	public String largestNumber(Integer[] numCards) {
		Arrays.sort(numCards, (x, y) -> {
			long sx = 10, sy = 10;
			while (x >= sx) {
				sx *= 10;
			}
			while (y >= sy) {
				sy *= 10;
			}
			return (int) (-sy * x - y + sx * y + x);
		});
		if (numCards[0] == 0) { // min element of the sorted array is zero, then the returned value will be at
			return "0";
		}
		StringBuilder largestNumBuilder = new StringBuilder();
		for (Integer integer : numCards) {
			largestNumBuilder.append(integer);
		}
		return largestNumBuilder.toString();
	}
	
	public void problem1() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String instr = in.nextLine();
//			ArrangeCards sol = new ArrangeCards();
//			String largestIntString = sol.largestNumber(sol.parseString(curr));
			// parse string
			String[] cardStrings = instr.split(",");
			int ind = 0;
			Integer[] cardInts = new Integer[cardStrings.length];
			for (String string : cardStrings) {
				cardInts[ind] = Integer.parseInt(string);
				ind++;
			}
			// calc largest num
			Arrays.sort(cardInts, (x, y) -> {
				long sx = 10, sy = 10;
				while (x >= sx) {
					sx *= 10;
				}
				while (y >= sy) {
					sy *= 10;
				}
				return (int) (-sy * x - y + sx * y + x);
			});
			if (cardInts[0] == 0) { // min element of the sorted array is zero, then the returned value will be at
											// the maximum 0
				System.out.println("0");
			}
			StringBuilder largestNumBuilder = new StringBuilder();
			for (Integer integer : cardInts) {
				largestNumBuilder.append(integer);
			}
			System.out.println(largestNumBuilder.toString());
		}
	}
}
