package top.damoncai.chapter_06_recursionBinarySearch;

/**
 * 递归二分查找
 * @author zhishun.cai
 * @date 2024/11/14
 */
public class RecursionBinarySearch<T extends Comparable<T>>{

    /**
     * 二分查找
     * @param arr 需要查找的数组
     * @param start 起始位置
     * @param end 截止文位置
     */
    public int binarySearch(T[] arr, T target,  int start, int end) {
        if (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if(arr[mid].compareTo(target) == 0) {
                return mid;
            }
            else if(arr[mid].compareTo(target) < 0) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
            return binarySearch(arr, target, start, end);
        }
        return -1;
    }
}
