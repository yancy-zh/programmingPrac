package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingGame
{
	/*
	 * һ����N��ѡ�ֲμӱ�����ѡ�ֱ��Ϊ1~N��3<=N<=100������M��3<=M<=10������ί��ѡ�ֽ��д�֡���ֹ���Ϊÿ����ί��ѡ�ִ�֣���߷�10�֣���ͷ�1�֡�
�����÷�����3λѡ�ֵı�š�����÷���ͬ����÷ָ߷�ֵ����ѡ��������ǰ(10��������ͬ����Ƚ�9�ֵ��������Դ����ƣ������в�����ֶ��ѡ�ֵ÷���ȫ��ͬ�����)��
��������:
��һ��Ϊ��Ƕ��ŷָ����������������һ�����ֱ�ʾM��3<=M<=10������ί���ڶ������ֱ�ʾN��3<=N<=100����ѡ�֡�
��2��M+1���ǰ�Ƕ��ŷָ���������У���ʾ��ίΪÿ��ѡ�ֵĴ�֣�0���±����ֱ�ʾ1��ѡ�ַ�����1���±����ֱ�ʾ2��ѡ�ַ������������ơ�
�������:
ѡ��ǰ3���ı�š�
ע��������Ϊ�쳣�����-1����M��N����ֲ��ڷ�Χ�ڡ�
ʾ��1��
����
4,5
10,6,9,7,6
9,10,6,7,5
8,10,6,5,10
9,10,8,4,9
���
2,1,5
˵��
��һ�д�����4����ί��5��ѡ�ֲμӱ���
���������4*5��ÿ��������ѡ�ֵı�ţ�ÿһ�д���һ����ί��ѡ�ֵĴ������
2��ѡ�ֵ÷�36���ŵ�1��1��ѡ��36���ŵ�2��5��ѡ��30��(2��10��ֵ��3����1��10��ֵֻ��1��������2���ŵ�һ)
��������������������������������
��Ȩ����������ΪCSDN���������ΰ�־����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/csfun1/article/details/124362254
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int TOTAL = 100;
		LinkedList<Integer> persons = new LinkedList<>();
		persons.addFirst(0);
		//initialize
		for (int i=1; i< TOTAL; i++)
		{
			persons.addLast(i);
		}
// del one val
		int counter =0;
		for (Iterator iterator = persons.iterator(); iterator.hasNext();)
		{
			counter++;
			if (counter == M)// delete the mth elem
			{
				iterator.next();
				iterator.remove();
				counter = 0;
			}
			if (persons.size()<=M)
			{
				break;
			}
		}
			
		persons.stream().forEach(System.out::println);
		
//		//�γ�Ȧ
//		persons.getLast();

	}
	
}
