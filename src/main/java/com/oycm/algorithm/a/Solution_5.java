package com.oycm.algorithm.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_5 {

    /**
     * 18.四数之和：https://leetcode.cn/problems/4sum/description/
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    public List<List<Integer>> method_1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans;
        Arrays.sort(nums);
        // nums[a] + nums[b] + nums[c] + nums[d] = target => nums[b] + nums[c] = target - nums[a] - nums[d]
        // 怎么排除哪种组合值一样的结果?
        for (int a = 0; a < n - 3; a++) {
            // 最小值大于target
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
            // 排除重复答案
            if (a > 0) {
                if (nums[a] == nums[a-1]) {
                    continue;
                }
            }
            int d = n-1;
            while (d > a + 2) {
                // 最大值下雨target
                if ((long)nums[d] + nums[d-1] + nums[d-2] + nums[d-3] < target) break;

                int b = a + 1;
                int c = d - 1;
                // 固定a和d，在(a,d)范围内找nums[b] + nums[c] = target - nums[a] - nums[d]
                while (b < c) {
                    if (nums[b] + nums[c] < target - nums[a] - nums[d]){
                        b++;
                    } else if (nums[b] + nums[c] > target - nums[a] - nums[d]) {
                        c--;
                    } else {
                        // 记录答案,排除重复组合
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        ans.add(list);
                        b++;
                        c--;
                        // 保证不重复记录答案
                        while (b < c) {
                            if (nums[b] == nums[b+1]){
                                b++;
                            } else if (nums[c] == nums[c-1]) {
                                c--;
                            } else {
                                break;
                            }
                        }
                    }
                }
                d--;
                // 保证不重复记录答案(a,d)中右答案，nums[d-1] == nums[d],那么(a, d-1)中符合要求的答案，肯定也在其中
                while (d > a + 2) {
                    if (nums[d] == nums[d+1]) {
                        d--;
                    }else {
                        break;
                    }
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        int target = 1000000000;
        System.out.println(solution.method_1(nums, target));
    }
}
