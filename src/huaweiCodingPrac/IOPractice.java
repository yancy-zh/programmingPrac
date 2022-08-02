package huaweiCodingPrac;

import java.util.Scanner;
import java.util.regex.Pattern;
public class IOPractice
{
	public static void printLineByLine()
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}		
	}

	public static void printWordByWord()
	{
		Scanner sc = new Scanner(System.in);
		Pattern pattern = Pattern.compile("\\w");
		while(sc.hasNextLine()) {
			System.out.print(sc.nextBoolean());
		}
	}
}
