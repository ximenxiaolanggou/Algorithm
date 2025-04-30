package top.damoncai.chapter_39_BinarySearchTree;

/**
 * 二叉搜索树
 * @author zhishun.cai
 * @date 2025/4/8
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    private BSTNode<K, V> root;

    public BinarySearchTree(BSTNode<K, V> root) {
        this.root = root;
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
