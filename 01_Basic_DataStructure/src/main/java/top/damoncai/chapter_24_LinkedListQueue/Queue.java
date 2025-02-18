package top.damoncai.chapter_24_LinkedListQueue;

/**
 *
 * 自定义队列接口
 *
 * @author zhishun.cai
 * @date 2025/2/10
 */
public interface Queue<E> {

    /**
     * 队列末尾添加元素
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 从队列头部获取元素，并移除元素
     * 队列为空，返回null
     * @return
     */
    E poll();

    /**
     * 从队列头部获取元素，不移除元素
     * 队列为空，返回null
     * @return
     */
    E peek();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队列是否满
     * @return
     */
    default boolean isFull() {
        return true;
    }
}
