import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindWords
{
	/*
	 * �ڸ����ַ������ҳ����ʣ������ʡ��ɴ�д��ĸ��Сд��ĸ�ַ����ɣ���������ĸ�ַ���Ϊ���ʵļ������ո��ʺš����ֵȵȣ�
���ⵥ����ĸ���㵥�ʣ����ҵ����ʺ󣬰��ճ��Ƚ��н������򣬣�����ʱ���������ͬ���򰴳��ֵ�˳��������У���
Ȼ�������һ���µ��ַ����У����ĳ�������ظ����ֶ�Σ���ֻ���һ�Σ��������������ַ�����û���ҵ����ʣ�������մ���
����ĵ���֮��ʹ��һ�����ո񡱸��������һ�����ʺ󲻼ӿո�
e.g.:
in: 
��������������������������������
��Ȩ����������ΪCSDN������huhuichun����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ���������
ԭ�����ӣ�https://blog.csdn.net/huhuichun/article/details/46808373
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String inStr = scanner.next();
			Pattern re= Pattern.compile("[a-zA-Z][a-zA-Z]+");
			Matcher m = re.matcher(inStr);
			ArrayList<String> arr = new ArrayList<>();
		
			Set<String> uniquSet = new HashSet<String>();
			String output = "";
			while (m.find())
			{
				String currString = m.group();
				if (uniquSet.contains(currString))
				{
					continue;
				}
				uniquSet.add(currString);
				arr.add(currString);
			}
		//TODO��https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator
			arr.sort(new Comparator<String>()
			{
				@Override
				public int compare(String o1, String o2) {
					return o1.length() - o2.length();
				};
			});
			StringBuilder sBuilder = new StringBuilder();
			for (int i = 0; i < arr.size(); i++)
			{
				sBuilder.append(arr.get(i)+ " ");
			}
			//TODO fix the result
			output = sBuilder.toString().substring(0, sBuilder.length()-1);
			System.out.println(output);
		}
		
	}
	

	
}
