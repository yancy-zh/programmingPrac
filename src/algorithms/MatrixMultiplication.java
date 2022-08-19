package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class MyMat
{
	public MyMat(int numRows, int numCols)
	{
		super();
		this.numRows = numRows;
		this.numCols = numCols;
	}
	
	private int numRows;
	private int numCols;
	
	public int getNumRows()
	{
		return numRows;
	}
	
	public void setNumRows(int numRows)
	{
		this.numRows = numRows;
	}
	
	public int getNumCols()
	{
		return numCols;
	}
	
	public void setNumCols(int numCols)
	{
		this.numCols = numCols;
	}
	
}

public class MatrixMultiplication
{
	/*
	 * 描述 矩阵乘法的运算量与矩阵乘法的顺序强相关。 例如：
	 * 
	 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
	 * 
	 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
	 * 
	 * 编写程序计算不同的计算顺序需要进行的乘法次数。
	 * 
	 * 数据范围：矩阵个数：1\le n\le 15 \1≤n≤15 ，行列数：1\le row_i,col_i\le 100\1≤row i ​ ,col i ​ ≤100 ，保证给出的字符串表示的计算顺序唯一。 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
	 * 
	 * 输入描述： 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
	 * 
	 * 输出描述： 输出需要进行的乘法次数
	 * 
	 * 示例1 输入： 3 50 10 10 20 20 5 (A(BC)) 复制 输出： 3500
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.ready())
		{
			int n = Integer.parseInt(br.readLine()); // num of matrices
			MyMat[] mats = new MyMat[n];
			for (int i = 0; i < n; i++)
			{
				String[] rowcol = br.readLine().split(" ");
				mats[i] = new MyMat(Integer.parseInt(rowcol[0]), Integer.parseInt(rowcol[1]));
			}
			String formula = br.readLine();
			Stack<MyMat> stack = new Stack<>();
			int sum = 0;
			for (int j = formula.length() - 1, k = n - 1; j >= 0; j--)
			{
				if (formula.charAt(j) >= 'A' && formula.charAt(j) <= 'Z')
				{
					stack.push(mats[k]);
					k--;
				}
				else if (formula.charAt(j)=='(')
				{
					MyMat mat1= stack.pop();
					MyMat mat2= stack.pop();
					sum += calcNumElem(mat1, mat2);
					stack.push(new MyMat(mat1.getNumRows(), mat2.getNumCols()));
				}
			}
			System.out.println(sum);
		}
	}
	
	public static int calcNumElem(MyMat a, MyMat b)
	{
		return a.getNumRows() * b.getNumRows() * b.getNumCols();
	}
	
}
