package top.damoncai.chapter_22_LinkedListAdjustRing;

/**
 * 1、链表判断是否为环
 * 2、找出环入口节点
 * @author zhishun.cai
 * @date 2025/2/7
 */
public class LinkedListAdjustRing<T> {

    /**
     * 判断链表是否为环
     *
     * 思路：
     * 1、定义两个指针，龟每次走一个，兔每次走两个
     * 2、如果存在环的话兔会追上乌龟（在环中）
     * @param node
     * @return
     */
    public boolean checkIsRing(Node<T> node) {
        // 乌
        Node<T> p1 = node;
        // 兔
        Node<T> p2 = node;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找环的入口
     * @param node
     * @return
     */
    public Node<T> findRingPort(Node<T> node) {

        Node<T> point = null;
        // 第一次龟兔相同点
        // 乌
        Node<T> p1 = node;
        // 兔
        Node<T> p2 = node;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                point = p1;
                break;
            }
        }

//        // 找出入口
        p1 = node;
        p2 = point;
        // 这里需要先判断再往后位移，因为收尾相连的环，并且龟兔恰好在起点相遇，所以需要先判断
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
