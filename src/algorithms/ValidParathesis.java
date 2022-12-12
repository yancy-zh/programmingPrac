package algorithms;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParathesis
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String testCase = "(dsgdsg))2432";
		System.out.println(validParentheses(testCase));
	}
	
	// Modify the argument if it is necessary
	public static boolean validParentheses(String parens)
	{
		int n = parens.length();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		Deque<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < n; i++)
		{
			char ch = parens.charAt(i);
			if (map.containsKey(ch))
			{
				if (stack.isEmpty() || stack.peek() != map.get(ch))
				{ return false; }
				stack.pop();
			}
			else if (ch == '(')
			{
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}
	
}
