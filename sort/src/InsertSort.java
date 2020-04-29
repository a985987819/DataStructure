/**
 * @author laoduan
 * @create 2020-04-28-18:09
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};

    }

    public static void insertSort(int[] arr){


        for (int i=1;i<arr.length;i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //1.insertIndex>=0保证在给insertVal找位置时不越界
            //2.insertVal<arr[insertIndex]待插入的书还没有找到插入位置

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                    arr[insertIndex+1]=arr[insertIndex];
                    insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }

    }
}
