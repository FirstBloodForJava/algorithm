package com.oycm.algorithm.db;

/**
 * @author ouyangcm
 * create 2024/6/19 15:26
 */
public class Solution_2_2226 {

    /**
     * 2226.每个小孩最多能分到多少糖果: https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
     * 将这些糖果分配给k个小孩,使每个小孩分到相同数量的糖果,每个小孩可以至多拿走一堆糖果,有些糖果可能不被分配
     * @param candies 整数数组,元素表示大小为candies[i]的一堆糖果,可以建糖果分成任意数量的子堆,但无法再将两堆合并到一起  eg: {5,8,6}
     * @param k 小孩数量 eg: 3
     * @return eg: 5
     */
    public int maximumCandies(int[] candies, long k) {
        int ans = 0;
        // 可以维护一个数组ans[i],下标i范围[1,max(candies[i])],数组值表示能分给多少个小孩,数组是非递增的,第一次ans[i]>k的,i-1即答案
        int maxCandy = Integer.MIN_VALUE;
        long sum = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
            sum += candy;
        }
        if (sum < k) {
            return ans;
        }else if (sum == k) {
            return 1;
        }else if (k == 1) {
            return maxCandy;
        }
        int left = 1;
        int right = maxCandy + 1;
        while (left < right) {
            int midCandy = (right - left) / 2 + left;
            long allocatableKids = 0;
            for (int candy : candies) {
                allocatableKids += candy / midCandy;
            }
            if (allocatableKids >= k) {
                ans = midCandy;
                left = midCandy + 1;
            }else {
                right = midCandy;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2_2226 solution = new Solution_2_2226();
        int[] candies = {1,1,1,5};
        long k = 1;
        System.out.println(solution.maximumCandies(candies, k));
    }
}
