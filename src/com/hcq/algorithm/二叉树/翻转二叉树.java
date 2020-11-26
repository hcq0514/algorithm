package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;

public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        //想一下root节点是干啥的
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
