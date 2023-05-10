package algorithms;

public class Sqrt
{
	public long mySqrt(int x)
	{
		// 0 无法取对数
		if (x == 0){
			return 0;
		}
		int res = (int) Math.exp(Math.log(x) * 0.5);
		return (long)(res+1)*(res+1) <= x? res+1: res;
	}
	

}
