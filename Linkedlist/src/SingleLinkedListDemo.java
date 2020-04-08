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

        singleLinkedList.list();
        System.out.println();
        System.out.println();
        System.out.println();

        HeroNode hero22 = new HeroNode(2, "瞎子", "4396");
        singleLinkedList.update(hero22);

        singleLinkedList.list();


        singleLinkedList.dele(hero3);
        singleLinkedList.dele(hero2);
        singleLinkedList.dele(hero1);
        singleLinkedList.dele(hero4);
        System.out.println("删除后的链表");
        singleLinkedList.list();
    }
}



//定义singlelinkedList管理英雄
class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

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