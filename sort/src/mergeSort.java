import java.util.Arrays;

/**
 * @author laoduan
 * @create 2020-05-08-22:27
 */
public class mergeSort {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int [arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("归并排序后"+ Arrays.toString(arr));
    }



    //分+合
    public static void mergeSort(int [] arr ,int left,int right,int [] temp){

        if(left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *合并
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void merge(int arr[],int left,int mid,int right,int[] temp){
        int i =left;
        int j = mid+1;
        int t = 0;//指向temp数组的当前索引

        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i<=mid && j<=right){
            //如果左边有序序列的当前元素小于等于右边有序序列的当前元素
            //将左边当前元素拷贝到temp
            //t后移i后移
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t +=1;
                i +=1;
            }else {
                temp[t] =arr[j];
                t +=1;
                j +=1;
            }
        }


        while (i<=mid){
            temp[t] = arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t] = arr[j];
            t+=1;
            j+=1;
        }


        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft= "+tempLeft+" ,right= "+right);
        while (tempLeft<=right)
        {
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }


    }
}
