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
	 * �˿ںϲ���̰���㷨�� <h2><a id="_0"></a>��Ŀ����</h2> <blockquote> <p>�� M(1&lt;=M&lt;=10) ���˿���<br> ÿ���˿����ǳ���ΪN(1&lt;=N&lt;=100)���������飬����˿�������2�������ϲ�ͬ�˿���ͬ������Ϊ��2���˿���
	 * ������������Ժϲ�<br> ��һ������˿������M��������M�У�ÿ�ж��ŷָ�������˿��顣����ϲ���Ķ˿��飬�ö�ά�����ʾ<br> <strong>��������</strong><br> ��һ������һ������M<br> �ڶ��п�ʼ����M�У�ÿ���ǳ���ΪN���������飬�ö��ŷָ�</p>
	 * <p><strong>�������</strong><br> �ϲ���Ķ�ά���飬�ö�ά�����ʾ<br> 1�������ͬ�˿ڽ�����һ��������С��������<br> 2�������˳�򱣳�����˳��<br> <strong>ʾ��1��</strong><br> ���룺<br> 4<br> 4<br> 2,3,2<br>
	 * 1,2<br> 5<br> <strong>�����</strong><br> [[4],[2,3],[1,2],[5]]<br> <strong>����</strong><br> 3<br> 2,3,1<br> 4,3,2<br> 5<br> <strong>���</strong>��<br>
	 * [[1,2,3,4],[5]]</p> </blockquote> <h2><a id="_30"></a>����˼·</h2> <p>���˿�����
	 * <code>TreeSet</code>�洢���������ж˿��飬���ҳ��Ժϲ����ǡ���������˿�����2����������ͬ�Ķ˿ڣ��ϲ����ǡ��ظ��˲�����ֱ���޷��ϲ��κζ˿��顣</p>
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
