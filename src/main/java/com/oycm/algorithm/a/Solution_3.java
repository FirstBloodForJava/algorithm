package com.oycm.algorithm.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/4/1 16:15
 */
public class Solution_3 {

    public static void main(String[] args) {
        int[] ints = {0, 0, 0, 0, 0};
    }

    /**
     * 15.三数之和：https://leetcode.cn/problems/3sum/description
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        return method_1(nums);
    }

    public static List<List<Integer>> method_1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        // 对数组从小到大排序 对于 i,j,k,存在nums[i]+nums[j]+nums[k]=0 则nums[i] <=0;nums[j]+nums[k]>=0且nums[j]+nums[k]=-nums[i];
        // 如果nums[i] > 0,则不会存在nums[i] + nums[j] + nums[k] = 0;
        // 如果nums[i] < 0,则需要从i之后找到使nums[j] + nums[k] = -nums[i],即nums[i]+nums[j] > 0;
        // 如果nums[i] = 0,则需要从i之后找到使nums[j] + nums[k] = 0;
        // 找j和k的过程,可以使用相向双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int x = nums[i];

            int j = i + 1;
            int k = nums.length - 1;
            // 和前一个数相同
            if (i > 0 && x == nums[i-1]){
                continue;
            }
            // x > 0
            if (nums[i] > 0){
                continue;
            }
            // 优化点一: 排序之后越往后越大
            if (nums[i] + nums[i+1] + nums[i+2] > 0){
                break;
            }
            // 优化点二: 如果nums[i] + nums[nums.length-1] + nums[nums.length-2] < 0,后面j和k怎么遍历都比最大的小
            if (nums[i] + nums[nums.length-1] + nums[nums.length-2] < 0){
                continue;
            }
            while(j < k){
                // 如果前面的j和后一个i+1相同,既排除了重复的三元组情况,也避免再去比较, 这个可以移到满足条件里面
                if (j > i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                // 如果后面的k和前一个k-1相同,既排除了重复的三元组情况,也避免再去比较
                if (k < nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] > -x){
                    k--;
                }else if (nums[j] + nums[k] < -x){
                    j++;
                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                }
            }


        }

        return result;
    }
}
