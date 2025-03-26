package top.damoncai.chapter_29_DQueue;

/**
 * 双端队列
 * @author zhishun.cai
 * @date 2025/2/25
 */
public interface Deque<E> {

    /**
     * 头部添加
     * @param e
     * @return
     */
    boolean offerFirst(E e);

    /**
     * 尾部天添加
     * @param e
     * @return
     */
    boolean offerLast(E e);

    /**
     * 头部获取
     * @param
     * @return e
     */
    E pollFirst();

    /**
     * 尾部获取
     * @param
     * @return e
     */
    E pollLast();

    /**
     * 头部弹出
     * @param
     * @return e
     */
    E peekFirst();

    /**
     * 尾部弹出
     * @param
     * @return e
     */
    E peekLast();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否为满
     * @return
     */
    boolean isFull();
}
