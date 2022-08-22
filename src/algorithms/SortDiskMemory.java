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
	 * 磁盘的容量单位有M,G,T这三个等级 他们之间的换算关系为 1T=1024G 1G=1024M 现在给定N块磁盘的容量，请对他们按从小到大的顺序进行稳定排序 例如给定5块盘容量，1T,20M,3G,10G6T,3M12G9M，排序后的结果为20M,3G,3M12G9M,1T,10G6T
	 * 注意单位可以重复出现，上述3M12G9M为 3M+12G+9M和12M12G相等 输入描述:
	 * 
	 * 输入第一行包含一个整数N，2<=N<=100，表示磁盘的个数 接下来的N行每行一个字符串 长度 (2<l<30)，表示磁盘的容量 有一个或多个格式为mv的子串组成，其中m表示容量大小v表示容量单位 磁盘容量m的范围 1~1024正整数容量单位v的范围包含题目中提到的M,G,T 输出描述:
	 * 
	 * 输出N行 表示N块磁盘容量排序后的结果 示例
	 * 
	 * 输入：
	 * 
	 * 3 1G 2G 1024M 输出：
	 * 
	 * 1G 1024M 2G 说明：
	 * 
	 * 1G和1024M容量相等,稳定排序要求保留他们原来的相对位置，故1G在1024M前 输入：
	 * 
	 * 3 2G4M 3M2G 1T 输出：
	 * 
	 * 3M2G 2G4M 1T 说明：
	 * 
	 * 1T大于2G4M大于3M2G ———————————————— 版权声明：本文为CSDN博主「JOEL-T99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
	 * 原文链接：https://blog.csdn.net/weixin_47243236/article/details/122797477 example input 3 1T 2T 1024M 4 1G 2G 1G2M 1024M usage: Scanner sc = new
	 * Scanner(System.in); while (sc.hasNext()) { int n = Integer.parseInt(sc.nextLine()); String[] strArr = new String[n]; for (int i = 0; i < n; i++) {
	 * strArr[i] = sc.nextLine(); } SortDiskMemory sol = new SortDiskMemory(); String[] sortedMemories = sol.sortDiskMemory(strArr); }
	 */
	HashMap<String, Integer> tagToAmount = new HashMap<>();
	HashMap<String, String> tagToRegex = new HashMap<>();
	String[] tags = { "T", "G", "M" };
	
	public SortDiskMemory()
	{
		// 换算内存时，以M为单位，"T" 和"G"均换算为M。
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
				// 对于一个输入的容量标签，扫描三种标签，其换算得到的容量何值？
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
