package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ServersNotReceivedLog
{
	
	/*
	 * Complete the 'getStaleServerCount' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY log_data 3.
	 * INTEGER_ARRAY query 4. INTEGER X
	 */
	
	public static List<Integer> getStaleServerCount(int n, List<List<Integer>> log_data, List<Integer> query, int X)
	{
		List<Integer> lsOfCount = new ArrayList<>();
		
		Set<Integer> idSet = new TreeSet<>();
		for (int j = 0; j < n; j++)
		{
			idSet.add(j + 1);
		}
		for (int i = 0; i < query.size(); i++)
		{
			int[] interval = { query.get(i) - X, query.get(i) };
			Set<Integer> remainSet = new TreeSet<>();
			remainSet.addAll(idSet);
			Set<Integer> receivedSet = new TreeSet<>();
			for (int j = 0; j < log_data.size(); j++)
			{
				
				if (log_data.get(j).get(1) <= interval[1] && log_data.get(j).get(1) >= interval[0])
				{
					receivedSet.add(log_data.get(j).get(0));
				}
			}
			remainSet.removeAll(receivedSet);
			lsOfCount.add(remainSet.size());
		}
		return lsOfCount;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		
		int log_dataRows = Integer.parseInt(bufferedReader.readLine().trim());
		int log_dataColumns = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<Integer>> log_data = new ArrayList<>();
		
		IntStream.range(0, log_dataRows).forEach(i -> {
			try
			{
				log_data.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList()));
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		});
		
		int queryCount = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<Integer> query = IntStream.range(0, queryCount).mapToObj(i -> {
			try
			{
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());
		
		int X = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<Integer> result = getStaleServerCount(n, log_data, query, X);
		
		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
