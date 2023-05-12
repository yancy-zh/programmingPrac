package huaweiCodingPrac;

import static org.hamcrest.CoreMatchers.either;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorstProductPrize
{
	
	public static List<Integer> main(String[] args)
	{
		/*
		 * 最差产品奖/滑动窗口 题目描述:<br> A公司准备对他下面的N个产品评选最差奖，评选的方式是首先对每个产品进行评分，然后根据评分区间计算相邻几个产品中最差的产品。评选的标准是依次找到从当前产品开始前M个产品中最差的产品，请给出最差产品的评分序列。<br> 输入描述:<br>
		 * 第一行，数字M，表示评分区间的长度，取值范围是0&lt;M&lt;10000第二行，产品的评分序列，比如[12,3,8,6,5]，产品数量N范围是-10000&lt;N&lt;10000<br> 输出描述:<br> 评分区间内最差产品的评分序列<br>
		 * <strong>输入:</strong><br> 3<br> 12,3,8,6,5<br> <strong>输出:</strong><br> 3,3,5<br> 说明:<br> 12.3.8 最差的是3<br> 3.8,6 中最差的是3<br> 8.6.5 中最差的是5</p> <h2><a
		 * id="_17"></a>解题思路</h2> <p>这道题是典型的<code>滑动窗口</code>。滑动窗口的移动过程：<br> 遍历评分数组，使用双端队列<code>minDeque</code>作为滑动窗口，存储当前区间内的最差评分。<br>
		 * 当遍历到下一个产品评分时，检查当前区间内最差评分是否仍在新的区间内。如果不在，则从队列中移除。遍历过程中，检查当前评分是否比双端队列中的最后一个评分好。如果是，则移除双端队列中的最后一个评分。</p> <
		 */
		Scanner scanner = new Scanner(System.in);
		int windowSize = Integer.parseInt(scanner.nextLine());
		List<Integer> scores = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
		Deque<Integer> minDeque = new ArrayDeque<Integer>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < scores.size(); i++)
		{
			if (i>=windowSize)
			{
				result.push(minDeque[0]);
				if (scores[i-windowSize]==minDeque[0])
				{
					minDeque.shift();
				}
			}
			while (minDeque.size()>0 && minDeque[minDeque.size()-1]> scores[i])
			{
				minDeque.pop();
			}
			minDeque.push(scores[i]);
				
		}
		result.push(minDeque[0]);
		System.out.println(result.toString());
		return result;
	}
	
}
