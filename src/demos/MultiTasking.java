package demos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MultiTasking
{
	// �������������ο����ӣ�https://blog.csdn.net/TESE_yan/article/details/115309034
	// ����: ��m�����д�������
	/*
	 * ��Ŀ������ ĳ�ദ�������������ϵͳһ������������ҵ�����ڴ棬���ܲ���ִ�У��䲢�������ڴ������������ϵͳ����SJF�ĵ��ȷ�ʽ�������ҵ���ȣ�ϵͳ�ڵ���ʱ���������ȵ���ִ�д���ʱ����̵���ҵ����
	 * 
	 * �ָ�������������m����ҵ��n��ÿ����ҵ�Ĵ���ʱ��ֱ�Ϊt1��t2 ... tn��
	 * 
	 * �� n > mʱ�����ȴ���ʱ��̵� m ����ҵ���봦�������������Ľ���ȴ�����ĳ����ҵ�������ʱ�����δӵȴ�������ȡ������ʱ����̵���ҵ���봦��
	 * 
	 * ��ϵͳ������������ҵ�ĺ�ʱΪ���٣�
	 * 
	 * ע����������ҵ�л������ġ�
	 * 
	 * ���������� ����2�У���һ��Ϊ2�����������ÿո�ָ������ֱ��ʾ����������m����ҵ��n���ڶ�������n�����������ÿո�ָ�������ʾÿ����ҵ�Ĵ���ʱ��t1��t2...tn��
	 * 
	 * 0<m��n<100��0<t1��t2...tn<100��
	 * 
	 * ��������� ���������ʱ��
	 * 
	 * ʾ��1��
	 * 
	 * ����
	 * 
	 * 3 5
	 * 
	 * 8 4 3 1 10
	 * 
	 * ���
	 * 
	 * 13
	 * 
	 * ʾ��2��
	 * 
	 * ����
	 * 
	 * 4 14 1 3 4 8 10 13 30 31 21 23 25 27 16 19
	 * 
	 * ���
	 * 
	 * 13 �������������������������������� ��Ȩ����������ΪCSDN��������ɽ���͡���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/TESE_yan/article/details/115309034
	 * ���ã�
	 * 
	 */
	public static void solv()
	{
		Scanner sc = new Scanner(System.in);
		int m, n;
		String[] taskTimeCosts;
		while (sc.hasNext())
		{
			String firstLineString = sc.nextLine();
			String[] strings = firstLineString.split(" ", 2);
			m = Integer.parseInt(strings[0]);
			n = Integer.parseInt(strings[1]);
			String secondLine = sc.nextLine();
			taskTimeCosts = secondLine.split(" ", -1);
			List<Integer> timeVals = new ArrayList<>();
			for (String string : taskTimeCosts)
			{
				timeVals.add(Integer.parseInt(string));
			}
			multiTaskingProcessing(m, n, timeVals);
		}
	}
	
	public static void multiTaskingProcessing(int m, int n, List<Integer> timePerTask)
	{
		timePerTask.sort(Comparator.naturalOrder());
		int rows = (n % m) == 0 ? (n / m) : (n / m + 1); // ��ȡ��������
		int remainder = (n % m) == 0 ? m - 1 : (n % m) - 1; // ��ȡ���ִ���������һ��
		int max_time = 0;
		for (int i = 0; i < rows; ++i)
		{
			max_time += timePerTask.get(i * m + remainder);
		}
		System.out.println(max_time);
	}
	
}
