package com.oycm.algorithm.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/4/1 16:15
 */
public class Solution_3 {

    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    public static List<List<Integer>> method_1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        // 对数组排序 对于 i,j,k,存在nums[i]+nums[j]+nums[k]=0 则nums[i] <=0;nums[j]+nums[k]>=0且nums[j]+nums[k]=-nums[i];
        Arrays.sort(nums);





        return result;
    }
}
