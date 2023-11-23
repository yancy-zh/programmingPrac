package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class FindLowestPrice
{
	public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts)
	{
		Map<String, List<Integer>> discountMap = new HashMap<String, List<Integer>>();
		String EMPTY = "EMPTY";
		for (int i = 0; i < discounts.size(); i++)
		{
			List<Integer> temp = new ArrayList<>();
			temp.add(Integer.parseInt(discounts.get(i).get(1)));
			temp.add(Integer.parseInt(discounts.get(i).get(2)));
			discountMap.put(discounts.get(i).get(0), temp);
		}
		discountMap.put(EMPTY, new ArrayList<>(Arrays.asList(2, 0))); // no discount
		int sum = 0;
		for (int i = 0; i < products.size(); i++)
		{
			List<String> product = products.get(i);
			int prePrice = Integer.parseInt(product.get(0));
			int minPrice = prePrice;
			for (int j = 1; j < product.size(); j++) // starting from the second idx is the tag
			{
				List<Integer> discountType = discountMap.get(product.get(j));
				int postPrice = discountCalc(discountType.get(0).intValue(), discountType.get(1).intValue(), prePrice);
				if (postPrice < minPrice)
				{
					minPrice = postPrice;
				}
			}
			sum += minPrice;
		}
		return sum;
	}
	
	public static int discountCalc(int type, int para, int price)
	{
		switch (type)
		{
			case 0:
				return para;
			case 1:
				return (int) Math.rint(price - price * 0.01 * para);
			case 2:
				return price - para;
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int productsRows = Integer.parseInt(bufferedReader.readLine().trim());
		int productsColumns = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<String>> products = new ArrayList<>();
		
		IntStream.range(0, productsRows).forEach(i -> {
			try
			{
				products.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		});
		
		int discountsRows = Integer.parseInt(bufferedReader.readLine().trim());
		int discountsColumns = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<String>> discounts = new ArrayList<>();
		
		IntStream.range(0, discountsRows).forEach(i -> {
			try
			{
				discounts.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		});
		
		int result = findLowestPrice(products, discounts);
		
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
