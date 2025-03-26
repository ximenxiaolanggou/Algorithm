package top.damoncai.chapter_32_MinHeap;

/**
 * 小顶堆
 * @author zhishun.cai
 * @date 2025/3/24
 */
public class MinHeap {

  private int[] arr;

  private int size;

  public MinHeap(int[] arr) {
    this.arr = arr;
    this.size = arr.length;
    this.heapfiy();
  }

  public MinHeap(int len) {
    this.arr = new int[len];
  }

  public MinHeap(int[] arr, int len) {
    if(len < arr.length) {
      throw new IllegalArgumentException("len长度要大一等于数组长度");
    }
    this.arr = new int[len];
    this.size =  arr.length;
    System.arraycopy(arr, 0, this.arr, 0, arr.length);
    this.heapfiy();
  }


  /**
   * 获取堆顶元素
   *
   * @return 堆顶元素
   */
  public int peek() {
    return arr[0];
  }

  /**
   * 删除堆顶元素
   *
   * @return 堆顶元素
   */
  public int poll() {
    int data = arr[0];
    arr[0] = arr[size - 1];
    size--;
    down(0);
    return data;
  }

  /**
   * 删除指定索引处元素
   *
   * @param index 索引
   * @return 被删除元素
   */
  public int poll(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    int data = arr[index];
    arr[index] = arr[size - 1];
    size--;
    down(index);
    return data;
  }

  /**
   * 替换堆顶元素
   *
   * @param replaced 新元素
   */
  public void replace(int replaced) {
    if(size == 0) {
      throw new IndexOutOfBoundsException("Heap is empty");
    }
    arr[0] = replaced;
    down(0);
  }

  /**
   * 堆的尾部添加元素
   *
   * @param offered 新元素
   * @return 是否添加成功
   */
  public boolean offer(int offered) {
    if(size == arr.length) {
      return false;
    }
    arr[size++] = offered;
    up(size - 1);
    return true;
  }

  /**
   * 构成大顶堆
   */
  public void heapfiy() {
    // 找到最后面一个非叶子节点
    int partentIndex = size >> 1 - 1;
    for (int i = partentIndex; i >= 0; i--) {
      down(i);
    }
  }

  /**
   * 下沉
   * @param partentIndex
   */
  private void down(int partentIndex) {
    int minIndex = partentIndex;
    int left = 2 * partentIndex + 1;
    int right = left + 1;

    if(left < size && arr[left] < arr[minIndex]) {
      minIndex = left;
    }
    if(right < size && arr[right] < arr[minIndex]) {
      minIndex = right;
    }

    if(minIndex != partentIndex) {
      swap(partentIndex, minIndex);
      down(minIndex);
    }
  }

  /**
   * 上浮
   * @param childIndex
   */
  public void up(int childIndex) {
    int parentIndex;
    while((parentIndex = childIndex / 2) >= 0) {
      if(arr[parentIndex] > arr[childIndex]) {
        swap(parentIndex, childIndex);
        childIndex = parentIndex;
      }else {
        break;
      }
    }
  }

  /**
   * 交换数组上的位置
   * @param partentIndex
   * @param maxIndex
   */
  public void swap(int partentIndex, int maxIndex) {
    int temp = arr[maxIndex];
    arr[maxIndex] = arr[partentIndex];
    arr[partentIndex] = temp;
  }

  /**
   * 打印
   */
  public void print() {
    if(size > 0) {
      String str = "";
      for (int i = 0; i < size; i++) {
        str += arr[i] + " ";
      }
      System.out.println(str);
    }
  }

  public int getSize() {
    return size;
  }
}
