package algorithms;

import java.util.Scanner;

/**
 * @author zzy
 * @time 2021/8/17
 * @description 双向链表 解决报数问题
 */
public class DoubleLinkList {

    /**
     * 头
     */
    private Node first;
    /**
     * 尾
     */
    private Node last;
 
    public DoubleLinkList(){
        first = null;
        last = null;
    }

    /**
     * 从双向链表的尾部插入数据
     * @param value 添加int型数字
     */
    public void insertLast(int value){
        Node newNode = new Node(value);
        //如果头结点为空，直接让头结点等于新的节点
        if (first == null) {
            first = newNode;
        }else {
            //建立连接
            last.next = newNode;
            newNode.previous = last;
        }
        //把最后个节点设置为最新的节点
        last = newNode;
    }

    /**
     * 判断双向链表是否为空
     * @return 如果头结点为空既双向链表为空，则返回true
     */
    public boolean isEmpty(){
        return first == null;
    }
 
    /**
     * 删除头节点
     * 要去除两个指针,一个指向下个的next ,一个是next的previous指向前面的
     * @return
     */
    public Node deleteFirst(){
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
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
     * 删除尾节点
     * 要去除两个指针,一个指向下个的next ,一个是next的previous指向前面的
     * @return
     */
    public Node deleteLast(){
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
        }
 
        Node temp = last;
        if (first.next == null) {
            last = null;
            //把第一个删除
            first = null;
        }else {
            last.previous.next = null;
        }
        last = temp.previous;
        return temp;
    }
    /**
     * 显示所有的数据
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
        //新建一个双向链表
        DoubleLinkList linkList = new DoubleLinkList();
        //输入n
        Scanner scanner = new Scanner(System.in);
        int n = 100;
        //按1-n的序号顺序插入链表，模拟n个人的座位
        for (int i = 1; i <= n; i++) {
            linkList.insertLast(i);
        }

        //设置一个指针指向头结点
        Node temp = linkList.first;
        /*
        m 为叫到m号出列的人
        index为标志位，判断是不是到了第m号人
        num为计算删除了多少值，如果num==n-1，那么说明双向链表中只有一个值，需要退出删除的循环
        flag标志位判断双向链表向前遍历还是向后遍历 false时向前遍历，true向后遍历 默认向后遍历
         */
        int m, index = 0, num = 0;
        boolean flag = true;
        //输入m值
        m = scanner.nextInt();

        while (true) {
            index++;
            //如果temp走到最后一个节点，将flag赋值为false 既向前遍历
            if (temp == linkList.last) {
                flag = false;
            }else if(temp == linkList.first){
                flag = true;
            }
            if (index % m == 0) {
                System.out.printf("删除的值: ");
                temp.display();
                if (temp == linkList.last) {
                    //如果待删除的节点为尾结点，则删除尾结点
                    linkList.deleteLast();
                    flag = false;
                } else if (temp == linkList.first) {
                    //如果待删除的节点为头结点，则删除头结点
                    linkList.deleteFirst();
                    flag = true;
                } else {
                    //如果删除的既不是头也不是尾，则安装正常的节点删除
                    temp.previous.next = temp.next;
                    temp.next.previous = temp.previous;
                }
                //计算删除节点的个数
                num++;
            }

            //判断当前遍历的方向
            if (flag) {
                //如果为true，则向后遍历
                temp = temp.next;
            } else {
                //如果为false，则向前遍历
                temp = temp.previous;
            }
            if (num == n - 1) {
                //删除的个数num等于N-1时，说明双向链表中，只有一个值
                break;
            }
        }

        //输出双向链表中的最后一个值
        System.out.printf("最后剩余的值:");
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
