import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author laoduan
 * @create 2020-04-28-16:07
 */
public class Bubblesort {
    public static void main(String[] args) {
        int arr[]={3,9,-1,10,-2};

        System.out.println("排序前的数组为");
        System.out.println(Arrays.toString(arr));


        BubbleSort(arr);


        System.out.println("排序后的数组为");
        System.out.println(Arrays.toString(arr));

    }

    public static void BubbleSort(int [] arr){

        int temp = 0;//临时变量
        boolean flag = false;//标识变量，表示是否进行交换
        for (int i=0;i<arr.length-1;i++){

            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (flag==false){
                //说明在一次排序中一次都没有交换
                break;
            }else{
                flag=false;//重置lfag，进行下次判断
            }
        }
    }
}
