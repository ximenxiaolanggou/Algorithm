package top.damoncai.chapter_01_binarysearch;

import org.junit.Test;

/**
 *
 * LeftMost
 *    返回 >= target的最靠左索引
 *
 * RightMost
 *    返回<=target的最靠右索引
 *
 * @author zhishun.cai
 * @date 2024/10/10
 */
public class Case_04_BinarySearch_LeftRightMost_Return {



    @Test
    public void mian() {
        int arr[] = {1,1,3,3,4,5,6,7};
        int target = 2;
        int targetIndex = binarySearchLeftMost(arr,target);
        System.out.println(targetIndex);
        targetIndex = binarySearchRightMost(arr,target);
        System.out.println(targetIndex);

    }


    /**
     *
     * 返回 >= target的最靠左索引
     */
    public int binarySearchLeftMost(int arr[], int target) {
        int candidate = -1;
        int L = 0, R = arr.length - 1;
        while (L <= R) {
            // 这里需要注意 L + R 的值可能超过int最大值，所以不能采用（L + R） / 2
            // 正确为(L + R) >>> 1 或者 L + (R - L) / 2
            int M = (L + R) >>> 1;
            if (target <= arr[M] ) {
                R = M - 1;
            }else  {
                L = M + 1;
            }
        }
        return L;
    }


    /**
     *
     * 返回<=target的最靠右索引
     */
    public int binarySearchRightMost(int arr[], int target) {
        int L = 0, R = arr.length - 1;
        while (L <= R) {
            // 这里需要注意 L + R 的值可能超过int最大值，所以不能采用（L + R） / 2
            // 正确为(L + R) >>> 1 或者 L + (R - L) / 2
            int M = (L + R) >>> 1;
            if (target < arr[M] ) {
                R = M - 1;
            }else{
                L = M + 1;
            }
        }
        return L - 1;
    }
}
