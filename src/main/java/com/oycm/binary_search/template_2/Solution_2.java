package com.oycm.binary_search.template_2;

import java.util.Stack;

/**
 * @author ouyangcm 寻找峰值
 * create 2024/4/8 12:42
 */
public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {8, 7, 6, 2, 4, 3, 1};
        System.out.println(solution.findPeakElement(nums));

        System.out.println(solution.method_1(nums));
        System.out.println(solution.method_2(nums));
        System.out.println(solution.method_3(nums));
        System.out.println(solution.method_4(nums));

    }

    public int findPeakElement(int[] nums) {
        return method_2(nums);
    }

    /**
     * 单调栈找出 数组中大于左右相邻的下标, 当前下标i不满足,则意味这nums[i] < nums[i+1] 则下一个nums[i+1]只需要判断是否大于nums[i+2]
     * @param nums
     * @return
     */
    public int method_1(int[] nums){
        if (nums.length == 1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        while (temp < nums.length){
            if (stack.isEmpty()){
                stack.push(temp);
            }else {
                if (nums[stack.peek()] > nums[temp]){
                    return stack.pop();
                }else {
                    stack.pop();
                    stack.push(temp);
                }
            }
            temp++;
        }

        if (!stack.isEmpty()){
            return stack.pop();
        }

        return -1;
    }

    /**
     * nums[i] < nums[i+1] 意味着 nums[i+1]和nums[i+2]比较,
     * 如果nums[i+1]大于nums[i+2],直接return就可以了
     * 如果nums[i+1]小于nums[i+2],则开始用i+2进行后续比较 用result记录i+1
     * @param nums
     * @return
     */
    public int method_2(int[] nums){
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[result] < nums[i]){
                result = i;
            }else {
                return result;
            }
        }

        return result;
    }

    /**
     * 对于数组 i-1 i i+1
     * 如果nums[i-1] < nums[i] > nums[i+1] 则找到答案
     * 如果nums[i-1] < nums[i] < nums[i+1] 往左i-1查找没有意义,所以i -> i+1
     * 如果nums[i-1] > nums[i] > nums[i+1] 往右i+1查找没有意义,所以i -> i-1
     * 如果nums[i-1] > nums[i] < nums[i+1] 往左右查找都可以, 可以i -> (i+1)/(i-1)
     * @param nums
     * @return
     */
    public int method_3(int[] nums) {
        int n = nums.length;
        int result = (int) (Math.random() * n);
        while (!(compare(nums, result-1, result) < 0 && compare(nums, result, result+1) > 0)){
            if (compare(nums, result-1, result) < 0){
                result+=1;
            }else {
                result-=1;
            }
        }

        return result;
    }

    public int[] get(int[] nums, int index){
        if (index == -1 || index == nums.length){
            return new int[]{0, 0};
        }
        return new int[]{1, nums[index]};
    }

    public int compare(int[] nums, int index1, int index2){
        int[] num1 = get(nums, index1);
        int[] num2 = get(nums, index2);
        // 边界
        if (num1[0] != num2[0]){
            return num1[0] > num2[0] ? 1 : -1;
        }
        return num1[1] > num2[1] ? 1 : -1;

    }

    /**
     * 因为数组中nums[i]!=nums[i+1],所以对于 nums[mid] 如果不是符合条件的,则必须会出现
     * nums[mid-1]<nums[mid]<nums[mid+1] 1
     * nums[mid-1]>nums[mid]>nums[mid+1] 2
     * nums[mid-1]>nums[mid]<nums[mid+1] 3
     * 这三种情况, 第一种情况,向右边进行二分查找,假设在右边中间不存在符合条件的索引,则右边必须单调递增,当到length-1时,这个符合条件
     * 向左查找同理
     * @param nums
     * @return
     */
    public int method_4(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int result = 0;

        while (left <= right){
            int mid = (left + right) / 2;
            if (compare(nums, mid-1, mid) < 0 && compare(nums, mid, mid+1) > 0){
                result = mid;
                break;
            }
            if (compare(nums, mid-1, mid) < 0){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }






}
