package top.damoncai.chapter_08_recursionDoubleSort;

/**
 * 递归实现冒泡排序
 * @author zhishun.cai
 * @date 2024/12/24
 */
public class RecursionDoubleSort {


    public void sort(Integer[] arr, int end) {
        if(end == 0) {
            return;
        }
        for(int i = 0; i < end; i++) {
            if(arr[i] > arr[i+1]) {
                swap(arr, i, i + 1);
            }
        }
        sort(arr, end - 1);
    }

    /**
     * 改进版本
     * 记录最后一次冒泡位置，因为最后一次冒泡后面的数据肯定是有序的。
     * 这个值相当于一个分解线：大于这个值位置的数据肯定是有序的，小于等于这个位置的数据可能是无需的
     * 所以在下次递归的时候将这个值作为截止位置
     * @param arr
     * @param end
     */
    public void sort_V2(Integer[] arr, int end) {
        if(end == 0) {
            return;
        }
        int latestSwapPosition = 0;
        for(int i = 0; i < end; i++) {
            if(arr[i] > arr[i+1]) {
                swap(arr, i, i + 1);
                latestSwapPosition = i;
            }
        }
        sort(arr, latestSwapPosition);
    }



    public void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
