package com.oycm.algorithm.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_8 {

    /**
     * 暴力的解法时间复杂度是 n^2
     * 1010.总持续时间可被60整除的歌曲：https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
     * @param time 歌曲时间的数组
     * @return 满足(nums[i] + nums[j]) % 60 == 0, i < j, 返回结果的对数
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, List<Integer>> catchMap = new HashMap<>();
        // 构建缓存: 取余的结果为0-59,value 为对应的索引，递增
        for (int i = 0; i < time.length; i++) {
            int temp = time[i] % 60;
            if (catchMap.containsKey(temp)) {
                catchMap.get(temp).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                catchMap.put(temp, list);
            }
        }
        for (int i = 0; i < time.length; i++) {
            int temp = time[i] % 60;
            List<Integer> tempList = null;
            if (temp == 0) {
                tempList = catchMap.get(0);
            }else {
                tempList = catchMap.get(60-temp);
            }
            if (tempList != null) {
                // 在tempList中查找第一个大于i的索引下标
                ans += tempList.size() - binarySearch(tempList, i);
            }
        }

        return ans;
    }

    /**
     *
     * @param list
     * @param target
     * @return 第一个大于target的索引，都小于target返回list.size()
     */
    public int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (right + left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_8 solution = new Solution_8();
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(solution.numPairsDivisibleBy60(time));
    }
}
