package com.oycm.algorithm.t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {


    /**
     * 300.最长递增子序列(LIS)
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return 1;
    }

    private int method_1(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dfs(int[] nums, int i) {
        int res = 0;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(nums, j));
            }
        }
        return res + 1;
    }

    // 动态规划的时间复杂度 === 状态个数 ×\times× 单个状态的计算时间
    private int method_2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, dfs(nums, i, dp));
        }
        return ans;

    }
    private int dfs(int[] nums, int i, int[] dp) {
        if (dp[i] > 0) return dp[i];

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dfs(nums, j, dp));
            }
        }

        return ++dp[i];
    }

    // 选/不选
    private int method_1_1(int[] nums) {

        return dfs(nums, nums.length-1, nums.length);
    }
    private int dfs(int[] nums, int i, int pre) {
        if (i < 0) return 0;

        if (pre == nums.length || nums[i] < nums[pre]) {
            return Math.max(dfs(nums, i-1, i) + 1, dfs(nums, i-1, pre));
        }
        return dfs(nums, i-1, pre);

    }

    // 记忆化搜索
    // 动态规划的时间复杂度 === 状态个数 ×\times× 单个状态的计算时间
    private int method_2_1(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = dfs(nums, nums.length-1, nums.length, dp);
        return ans;
    }

    private int dfs(int[] nums, int i, int pre, int[][] dp) {
        if (i < 0) return 0;
        if (dp[i][pre] != -1) return dp[i][pre];
        if (pre == nums.length || nums[i] < nums[pre]) {
            dp[i][pre] = Math.max(dfs(nums, i-1, i, dp) + 1, dfs(nums, i-1, pre, dp));
        }else {
            dp[i][pre] = dfs(nums, i-1, pre, dp);
        }
        return dp[i][pre];
    }


    public static int method() {
        int[] i = {1};
        ++i[0];
        // return 3
        return i[0]+1;
    }

    // dp 动态规划
    public int method_3(int[] nums) {
        int n = nums.length;
        // dp[i] 表示i结尾的LIS
        // 如果nums[i+1] < nums[i] i+1的LIS肯定是 dp[i+1] <= dp[i]
        // 如果nums[i+1] > nums[i] dp[i+1]的nums[i+1] 和 前面的nums[0]比到nums[i] j表示
        // nums[i+1] > nums[j] 则dp[i] = max(dp[j], dp[i])继承前面最大的LIS，最后再自增1
        // 当dp[i] = 0,意味这这个nums[i] <= num[j] (0<=j<i)，i的结尾的子序列只能是自己
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            ans = Math.max(ans, ++dp[i]);
        }
        return ans;
    }

    // 贪心
    public int method_4(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 在g中查找第一个>=nums[i]的下标,不存在返回g.size()
            int index = searchFirstGreaterThanTarget(g, nums[i]);
            if (index == g.size()){
                g.add(nums[i]);
            }else {
                g.set(index, nums[i]);
            }
        }
        return g.size();
    }

    public int lowerBound(List<Integer> list, int target) {
        int left = -1;
        int right = list.size();
        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * 保证中间要有一个元素(left,right]右边是可取的，表示左开右闭
     * @param list
     * @param target
     * @return list中>=target的索引，不存在则return list.size()
     */
    public int searchFirstGreaterThanTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {4,5,1,2,10,4,3,8,9};
        System.out.println(solution.method_1(nums));
        System.out.println(solution.method_2(nums));
        System.out.println(solution.method_1_1(nums));
        System.out.println(solution.method_2_1(nums));
        System.out.println(solution.method_4(nums));

    }
}
