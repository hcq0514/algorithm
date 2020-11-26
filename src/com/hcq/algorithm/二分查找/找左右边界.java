package com.hcq.algorithm.二分查找;

import java.util.Arrays;

/**
 * 定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class 找左右边界 {

    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeftRange(nums, target);
        int right = searchRightRange(nums, target);
        int[] a = {left, right};
        return a;
    }


    public static int searchLeftRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //终止条件是left == right+1
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                //如果这边不减1的话，会导致当left等于right时无法跳出循环，
                // 我们主要是用left来返回，所以这边的right其实不用精确到是那个target
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        //当target不存在的时候,left有可能会一直加到length的长度
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
//        return left;
        return left;
    }

    public static int searchRightRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
//        nums = [5,7,7,8,8,10], target = 8
        int[] a = {5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(a, 8);
        System.out.println(Arrays.toString(ints));


    }
}
