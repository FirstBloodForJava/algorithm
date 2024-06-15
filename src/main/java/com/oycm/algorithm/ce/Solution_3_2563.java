package com.oycm.algorithm.ce;

import java.util.Arrays;

public class Solution_3_2563 {

    /**
     * 2563.统计公平数对的数目: https://leetcode.cn/problems/count-the-number-of-fair-pairs/
     * 公平数对: (i, j), 0 <= i < j < n,且 lower <= nums[i] + nums[j] <= upper
     * 这里只看两端: 考虑是否可以排序之后再处理
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;

        if (nums.length == 1) return ans;

        // 根据题意,(i,j)是不相同的下标,且 lower <= nums[i] + nums[j] <= upper,就算排序打乱了原数组的顺序,统计次数,也是不影响结果的

        // 1.数组排序
        Arrays.sort(nums);

        int n = nums.length;
        // 最小值大于upper,最大值小于lower的情况没有答案
        if (nums[0] + nums[1] > upper || nums[n-1] + nums[n-2]< lower) return ans;

        // 套双层循环解决吗? 时间复杂度n^2 超出时间限制 找最小值和最大值用二分法n*logn
        for (int i = 0; i < n-1; i++) {
            // 寻找lower - nums[i] >= nums[minRight]第一个索引 (i,n)边界
            int minRight = binarySearchMin(nums, i, lower - nums[i], false);
            if (minRight == n) continue;
            // 寻找upper - nums[i] <= nums[maxRight]最后一个索引,等价于update - nums[i] > nums[maxRight]第一个索引
            int maxRight = binarySearchMin(nums, i, upper - nums[i], true);
            ans += maxRight - minRight;
        }

        // 能否用相向双指针来实现? left=0, right = n - 1; nums[left] + nums[right]符合条件,不能保证中间部分符合条件
        // 快慢指针? slow fast

        return ans;
    }
    public int binarySearchMin(int[] nums, int left, int target, boolean isEquals) {
        int right = nums.length;
        while (left+1 < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target || (isEquals && nums[mid] == target)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_3_2563 solution = new Solution_3_2563();
        int[] nums = {1,7,9,2,5};
        int lower = 11;
        int upper = 11;
        System.out.println(solution.countFairPairs(nums, lower, upper));
    }
}
