package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class multiThreading
{
	/*
	 * 2080. ����ȥ��
����һ���������� nums ����ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ���������� ������ɾ����������³��ȡ�

���Ҫ��
ʱ�����ƣ�1000ms, �ڴ����ƣ�64MB
����
����һ����������

���
ȥ�غ����鳤��

����
�������� 1 ����

1,1,1,2,2,3
������� 1
5
	 */
	int[] toSort;
	public multiThreading(int[] p_toSort)
	{
		this.toSort = p_toSort;
	}
	
	public int uniqueArr(int[] arr)
	{
		Arrays.sort(arr);
		ArrayList<Integer> outArr = new ArrayList<>();
		outArr.add(arr[0]);
		outArr.add(arr[1]);
		for (int i = 2; i < arr.length; i++)
		{
			if (arr[i] == arr[i-1] && arr[i-1] == arr[i-2])
			{
				continue;
			} else 
			{
				outArr.add(arr[i]);
			}
		}
		return outArr.size();
	}
	
	public static void main(String[] args)
	{
		int[] test = {1,1, 1, 1, 2,  2, 2, 3};
		multiThreading multiThreading = new multiThreading(test);
		int res = multiThreading.uniqueArr(test);
		System.out.println(res);
	}
	
}
