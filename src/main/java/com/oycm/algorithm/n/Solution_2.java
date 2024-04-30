package com.oycm.algorithm.n;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = solution.method_2(nums);
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
        dfs(0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    List<Integer> temp = new ArrayList<>();
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

    /**
     * {1, 2, 3} 对于1 可以组合1,2 1,3, 1,2,3；1固定使用，后面的2, 3可以作为前面的dfs来进行选/不选
     * @param nums
     * @return
     */
    private List<List<Integer>> method_2(int[] nums) {
        this.nums = nums;
        ans.add(new ArrayList<>(temp));

        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(i+1);
            temp.clear();
        }

        return ans;
    }

    private List<List<Integer>> method_2_1(int[] nums) {
        this.nums = nums;
        dfs_2(0);
        return ans;
    }

    private void dfs_2(int i) {
        ans.add(new ArrayList<>(temp));
        if (i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            dfs_2(j+1);
            // 恢复
            temp.remove(temp.size()-1);
        }
    }


    /**
     * 对于nums长度的子集，可以用二进制的0/1来表示子集是否被选用。例如{1, 2}
     * 00 {}，01 {2}，10{1}，11{1,2} 刚好2^2中0/1的关系表四了子集的清空
     * 缺点，内存占用高于前面两种算法
     * @param nums
     * @return
     */
    public List<List<Integer>> method_3(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < (1<<n); i++) {
            path.clear();
            // 遍历找出是i对应二进制值是1的下标
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) {
                    path.add(nums[j]);
                }
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }

}
