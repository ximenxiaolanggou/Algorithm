package top.damoncai.chapter_17_LinkedListRemoveSameEleNoReserve;

import top.damoncai.chapter_16_LinkedListRemoveSameEleReserve.Node;

/**
 * 有序链表删除重复节点，并不保留重复节点
 *
 * @author zhishun.cai
 * @date 2025/1/9
 */
public class LinkedListRemoveSameEleNoReserve<T> {

    public Node<T> remove(Node<T> head) {
        Node<T> node = new Node(-1, head);
        node = removeDuplicates(node);
        return node.next;
    }

    public Node<T> removeDuplicates(Node<T> head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }

        Node<T> preNode = head;
        Node<T> leftNode = head.next;
        Node<T> rightNode = head.next.next;

        while(rightNode != null) {
            if(leftNode.data == rightNode.data) {
                rightNode = rightNode.next;
            }else {
                if(leftNode.next == rightNode) {
                    // 左右节点没有间隔
                    preNode = leftNode;
                    leftNode = leftNode.next;
                }else {
                    // 左右节点有间隔
                    preNode.next = rightNode;
                    leftNode = rightNode;
                }
                rightNode = leftNode.next;
            }
        }

        // 最后几位是重复的
        if(leftNode.next != null) {
            preNode.next = null;
        }

        return head;
    }


    public Node<T> remove2(Node<T> head) {
        Node<T> node = new Node(-1, head);
        node = removeDuplicates2(node);
        return node.next;
    }

    public Node<T> removeDuplicates2(Node<T> head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }

        Node<T> p1 = head;
        Node<T> p2, p3;

        while((p2 = p1.next) != null && (p3 = p2.next) != null) {
           if(p2.data == p3.data) {
               // 存在相同数据节点
               while(p3 != null && p2.data == p3.data) {
                   p3 = p3.next;
               }
               p1.next = p3;
           }else {
               // 不存在相同的数据节点
               p1 = p1.next;
           }
        }
        return head;
    }


    /**
     * 递归方式
     * @param head
     * @return
     */
    public Node<T> removeDuplicatesReursion(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 创建哨兵节点
        Node<T> node = new Node(-1, head);

        doRemoveDuplicatesReursion(node);

        return node.next;
    }

    public void doRemoveDuplicatesReursion(Node<T> p1) {
        if(p1 == null || p1.next == null) {
            return;
        }
        Node<T> p2 = p1.next;
        Node<T> p3 = p2.next;
        if(p2.data == p3.data) {
            while(p3 != null && p2.data == p3.data) {
                p3 = p3.next;
            }
            p1.next = p3;
        }else {
            p1 = p1.next;
        }
        doRemoveDuplicatesReursion(p1);
    }
}
