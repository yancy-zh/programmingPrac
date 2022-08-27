package algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BestTimeRanges
{
	/*
	 * ���ҽӿڳɹ�������ʱ��Ρ�
����֮�佻���Ľӿڳɹ�����Ϊ������ùؼ��������ԣ�ĳ��ʱ����ڵĽӿ�ʧ����ʹ��һ�������ʾ��������ÿ��Ԫ�ض��ǵ�λʱ����ʧ������ֵ�������е���ֵΪ0~100������������һ����ֵ(minAverageLost)��ʾĳ��ʱ�����ƽ��ʧ��������ֵ����ƽ��ʧ����С�ڵ���minAverageLost���ҳ��������ʱ��Σ����δ�ҵ���ֱ�ӷ���NULL��
��������:
�������������ݣ���һ��Ϊ{minAverageLost}���ڶ���Ϊ{����}������Ԫ��ͨ���ո�(" ��)�ָ���minAverageLost��������Ԫ��ȡֵ��ΧΪ0~100������������Ԫ�صĸ������ᳬ��100����
�������:
�ҳ�ƽ��ֵС�ڵ���minAverageLost���ʱ��Σ���������±�ԣ���ʽ{beginIndex}-{endIndx}(�±��0��ʼ)�����ͬʱ���ڶ���ʱ��Σ����������±�����±��֮��ʹ�ÿո�(�� ")ƴ�ӣ�����±�԰��±��С��������
ʾ��1��
����
1
0 1 2 3 4
���
0-2
˵��
A��������ͣ�minAverageLost=1������[0, 1, 2, 3, 4]
B��ǰ3��Ԫ�ص�ƽ��ֵΪ1����������һ���������������±꣬��0-2
��������������������������������
��Ȩ����������ΪCSDN���������ΰ�־����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/csfun1/article/details/124362254
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int minAverageLost = Integer.parseInt(scanner.nextLine());
		List<Integer> rates = Arrays.asList(scanner.nextLine().split(" ")).stream().map(o->Integer.parseInt(o)).collect(Collectors.toList());
		int left = 0;
		int right = 0;
		StringBuilder sBuilder = new StringBuilder();
		while (right < rates.size()) {
			if (right == left)
			{
				right++;
			}
			if ( chkAvgMean(rates, left, right, minAverageLost))// expand the right pointer
			{
				while(right < rates.size() && chkAvgMean(rates, left, right, minAverageLost)) {
					right++;
				}
				right--;
				sBuilder.append(left).append("-").append(right-1).append(" ");
				right++;
			} else {
				left++;
			}
			
		}
		System.out.println(sBuilder);
	}
	
	public static boolean chkAvgMean(List<Integer> rates,int left, int right, int avg)
	{
		double total = 0;
		for (int i = left; i < right; i++)
		{
			total += rates.get(i);
		}
		return (double)(total/(right-left+1)) <= avg;
	}
}
