package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		double d = scanner.nextDouble();
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		System.out.println("US: \u0024" + numberFormat.format(d));
		numberFormat = NumberFormat.getInstance(new Locale("en", "IN"));
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		System.out.println("India: Rs." + numberFormat.format(d));
		numberFormat = NumberFormat.getInstance(Locale.CHINA);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		System.out.println("China: " + "\uFFE5" + numberFormat.format(d).substring(numberFormat.format(d).indexOf('\u00A5') + 1));
		numberFormat = NumberFormat.getInstance(Locale.FRANCE);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		System.out.println("France: " + numberFormat.format(d) + " \u20ac");
	}
}
