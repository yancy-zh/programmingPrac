package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CharactorSet
{
	/**
	 * ���������ַ����ϣ�һ��Ϊȫ���ַ�����һ��Ϊ��ռ���ַ�������ռ�õ��ַ����е��ַ�������ʹ�ã�Ҫ�����ʣ������ַ����� ��������������Ϊһ���ַ������ַ����а�����ȫ���ַ�������ռ���ַ����������ַ���ʹ��@���ӣ�ǰ��Ϊȫ��������Ϊ��ռ�á� ��ռ���ַ����е��ַ�һ����ȫ���ַ����е��ַ���
	 * �ַ����е��ַ����ַ�֮����Ӣ�Ķ��ŷָ��� �ַ����е��ַ���ʾΪ�ַ������֣��ַ�������ʹ��Ӣ��ð�ŷָ�������a:1,��ʾ1��a�ַ����ַ�ֻ����Ӣ����ĸ�����ִ�Сд������ֻ���������Σ�����������100�����һ���ַ���û��ռ�ã�@��ʶ��Ȼ���ڣ�����a:3,b:5,c:2@ ʾ��1�� ����
	 * a:3,b:5,c:2@a:1,b:2 ��� a:2,b:3,c:2 ע�⣺������ַ�˳��Ҫ������һ�£����ĳ���ַ���ȫ��ռ�ã�����Ҫ������� ʾ��2�� ���� a:3,b:5,c:2@a:3,b:2 ��� b:3,c:2 ��������������������������������
	 * ��Ȩ����������ΪCSDN����������ѽ�����㡹��ԭ�����£���ѭ CC 4.0 BY-SA ��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/JH_Shawlin/java/article/details/100898028
	 *
	 * @author YaoZhang
	 */
	public static void solv()
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			Map<String, Integer> map = new LinkedHashMap<>();
			// ��ȡȫ���ַ���
			String[] twoCharSet = scanner.nextLine().split("@", 2);
			for (String item : twoCharSet[0].split(",", -1))
			{
				String[] tempStrs = item.split(":", 2);
				map.put(tempStrs[0], Integer.valueOf(tempStrs[1]));
			}
			// ��ȡ��ռ���ַ���
			if (twoCharSet.length == 2)
			{
				for (String item : twoCharSet[1].split(",", -1))
				{
					String[] tempStrs = item.split(":", 2);
					map.put(tempStrs[0], map.get(tempStrs[0]) - Integer.valueOf(tempStrs[1]));
				}
			}
			// ������
			StringBuilder stringBuilder = new StringBuilder();
			map.entrySet().forEach(x -> {
				if (x.getValue() > 0)
				{
					stringBuilder.append(x.getKey() + ":" + x.getValue() + ",");
				}
			});
			System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1).toString());
		}
	}
}
