package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;


/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }


    /**
     *
     * 其实是根据根节点来考虑怎么去遍历左右子树，
     * @param postorder 后序遍历数组
     * @param postStartIndex 后序遍历起点
     * @param postEndIndex 后序遍历终点
     * @param inorder  中序遍历数组
     * @param inStartIndex 中序遍历起点
     * @param inEndIndex 中序遍历终点
     * @return
     */
    private TreeNode buildTreeHelper(int[] inorder, int inStartIndex, int inEndIndex,
                                     int[] postorder, int postStartIndex, int postEndIndex) {
        if (inStartIndex > inEndIndex) {
            return null;
        }
        int root = postorder[postEndIndex];
        int rootIndex = -1;
        //从中序开始遍历
        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(root);
        int leftNo = rootIndex - inStartIndex;
        treeNode.left = buildTreeHelper(inorder, inStartIndex, rootIndex - 1, postorder, postStartIndex, postStartIndex + leftNo-1);
        //这边减一是减去root的根节点
        treeNode.right = buildTreeHelper(inorder, rootIndex + 1, inEndIndex, postorder, postStartIndex + leftNo, postEndIndex-1);
        return treeNode;
    }
}
