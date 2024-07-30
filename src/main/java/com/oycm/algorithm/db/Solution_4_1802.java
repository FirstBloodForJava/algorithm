package com.oycm.algorithm.db;

/**
 * @author ouyangcm
 * create 2024/6/19 16:09
 */
public class Solution_4_1802 {

    /**
     * 1802.有界数组中指定下标处的最大值: https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/
     * 构造一个满足一下条件的数组nums
     *  nums.length = n;
     *  nums[i](0<=i<n)是正整数;
     *  abs(num[i]-nums[i+1]) <= 1(0<=i<n-1)
     *  nums所有元素之和不超过maxSum;
     *  nums[index]的值被最大化
     * @param n 构造的数组长度; eg: 4
     * @param index 数组中的最大值; eg: 2
     * @param maxSum 构造数组的阈值; eg: 6
     * @return eg: 2
     */
    public int maxValue(int n, int index, int maxSum) {
        int ans = 1;
        // _/\_ 数组类似这样的走势时,sums <= maxSum时,nums[index]所对应的值才会是最大
        // min(sums)随着nums[index]的增大而增大
        if (maxSum == n) {
            return ans;
        }
        int left = ans;
        int right = maxSum;
        // 这里使用闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long minSums = calculate(n, index, mid);
            if (minSums > maxSum) {
                right = mid - 1;
            }else {
                ans = mid;
                left = mid + 1;
            }
        }

        return ans;
    }

    // 使用long避免计算精度溢出
    private long calculate(long n, long index, long max) {
        long minSum = 0;

        if (max > index) {
            minSum = (max + max - index) * (index + 1) / 2 ;
        }else {
            minSum += (1 + max) * max / 2  + index - max + 1;
        }
        long right = n - index;
        if (max >= right) {
            minSum += (max + max - right + 1) * right / 2 ;
        }else {
            minSum += (1 + max) * max / 2  + right - max;
        }
        minSum -= max;
        return minSum;
    }

    public static void main(String[] args) {
        Solution_4_1802 solution = new Solution_4_1802();
        System.out.println(solution.maxValue(3, 0, 815094800));
    }
}
