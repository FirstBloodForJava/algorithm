package com.oycm.algorithm.d;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_7_2389 {

    /**
     * 2389.和有限的最长子序列: https://leetcode.cn/problems/longest-subsequence-with-limited-sum/description/
     * 子序列: 是一个数组删除(不删除)某些元素,不改变顺序得到的一个数组
     * @param nums 数组,长度n
     * @param queries 数组,长度m
     * @return 数组长度为m,其中answer[i]表示nums的子序列之和小于等于queries[i]的最大长度
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] ans = new int[queries.length];

        // 子序列表示的是删除或不删除,不具备连续性,对nums进行排序后: 假设原来的子序列下标是3,8,排序之后变成了1,2等价于把其他元素都删除了
        Arrays.sort(nums);

        // 数组升序之后,要想子序列最长,数组中的元素应该要最小,所以等价于在排序之后nums前缀和中找小于等于queries[i]的索引
        int[] sums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < sums[1]) {
                ans[i] = 0;
            }else if (queries[i] >= sums[n]) {
                ans[i] = n;
            }else {
                ans[i] = binarySearch(sums, queries[i]) - 1;
            }
        }

        return ans;
    }

    // 二分查找第一个大于target的值,不存在返回0
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        Solution_7_2389 solution = new Solution_7_2389();
        int[] nums = {4,5,2,2};
        int[] queries = {1};

        System.out.println(Arrays.stream(solution.answerQueries(nums, queries)).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }
}
