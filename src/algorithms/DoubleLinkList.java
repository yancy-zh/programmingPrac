package algorithms;

import java.util.Scanner;

/**
 * @author zzy
 * @time 2021/8/17
 * @description ˫������ �����������
 */
public class DoubleLinkList {

    /**
     * ͷ
     */
    private Node first;
    /**
     * β
     */
    private Node last;
 
    public DoubleLinkList(){
        first = null;
        last = null;
    }

    /**
     * ��˫�������β����������
     * @param value ���int������
     */
    public void insertLast(int value){
        Node newNode = new Node(value);
        //���ͷ���Ϊ�գ�ֱ����ͷ�������µĽڵ�
        if (first == null) {
            first = newNode;
        }else {
            //��������
            last.next = newNode;
            newNode.previous = last;
        }
        //�������ڵ�����Ϊ���µĽڵ�
        last = newNode;
    }

    /**
     * �ж�˫�������Ƿ�Ϊ��
     * @return ���ͷ���Ϊ�ռ�˫������Ϊ�գ��򷵻�true
     */
    public boolean isEmpty(){
        return first == null;
    }
 
    /**
     * ɾ��ͷ�ڵ�
     * Ҫȥ������ָ��,һ��ָ���¸���next ,һ����next��previousָ��ǰ���
     * @return
     */
    public Node deleteFirst(){
        if (first == null) {
            throw new RuntimeException("�������ݲ�����");
        }
        Node temp = first;
        if (first.next == null) {
            last = null;
        }else {
            first.next.previous = null;
        }
        first = temp.next;
        return temp;
    }
 
    /**
     * ɾ��β�ڵ�
     * Ҫȥ������ָ��,һ��ָ���¸���next ,һ����next��previousָ��ǰ���
     * @return
     */
    public Node deleteLast(){
        if (first == null) {
            throw new RuntimeException("�������ݲ�����");
        }
 
        Node temp = last;
        if (first.next == null) {
            last = null;
            //�ѵ�һ��ɾ��
            first = null;
        }else {
            last.previous.next = null;
        }
        last = temp.previous;
        return temp;
    }
    /**
     * ��ʾ���е�����
     */
    public void display(){
        if (first == null) {
            return;
        }
        Node current = first;
        while(current != null){
            current.display();
            current = current.next;
        }

    }
 
    public static void main(String[] args) {
        //�½�һ��˫������
        DoubleLinkList linkList = new DoubleLinkList();
        //����n
        Scanner scanner = new Scanner(System.in);
        int n = 100;
        //��1-n�����˳���������ģ��n���˵���λ
        for (int i = 1; i <= n; i++) {
            linkList.insertLast(i);
        }

        //����һ��ָ��ָ��ͷ���
        Node temp = linkList.first;
        /*
        m Ϊ�е�m�ų��е���
        indexΪ��־λ���ж��ǲ��ǵ��˵�m����
        numΪ����ɾ���˶���ֵ�����num==n-1����ô˵��˫��������ֻ��һ��ֵ����Ҫ�˳�ɾ����ѭ��
        flag��־λ�ж�˫��������ǰ�������������� falseʱ��ǰ������true������ Ĭ��������
         */
        int m, index = 0, num = 0;
        boolean flag = true;
        //����mֵ
        m = scanner.nextInt();

        while (true) {
            index++;
            //���temp�ߵ����һ���ڵ㣬��flag��ֵΪfalse ����ǰ����
            if (temp == linkList.last) {
                flag = false;
            }else if(temp == linkList.first){
                flag = true;
            }
            if (index % m == 0) {
                System.out.printf("ɾ����ֵ: ");
                temp.display();
                if (temp == linkList.last) {
                    //�����ɾ���Ľڵ�Ϊβ��㣬��ɾ��β���
                    linkList.deleteLast();
                    flag = false;
                } else if (temp == linkList.first) {
                    //�����ɾ���Ľڵ�Ϊͷ��㣬��ɾ��ͷ���
                    linkList.deleteFirst();
                    flag = true;
                } else {
                    //���ɾ���ļȲ���ͷҲ����β����װ�����Ľڵ�ɾ��
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
                //����ɾ���ڵ�ĸ���
                num++;
            }

            //�жϵ�ǰ�����ķ���
            if (flag) {
                //���Ϊtrue����������
                temp = temp.next;
            } else {
                //���Ϊfalse������ǰ����
                temp = temp.previous;
            }
            if (num == n - 1) {
                //ɾ���ĸ���num����N-1ʱ��˵��˫�������У�ֻ��һ��ֵ
                break;
            }
        }

        //���˫�������е����һ��ֵ
        System.out.printf("���ʣ���ֵ:");
        linkList.display();
    }
}

class Node{
    public Node previous;
    public Node next;
    public long data;

    public Node(long data){
        this.data = data;
    }
    public void display(){
        System.out.println(data);
    }
}
