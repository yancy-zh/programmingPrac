package algorithms;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 * Լɪ�� ������Ϸ ���� 5��3 �����һ���˳���Ϸ����4�� 
 * �����Χ�ǻ����������˳���Ϸ��Ȼ��������,���һ��Ϊ�Ҵ���
 * Ҫ���㱨��С������
 * @author mac
 *
 */
public class BSYX {
	public static void main(String[] args) {
//		System.out.println("---������"+baoshu1(5,3));
//		System.out.println("---������"+baoshu1(12,3));
		System.out.println("---������"+baoshu2(100,3));
	}
 
	/**
	 * baoshu prints the last persons' indices
	 * @param num number of persons
	 * @param count the index at which the person will be removed
	 */
	public static int baoshu1(int num, int count) {
		// ����˳����ǵ�n����
		int n = 0;
		// ʣ�����
		int rest = num;
		// ���������ʼ��Ϊ0��Ϊ��ʶλ
		int[] arr = new int[num + 1];
		// ��ʼ������
		int index = 1;
		for (int i = 1, j = 1; i < num + 1; i++, j++) {
			//�������˳�������
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
				System.out.print("��" + index + "����Ϸ," + i + "[" + j + "],");
			} else if (j < count ) {
				System.out.print(i + "[" + j + "],");
			} else {
				System.out.print(i + "[" + j + "]--" + i + "�˳���Ϸ");
				// ����j��++����Ϊ0����Ϸ����+1,���������λ���˳���ʣ������1
				j = 0;
				index++;
				rest--;
				arr[i] = 1;
			}
			if (i == num ) {
				// �ص�ͷ����++����Ϊ0
				i = 0;
			}
		}
		return n;
	}
	/**
	 * ���ö���
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
			// �����������
			if(l%count == 1) {
				System.out.println();
				list.add(poll);
				System.out.print("��" + index + "����Ϸ," + poll + "[" + 1 + "],");
			}else if(l%count==0) {
				System.out.println(poll + "[" + count + "]--" + poll + "�˳���Ϸ");
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
