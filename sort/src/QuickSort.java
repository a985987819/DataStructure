import java.util.Arrays;

/**
 * @author laoduan
 * @create 2020-05-08-20:29
 */
public class QuickSort {
    public static void main(String[] args) {


        int [] arr = {-9,78,0,23,-567,70};

        quickSort(arr,0,arr.length-1);
        System.out.println("arr = "+ Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp = 0;//临时变量，交换时使用

        while (l<r){
            //在privot的左边找，找到一个大于等于pivot的值才退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在privot的右边找，找到一个小于等于pivot的值才退出
            while (arr[r]>pivot){
                r-=1;
            }

            //如果l>=r，说明pivot的左右两边的值已经按照左边全部小于等于pivot
            //右边大于pivot
            if (l>=r){
                break;
            }

            temp = arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            //如果叫唤完发现arr[l] == pivot,则--，前移
            if(arr[l]== pivot){
                r-=1;
            }
            if(arr[r]== pivot){
                l+=1;
            }
        }

        //如果l==r,必须让l++,r--,否则栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }

    }
}
