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
	 * ***VLAN***是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。 定义一个VLAN ID的资源池(下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，所有的VLAN用英文逗号连接起来。现
	 * 在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，需要你输出从VLAN资源池中移除申请的VLAN后的资源池。 输入描述：
	 * 
	 * 第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。 输出描述：
	 * 
	 * 从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。 如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。 备注：
	 * 
	 * 输入VLAN资源池中VLAN的数量取值范围为[2-4094]间的整数，资源池中VLAN不重复且合法([1,4094]之间的整数)，输入是乱序的。
	 * 
	 * 示例
	 * 
	 * 输入：
	 * 
	 * 1-5 2 输出：
	 * 
	 * 1,3-5 说明：
	 * 
	 * 原VLAN资源池中有VLAN 1、2、3、4、5，从资源池中移除2后，剩下VLAN 1、3、4、5，按照题目描述格式并升序后的结果为1,3-5。 输入：
	 * 
	 * 20-21,15,18,30,5-10 15 输出：
	 * 
	 * 5-10,18,20-21,30 说明：
	 * 
	 * 原VLAN资源池中有VLAN 5、6、7、8、9、10、15、18、20、21、30，从资源池中移除15后，资源池中剩下的VLAN为 5、6、7、8、9、10、18、20、21、30，按照题目描述格式并升序后的结果为5-10,18,20-21,30。 输入：
	 * 
	 * 5,1-3 10 输出：
	 * 
	 * 1-3,5 说明：
	 * 
	 * 原VLAN资源池中有VLAN 1、2、3，5，申请的VLAN 10不在原资源池中，将原资源池按照题目描述格式并按升序排序后输出的结果为1-3,5。 ———————————————— 版权声明：本文为CSDN博主「JOEL-T99」的原创文章，遵循CC 4.0
	 * BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/weixin_47243236/article/details/123007521
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
        // 对排序后的数组进行重组，一一遍历，如果下个数等于上个数加1，继续遍历，否则直接加入sb
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
            if (j == 1) { // 如果下个数不等于上个数加1，直接加入sb,同时i++
                sb.append(first);
                sb.append(",");
                i++;
            } else {  // 否则第一个数-递增的最后一个数加入sb,同时i=i+j
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
