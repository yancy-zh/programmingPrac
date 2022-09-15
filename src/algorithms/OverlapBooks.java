package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Book implements Comparable<Book>
{
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	private int width;
	private int length;
	
	@Override
	public int compareTo(Book o)
	{
		if (this.width < o.width)
		{
			return -1;
		}
		else if (this.width > o.width)
		{
			return 1;
		}
		else if (this.length < o.length)
		{
			return -1;
		}
		else if (this.length > o.length)
		{ return 1; }
		return 0;
	}
	
	public Book(int width, int length)
	{
		super();
		this.width = width;
		this.length = length;
	}
	
}

public class OverlapBooks
{
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(",");
		// List<Integer> data = Arrays.asList(line).stream().map(o -> o.replace(']', ' ')).map(o -> o.replace('[', ' ')).map(o -> o.strip()).map(o ->
		// Integer.parseInt(o)).collect(Collectors.toList());
		List<Integer> data = processData(line);
		List<Book> books = new ArrayList<>();
		for (int k = 0; k < data.size() - 1; k = k + 2)
		{
			Book book = new Book(data.get(k), data.get(k + 1));
			books.add(book);
		}
		int len = books.size(); // num of books
		List<Integer> dp = new ArrayList<>(); // dp array
		for (int l = 0; l < len; l++)
		{
			dp.add(1);
		}
		Collections.sort(books);
		int res = 1;
		for (int i = 1; i < len; i++)
		{
			Book curr = books.get(i);
			for (int j = 0; j < i; j++)
			{
				Book pre = books.get(j);
				if (curr.getWidth() > pre.getWidth() && curr.getLength() > pre.getLength())
				{
					dp.set(i, Math.max(dp.get(i), dp.get(j) + 1));
				}
				res = Math.max(res, dp.get(i));
			}
		}
		System.out.println(res);
	}
	
	public static List<Integer> processData(String[] line)
	{
		List<Integer> output = new ArrayList<Integer>();
		Pattern reg = Pattern.compile("[0-9]+");
		for (int i = 0; i < line.length; i++)
		{
			Matcher match=  reg.matcher(line[i]);
			if (match.find())
			{
				String temp = match.group();
				output.add(Integer.parseInt(temp));
			}
		}
		return output;
	}
}
