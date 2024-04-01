package com.oycm.algorithm.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/4/1 14:50
 */
public class Solution_1 {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        return method_1(nums, target);
    }

    public static int[] method_1(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // 假设其中有nums[i]=x;nums[j]=y;x+y=target
            // nums[i]当前会和前面的map中的value比较
            // 当num[j]的j>i时,会和前面的num[i],通过这样简化了target-x的查找时间,增加了hash表的开销
            if (tempMap.containsKey(target - nums[i])){
                return new int[]{i, tempMap.get(target-nums[i])};
            }

            tempMap.put(nums[i], i);

        }

        return result;
    }




}
