package algorithms;

import java.util.HashMap;
import java.util.Map;

public class FibonacciArray {
	Map<Integer, Integer> map = new HashMap<>();
	//备忘�?
    public int fib(int n) {
    	/*写一个函数，输入 n ，求斐波那契（Fibonacci）数列的�? n 项（�? F(N)）�?�斐波那契数列的定义如下�?

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列�? 0 �? 1 �?始，之后的斐波那契数就是由之前的两数相加而得出�??
e.g.:
		FibonacciArray fibSol = new FibonacciArray();
		System.out.println(fibSol.fib(2));
*/
    	if (map.containsKey(n)) {
			return map.get(n);
		}
    	if (n==0 || n==1) return n;
    	int res = fib(n-1) + fib(n-2);
    	res %= 1000000007;
    	map.put(n, res);
		return res;
    }
}
