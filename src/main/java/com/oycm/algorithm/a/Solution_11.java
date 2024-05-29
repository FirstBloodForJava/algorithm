package com.oycm.algorithm.a;

import java.util.Collections;
import java.util.List;

public class Solution_11 {

    /**
     * 2824.统计和小于目标的下标对数目：https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/description/
     * @param nums
     * @param target
     * @return 0 <= i < j < n,nums[i] + nums[j] < target的对数
     */
    public int countPairs(List<Integer> nums, int target) {

        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) ans++;
            }
        }

        return ans;
    }

    public int method_2(List<Integer> nums, int target) {

        // 由于a + b == b + a,所以可以对数组进行排序
        // 从left=0,right=size-1
        // 如果left + right < target,则以left开始,到right的都是小于target的,计算完left++
        // 如果left + right >= target,则任意和right组合都会>=target,right--
        // 循环退出条件left == right
        int ans = 0;
        int left = 0;
        int right = nums.size() - 1;
        Collections.sort(nums);
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                ans += right - left;
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
