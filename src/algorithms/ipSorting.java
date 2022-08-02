package algorithms;


public class ipSorting
{
	
	public static void main(String[] args)
	{
		// 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
		/* 链接：https://www.nowcoder.com/questionTerminal/de538edd6f7e4bc3a5689723a7435682
来源：牛客网

请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

所有的IP地址划分为 A,B,C,D,E五类

A类地址从1.0.0.0到126.255.255.255;

B类地址从128.0.0.0到191.255.255.255;

C类地址从192.0.0.0到223.255.255.255;

D类地址从224.0.0.0到239.255.255.255；

E类地址从240.0.0.0到255.255.255.255


私网IP范围是：

从10.0.0.0到10.255.255.255

从172.16.0.0到172.31.255.255

从192.168.0.0到192.168.255.255


子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
（注意二进制下全是1或者全是0均为非法子网掩码）

注意：
1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
2. 私有IP地址和A,B,C,D,E类地址是不冲突的


输入描述:
多行字符串。每行一个IP地址和掩码，用~隔开。


请参考帖子https://www.nowcoder.com/discuss/276处理循环输入的问题。


输出描述:
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。*/
	
	}
	int[] ipSplit(String ip) {
		String[] ipParts = ip.split(".");
		int[] intParts = {};
		for (int i = 0; i < ipParts.length; i++)
		{
			intParts[i] = Integer.parseInt(ipParts[i]);
		}
		return intParts;
	}
	
	boolean ipIsTypeA(String ip) {
		int[] intParts = ipSplit(ip);
		if(intParts[0] >= 128 && intParts[0] <= 191 
				&& intParts[1] >= 0 && intParts[1] <= 255
				&& intParts[2] >= 0 && intParts[2] <= 255
				&& intParts[3] >= 0 && intParts[3] <= 255
				) {
			return true;
		} 
		return false;
	}
	
	boolean ipIsTypeB(String ip) {
		int[] intParts = ipSplit(ip);
		if(intParts[0] >= 1 && intParts[0] <= 126 
				&& intParts[1] >= 0 && intParts[1] <= 255
				&& intParts[2] >= 0 && intParts[2] <= 255
				&& intParts[3] >= 0 && intParts[3] <= 255
				) {
			return true;
		} 
		return false;
	}
	
	boolean ipIsTypeC(String ip) {
		int[] intParts = ipSplit(ip);
		if(intParts[0] >= 224 && intParts[0] <= 239 
				&& intParts[1] >= 0 && intParts[1] <= 255
				&& intParts[2] >= 0 && intParts[2] <= 255
				&& intParts[3] >= 0 && intParts[3] <= 255
				) {
			return true;
		} 
		return false;
	}
	
	boolean ipIsTypeD(String ip) {
		int[] intParts = ipSplit(ip);
		if(intParts[0] >= 1 && intParts[0] <= 126 
				&& intParts[1] >= 0 && intParts[1] <= 255
				&& intParts[2] >= 0 && intParts[2] <= 255
				&& intParts[3] >= 0 && intParts[3] <= 255
				) {
			return true;
		} 
		return false;
	}
	
	boolean ipIsTypeE(String ip) {
		int[] intParts = ipSplit(ip);
		if(intParts[0] >= 240 && intParts[0] <= 255 
				&& intParts[1] >= 0 && intParts[1] <= 255
				&& intParts[2] >= 0 && intParts[2] <= 255
				&& intParts[3] >= 0 && intParts[3] <= 255
				) {
			return true;
		} 
		return false;
	}
}
