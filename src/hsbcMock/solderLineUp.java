package hsbcMock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import utils.MyPrinter;

public class solderLineUp
{
	
	public static void main(String[] args)
	{
		// 士兵排队
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine())
		{
			int n = Integer.parseInt(scanner.nextLine());
			List<Integer> x_coordinates = new ArrayList<>();
			List<Integer> y_coordinates = new ArrayList<>();
			for (int i = 0; i < n; i++)
			{
				// get each line for coordinates
				List<Integer> coordinates = Arrays.asList(scanner.nextLine().split(" ")).stream().map(o -> Integer.parseInt(o)).collect(Collectors.toList());
				x_coordinates.add(coordinates.get(0));
				y_coordinates.add(coordinates.get(1));
			}
			// sort y values
			y_coordinates.sort(Comparator.naturalOrder());
			// get mid y
			int y_mid = y_coordinates.get(n / 2);
			MyPrinter myPrinter = new MyPrinter();
			myPrinter.printList(y_coordinates);
			System.out.println("mid y is: " + y_mid);
			// sort original x values
			x_coordinates.sort(Comparator.naturalOrder());
			// modify the x array
			for (int i = 0; i < n; i++)
			{
				x_coordinates.add(i, x_coordinates.get(i) - i);
			}
			// sort the modified coordinates
			x_coordinates.sort(Comparator.naturalOrder());
			myPrinter.printList(x_coordinates);
			// get the mid x
			int x_mid = x_coordinates.get(n / 2);
			System.out.println("mid x is: " + x_mid);
		}
		
	}
	
}
