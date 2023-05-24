package huaweiCodingPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PortsMerge
{
	/*
	 * 端口合并（贪心算法） <h2><a id="_0"></a>题目描述</h2> <blockquote> <p>有 M(1&lt;=M&lt;=10) 个端口组<br> 每个端口组是长度为N(1&lt;=N&lt;=100)的整数数组，如果端口组间存在2个及以上不同端口相同，则认为这2个端口组
	 * 互相关联，可以合并<br> 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组。输出合并后的端口组，用二维数组表示<br> <strong>输入描述</strong><br> 第一行输入一个数字M<br> 第二行开始输入M行，每行是长度为N的整数数组，用逗号分割</p>
	 * <p><strong>输出描述</strong><br> 合并后的二维数组，用二维数组表示<br> 1：组合内同端口仅保留一个，并从小到大排序。<br> 2：组合外顺序保持输入顺序。<br> <strong>示例1：</strong><br> 输入：<br> 4<br> 4<br> 2,3,2<br>
	 * 1,2<br> 5<br> <strong>输出：</strong><br> [[4],[2,3],[1,2],[5]]<br> <strong>输入</strong><br> 3<br> 2,3,1<br> 4,3,2<br> 5<br> <strong>输出</strong>：<br>
	 * [[1,2,3,4],[5]]</p> </blockquote> <h2><a id="_30"></a>解题思路</h2> <p>将端口组用
	 * <code>TreeSet</code>存储。遍历所有端口组，并且尝试合并它们。如果两个端口组有2个及以上相同的端口，合并它们。重复此操作，直到无法合并任何端口组。</p>
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int setCnt = Integer.parseInt(scanner.nextLine());
		List<TreeSet<Integer>> portSets = new ArrayList<>(setCnt);
		for (int i = 0; i < setCnt; i++)
		{
			List<Integer> portLs = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
			TreeSet<Integer> portSet = new TreeSet<>(portLs);
			portSets.add(portSet);
		}
		while (mergePortSets(portSets))
			;
		System.out.println(portSets.toString());
	}
	
	// merge sets when possible, and return true, otherwise return false.
	public static boolean mergePortSets(List<TreeSet<Integer>> portSets)
	{
		for (int i = 0; i < portSets.size(); i++)
		{
			for (int j = i + 1; j < portSets.size(); j++)
			{
				TreeSet<Integer> group1 = portSets.get(i);
				TreeSet<Integer> group2 = portSets.get(j);
				if (chkConnectivity(group1, group2))
				{
					group1.addAll(group2);
					portSets.remove(j);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean chkConnectivity(TreeSet<Integer> group1, TreeSet<Integer> group2)
	{
		TreeSet<Integer> intersection = new TreeSet<>();
		intersection.addAll(group1);
		intersection.retainAll(group2);
		if (intersection.size() >= 2)
		{ return true; }
		return false;
	}
}
