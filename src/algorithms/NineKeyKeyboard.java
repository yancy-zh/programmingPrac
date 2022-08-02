package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.text.Keymap;

public class NineKeyKeyboard
{
	private static Map<Character, String> keyMap = new HashMap<Character, String>()
	{
		{
			put('1', ",.");
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
			put('0', " ");
			put('/', "/");
		}
	};
	
	public static void main(String[] args)
	{
		// https://blog.csdn.net/qq_34465338/article/details/125670970
		/*
		 * 1. # �л����ֺ�Ӣ��ģʽ��Ĭ��������ģʽ����#���л�ΪӢ��ģʽ 2. /��ʾ�ӳ٣�����һ�������뿪ʼͳ����һ�����룬����ģʽ��û��Ч�� 3. ��ΰ�ͬһ��������ĸ���濪ʼѭ����
		 */
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			boolean EnglishMode = false; // when type # switch to mode
			String line = scanner.nextLine();
			StringBuilder outputBuilder = new StringBuilder();
			Character curr = null;
			int counter = 0;
			for (int i = 0; i < line.length(); i++)
			{
				if (i == 0)
				{
					curr = line.charAt(i);
					if (curr == '#')
					{
						EnglishMode = true;
					}
					if (!EnglishMode)
					{
						outputBuilder.append(curr);
						continue;
					}
				}
				else if (i > 0)
				{
					if (!EnglishMode) // number mode
					{
						curr = line.charAt(i);
						if (curr == '#')
						{
							EnglishMode = true;
							counter = 0;
						}
						else
						{
							outputBuilder.append(curr);
						}
					}
					else// english mode
					{
						if (line.charAt(i) == curr)// curr char the same as prev
						{
							counter++;
							if (i == line.length() - 1)// reached the last char
							{
								// complete the calculation
								outputBuilder.append(englishMode(curr, counter));
							}
						}
						else
						{// curr char not the same as prev
							// complete the previous calculation
							if (counter >= 1)
							{
								outputBuilder.append(englishMode(curr, counter));
							}
							// obtain current char
							curr = line.charAt(i);
							// counter set to 1
							counter = 1;
						}
					}
				}
			}
			// complete the calculation if counter is not 0
			if (EnglishMode && counter >= 1)
			{
				outputBuilder.append(englishMode(curr, counter));
			}
			//TODO: / slash logic to be implemented. 
			System.out.println(outputBuilder.toString());
		}
		
	}
	
	// english mode
	public static char englishMode(Character inChar, int counter)
	{
		int mapSize = keyMap.get(inChar).length();
		return keyMap.get(inChar).charAt((counter - 1) % mapSize);
		
	}
	
}
