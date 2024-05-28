package com.oycm.algorithm.a;

import java.util.HashMap;
import java.util.Map;

public class Solution_6 {

    /**
     * 219.存在重复元素 II：https://leetcode.cn/problems/contains-duplicate-ii/description/
     * 给定一个数组nums, 存在nums[i] == nums[j],且abs(i-j) <= k则return true, 否则return false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /*if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                } else {
                    // 因为是小于等于k，越往后，不跟新i，距离回越来越大
                    map.put(nums[i], i);
                }
            }else {
                map.put(nums[i], i);
            }*/
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_6 solution = new Solution_6();
        int[] nums = {1, 0, 1, 1};
        System.out.println(solution.containsNearbyDuplicate(nums, 1));
    }
}
