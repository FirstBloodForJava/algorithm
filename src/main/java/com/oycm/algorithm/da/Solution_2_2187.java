package com.oycm.algorithm.da;

import java.util.Arrays;

public class Solution_2_2187 {

    /**
     * 2187.完成旅途的最少时间: https://leetcode.cn/problems/minimum-time-to-complete-trips/description/
     * @param time 数组,time[i]表示第i辆公交车完成一趟旅途所需要花费的时间
     * @param totalTrips 整数表示总共需要完成的旅途数目
     * @return 完成至少totalTrips趟需要花费的最少时间(公交车独立运行,同时进行旅途互不影响)
     */
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 1;
        // 时间time以时间为下标,完成的趟数是一个非递减数组;如何确定时间的范围[1,?]?通过min(time[i])*totalTrips作为最大值
        long min = Integer.MAX_VALUE;
        for (int i : time) {
            min = Math.min(i, min);
        }

        // 搜索范围[1, min*totalTrips],转换成在一个非递减数组中,查找第一次大于等于target的索引
        long left = 1;
        long right = min * totalTrips;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long trips = calculateTrips(time, mid);
            if (trips >= totalTrips) {
                right = mid - 1;
                ans = mid;
            }else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public long calculateTrips(int[] time, long currTime) {
        long ans = 0;
        for (int i : time) {
            ans += currTime / i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2_2187 solution = new Solution_2_2187();
        int[] time = new int[10000];
        Arrays.fill(time, 1);
        int totalTrips = 10000000;

        System.out.println(solution.minimumTime(time, totalTrips));
    }
}
