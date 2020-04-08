import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * @author laoduan
 * @create 2020-04-08-16:22
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {


        HeroNode hero1 = new HeroNode(1, "贾克斯", "武器大师");
        HeroNode hero2 = new HeroNode(2, "李青", "盲僧");
        HeroNode hero3 = new HeroNode(3, "凯瑟琳", "皮城女警");
        HeroNode hero4 = new HeroNode(4, "提莫", "迅捷斥候");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList.orderadd(hero1);
        singleLinkedList.orderadd(hero4);
        singleLinkedList.orderadd(hero2);
        singleLinkedList.orderadd(hero3);
//
//        singleLinkedList.list();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        HeroNode hero22 = new HeroNode(2, "瞎子", "4396");
//        singleLinkedList.update(hero22);
//
        singleLinkedList.list();


        System.out.println("----------------倒序后的链表----------------");
        singleLinkedList.reverse(singleLinkedList.getHead());
        singleLinkedList.list();
//
//
//        singleLinkedList.dele(hero3);
//        singleLinkedList.dele(hero2);
//        singleLinkedList.dele(hero1);
//        singleLinkedList.dele(hero4);
//        System.out.println("删除后的链表");
//        singleLinkedList.list();

        //System.out.println("倒数第k个结点");
//        singleLinkedList.list();
//        singleLinkedList.count(singleLinkedList.getHead());
//        singleLinkedList.revek(singleLinkedList.getlength(singleLinkedList.getHead()),2);



    }
}



//定义singlelinkedList管理英雄
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            if(temp.next==null){
                break;
            }else {
                //如果没有找到，就后移
                temp=temp.next;
            }
        }
        temp.next=heroNode;
    }


    //顺序添加
    public void orderadd(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }if(temp.next.no>heroNode.no){//找到要添加的位置了

                break;
            }else if(heroNode.no==temp.next.no){
                flag=true;
                System.out.println("要插入的元素已经存在");
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.printf("待插入的英雄 %d 已经存在，不能添加\n",heroNode.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }

    }

    //修改
    public void update(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;
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
    public void dele(HeroNode heroNode){
        if(head==null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;

        while (true){
            if(temp==null){
                System.out.println("链表中没有你要删的结点");
                break;
            }if(temp.next.no==heroNode.no){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }

    //求单链表结点个数
    public int count(HeroNode head){
        HeroNode temp = head.next;
        int count=0;
        if(head==null){
            System.out.println("链表长度为0");
        }
        while (true){
            if(temp==null){
                System.out.printf("链表的长度为%d",count);
                break;
            }
            count++;
            temp=temp.next;
        }
        return count;
    }

    //翻转单链表
    public void reverse(HeroNode head){
        if(head==null){
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reversehead = new HeroNode(0,"","");
        while (temp!=null){
            next=temp.next;
            temp.next=reversehead.next;
            reversehead.next=temp;
            temp=next;

        }
        head.next=reversehead.next;
    }
    //获取长度
    public int getlength(HeroNode head){
        int count=0;
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            count += 1;
        }
        return count;
    }
    //倒数第k个结点
    public void revek(int length,int k){
        HeroNode temp =head;
        for(int l=0;l<=length-k;l++){
            temp=temp.next;
        }
        System.out.printf("倒数第%d个结点是"+temp,k);
    }



    //显示
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，创建一个temp
        HeroNode temp=head.next;
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


class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //构造器
    public HeroNode(int hNo,String hName,String hNickname){
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