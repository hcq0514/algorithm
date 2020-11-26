package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int lo, int hi, int[] nums) {
        if (lo > hi) {
            return null;
        }
        //获取root，最大的值
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        //遍历root左边
        root.left = construct(lo, maxIndex - 1, nums);
        //遍历root右边
        root.right = construct(maxIndex + 1, hi, nums);
        return root;
    }

    public static void main(String[] args) {
        最大二叉树 z = new 最大二叉树();
        TreeNode treeNode = z.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);
    }
}
