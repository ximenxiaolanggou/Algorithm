package top.damoncai.case_01_binarysearch;

import org.junit.Test;

/**
 *
 * 二分查找
 * @author zhishun.cai
 * @date 2024/9/19
 */
public class Case_01_BinarySearchBasic {

    /**
     * 二分查找
     */
    @Test
    public void mian() {
        int arr[] = {1,2,3,4,5,6,7};
        int target = 7;
        int targetIndex = binarySearch(arr,target);
        System.out.println(targetIndex);
    }

    public int binarySearch(int arr[], int target) {
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
                return M;
            }
        }
        return -1;
    }
}
