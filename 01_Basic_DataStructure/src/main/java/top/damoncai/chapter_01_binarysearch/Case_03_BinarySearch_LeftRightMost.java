package top.damoncai.chapter_01_binarysearch;


/**
 *
 * 二分查找：最左 | 右查找
 *
 * 当数组中如果存在重复元素，那么我们希望提供两个方法
 *  - 一个是返回查找元素第一次出现的索引位置
 *  - 二个事返回查找元素最后一次出现的索引位置
 *
 * @author zhishun.cai
 * @date 2024/10/10
 */
public class Case_03_BinarySearch_LeftRightMost {






    /**
     *
     * 返回查找元素第一次出现的索引位置
     */
    public int binarySearchLeftMost(int arr[], int target) {
        int candidate = -1;
        int L = 0, R = arr.length - 1;
        while (L <= R) {
            // 这里需要注意 L + R 的值可能超过int最大值，所以不能采用（L + R） / 2
            // 正确为(L + R) >>> 1 或者 L + (R - L) / 2
            int M = (L + R) >>> 1;
            if (target < arr[M] ) {
                R = M - 1;
            }else if(arr[M] < target) {
                L = M + 1;
            }else {
                candidate = M;
                R = M - 1;
            }
        }
        return candidate;
    }


    /**
     *
     * 回查找元素最后一次出现的索引位置
     */
    public int binarySearchRightMost(int arr[], int target) {
        int candidate = -1;
        int L = 0, R = arr.length - 1;
        while (L <= R) {
            // 这里需要注意 L + R 的值可能超过int最大值，所以不能采用（L + R） / 2
            // 正确为(L + R) >>> 1 或者 L + (R - L) / 2
            int M = (L + R) >>> 1;
            if (target < arr[M] ) {
                R = M - 1;
            }else if(arr[M] < target) {
                L = M + 1;
            }else {
                candidate = M;
                L = M + 1;
            }
        }
        return candidate;
    }
}
