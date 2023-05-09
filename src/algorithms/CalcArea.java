package algorithms;

import java.util.Scanner;


public class CalcArea
{
	/*
	 * ��ͼ�����Ļ�ͼ�ʳ�ʼλi��ԭ��(0.0)�� �������������ͼ�ʰ�����������ֱ��:
1 )�������ź����������������ֱ�ߣ�ֱ���������յ�ֵE,
2 )�ڼ��ͨ��ָ�����������᷽�����ƫ�ơ���ͬʱ����ֱ�ߣ�ƫ�ƺ󰴹���1����ֱ��;ָ��ĸ�ʽΪX offsetY����ʾ�ں�����X�������귽��ƫ��, offsetYΪ������ʾ����ƫ��,Ϊ������ʾ����ƫ�ơ�
�����˺������յ�ֵE.�Լ�����������ָ��������Ƶ�ֱ�ߺͺ������ᡣ�Լ�X-E��ֱ�����ͼ�ε������
����ģ��:
����Ϊ��������NE����ʾ��N��ָ��������еĺ�����K��ֵE.
������N�С�ÿ������������ʾ-������ָ��x osorr��������֤������X�Ե�������ʽ���֡��Ҳ��������ͬ�������塣ȡֵ��Χ:0<N<= 10000, 0<X<= E<=20000, -10000<=offsetY<=10000.
�������:
һ����������ʾ����õ��������������֤.�����Χ��0-4294967295��
ʾ��1:
����
4 10
1 1
2 1
3 1
4 -2
���
12
��������������������������������
��Ȩ����������ΪCSDN���������ΰ�־����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/csfun1/article/details/124509176
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(" ");
		int numCmds = Integer.parseInt(line[0]);
		int maxX = Integer.parseInt(line[1]);
		long area = 0;
		int originX = 0;
		int originY = 0;
		int deltaX = 0;
		boolean flag = false;
		for (int i = 0; i < numCmds; i++)
		{
			
			String[] cmdStrings = scanner.nextLine().split(" ");
			int xNew = Integer.parseInt(cmdStrings[0]);
			if (xNew <= maxX)
			{
				deltaX = xNew -originX;
			} else {
				deltaX = maxX - originX;
				flag = true;
			}
			area += (xNew - originX) * Math.abs(originY + Integer.parseInt(cmdStrings[1]));
			originY += Integer.parseInt(cmdStrings[1]);
			originX = xNew;
			if (flag)
			{
				break;
			}
		}
		area += (maxX - originX) * originY;
		System.out.println(area);
	}
	
}
