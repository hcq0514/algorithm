package com.hcq.algorithm.动态规划;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     */

    /**
     * //dp 给定一个金额，输出需要几次
     */
    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> m = new HashMap<>();
        return dp(coins, amount, m);
    }

    public static int dp(int[] coins, int amount, Map<Integer, Integer> map) {
        Integer mapCount = map.get(amount);
        if (mapCount != null) {
            return mapCount;
        }
        int response;
        //定义为最大值，防止下面min比的时候给他赋值
        int minCount = Integer.MAX_VALUE;
        //1.base case
        if (amount == 0) {
            return 0;
        }
        //如果减到最后已经小于0了，则代表没有匹配的值，就是小于0了
        if (amount < 0) {
            return -1;
        }
        //确认状态，变量：amount，coins是题目给定的
        //选择 coins的变量
        for (int coin : coins) {
            response = dp(coins, amount - coin, map);
            map.put(amount - coin, response);
            if (response == -1) {
                continue;
            }
            minCount = Math.min(minCount, 1 + response);
        }
        //如果都查不到，则返回-1 例如[2] 3
        if (minCount == Integer.MAX_VALUE) {
            minCount = -1;
        }
        return minCount;
    }

    /**
     * 从底向上的思想就是把那个备忘录先初始化出来
     */
    public static int coinChange2(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int a = 0; a < amount; a++) {
            for (int coin : coins) {
                if (a - coin < 0) continue;
                memo[a] = Integer.min(memo[a], 1 + memo[a - coin]);
                System.out.println("memo[" + a + "] =" + memo[a]);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        System.out.println(coinChange2(coins, 3333));


    }
}
