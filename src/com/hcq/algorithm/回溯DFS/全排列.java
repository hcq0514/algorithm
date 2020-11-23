package com.hcq.algorithm.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

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

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        backTrace(res, selected, nums);
        return res;
    }

    public static void backTrace(List<List<Integer>> res, List<Integer> selected, int[] nums) {
        //如果已经到底了，则返回
        if (selected.size() == nums.length) {
            //这边得用new一个数组，如果不new一个数组的话他其实添加的是指针，到最后会全部变为0
            res.add(new ArrayList<>(selected));
//            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果已经选完的就不再选
            if (selected.contains(nums[i])) {
                continue;
            }
            //做选择
            selected.add(nums[i]);
            backTrace(res, selected, nums);
            selected.remove((Integer) nums[i]);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);

    }
}
