package top.damoncai.chapter_39_BinarySearchTree;

import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhishun.cai
 * @date 2025/4/8
 */
class BinarySearchTreeTest {

    static BinarySearchTree bst;

    static BinarySearchTree bst2;

    static {
        BinarySearchTree.BSTNode<Integer,String> n1 = new BinarySearchTree.BSTNode<>(1, "张三丰");
        BinarySearchTree.BSTNode<Integer,String> n2 = new BinarySearchTree.BSTNode<>(3, "张无忌");
        BinarySearchTree.BSTNode<Integer,String> n3 = new BinarySearchTree.BSTNode<>(2, "武当",n1, null);

        BinarySearchTree.BSTNode<Integer,String> n4 = new BinarySearchTree.BSTNode<>(5, "白眉鹰王");
        BinarySearchTree.BSTNode<Integer,String> n5 = new BinarySearchTree.BSTNode<>(7, "吸血鬼王");
        BinarySearchTree.BSTNode<Integer,String> n6 = new BinarySearchTree.BSTNode<>(6, "魔教",n4, null);

        BinarySearchTree.BSTNode<Integer,String> root = new BinarySearchTree.BSTNode<>(4, "倚天屠龙记",n3, n6);

        bst = new BinarySearchTree(root);
    }

    static {
        BinarySearchTree.BSTNode<Integer,String> n7 = new BinarySearchTree.BSTNode<>(5, "金毛狮王",null, null);

        BinarySearchTree.BSTNode<Integer,String> n1 = new BinarySearchTree.BSTNode<>(1, "张三丰");
        BinarySearchTree.BSTNode<Integer,String> n2 = new BinarySearchTree.BSTNode<>(3, "张无忌");
        BinarySearchTree.BSTNode<Integer,String> n3 = new BinarySearchTree.BSTNode<>(2, "武当",n1, n2);

        BinarySearchTree.BSTNode<Integer,String> n4 = new BinarySearchTree.BSTNode<>(6, "白眉鹰王",n7 , null);
        BinarySearchTree.BSTNode<Integer,String> n5 = new BinarySearchTree.BSTNode<>(8, "吸血鬼王");
        BinarySearchTree.BSTNode<Integer,String> n6 = new BinarySearchTree.BSTNode<>(7, "魔教",n4, n5);

        BinarySearchTree.BSTNode<Integer,String> root = new BinarySearchTree.BSTNode<>(4, "倚天屠龙记",n3, n6);

        bst2 = new BinarySearchTree(root);
    }

    /**
     * 二叉搜索树  - 获取
     */
    @Test
    void get() {


        Assertions.assertEquals("张无忌", bst.get(3));
        Assertions.assertEquals("魔教", bst.get(6));
    }

    /**
     * 取最小值 - 递归方式获
     */
    @Test
    void minRecursion() {

        Assertions.assertEquals("张三丰", bst.minRecursion());
    }

    /**
     * 取最小值 - 非递归方式获
     */
    @Test
    void min() {

        Assertions.assertEquals("张三丰", bst.min());
    }

    /**
     * 取最大值 - 归方式获
     */
    @Test
    void maxRecursion() {
        Assertions.assertEquals("吸血鬼王", bst.maxRecursion());
    }

    /**
     * 取最大值 - 非递归方式获
     */
    @Test
    void max() {
        Assertions.assertEquals("吸血鬼王", bst.max());
    }

    /**
     * 测试添加
     */
    @Test
    void put() {
        bst.put(1, "张无忌2");
        bst.put(7, "吸血鬼王2");

        Assertions.assertEquals("张无忌2", bst.min());
        Assertions.assertEquals("吸血鬼王2", bst.max());

        bst.put(0, "张敏");
        bst.put(8, "玄冥二老");

        Assertions.assertEquals("张敏", bst.min());
        Assertions.assertEquals("玄冥二老", bst.max());
    }

    /**
     * 查找前继节点
     */
    @Test
    void predecessor() {
        Assertions.assertNull(bst2.predecessor(1));
        Assertions.assertEquals("武当", bst2.predecessor(3));
        Assertions.assertEquals("倚天屠龙记", bst2.predecessor(5));
        Assertions.assertEquals("魔教", bst2.predecessor(8));
    }

    /**
     * 查找后继节点
     */
    @Test
    void successor() {
        Assertions.assertNull(bst2.successor(8));
        Assertions.assertEquals("倚天屠龙记", bst2.successor(3));
        Assertions.assertEquals("白眉鹰王", bst2.successor(5));
        Assertions.assertEquals("武当", bst2.successor(1));
    }

    @Test
    void delete() {
        bst.delete(6);
        System.out.println(bst);
    }

    @Test
    void less() {
        List res = bst2.less(6);
        Assertions.assertEquals(res,List.of("张三丰","武当","张无忌","倚天屠龙记","金毛狮王"));
    }

    @Test
    void more() {
        List res = bst2.more(6);
        Assertions.assertEquals(res,List.of("吸血鬼王","魔教"));
    }

    @Test
    void between() {
        List res = bst2.between(5,7);
        Assertions.assertEquals(res,List.of("白眉鹰王"));
    }

    /**
     * 校验二叉搜索树是否合法
     */
    @Test
    void checkBinarySearchTree() {
        boolean iggle = bst2.checkBinarySearchTree();
        Assertions.assertTrue(iggle);
    }

    /**
     * 递归方式判断二叉搜索树是否合法
     */
    @Test
    void checkBinarySearchTreeRecursion() {
        boolean iggle = bst2.checkBinarySearchTreeRecursion();
        Assertions.assertTrue(iggle);
    }

    /**
     * 范围方式判断二叉搜索树是否合法
     */
    @Test
    void checkBinarySearchTreeRange() {
        boolean res = bst2.checkBinarySearchTreeRange();
        Assertions.assertTrue(res);
    }

    @Test
    void between2() {
        List res = bst2.between2(5,7);
        Assertions.assertEquals(res,List.of("白眉鹰王"));
    }

    @Test
    void doBuildBinarySearchTreeInsert() {
        Integer data[] = {8,4,2,6,12};
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        BinarySearchTree.BSTNode<Integer, Integer> node = tree.buildBinarySearchTreeInsert(data);

        boolean check = new BinarySearchTree(node).checkBinarySearchTree();
        Assertions.assertTrue(check);
    }
}