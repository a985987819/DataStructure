/**
 * @author laoduan
 * @create 2020-04-09-22:27
 */
public class josepfu {
    public static void main(String[] args) {


        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
//        circleSingleLinkedList.showboy();
        circleSingleLinkedList.josepfu(1, 2, 25);
    }
}


//创建一个环形的单向列表
class CircleSingleLinkedList {
    private Boy first = null;

    //添加小孩节点，组成环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        //用for来创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;//让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showboy(){
        if(first==null){
            System.out.println("没有小孩");
            return;
        }
        //first不能动，要用辅助指针
        Boy curBoy =first;
        while (true){
            System.out.printf("当前小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){
                //说明循环完毕
                break;
            }else {
                curBoy=curBoy.getNext();
            }
        }
    }
    //约瑟夫
    public void josepfu(int startNo,int n,int nums){
        if (first==null||startNo<1||startNo>nums){
            System.out.println("参数有误");
            return;
        }
        Boy helper = first;
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }

        while (true){
            if(helper==first){
                break;
            }
            for (int x=0;x<n-1;x++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("出圈的小孩编号为%d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后剩下的小孩是%d\n",first.getNo());
    }
}


//创建一个boy类，表示一个结点
class Boy {
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
    public Boy (int no ){
        this.no = no;
    }
    private int no;
    private Boy next;

}