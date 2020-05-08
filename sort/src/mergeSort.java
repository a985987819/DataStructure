/**
 * @author laoduan
 * @create 2020-05-08-22:27
 */
public class mergeSort {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
    }


    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void merge(int arr[],int left,int mid,int right,int[] temp){
        int i =left;
        int j = mid+1;
        int t = 0;

        //先把左右两边（有序）的数据按照规则填充到temp数组
        //知道左右两边的有序序列，又一遍处理完毕为止
        while (i<mid&&j<=right){
            if(arr[i]<=arr[j]){
                //如果左边有序序列的当前元素小于等于右边有序序列的当前元素
                //将左边当前元素拷贝到temp
                //t后移i后移
                temp[t]=arr[i];
                t +=1;
                i +=1;
            }
        }
    }
}
