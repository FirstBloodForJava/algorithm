package com.oycm.algorithm.cb;

public class Solution_2 {

    /**
     * 1493.删掉一个元素以后全为1的最长子数组：https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
     * @param nums 数组元素只能是0或1
     * @return 在nums中删掉一个元素，返回最长只包含1的非空连续子数组的长度
     */
    public int longestSubarray(int[] nums) {
        // 思路: 将数组分为三个部分left mid right
        // 当nums[i]==0时,mid==0,left++;mid==1,right++;
        // 当nums[i]==0时,mid=1,数组被分为了三部分,如果后续出现nums[i]==1则right++;如果nums[i]==0,则left=right,right=0
        // 计算答案，最终答案-1
        int ans = 0;
        int left = 0;
        int mid = 0;
        int right = 0;
        for (int num : nums) {
            if (num == 1) {
                if (mid == 1) {
                    right++;
                }else {
                    left++;
                }
            }else {
                if (mid == 1) {
                    left = right;
                    right = 0;
                }else {
                    mid++;
                }
            }
            ans = Math.max(ans, left + right + mid);
        }

        return ans-1;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {1,1,0,1};
        System.out.println(solution.longestSubarray(nums));
    }
}
