package com.oycm.algorithm.cd;

public class Solution_5_2302 {

    /**
     * 子数组得分: 子数组的和*子数组的长度
     * 2302.统计得分小于K的子数组数目: https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/description/
     * @param nums 正整数数组
     * @param k 目标k值
     * @return 子数组得分小于k的数组数目
     */
    public long countSubarrays(int[] nums, long k) {

        // [left,right]子数组得分小于k,则[left,right], [left+1,right]...[right,right]肯定是小于k,子数组个数为right-left+1
        int n = nums.length;
        long ans = 0;
        // sums[i]表示nums数组下标i之前所有元素和(不包括i),例如: sums[2] = nums[0] + nums[1],
        // [left,right]之间的和为: sums[right+1]-sums[left],[1,2] = sums[3] - sums[1]
        long[] sums = new long[n+1];
        for (int i = 1; i <= n ; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        int left = 0;
        long temp = 0;
        for (int right = 0; right < n; right++) {
            temp = (sums[right+1] - sums[left]) * (right - left + 1);
            while (temp >= k) {
                if (left == right) {
                    left++;
                    break;
                }
                left++;
                temp = (sums[right+1] - sums[left]) * (right - left + 1);
            }
            ans += right - left + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_5_2302 solution = new Solution_5_2302();
        int[] nums = {1, 1, 1};
        int k = 5;
        System.out.println(solution.countSubarrays(nums, k));
    }
}
