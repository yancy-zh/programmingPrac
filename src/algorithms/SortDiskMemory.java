package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MemLabel
{
	private int index;
	private String labelString;
	private int memAmount;
	
	public MemLabel(int index, String labelString, int memAmount)
	{
		super();
		this.index = index;
		this.labelString = labelString;
		this.memAmount = memAmount;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	public String getLabelString()
	{
		return labelString;
	}
	
	public void setLabelString(String labelString)
	{
		this.labelString = labelString;
	}
	
	public int getMemAmount()
	{
		return memAmount;
	}
	
	public void setMemAmount(int memAmount)
	{
		this.memAmount = memAmount;
	}
	
}

public class SortDiskMemory
{
	/*
	 * ���̵�������λ��M,G,T�������ȼ� ����֮��Ļ����ϵΪ 1T=1024G 1G=1024M ���ڸ���N����̵�������������ǰ���С�����˳������ȶ����� �������5����������1T,20M,3G,10G6T,3M12G9M�������Ľ��Ϊ20M,3G,3M12G9M,1T,10G6T
	 * ע�ⵥλ�����ظ����֣�����3M12G9MΪ 3M+12G+9M��12M12G��� ��������:
	 * 
	 * �����һ�а���һ������N��2<=N<=100����ʾ���̵ĸ��� ��������N��ÿ��һ���ַ��� ���� (2<l<30)����ʾ���̵����� ��һ��������ʽΪmv���Ӵ���ɣ�����m��ʾ������Сv��ʾ������λ ��������m�ķ�Χ 1~1024������������λv�ķ�Χ������Ŀ���ᵽ��M,G,T �������:
	 * 
	 * ���N�� ��ʾN��������������Ľ�� ʾ��
	 * 
	 * ���룺
	 * 
	 * 3 1G 2G 1024M �����
	 * 
	 * 1G 1024M 2G ˵����
	 * 
	 * 1G��1024M�������,�ȶ�����Ҫ��������ԭ�������λ�ã���1G��1024Mǰ ���룺
	 * 
	 * 3 2G4M 3M2G 1T �����
	 * 
	 * 3M2G 2G4M 1T ˵����
	 * 
	 * 1T����2G4M����3M2G �������������������������������� ��Ȩ����������ΪCSDN������JOEL-T99����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
	 * ԭ�����ӣ�https://blog.csdn.net/weixin_47243236/article/details/122797477 example input 3 1T 2T 1024M 4 1G 2G 1G2M 1024M usage: Scanner sc = new
	 * Scanner(System.in); while (sc.hasNext()) { int n = Integer.parseInt(sc.nextLine()); String[] strArr = new String[n]; for (int i = 0; i < n; i++) {
	 * strArr[i] = sc.nextLine(); } SortDiskMemory sol = new SortDiskMemory(); String[] sortedMemories = sol.sortDiskMemory(strArr); }
	 */
	HashMap<String, Integer> tagToAmount = new HashMap<>();
	HashMap<String, String> tagToRegex = new HashMap<>();
	String[] tags = { "T", "G", "M" };
	
	public SortDiskMemory()
	{
		// �����ڴ�ʱ����MΪ��λ��"T" ��"G"������ΪM��
		tagToAmount.put("T", 1024 * 1024);
		tagToAmount.put("G", 1024);
		tagToAmount.put("M", 1);
		tagToRegex.put("T", "\\d+(T)");
		tagToRegex.put("G", "\\d+(G)");
		tagToRegex.put("M", "\\d+(M)");
	}
	
	public String[] sortDiskMemory(String[] memories)
	{
		HashMap<Integer, String> hashMap = new HashMap<>();
		List<Integer> sorted = new ArrayList<Integer>();
		List<MemLabel> sortedLabels = new ArrayList<>(memories.length);
		for (int i = 0; i < memories.length; i++)
		{
			int sum = 0;
			for (int j = 0; j < tags.length; j++)
			{
				// ����һ�������������ǩ��ɨ�����ֱ�ǩ���任��õ���������ֵ��
				sum += calcAmount(memories[i], tags[j]);
			}
			sorted.add(sum);
			hashMap.put(sum, memories[i]);
			// TODO: handle labels with same calc memories
			sortedLabels.add(new MemLabel(i, memories[i], sum));
		}
		Collections.sort(sorted);
		sortedLabels.sort(new Comparator<MemLabel>()
		{
			@Override
			public int compare(MemLabel o1, MemLabel o2)
			{
				if (o1.getMemAmount() < o2.getMemAmount())
				{
					return -1;
				}
				else if (o1.getMemAmount() > o2.getMemAmount())
				{
					return 1;
				}
				else if (o1.getIndex() < o2.getIndex())
				{
					return -1;
				}
				else if (o1.getIndex() > o2.getIndex())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
		});
		String[] sortedMemories = new String[sortedLabels.size()];
		for (int i = 0; i < sortedLabels.size(); i++)
		{
			sortedMemories[i] = sortedLabels.get(i).getLabelString();
		}
		return sortedMemories;
	}
	
	public long calcAmount(String diskMemo, String tag)
	{
		Pattern TTag = Pattern.compile(tagToRegex.get(tag));
		Matcher matcherT = TTag.matcher(diskMemo);
		if (matcherT.find())
		{
			String foundStr = matcherT.group();
			long temp = Integer.parseInt(foundStr.substring(0, foundStr.length() - 1));
			int scale = tagToAmount.get(tag);
			return scale * temp;
		}
		else
		{
			return 0;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			int n = Integer.parseInt(sc.nextLine());
			String[] strArr = new String[n];
			for (int i = 0; i < n; i++)
			{
				strArr[i] = sc.nextLine();
			}
			SortDiskMemory sol = new SortDiskMemory();
			String[] sortedMemories = sol.sortDiskMemory(strArr);
			System.out.println(Arrays.toString(sortedMemories));
		}
	}
}
