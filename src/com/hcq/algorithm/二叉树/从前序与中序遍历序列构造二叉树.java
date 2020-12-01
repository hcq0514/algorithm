package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    /**
     *
     * 其实是根据根节点来考虑怎么去遍历左右子树，
     * @param preorder 前序遍历数组
     * @param preStartIndex 前序遍历起点
     * @param preEndIndex 前序遍历终点
     * @param inorder  中序遍历数组
     * @param inStartIndex 中序遍历起点
     * @param inEndIndex 中序遍历终点
     * @return
     */
    private TreeNode buildTreeHelper(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex) {
        // preorder 为空，直接返回 null
        if (preStartIndex > preEndIndex) {
            return null;
        }
        //跟节点也就是前序遍历的第一个值
        int rootVal = preorder[preStartIndex];
        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到根节点的位置
        int inRootIndex = 0;
        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (rootVal == inorder[i]) {
                inRootIndex = i;
                break;
            }
        }
        //左子树的长度
        int leftNum = inRootIndex - inStartIndex;
        //递归的构造左子树
        //左子树的起点为index=rootIndex+1 终点为leftNum
        root.left = buildTreeHelper(preorder, preStartIndex + 1, preStartIndex + leftNum, inorder, inStartIndex, inRootIndex-1);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, preStartIndex + leftNum + 1, preEndIndex, inorder, inRootIndex + 1, inEndIndex);
        return root;
    }
}
