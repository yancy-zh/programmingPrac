package huaweiCodingPrac;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignSeatForNewEmployee {
	/*
	 * <h3 id="main-toc">题目描述</h3>
	 * <p>工位由序列F1,F2…Fn组成，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。</p>
	 * <p>1、某一空位的友好度为左右连续老员工数之和，<br> 2、为方便新员工学习求助，优先安排友好度高的空位，</p>
	 * <p>给出工位序列，求所有空位中<strong>友好度的最大值</strong>。</p> <p></p> <h3
	 * id="%E8%BE%93%E5%85%A5%E6%8F%8F%E8%BF%B0">输入描述</h3>
	 * <p>第一行为工位序列：F1，F2…Fn组成，<br>
	 * 1&lt;=n&lt;=10000，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。</p> <p></p> <h3
	 * id="%E8%BE%93%E5%87%BA%E6%8F%8F%E8%BF%B0">输出描述</h3>
	 * <p>所有空位中友好度的最大值。如果没有空位，返回0。</p> <p></p> <h3 id="%E7%94%A8%E4%BE%8B">用例</h3>
	 * <table border="1" cellpadding="1" cellspacing="1" style="width:500px;">
	 * <tbody> <tr> <td style="width:86px;">输入</td> <td style="width:412px;">0 1
	 * 0</td> </tr> <tr> <td style="width:86px;">输出</td> <td
	 * style="width:412px;">1</td> </tr> <tr> <td style="width:86px;">说明</td> <td
	 * style="width:412px;">第1个位置和第3个位置，友好度均为1。</td> </tr> </tbody> </table>
	 * eg2：1 1 1 0 1 2 1 1 1 0 0 1 1 1 2 1 1 out：4
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> seats = Stream.of(sc.nextLine().split(" ")).map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		int maxfriendliness = 0;
		int leftFriendliness = 0;
		int rightFriendliness = 0;

		for (int i = 0; i < seats.size(); i++) {
			if (seats.get(i) == 1) {
				leftFriendliness++;
			} else if (seats.get(i) == 2) {
				leftFriendliness = 0;
			} else if (seats.get(i) == 0) {
				// cal the right friendliness
				int j = i + 1;
				while (j < seats.size() && seats.get(j) == 1) {
					rightFriendliness++;
					j++;
				}
				// update max friendliness
				if (leftFriendliness + rightFriendliness > maxfriendliness) {
					maxfriendliness = leftFriendliness + rightFriendliness;
				}
				leftFriendliness = 0;
				rightFriendliness = 0;
			}
		}
		System.out.println(maxfriendliness);
	}
}
