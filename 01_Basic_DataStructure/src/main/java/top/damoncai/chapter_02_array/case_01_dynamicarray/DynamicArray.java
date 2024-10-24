package top.damoncai.chapter_02_array.case_01_dynamicarray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 动态数组方法实现
 * @author zhishun.cai
 * @date 2024/10/23
 */
public class DynamicArray<T> implements Iterable<T> {

    /**
     * 元素个数
     */
    private int size = 0;

    /**
     * 容器容量
     */
    private int capacity = 8;

    /**
     * 数据容器 - 数组
     */
    private Object[] arr = {};

    /**
     * 添加元素
     * @param data
     */
    private void addLast(T data) {
        add(size, data);
    }

    /**
     * 索引添加
     * @param index
     * @param data
     */
    private void add(int index, T data) {
        // TODO 校验是否需要扩容
        if(arr.length == 0) {
            arr = new Object[capacity];
        }
        if(index < 0 || index > size) {
            String msg = """
                    Index: %s, Size: %s"
                    """.formatted(index, size);
            throw new IndexOutOfBoundsException(msg);
        }
        if(index != size) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        size++;
        arr[index] = data;
    }

    /**
     * 删除
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T data = (T) arr[index];
        if(index != size - 1) {
            System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        }
        size--;
        return data;
    }

    /**
     * 查询元
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return (T)arr[index];
    }

    /**
     * 遍历
     */
    public void foreach(Consumer<T> consumer) {
        for(int i = 0; i < size; i++) {
            consumer.accept((T)arr[i]);
        }
    }

    public void checkIndex(int index) {
        if(index < 0 || index >= size) {
            String msg = """
                    Index: %s, Size: %s"
                    """.formatted(index, size);
            throw new IndexOutOfBoundsException(msg);
        }
    }

    /**
     * iterator
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T)arr[index++];
            }
        };
    }

    /**
     * stream
     * @return
     */
    public Stream<T> stream() {
        return Stream.of((T[]) Arrays.copyOfRange(arr, 0, size));
    }
}
