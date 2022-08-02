package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VLAN
{
	/*
	 * ***VLAN***��һ�ֶԾ������豸�����߼����ֵļ�����Ϊ�˱�ʶ��ͬ��VLAN������VLAN ID(1-4094֮�������)�ĸ�� ����һ��VLAN ID����Դ��(�³�VLAN��Դ��)����Դ����������VLAN�ÿ�ʼVLAN-����VLAN��ʾ�����������õ���������ʾ�����е�VLAN��Ӣ�Ķ���������������
	 * ����һ��VLAN��Դ�أ�ҵ����Ҫ����Դ��������һ��VLAN����Ҫ�������VLAN��Դ�����Ƴ������VLAN�����Դ�ء� ����������
	 * 
	 * ��һ��Ϊ�ַ�����ʽ��VLAN��Դ�أ��ڶ���Ϊҵ��Ҫ�����VLAN��VLAN��ȡֵ��ΧΪ[1,4094]֮��������� ���������
	 * 
	 * ������VLAN��Դ�����Ƴ������VLAN���ַ�����ʽ��VLAN��Դ�أ����Ҫ��������Ŀ�����еĸ�ʽ�����Ұ���VLAN��С������������� ��������VLAN����ԭVLAN��Դ���ڣ����ԭVLAN��Դ�������������ַ������ɡ� ��ע��
	 * 
	 * ����VLAN��Դ����VLAN������ȡֵ��ΧΪ[2-4094]�����������Դ����VLAN���ظ��ҺϷ�([1,4094]֮�������)������������ġ�
	 * 
	 * ʾ��
	 * 
	 * ���룺
	 * 
	 * 1-5 2 �����
	 * 
	 * 1,3-5 ˵����
	 * 
	 * ԭVLAN��Դ������VLAN 1��2��3��4��5������Դ�����Ƴ�2��ʣ��VLAN 1��3��4��5��������Ŀ������ʽ�������Ľ��Ϊ1,3-5�� ���룺
	 * 
	 * 20-21,15,18,30,5-10 15 �����
	 * 
	 * 5-10,18,20-21,30 ˵����
	 * 
	 * ԭVLAN��Դ������VLAN 5��6��7��8��9��10��15��18��20��21��30������Դ�����Ƴ�15����Դ����ʣ�µ�VLANΪ 5��6��7��8��9��10��18��20��21��30��������Ŀ������ʽ�������Ľ��Ϊ5-10,18,20-21,30�� ���룺
	 * 
	 * 5,1-3 10 �����
	 * 
	 * 1-3,5 ˵����
	 * 
	 * ԭVLAN��Դ������VLAN 1��2��3��5�������VLAN 10����ԭ��Դ���У���ԭ��Դ�ذ�����Ŀ������ʽ�����������������Ľ��Ϊ1-3,5�� �������������������������������� ��Ȩ����������ΪCSDN������JOEL-T99����ԭ�����£���ѭCC 4.0
	 * BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/weixin_47243236/article/details/123007521
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			ArrayList<Integer> intArr = new ArrayList<>(); // output array
			// get the list of values
			String sourcePool = scanner.nextLine(); // source pool
			int target = Integer.parseInt(scanner.nextLine()); // target source number
			String[] numStrings = sourcePool.split(",");
			// loop in the strings
			boolean flag = false;
			Pattern re = Pattern.compile("-");
			for (int i = 0; i < numStrings.length; i++)
			{
				String currStr = numStrings[i];
				Matcher matcher = re.matcher(currStr);
				if (matcher.find()) // the string contains "-"
				{// is a series of numbers
					String[] temp = currStr.split("-");
					int begin = Integer.parseInt(temp[0]);
					int end = Integer.parseInt(temp[1]);
					for (int j = begin; j <= end; j++)
					{
						if (flag) // target is already found
						{
							intArr.add(j);
							continue;
						}
						if (target == j)
						{
							flag = true;
						}
						else
						{
							intArr.add(j);
						}
					}
				}
				else
				{
					int currNum = Integer.parseInt(currStr);
					if (flag) // target is already found
					{
						intArr.add(currNum);
						continue;
					}
					if (target == currNum)
					{// is a single number
						flag = true;
					}
					else
					{
						intArr.add(currNum);
					}
				}
			}
			// print the output string list
			intArr.sort(null);
			// System.out.println(Arrays.asList(intArr).toString());
			// format the output string
			System.out.println(formatString(intArr).toString());
		}
	}
	
	public static String formatString(ArrayList<Integer> list)
	{
		StringBuilder sb = new StringBuilder();
        // ������������������飬һһ����������¸��������ϸ�����1����������������ֱ�Ӽ���sb
        int i = 0;
        while (i < list.size()) {
            int first = list.get(i);
            int j = 1;
            while (j <= list.size() - 1 - i) {
                if (list.get(i) + j == list.get(i + j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == 1) { // ����¸����������ϸ�����1��ֱ�Ӽ���sb,ͬʱi++
                sb.append(first);
                sb.append(",");
                i++;
            } else {  // �����һ����-���������һ��������sb,ͬʱi=i+j
                sb.append(String.valueOf(first) + "-" + String.valueOf(first + j - 1) + ",");
                i = i + j;
            }
        }

//		ArrayList<String> outStrList = new ArrayList<>();
//		int i = 0;
//		while (i < intArr.size())
//		{
//			int j = i + 1;
//			int curr = intArr.get(i);
//			int next = intArr.get(j);
//			while (next - curr == (j - i) && j < intArr.size()-1)// continuous
//			{
//				j++;
//				next = intArr.get(j);
//			}
//			if (j == i + 1)
//			{// j only is larger than i by 1
//				outStrList.add(String.valueOf(curr));
//			}
//			else
//			{ // j is larger than i by many
//				outStrList.add("%s-%s".formatted(curr, next));
//			}
//			i = j + 1;
//		}
		return sb.toString().substring(0, sb.length()-1);
	}
}
