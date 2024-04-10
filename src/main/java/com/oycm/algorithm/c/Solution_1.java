package com.oycm.algorithm.c;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        return method_1(target, nums);
    }

    public int method_1(int target, int[] nums){
        int result = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    result = Math.min(result, j-i+1);
                    break;
                }
            }
            if (i == 0 && target > sum){
                break;
            }
            sum = 0;
        }

        return result > nums.length ? 0 : result;
    }
}
