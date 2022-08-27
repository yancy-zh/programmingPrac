package algorithms;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 * 约瑟夫环 报数游戏 比如 5，3 则最后一个退出游戏的是4号 
 * 五个人围城环，数到三退出游戏，然后往下轮,最后一个为幸存者
 * 要满足报数小于人数
 * @author mac
 *
 */
public class BSYX {
	public static void main(String[] args) {
//		System.out.println("---生存者"+baoshu1(5,3));
//		System.out.println("---生存者"+baoshu1(12,3));
		System.out.println("---生存者"+baoshu2(100,3));
	}
 
	/**
	 * baoshu prints the last persons' indices
	 * @param num number of persons
	 * @param count the index at which the person will be removed
	 */
	public static int baoshu1(int num, int count) {
		// 最后退出的是第n个人
		int n = 0;
		// 剩余的人
		int rest = num;
		// 利用数组初始化为0作为标识位
		int[] arr = new int[num + 1];
		// 初始化次数
		int index = 1;
		for (int i = 1, j = 1; i < num + 1; i++, j++) {
			//跳过已退出的数据
			while (arr[i] == 1) {
				if(i<num) {
					i++;
				}else {
					i=1;
				}
			}
			if (rest == 1) {
				n = i;
				break;
			}
			if (j == 1) {
				System.out.println();
				System.out.print("第" + index + "次游戏," + i + "[" + j + "],");
			} else if (j < count ) {
				System.out.print(i + "[" + j + "],");
			} else {
				System.out.print(i + "[" + j + "]--" + i + "退出游戏");
				// 重置j会++故设为0，游戏次数+1,数组做标记位已退出，剩余人少1
				j = 0;
				index++;
				rest--;
				arr[i] = 1;
			}
			if (i == num ) {
				// 回到头，会++故设为0
				i = 0;
			}
		}
		return n;
	}
	/**
	 * 利用队列
	 * @param num
	 * @param count
	 * @return
	 */
	public static int baoshu2(int num, int count) {
		int n = 0;
		int rest = num;
		int index = 1;
		int l = 0;
		Queue<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<num+1;i++) {
			list.add(i);
		}
		while(!list.isEmpty()) {
			Integer poll = list.poll();
			l++;
			if(rest == 1) {
				n=poll;
				break;
			}
			// 灵活运用求余
			if(l%count == 1) {
				System.out.println();
				list.add(poll);
				System.out.print("第" + index + "次游戏," + poll + "[" + 1 + "],");
			}else if(l%count==0) {
				System.out.println(poll + "[" + count + "]--" + poll + "退出游戏");
				rest --;
				index++;
			}else {
				list.add(poll);
				System.out.print(poll + "[" + poll%count + "],");
			}
		}
		return n;
		
	}
 
}
