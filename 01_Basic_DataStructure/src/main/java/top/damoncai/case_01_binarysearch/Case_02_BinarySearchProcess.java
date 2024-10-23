package top.damoncai.case_01_binarysearch;

import org.junit.Test;

/**
 *
 * 二分查找
 * @author zhishun.cai
 * @date 2024/9/19
 */
public class Case_02_BinarySearchProcess {

    @Test
    public void mian() {
        int arr[] = {1,2,3,4,5,6,7};
        int target = 7;
        int targetIndex = binarySearch(arr,target);
        System.out.println(targetIndex);
    }


    /**
     * 二分查找 改进版本，思路一样主要就是边界问题
     * 让右边界不参与比较类似于左闭右开的状态[)
     */
    public int binarySearch(int arr[], int target) {
        int L = 0, R = arr.length; // 刚开始让右指针指向数组 + 1的位置
        while (L <= R) {
            // 这里需要注意 L + R 的值可能超过int最大值，所以不能采用（L + R） / 2
            // 正确为(L + R) >>> 1 或者 L + (R - L) / 2
            int M = (L + R) >>> 1;
            if (target < arr[M] ) {
                R = M; // 循环判断如果中间索引值（m）不是，那么M这个边界就是用不上的，所以直接指过来
            }else if(arr[M] < target) {
                L = M + 1;
            }else {
                return M;
            }
        }
        return -1;
    }
}
