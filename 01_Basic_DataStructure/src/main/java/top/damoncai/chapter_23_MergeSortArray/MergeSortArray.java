package top.damoncai.chapter_23_MergeSortArray;

/**
 *
 * 合并有序数组
 * 数组1：[1,3,5,6]
 * 数组2：[2,3,4,7]
 * 合并后：[1,2,3,3,4,5,6,7]
 *
 * @author zhishun.cai
 * @date 2025/2/8
 */
public class MergeSortArray {


    /**
     * 常规合并
     * @param a1 数组1
     * @param a2 数组2
     * @return
     */
    public int[] commonMerge(int[] a1, int[] a2) {
        // 健壮性校验
        if(a1 == null || a1.length == 0 ) {
            return a2;
        }
        if(a2 == null || a2.length == 0 ) {
            return a1;
        }

        int[] merged = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;

        while(i < a1.length && j < a2.length ) {
            if(a1[i] < a2[j]) {
                merged[k++] = a1[i++];
            }else {
                merged[k++] = a2[j++];
            }
        }

        if(i >= a1.length) {
            // a1数组遍历结束
            System.arraycopy(a2, j, merged, k, a2.length - j );
        }

        if(j >= a2.length) {
            // a2数组遍历结束
            System.arraycopy(a1, i, merged, k, a1.length - i);
        }

        return merged;
    }


    /**
     * 递归排序
     * @param a1
     * @param a2
     * @return
     */
    public int[] recursionMerge(int[] a1, int[] a2) {
        // 健壮性校验
        if(a1 == null || a1.length == 0 ) {
            return a2;
        }
        if(a2 == null || a2.length == 0 ) {
            return a1;
        }

        int[] merged = new int[a1.length + a2.length];

        doRecursionMerge(a1, 0, a2, 0, merged, 0);

        return merged;
    }

    private void doRecursionMerge(int[] a1, int i, int[] a2, int j, int[] merged, int k) {

        if(i >= a1.length) {
            // a1数组遍历结束
            System.arraycopy(a2, j, merged, k, a2.length - j );
            return;
        }

        if(j >= a2.length) {
            // a2数组遍历结束
            System.arraycopy(a1, i, merged, k, a1.length - i);
            return;
        }


        if(a1[i] < a2[j]) {
            merged[k++] = a1[i++];
        }else {
            merged[k++] = a2[j++];
        }

        doRecursionMerge(a1, i, a2, j, merged, k);
    }
}
