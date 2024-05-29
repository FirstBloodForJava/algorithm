package com.oycm.algorithm.a;

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


}
