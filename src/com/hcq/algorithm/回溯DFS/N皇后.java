package com.hcq.algorithm.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {

    /**
     * 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 输入：4
     * 输出：[
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上
     * 解释: 4 皇后问题存在两个不同的解法。
     * <p>
     */

    public static List<List<String>> solveNQueens(int n) {
        //创建一个棋盘
        char[][] ints = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        backTrace(res, ints, 0);
        return res;
    }

    public static void backTrace(List<List<String>> res, char[][] ints, int row) {
        //如果已经到底了，则返回
        if (row == ints.length) {
            //这边得用new一个数组，如果不new一个数组的话他其实添加的是指针
            res.add(construct(ints));
            return;
        }
        //取出他那个列有多少条数据
        int n = ints[row].length;
        //遍历行上的每个值，去找可能的选项
        for (int j = 0; j < n; j++) {
            if (!isValid(ints, row, j)) {
                continue;
            }
            ints[row][j] = 'Q';
            //一行只会有一个皇后，直接下一层穷举
            backTrace(res, ints, row + 1);
            ints[row][j] = '.';
        }
    }

    private static List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            String s = new String(chess[i]);
            path.add(s);
        }
        return path;
    }

    public static boolean isValid(char[][] ints, int row, int col) {
        int n = ints.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (ints[i][col] == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (ints[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (ints[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);

    }
}
