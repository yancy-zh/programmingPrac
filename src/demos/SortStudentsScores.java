package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortStudentsScores
{
	/*
	 * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
	 * 
	 * 都按先录入排列在前的规则处理。
	 * 
	 * 例示： jack 70 peter 96 Tom 70 smith 67
	 * 
	 * 从高到低 成绩 peter 96 jack 70 Tom 70 smith 67
	 * 
	 * 从低到高
	 * 
	 * smith 67
	 * 
	 * jack 70
	 * 
	 * Tom 70 peter 96
	 * 
	 * 注：0代表从高到低，1代表从低到高
	 * 
	 * 数据范围：人数：1\le n \le 200\1≤n≤200 进阶：时间复杂度：O(nlogn)\O(nlogn) ，空间复杂度：O(n)\O(n) 输入描述： 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
	 * 
	 * 输出描述： 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
	 * 
	 * 示例1 输入： 3 0 fang 90 yang 50 ning 70 输出： fang 90 ning 70 yang 50 示例2 输入： 3 1 fang 90 yang 50 ning 70 输出： yang 50 ning 70 fang 90
	 */
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int byAccending = Integer.parseInt(bf.readLine());
		List<Map.Entry<String, Integer>> studentsScores = new ArrayList<>();
		for (int i = 0; i < n; i++)
		{
			String line = bf.readLine();
			Pattern reScore1 = Pattern.compile("[a-zA-Z]+");
			Matcher matcher1 = reScore1.matcher(line);
			if (matcher1.find()) // score name exists in the line
			{
				String name = matcher1.group();
				Pattern reScore2 = Pattern.compile("\\d+");
				Matcher matcher2 = reScore2.matcher(line);
				if (matcher2.find())
				{
					Integer score = Integer.parseInt(matcher2.group());
					studentsScores.add(new AbstractMap.SimpleEntry<String, Integer>(name, score));
				}
				else
				{
					continue;
				}
			}
			else
			{
				continue;
			}
		}
		studentsScores.sort(new Comparator<Map.Entry<String, Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				if (o1.getValue() < o2.getValue())
				{
					return (byAccending == 1 ? -1 : 1);
				}
				else if (o1.getValue() > o2.getValue())
				{ return (byAccending == 1 ? 1 : -1); }
				return 0;
			}
		});
		for (Map.Entry<String, Integer> entry : studentsScores)
		{
			System.out.println(String.format("%s %s", entry.getKey(), entry.getValue()));
		}
	}
}
