import java.util.Scanner;

/**
 * @author laoduan
 * @create 2020-04-10-17:21
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        Arraystack stack = new Arraystack(4);
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
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        stack.pop();

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


class Arraystack{
    private int maxSize;//栈的大小
    private int[] stack;//数组
    private int top = -1;


    public Arraystack(int maxSize){
        this.maxSize=maxSize;
        stack=new int [this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满，不能入栈");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        top--;
        return stack[top+1];
    }
    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，不能遍历");
        }
        for (int i=top;i>-1;i--){
            System.out.printf("stacl[%d]=%d\n",i,stack[i]);
        }
    }

}