package com.oycm.algorithm.n;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans.size());
        System.out.println(ans);
    }

    /**
     * 78.子集
     * https://leetcode.cn/problems/subsets/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.temp = new ArrayList<>();
        dfs(0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 对于子集，就是对于nums的任意元素i，只有选与不选这两种情况
     * @param nums
     * @return
     */
    private List<List<Integer>> method_1(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int i, List<Integer> temp) {
        if (i == nums.length) {
            // 答案
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 不选
        dfs(nums, i+1, temp);
        // 选
        temp.add(nums[i]);
        dfs(nums, i+1, temp);
        // 回溯恢复，把选了的移除，恢复现场
        temp.remove(temp.size()-1);
    }

    int[] nums;
    List<Integer> temp;
    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 不选
        dfs(i+1);
        // 选
        temp.add(nums[i]);
        dfs(i+1);
        temp.remove(temp.size()-1);
    }
}
