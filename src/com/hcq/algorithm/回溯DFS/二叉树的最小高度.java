package com.hcq.algorithm.回溯DFS;

import com.hcq.algorithm.DTO.TreeNode;

public class 二叉树的最小高度 {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * 回溯算法解题思路
     * <p>
     * if(到底){
     * res = list.add(select)
     * }
     * for(选择:所有可选项){
     * 做选择
     * backTrace()
     * removeSelect
     * }
     */

    public static Integer minDepth(TreeNode node) {
        final int depth = 0;
        int minDep = Integer.MAX_VALUE;
        return backTrace(node, depth, minDep);
    }

    public static Integer backTrace(TreeNode currentNode, Integer depth, int minDep) {
        //如果已经到底了，则返回
        if (currentNode.left == null && currentNode.right == null) {
            minDep = Math.min(minDep, depth);
            return minDep;
        }
        if (currentNode.left != null) {
            depth = depth + 1;
            backTrace(currentNode.left, depth, minDep);
            depth = depth - 1;
        }
        if (currentNode.right != null) {
            depth = depth + 1;
            backTrace(currentNode.right, depth, minDep);
            depth = depth - 1;
        }
        return minDep;
    }

    public static void main(String[] args) {

    }
}
