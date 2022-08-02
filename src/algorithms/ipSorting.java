package algorithms;


public class ipSorting
{
	
	public static void main(String[] args)
	{
		// �����IP��ַ�Ͷ�Ӧ�����룬���з���ʶ��Ҫ����A/B/C/D/E���ַ���࣬���Ϸ��ĵ�ַ�����뵥�����ࡣ
		/* ���ӣ�https://www.nowcoder.com/questionTerminal/de538edd6f7e4bc3a5689723a7435682
��Դ��ţ����

�����IP��ַ�Ͷ�Ӧ�����룬���з���ʶ��Ҫ����A/B/C/D/E���ַ���࣬���Ϸ��ĵ�ַ�����뵥�����ࡣ

���е�IP��ַ����Ϊ A,B,C,D,E����

A���ַ��1.0.0.0��126.255.255.255;

B���ַ��128.0.0.0��191.255.255.255;

C���ַ��192.0.0.0��223.255.255.255;

D���ַ��224.0.0.0��239.255.255.255��

E���ַ��240.0.0.0��255.255.255.255


˽��IP��Χ�ǣ�

��10.0.0.0��10.255.255.255

��172.16.0.0��172.31.255.255

��192.168.0.0��192.168.255.255


��������Ϊ��������ǰ����������1��Ȼ��ȫ��0�������磺255.255.255.32����һ���Ƿ������룩
��ע���������ȫ��1����ȫ��0��Ϊ�Ƿ��������룩

ע�⣺
1. �����ڡ�0.*.*.*���͡�127.*.*.*����IP��ַ�������������������һ�࣬Ҳ�����ڲ��Ϸ�ip��ַ������ʱ�����
2. ˽��IP��ַ��A,B,C,D,E���ַ�ǲ���ͻ��


��������:
�����ַ�����ÿ��һ��IP��ַ�����룬��~������


��ο�����https://www.nowcoder.com/discuss/276����ѭ����������⡣


�������:
ͳ��A��B��C��D��E������IP��ַ��������롢˽��IP�ĸ�����֮���Կո������*/
	
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
