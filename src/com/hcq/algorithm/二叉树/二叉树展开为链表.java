package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;

public class 二叉树展开为链表 {
    /**
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //根据转为链表，从最下面开始转，所以用后续遍历
        if (root.left != null) {
            //找到root.left的最右边节点
            pre = root.left;
            while (pre.right != null) {
                //无限取右节点，当right为空时就是最右的了
                pre = pre.right;
            }
            //把root.right节点接到root.left的最右边节点下
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

}
