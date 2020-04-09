/**
 * @author laoduan
 * @create 2020-04-09-21:29
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("-------------------双向链表测试-----------------------\n\n");


        HeroNode2 hero1 = new HeroNode2(1, "贾克斯", "武器大师");
        HeroNode2 hero2 = new HeroNode2(2, "李青", "盲僧");
        HeroNode2 hero3 = new HeroNode2(3, "凯瑟琳", "皮城女警");
        HeroNode2 hero4 = new HeroNode2(4, "提莫", "迅捷斥候");


        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        System.out.println("-------------------显示双向链表--------------------\n");
//        doubleLinkedList.list();

        System.out.println("--------------------顺序添加-----------------\n\n");

        doubleLinkedList.orderadd(hero2);
        doubleLinkedList.orderadd(hero1);
        doubleLinkedList.orderadd(hero4);
        doubleLinkedList.orderadd(hero3);
        doubleLinkedList.list();

//        //修改
//        HeroNode2 newHeroNode = new HeroNode2(2,"豹女","狂野女猎手");
//        doubleLinkedList.update(newHeroNode);
//        System.out.println("---------------------");
//        doubleLinkedList.list();
//
//        //删除
//        System.out.println("-----------------删除双向链表\n\n");
//        doubleLinkedList.dele(3);
//        doubleLinkedList.list();

    }
}


class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }
    //显示
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，创建一个temp
        HeroNode2 temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp=temp.next;
        }
    }


    //添加
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //形成一个双向链表
        temp.next=heroNode;
        heroNode.pre=temp;
    }
    //按编号顺序添加
    public void orderadd(HeroNode2 heroNode){


        HeroNode2 temp = head;
        if(temp==null){
            return;
        }
        while (true){
            if (temp.next==null){
                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }
            temp=temp.next;
        }
        heroNode.next=temp.next;
        heroNode.pre=temp;
        temp.next=heroNode;
    }

    //修改一个结点,和单向链表基本一样，只是节点类型是heronode2
    public void update(HeroNode2 heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if(temp.next.no==heroNode.no){
                flag=true;
                break;
            }if(temp.next==null){
                System.out.println("链表中没有你要找的结点");
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next.nickname=heroNode.nickname;
            temp.next.name=heroNode.name;
        }
    }

    //删除
    public void dele(int no){

        //判断当前链表是否为空
        if(head.next==null){
            System.out.println("链表为空,无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag= false;

        while (true){
            if(temp==null){
                System.out.println("链表中没有你要删的结点");
                break;
            }if(temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.pre.next=temp.next;
            //如果是最后一个结点，就不需要执行下面一句话，否则空指针异常
            if(temp.next!=null){
                temp.next.pre=temp.pre;

            }
        }
        else {
            System.out.printf("要删除的%d结点不在",no);
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//默认为null
    public HeroNode2 pre;

    //构造器
    public HeroNode2(int hNo,String hName,String hNickname){
        this.no=hNo;
        this.name=hName;
        this.nickname=hNickname;
    }

    //重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}