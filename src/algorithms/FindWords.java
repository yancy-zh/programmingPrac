package algorithms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWords
{
	/*
	 * 在给定字符串中找出单词（“单词”由大写字母和小写字母字符构成，其他非字母字符视为单词的间隔，如空格、问号、数字等等；
//另外单个字母不算单词）；找到单词后，按照长度进行降序排序，（排序时如果长度相同，则按出现的顺序进行排列），
//然后输出到一个新的字符串中；如果某个单词重复出现多次，则只输出一次；如果整个输入的字符串中没有找到单词，请输出空串。
//输出的单词之间使用一个“空格”隔开，最后一个单词后不加空格。
 * input:
 * 12I3have4a5dream#but%I@*never#&REEACHED!@IT
 * output:
IT but have dream never REEACHED
————————————————
版权声明：本文为CSDN博主「huhuichun」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/huhuichun/article/details/46808373
	 * https://blog.csdn.net/huhuichun/article/details/46808373
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
		//TODO锟斤拷https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator
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
