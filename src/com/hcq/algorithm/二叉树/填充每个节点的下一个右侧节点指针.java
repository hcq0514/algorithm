package com.hcq.algorithm.二叉树;

public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        //base case
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};