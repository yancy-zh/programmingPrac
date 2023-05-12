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
		 * ����Ʒ��/�������� ��Ŀ����:<br> A��˾׼�����������N����Ʒ��ѡ������ѡ�ķ�ʽ�����ȶ�ÿ����Ʒ�������֣�Ȼ�������������������ڼ�����Ʒ�����Ĳ�Ʒ����ѡ�ı�׼�������ҵ��ӵ�ǰ��Ʒ��ʼǰM����Ʒ�����Ĳ�Ʒ�����������Ʒ���������С�<br> ��������:<br>
		 * ��һ�У�����M����ʾ��������ĳ��ȣ�ȡֵ��Χ��0&lt;M&lt;10000�ڶ��У���Ʒ���������У�����[12,3,8,6,5]����Ʒ����N��Χ��-10000&lt;N&lt;10000<br> �������:<br> ��������������Ʒ����������<br>
		 * <strong>����:</strong><br> 3<br> 12,3,8,6,5<br> <strong>���:</strong><br> 3,3,5<br> ˵��:<br> 12.3.8 ������3<br> 3.8,6 ��������3<br> 8.6.5 ��������5</p> <h2><a
		 * id="_17"></a>����˼·</h2> <p>������ǵ��͵�<code>��������</code>���������ڵ��ƶ����̣�<br> �����������飬ʹ��˫�˶���<code>minDeque</code>��Ϊ�������ڣ��洢��ǰ�����ڵ�������֡�<br>
		 * ����������һ����Ʒ����ʱ����鵱ǰ��������������Ƿ������µ������ڡ�������ڣ���Ӷ������Ƴ������������У���鵱ǰ�����Ƿ��˫�˶����е����һ�����ֺá�����ǣ����Ƴ�˫�˶����е����һ�����֡�</p> <
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
