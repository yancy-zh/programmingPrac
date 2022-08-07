package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sortByHeightWeight
{
	
	public static void main(String[] args)
	{
		/*
		 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。 输入描述: 两个序列，每个序列由n个正整数组成（0 < n <=
		 * 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。 输出描述: 排列结果，每个数值都是原始序列中的学生编号，编号从1开始 示例1： 输入 4 100 100 120 130 40 30 60 50 输出 2 1 3 4 说明
		 * 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。 示例2： 输入 3 90 110 90 45 60 45 输出 1 3 2 说明 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
		 */
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			int count = Integer.parseInt(scanner.nextLine());
			ArrayList<Student> students = new ArrayList<sortByHeightWeight.Student>();
			String[] heights = scanner.nextLine().split(" ");
			String[] weights = scanner.nextLine().split(" ");
			
			for (int i = 0; i < count; i++)
			{
				students.add(new Student(i+1,Integer.parseInt(heights[i]) ,Integer.parseInt(weights[i])));
			}
			Collections.sort(students);
			// print the sorted students indices.
			for (int i = 0; i < students.size(); i++)
			{
				System.out.print(students.get(i).idx +" ");
			}
		}
	}
	
	static class Student implements Comparable<Student>
	{
		private int idx;
		private int height;
		private int weight;
		
		public Student(int idx, int height, int weight)
		{
			super();
			this.idx = idx;
			this.height = height;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Student o)
		{
			if (o.height > this.height)
			{ return -1; }
			if (o.weight > this.weight)
			{ return -1; }
			if (o.idx > this.idx)
			{ return -1; }
			return 0;
		}
		
	}
}
