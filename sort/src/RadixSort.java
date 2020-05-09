import java.util.Arrays;

/**
 * @author laoduan
 * @create 2020-05-09-22:20
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        radixSort(arr);
    }


    public static void radixSort(int[] arr){

        //得到数组中最大的数的位数
        int max = arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength = (max+"").length();
        //二维数组包含10个一位数组
        //为了防止在放入数的时候数据溢出，则每个一位数组大小定为arr.length
        //基数排序是使用空间换时间的经典算法
        int [][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数组，定义一个一位数组来记录每个桶每次放入的数据个数

        int [] bucketElementCounts = new int [10];

        for (int i = 0, n = 1;i<maxLength;i++,n*=10){
            for (int j=0 ; j<arr.length ;j++){
                //取出每个元素个位的值
                int digitOfElement = arr[j]/n%10;
                //放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一位数组的下标一次取出数据，放入原来数组）
            int index = 0;
            for (int k = 0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，则放入原数组
                if(bucketElementCounts[k]!=0){
                    for (int l = 0;l<bucketElementCounts[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                /**
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                 */
                //第l轮处理后，需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k]= 0;
            }

            System.out.println("第"+i+"轮排序后的结果是"+ Arrays.toString(arr));
        }


    }

}
