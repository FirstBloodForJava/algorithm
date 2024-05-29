package com.oycm.algorithm.a;

import java.util.HashMap;
import java.util.Map;

public class Solution_9 {

    /**
     * 1512.好数对的数目：https://leetcode.cn/problems/number-of-good-pairs/description/
     * @param nums
     * @return nums[i] == nums[j],且i<j,所有的对数
     */
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) ans += map.get(num);
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        Solution_9 solution = new Solution_9();
        System.out.println(solution.numIdenticalPairs(nums));
    }
}
