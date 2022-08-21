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
	 * ����һЩͬѧ����Ϣ�����֣��ɼ������У����㽫���ǵ���Ϣ���ճɼ��Ӹߵ��ͻ�ӵ͵��ߵ�����,��ͬ�ɼ�
	 * 
	 * ������¼��������ǰ�Ĺ�����
	 * 
	 * ��ʾ�� jack 70 peter 96 Tom 70 smith 67
	 * 
	 * �Ӹߵ��� �ɼ� peter 96 jack 70 Tom 70 smith 67
	 * 
	 * �ӵ͵���
	 * 
	 * smith 67
	 * 
	 * jack 70
	 * 
	 * Tom 70 peter 96
	 * 
	 * ע��0����Ӹߵ��ͣ�1����ӵ͵���
	 * 
	 * ���ݷ�Χ��������1\le n \le 200\1��n��200 ���ף�ʱ�临�Ӷȣ�O(nlogn)\O(nlogn) ���ռ临�Ӷȣ�O(n)\O(n) ���������� ��һ������Ҫ������˵ĸ���n���ڶ�������һ��������ʾ����ķ�ʽ��֮��n�зֱ��������ǵ����ֺͳɼ�����һ���ո����
	 * 
	 * ��������� ����ָ����ʽ������ֺͳɼ������ֺͳɼ�֮����һ���ո����
	 * 
	 * ʾ��1 ���룺 3 0 fang 90 yang 50 ning 70 ����� fang 90 ning 70 yang 50 ʾ��2 ���룺 3 1 fang 90 yang 50 ning 70 ����� yang 50 ning 70 fang 90
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
