/**
 * @author laoduan
 * @create 2020-03-26-10:34
 */
public class CircleArrayQueue {

    public static void main(String[] args) {


        System.out.println("测试数组模拟环形队列的案例");

    }
}


class CircleArray{
    private int maxSize;//表示数组的最大容量
    //front 变量的含义做调整：front指向队列的第一个元素，初始值为0
    private int front;//队列头
    //rear  变量的含义：指向队列的最后一个元素的后一个位置，初始值为0
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列


    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front=0;
        rear=0;
    }


    //判断队列是否满
    public  boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能加入数据----------");
            return;
        }

        arr[rear]=n;
        //将rear后移，考虑取模
        rear = (rear+1)%maxSize;
    }

    //获取队列的元素，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        //front是指向队列的第一个元素
        //1. 先把front对应的值保留到一个临时变量
        //2. 将front后移,考虑取模
        //3. 将临时保存的变量返回
        int value = arr[front];
        front = (front+1)%maxSize;
        return front;
    }
    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("对烈士空的，没有数据-------");
            return;
        }
        for(int i = front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}