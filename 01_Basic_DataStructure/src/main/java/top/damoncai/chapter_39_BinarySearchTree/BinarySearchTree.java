package top.damoncai.chapter_39_BinarySearchTree;

import lombok.ToString;
import top.damoncai.chapter_26_LinkedListStack.LinkedListStack;
import top.damoncai.chapter_31_MaxHeap.MaxHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树
 * @author zhishun.cai
 * @date 2025/4/8
 */
@ToString
public class BinarySearchTree<K extends Comparable<K>, V> {

    private BSTNode<K, V> root;

    public BinarySearchTree(BSTNode<K, V> root) {
        this.root = root;
    }

    public BinarySearchTree() {

    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public V get(K key) {
        return doGet(root, key);
    }

    private V doGet(BSTNode<K, V> node, K key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return doGet(node.left, key);
        }else if (compare > 0) {
            return doGet(node.right, key);
        }else {
            return node.value;
        }
    }

    /**
     * 获取最小值 - 递归的方式
     * @return
     */
    public V minRecursion() {
        if(root == null) return null;
        return doMinRecursion(root);
    }

    public V doMinRecursion(BSTNode<K, V> node) {

        if(node.left != null) {
            return doMinRecursion(node.left);
        }else {
            return node.value;
        }
    }

    /**
     * 获取最小值 - 非递归的方式
     * @return
     */
    public V min() {
        return doMin(root);
    }

    public V doMin(BSTNode<K, V> root) {
        if(root == null) return null;
        BSTNode<K, V> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }


    /**
     * 获取最大值 - 递归的方式
     * @return
     */
    public V maxRecursion() {
        if(root == null) return null;
        return doMaxRecursion(root);
    }

    public V doMaxRecursion(BSTNode<K, V> node) {
        if(node.right != null) {
            return doMaxRecursion(node.right);
        }else {
            return node.value;
        }
    }

    /**
     * 添加
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if(root == null) {
            root = new BSTNode(key, value);
            return;
        }
        BSTNode<K, V> node = root;
        BSTNode<K, V> parent = null;
         while(node != null) {
             parent = node;
             int compare = key.compareTo(node.key);
             if (compare < 0) {
                 node = node.left;
             }else if (compare > 0) {
                 node = node.right;
             }else {
                 // 相同key
                 node.value = value;
                 return;
             }
         }
         if(key.compareTo(parent.key) < 0) {
             parent.left = new BSTNode(key, value);
         }else {
             parent.right = new BSTNode(key, value);
         }
    }

    /**
     * 获取最da值 - 非递归的方式
     * @return
     */
    public V max() {
       return doMax(root);
    }

    public V doMax(BSTNode<K, V> root) {
        if(root == null) return null;
        BSTNode<K, V> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    /**
     * 根据key获取前继节点
     * @param key
     * @return
     */
    public V predecessor(K key) {
        if(root == null) {
            return null;
        }
        BSTNode<K, V> node = root;
        BSTNode<K, V> predecessorNode = null;
        while(node != null) {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                node = node.left;
            }else if (compare > 0) {
                predecessorNode = node;
                node = node.right;
            }else {
                // 根据key获取到节点
                // 判断是否有左孩子
                if(node.left != null) {
                    // 找到左树最大值
                    return doMax(node.left);
                }else {
                    // 找到第一个右子节点过来的数
                    return predecessorNode == null ? null : predecessorNode.value;
                }
            }
        }
        // 没有匹配的key
        return null;
    }

    /**
     * 根据key获取后继节点
     * @param key
     * @return
     */
    public V successor(K key) {
        if(root == null) {
            return null;
        }
        BSTNode<K, V> node = root;
        BSTNode<K, V> predecessorNode = null;
        while(node != null) {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                predecessorNode = node;
                node = node.left;
            }else if (compare > 0) {
                node = node.right;
            }else {
                // 根据key获取到节点
                // 判断是否有左孩子
                if(node.right != null) {
                    // 找到左树最大值
                    return doMin(node.right);
                }else {
                    // 找到第一个右子节点过来的数
                    return predecessorNode == null ? null : predecessorNode.value;
                }
            }
        }
        // 没有匹配的key
        return null;
    }

    /**
     * 删除节点
     * @param key
     */
    public void delete(K key) {
        BSTNode<K, V> curNode = root;
        BSTNode<K, V> parentNode = null;
        // 查找节点
        while(curNode != null) {
            int res = key.compareTo(curNode.key);
            if (res < 0) {
                // 向左查找
                parentNode =  curNode;
                curNode =  curNode.left;
            }else if (res > 0) {
                // 向右边
                parentNode =  curNode;
                curNode =  curNode.right;
            } else {
                // 相等
                break;
            }
        }

        if(curNode == null) {
            // 未找到删除的节点
            return;
        }

        if(curNode.right == null) {
            shift(parentNode, curNode, curNode.left);

        }else if(curNode.left == null) {
            shift(parentNode, curNode, curNode.right);
        }else {
            // 1、查找删除节点的后继节点
            BSTNode<K, V> sNode = curNode.right;
            BSTNode<K, V> sParent = curNode;
            while(sNode.left != null) {
                sParent = sNode;
                sNode =  sNode.left;
            }
            // 2、判断是否相邻
            if(sParent != curNode) {
                // 不相邻 - 处理后继节点的子节点
                shift(sParent, sNode, sNode.right);
                sNode.right = curNode.right;
            }

            // 3、后继节点取替删除节点
            shift(parentNode, curNode, sNode);
            sNode.left = curNode.left;

        }
    }

    /**
     * 托孤方法
     *
     * @param parentNode  被删除节点的父亲
     * @param deleteNode 被删除节点
     * @param childNode   被顶上去的节点
     */
    // 只考虑让 n1父亲的左或右孩子指向 n2, n1自己的左或右孩子并未在方法内改变
    void shift( BSTNode<K, V> parentNode,  BSTNode<K, V> deleteNode,  BSTNode<K, V> childNode) {
        if(parentNode == null) {
            root = childNode;
        }else if(parentNode.left == deleteNode) {
            parentNode.left = childNode;
        }else{
            parentNode.right = childNode;
        }
    };

    /**
     * 获取小于某个值的节点
     *
     * 中序便利默认是顺序输出 - 可以利用这一特点进行过滤
     * @param key
     * @return
     */
    public List<V> less(K key) {
        List<V> list = new ArrayList<>();
        LinkedListStack<BSTNode<K, V>> stack = new LinkedListStack<>(20);
        BSTNode<K, V> p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                BSTNode<K, V> pop = stack.pop();
                if(pop.key.compareTo(key) < 0) {
                    list.add(pop.value);
                }else {break;}
                p = pop.right;
            }
        }
        return list;
    }

    /**
     * 获取大于某个值的节点
     * @param key
     * @return
     */
    public List<V> more(K key) {
        List<V> list = new ArrayList<>();
        LinkedListStack<BSTNode<K, V>> stack = new LinkedListStack<>(20);
        BSTNode<K, V> p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.right;
            }else {
                BSTNode<K, V> pop = stack.pop();
                if(pop.key.compareTo(key) < 0) {
                    list.add(pop.value);
                }else {break;}
                p = pop.left;
            }
        }
        return list;
    }

    /**
     * 获取大于某个值的节点
     * @param low 下限值
     * @param up 上限值
     * @return
     */
    public List<V> between(K low, K up) {
        List<V> list = new ArrayList<>();
        LinkedListStack<BSTNode<K, V>> stack = new LinkedListStack<>(20);
        BSTNode<K, V> p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                BSTNode<K, V> pop = stack.pop();
                if(low.compareTo(pop.key) < 0 && pop.key.compareTo(up) < 0) {
                    list.add(pop.value);
                }
                p = pop.right;
            }
        }
        return list;
    }

    /**
     * 上面between效率不是很高，因为涉及到各个节点，我们可以当不满足的时候进行跳过处理(减枝)
     * @param low
     * @param up
     * @return
     */
    public List<V> between2(K low, K up) {
        List<V> list = new ArrayList<>();
        LinkedListStack<BSTNode<K, V>> stack = new LinkedListStack<>(20);
        BSTNode<K, V> p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                BSTNode<K, V> pop = stack.pop();
                if(low.compareTo(pop.key) < 0 && pop.key.compareTo(up) < 0) {
                    list.add(pop.value);
                }
                p = pop.right;
            }
        }
        return list;
    }

    public void doBetween2( BSTNode<K, V> p,K low, K up, List<V> collertor) {
        if(p == null) {
            return;
        }

        int lowRes = low.compareTo(p.key);
        int upRes = p.key.compareTo(up);
        if(lowRes >= 0) {
            // 左枝不需要考虑
            doBetween2(p.right, low, up, collertor);
        }

        if(upRes >= 0) {
            // 右枝不需要考虑
            doBetween2(p.left, low, up, collertor);
        }

        // 值符合要求
        collertor.add(p.value);
        doBetween2(p.left, low, up, collertor);
        doBetween2(p.right, low, up, collertor);
    }



    /**
     * 校验二叉搜索树是否合法 - 中序遍历
     * @return
     */
    public boolean checkBinarySearchTree() {
        K pre = null;
        BSTNode<K, V> p = root;
        LinkedListStack<BSTNode<K, V>> stack = new LinkedListStack<>(20);
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else {
                BSTNode<K, V> pop = stack.pop();
                if(pre != null && pop.key.compareTo(pre) <= 0) {
                    return false;
                }
                pre = pop.key;
                p = pop.right;
            }
        }
        return true;
    }

    /**
     * 递归方式判断二叉搜索树是否合法
     * @return
     */
    public boolean checkBinarySearchTreeRecursion() {
       return doCheckBinarySearchTreeRecursion(root);
    }

    // Tip：这里使用的是全局变量，如果递归使用参数需要注意，值传递和引用传递问题
    K pre = null;
    public boolean doCheckBinarySearchTreeRecursion(BSTNode<K, V> node) {
        if(node == null) {
            return true;
        }
        boolean res = doCheckBinarySearchTreeRecursion(node.left);
        if(!res) {
            return false;
        }
        if(pre != null && node.key.compareTo(pre) <= 0) {
            return false;
        }
        pre = node.key;

        return doCheckBinarySearchTreeRecursion(node.right);
    }

    /**
     * 校验搜索二叉树是否合法 - 范围方式
     * @return
     */
    public boolean checkBinarySearchTreeRange() {
        K min =  null;
        K max = null;
        return doCheckBinarySearchTreeRange(min, max, root);
    }

    public boolean doCheckBinarySearchTreeRange(K min, K max,BSTNode<K, V> node) {
        if(node == null) {
            return true;
        }
        if(min != null && min.compareTo(node.key) >= 0) {
            return false;
        }
        if(max != null && max.compareTo(node.key) <= 0) {
            return false;
        }
        boolean left = doCheckBinarySearchTreeRange(min, node.key, node.left);
        boolean right = doCheckBinarySearchTreeRange(node.key,max , node.right);

        return left && right;
    }

    /**
     * 根据前序遍历的结果，可以唯一地构造出一个二叉搜索树
     * 一次插入方法构建
     * @param data
     * @return
     */
    public BSTNode<K, V> buildBinarySearchTreeInsert(K data[]) {
        if(data == null || data.length == 0) {
            return null;
        }
        BSTNode<K, V> root = new BSTNode(data[0], data[0]);

        for (int i = 1; i < data.length; i++) {
           ;
            doBuildBinarySearchTreeInsert(root, data[i]);
        }

        return root;
    }

    public BSTNode<K, V> doBuildBinarySearchTreeInsert(BSTNode<K, V> root,K data) {
        if(root == null) {
            // 便利到最后 - 创建节点
            return new BSTNode(data,data);
        }
        int left =  data.compareTo(root.key);

        if(left < 0) {
            root.left = doBuildBinarySearchTreeInsert(root.left, data);
        }
        if(left > 0) {
            root.right = doBuildBinarySearchTreeInsert(root.right, data);
        }

        return root;
    }


    /**
     * 根据前序遍历的结果，可以唯一地构造出一个二叉搜索树
     * 范围法
     * @param data
     * @return
     */
    public BSTNode<K, V> buildBinarySearchTreeRange(K data[]) {
       return doBuildBinarySearchTreeRange(data, null);
    }

    int i = 0;
    public BSTNode<K, V> doBuildBinarySearchTreeRange(K data[], K Max) {

        if(i >= data.length) {
            return null;
        }

        K val = data[i];

        if(Max !=null && Max.compareTo(val) > 0) {
            return null;
        }

        BSTNode<K, V> node = new BSTNode(val,val);
        i++;
        node.left = doBuildBinarySearchTreeRange(data,val);
        node.right = doBuildBinarySearchTreeRange(data,Max);
        return node;
    }


    @ToString
    static class BSTNode<K, V> {
        K key; // 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        V value;
        BSTNode<K, V> left;
        BSTNode<K, V> right;


        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
