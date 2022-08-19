package algorithms;

import java.util.Stack;

public class BracketChecker
{
	
	public static void main(String[] args)
	{
		String testStr = "if((a==1)&&(b==1))";
		System.out.println(isGoodBracket(testStr));
		String testStr2 = "if((a==1))&&((b==1))";
		System.out.println(isGoodBracket(testStr2));
		
	}
	
	public static boolean isGoodBracket(String instr)
	{
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < instr.length(); i++)
		{
			if (instr.charAt(i) == '(')
			{
				stack.push(')');
			}
			if (instr.charAt(i) == ')')
			{
				if (stack.isEmpty())
				{
					return false;
				} 
				char temp = stack.pop();
				if (temp != ')')
				{
					return false;
				}
			}
		}
		if (!stack.isEmpty()) // too many '('
		{
			return false;
		}
		return true;
	}
}
