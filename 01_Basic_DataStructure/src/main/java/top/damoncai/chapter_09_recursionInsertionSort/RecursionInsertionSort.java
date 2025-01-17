package top.damoncai.chapter_09_recursionInsertionSort;

/**
 *
 * 递归插入排序
 * @author zhishun.cai
 * @date 2024/12/26
 */
public class RecursionInsertionSort {

  public void sort(int[] arr, int targetIndex) {
    if(targetIndex == arr.length) {
      return;
    }

    // 需要插入的值
    int inserVal = arr[targetIndex];
    // 已经有序的右边界位置
    int insertIndex = targetIndex - 1;

    // while循环是为了找出需要插入的位置
    while(insertIndex >= 0 && arr[insertIndex] > inserVal) {
      arr[insertIndex + 1] = arr[insertIndex];
      insertIndex--;
    }

    // 如果需要插入的insertIndex位置为0号索引，这里的insertIndex会变成 -1
    arr[insertIndex + 1] = inserVal;

    sort(arr, ++ targetIndex);
  }

}
