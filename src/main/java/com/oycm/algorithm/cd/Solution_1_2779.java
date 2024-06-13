package com.oycm.algorithm.cd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1_2779 {

    /**
     * 完全子数组: 子数组中不同元素的数目等于整个数组不同元素的数目
     * 2799. 统计完全子数组的数目：https://leetcode.cn/problems/count-complete-subarrays-in-an-array/
     * @param nums 正整数数组
     * @return
     */
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        int n = nums.length;
        // cache记录nums中不同元素的情况
        Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }
        if (cache.size() == nums.length) return 1;
        // [minLeft, minRight]之间是一个完全子数组,则固定一边延长一边的次数就是子数组的个数

        Map<Integer, Integer> rMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            if (rMap.containsKey(nums[right])) {
                rMap.put(nums[right], rMap.get(nums[right]) + 1);
            }else {
                rMap.put(nums[right], 1);
            }

            // [left, right]是一个完全子数组,right到n-1的子数组都符合要求
            // 这里为什么不需要考虑[0,left]的子数组情况因为left是从0开始的
            while (rMap.size() == cache.size()) {
                ans += n- right;
                // 这个时候左指针右移
                if (rMap.get(nums[left]) == 1) {
                    rMap.remove(nums[left]);
                }else {
                    rMap.put(nums[left], rMap.get(nums[left]) - 1);
                }
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_1_2779 solution = new Solution_1_2779();
        int[] nums = {459,459,962,1579,1435,756,1872,1597};
        System.out.println(solution.countCompleteSubarrays(nums));
    }
}
