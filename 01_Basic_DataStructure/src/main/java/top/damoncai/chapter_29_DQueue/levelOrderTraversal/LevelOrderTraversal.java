package top.damoncai.chapter_29_DQueue.levelOrderTraversal;

import top.damoncai.chapter_24_LinkedListQueue.LinkedListQueue;
import top.damoncai.chapter_29_DQueue.LinkedListDQueue;

/**
 *
 * 树节点层序遍历
 * @author zhishun.cai
 * @date 2025/3/3
 */
public class LevelOrderTraversal {

    /**
     *      1
     *     / \
     *    2   3
     *   /\   /\
     *  4  5 6  7
     *
     * 1 3 2 4 5 6 7
     *
     * 树节点遍历
     * @param root
     */
    public void traversal(TreeNode root) {
        LinkedListDQueue<TreeNode> queue = new LinkedListDQueue<TreeNode>();
        // 添加根节点
        queue.offerFirst(root);
        int c1 = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.pollLast();
                System.out.print(node + " ");
                if(level % 2 == 0) {
                    // 偶数层
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                        c2++;
                    }

                    if (node.left != null) {
                        queue.offerFirst(node.left);
                        c2++;
                    }
                }else {
                    // 奇数层
                    if (node.left != null) {
                        queue.offerLast(node.left);
                        c2++;
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                        c2++;
                    }
                }
            }
            c1 = c2;
            level++;
            System.out.println();
        }
    }
}
