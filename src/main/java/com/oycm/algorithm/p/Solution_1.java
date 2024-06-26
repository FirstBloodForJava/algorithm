package com.oycm.algorithm.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {

    /**
     * 46.全排列
     * https://leetcode.cn/problems/permutations/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    List<List<Integer>> ans_1 = new ArrayList<>();
    List<Integer> path;
    int[] nums;
    boolean chose[];

    private List<List<Integer>> method_1(int[] nums) {
        chose = new boolean[nums.length];
        // 构建指定长度的path
        path = Arrays.asList(new Integer[nums.length]);
        this.nums = nums;
        dfs(0);
        return ans_1;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans_1.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!chose[j]) {
                path.set(i, nums[j]);
                chose[j] = true;
                dfs(i+1);
                chose[j] = false;
            }
        }
    }

    private List<List<Integer>> method_2(int[] nums) {
        path = Arrays.asList(new Integer[nums.length]);
        this.nums = nums;
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        dfs_2(0, s);
        return ans_1;
    }

    private void dfs_2(int i, List<Integer> s) {
        if (i == nums.length) {
            ans_1.add(new ArrayList<>(path));
            return;
        }
        for (Integer x : s) {
            path.set(i, x);
            List<Integer> temp = new ArrayList<>(s);
            temp.remove(x);
            dfs_2(i+1, temp);
        }
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.method_2(new int[]{1, 2, 3}));
    }
}
