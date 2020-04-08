/**
 * @author laoduan
 * @create 2020-03-23-12:41
 */
public class ArrayQueueDemo {

    class ArrayQueue{
        private int maxSize;//表示数组的最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//改数据用于存放数据，模拟队列


        //创建队列的构造器
        public ArrayQueue(int arrMaxSize){
            maxSize = arrMaxSize;
            arr = new int [maxSize];
            front = -1;//指向队列头不，分析出front是指向队列头的前一位置
            rear = -1;//指向对列尾，队列最后一个数据
        }


        //判断队列是否满
        public boolean isFull(){
            return rear == maxSize -1;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        //添加数据到队列
        public void addQueue(int n){
            if(isFull()){
                System.out.println("队列慢，不能加入数据");
                return;
            }
            rear++;//让rear后移
            arr[rear] = n;
        }

    }
}
