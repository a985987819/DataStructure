import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author laoduan
 * @create 2020-04-10-17:53
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();



        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("------------------------");
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("pop:出栈");
            System.out.println("push:入栈\n");
            System.out.println("输入你的选择\n");

            key = scanner.next();
            switch (key){
                case "show":
                    linkedListStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    System.out.println("请输入数据");
                    String data = scanner.next();
                    MyNode myNode = new MyNode(value, data);
                    linkedListStack.push(myNode);
                    break;
                case "pop":
                    try {
                        linkedListStack.pop();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;

            }

        }
        System.out.println("程序退出");



    }
}

class LinkedListStack{
    private int top=-1;

    MyNode head = new MyNode(0,"");
    public MyNode getHead(){
        return head;
    }


    //入栈
    public void push(MyNode myNode){
        MyNode temp = head.next;
        if(head.next==null){
            head.next=myNode;
        }else {
            myNode.next=temp;
            head.next=myNode;
        }
        top++;
    }

    //出栈
    public MyNode pop (){
        MyNode node = head.next;
        head.next=node.next;
        System.out.println("取出的栈顶数据是:"+node);
        if(node==null){
            System.out.println("链表为空");
        }
        return node;
    }


    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }

        MyNode temp = head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp=temp.next;
        }
    }

}

class MyLinkedList{
    MyNode head =  new MyNode(0,"");
    public MyNode getHead(){
        return head;
    }


    public void add(MyNode myNode){
        MyNode temp = head.next;
        if(head.next==null){
            head.next=myNode;
        }else {
            myNode.next=temp;
            head.next=myNode;
        }
    }

    public void show(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }

        MyNode temp = head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp=temp.next;
        }
    }
}
class MyNode{
    int no;
    String data;
    MyNode next;

    public MyNode(int no,String data){
        this.no=no;
        this.data=data;
    }

    @Override
    public String toString() {
        return "{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}