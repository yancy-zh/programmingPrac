package demos;

import java.util.HashSet;
import java.util.Scanner;

public class FindCharSetSize {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		HashSet<Character> charSet = new HashSet<Character>();
		for (Character ch : str.toCharArray()) {
			charSet.add(ch);
		}
		System.out.println(charSet.size());
	}
}
