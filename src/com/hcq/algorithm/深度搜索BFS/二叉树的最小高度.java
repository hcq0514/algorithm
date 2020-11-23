package com.hcq.algorithm.深度搜索BFS;

import com.hcq.algorithm.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小高度 {

    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明：叶子节点是指没有子节点的节点。
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     */



    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //把root节点添加进来
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                //判断是否达到目标
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                //循环遍历他周边的节点，加入到queue，接下来遍历她们
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}


