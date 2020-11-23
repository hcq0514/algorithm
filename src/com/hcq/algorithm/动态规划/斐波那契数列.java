package com.hcq.algorithm.动态规划;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数列 {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
     * 提示
     * 0 ≤ N ≤ 30
     */

    //第一种暴力解法
    public static int fib1(int N) {
        //base case
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        //变量为N
        return fib1(N - 1) + fib1(N - 2);
    }

    /**
     * 增加备忘录，以空间换时间
     */
    public static int fib2(Map<Integer, Integer> m, int N) {
        //查询是否已经存在
        Integer integer = m.get(N);
        if (integer != null) {
            return integer;
        }
        //base case
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        //变量为N
        int fibN = fib2(m, N - 1) + fib2(m, N - 2);
        m.put(N, fibN);
        return fibN;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();
//        System.out.println(fib1(4));

        System.out.println(fib2(m, 344));

    }
}
