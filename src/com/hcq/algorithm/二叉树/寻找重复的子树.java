package com.hcq.algorithm.二叉树;

import com.hcq.algorithm.DTO.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树（根节点，左右节点都一样），你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class 寻找重复的子树 {


    //记录所有子树的出现次数
    private HashMap<String, Integer> alreadyExistSubTree = new HashMap<>();
    //记录重复的子树根节点
    private LinkedList<TreeNode> res = new LinkedList<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtreesHelp(root);
        return res;
    }

    private String findDuplicateSubtreesHelp(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = findDuplicateSubtreesHelp(root.left);
        String right = findDuplicateSubtreesHelp(root.right);
        //root节点应该干啥，
        // 对于同一类的重复子树（根节点，左右节点都一样）
        String subTree = left + "-" + right + "-" + root.val;
        //首先判断数据里面有没有
        Integer s = alreadyExistSubTree.getOrDefault(subTree, 0);
        //为避免重复，只添加一次
        if (s == 1) {
            res.add(root);
        }
        alreadyExistSubTree.put(subTree, s + 1);
        return subTree;
    }
}
