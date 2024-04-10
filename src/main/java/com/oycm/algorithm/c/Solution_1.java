package com.oycm.algorithm.c;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {1,2,3,4,5};
        System.out.println(solution.minSubArrayLen(11, nums));
        System.out.println(solution.method_3(11, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {
        return method_1(target, nums);
    }

    /**
     *
     * @param target 目标值
     * @param nums 都为正数的数组
     * @return 大于等于target的最小连续子数组的值,没有则为0
     */
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

    /**
     * 从0开始找找到第一个右边第一个大于等于target的right,这个时候就得到了一个长度 right-0+1意味着我们找到了第一个0开始的最小子数组的长度，这个时候就可以开始找第二个的最小子数组
     * 即到right和>=target,找下一个left+1的大于等于target的值，当减少到自己时,里面的循环就退出了
     * @param target
     * @param nums
     * @return
     */
    public int method_2(int target, int[] nums){
        int result = nums.length + 1;
        int left = 0;
        int right = 0;
        int s = 0;
        while (right < nums.length){
            s += nums[right];

            // 这里不会死循环 如果存在一个nums[i] >= target,这里
            while (s >= target){
                // 记录长度
                result = Math.min(result, right-left+1);
                s-=nums[left];
                left++;

            }
            right++;
        }
        return result > nums.length ? 0 : result;
    }

    /**
     * 二分法查找
     * @param target
     * @param nums
     * @return
     */
    public int method_3(int target, int[] nums){
        int result = nums.length + 1;
        int[] sums = new int[nums.length+1];
        // 前缀和
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        // sums是单调递增的,指定i开始的任意下标，如果存在连续数组，则有sums[right]-sums[i] >= target,长度为right-i
        // 意思是从i开始的到right的数组和为sum[right+1]-sums[i]
        // sums[right]表示前面right个元素的和 sums[2]=nums[0]+nums[1]
        for (int i = 0; i < nums.length; i++) {
            // 找大于等于，没找到小于0，这里不会为0
            int right = binarySearchFirstMax(sums, target + sums[i]);
            if (right > 0){
                result = Math.min(result, right-i);
            }
        }
        return result > nums.length ? 0 : result;
    }

    /**
     * 二分法查找第一个大于等于x的索引
     * @param arr
     * @param x
     * @return
     */
    public int binarySearchFirstMax(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int result = arr.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] >= x){
                result = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return result == arr.length ? -1 : result ;
    }
}
