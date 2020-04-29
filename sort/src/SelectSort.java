import java.util.Arrays;

/**
 * @author laoduan
 * @create 2020-04-28-16:53
 */
public class SelectSort {
    public static void main(String[] args) {


        int [] arr ={101,34,119,1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){

        for (int i=0;i<arr.length-1;i++) {
            int minIndex = 0;
            int min =arr[i];

            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
