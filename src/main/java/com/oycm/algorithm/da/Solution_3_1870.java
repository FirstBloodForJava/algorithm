package com.oycm.algorithm.da;

/**
 * @author ouyangcm
 * create 2024/6/19 15:02
 */
public class Solution_3_1870 {

    /**
     * 1870.准时到达的列车最小时速: https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/
     * 每趟列车只能整点发车,需要在两趟列车之间等待一段时间,如果无法准时到达,则返回-1
     * @param dist 整数数组,dist[i]表示第i趟列车行驶距离 eg: {1,3,2}
     * @param hour 浮点数,表示到达办公室可用的总通勤时间; eg: 6
     * @return eg: 1
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        // 时间不够列车的趟数
        if (hour <= dist.length-1) return -1;

        int right = 10000000;

        // 随着速度增加，所需要的时间是非递增的,在dist距离数组,以这个速度[1, maxSpeed]范围,耗时递减的数组中寻找第一次大于hour时，speed+1
        // [1, maxSpeed]对于hour访问[maxHour,n]

        int ans = 1;
        /*while (left <= right) {
            int mid = left + (right - left) / 2;
            if (calculateHourByDist(dist, mid) > hour) {
                left = mid + 1;
            }else {
                ans = mid;
                right = mid - 1;
            }
        }*/

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateHourByDist(dist, mid) > hour) {
                left = mid + 1;
            }else {
                if (mid == 2) {
                    System.out.println();
                }
                right = mid;
            }
        }

        return left == 0 ? ans : right;
    }

    public double calculateHourByDist(int[] dist, int speed) {
        double ans = 0;

        for (int i = 0; i < dist.length; i++) {
            if (i < dist.length-1) {
                ans += Math.ceil((double) dist[i] / speed);
            }else {
                ans += (double) dist[i] / speed;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] dist = {1,3,2};
        double hour = 6;
        Solution_3_1870 solution = new Solution_3_1870();
        System.out.println(solution.minSpeedOnTime(dist, hour));
    }
}
