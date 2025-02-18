package top.damoncai.chapter_26_LinkedListStack;

/**
 * @author zhishun.cai
 * @date 2025/2/14
 */
public interface Stack<E> {

    /**
     * 栈顶添加数据
     * @param e
     * @return
     */
    boolean push(E e);

    /**
     * 返回栈顶元素
     * 从栈顶弹出元素，栈为空返回null
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素
     * 栈顶不弹出元素，栈为空返回null
     * @return
     */
    E peek();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否满了
     * @return
     */
    boolean isFull();
}
