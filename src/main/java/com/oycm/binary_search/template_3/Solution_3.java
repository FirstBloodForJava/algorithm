package com.oycm.binary_search.template_3;

/**
 * @author ouyangcm
 * create 2024/4/9 15:39
 */
public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(solution.findPeakElement(nums));

    }

    public int findPeakElement(int[] nums) {

        return method_1(nums);
    }

    /**
     * 峰值需要 nums[i]>nums[i-1]且nums[i]>nums[i+1] nums[0]=nums[length]=-∞
     * 对于任意一个数i,有下面3种情况
     *      1.nums[i-1] < nums[i] < nums[i+1]
     *      2.nums[i-1] < nums[i] > nums[i+1]
     *      3.nums[i-1] > nums[i] > nums[i+1]
     *      4.nums[i-1] > nums[i] < nums[i+1]
     * 第2种是符合条件的,如果1,3情况，如果往递减的一方去查找，是没有任何意义的，因为num[i]!=nums[i+1],它可以一直递减，最终就没有峰值
     * 而如果往递增的方向查询，就算一直递增，0或length-1最终都会是峰值
     * 第4种往左往右的方向都可以
     * @param nums nums[0]=nums[length]=-∞ nums[i]!=nums[i+1]
     * @return 峰值索引
     */
    public int method_1(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if (!(compare(nums, mid-1,mid) < 0 && compare(nums, mid, mid + 1) > 0)){
                if (compare(nums, mid-1, mid) > 0){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                break;
            }
        }

        return mid;
    }

    public int compare(int[] nums, int ind1, int ind2){

        int[] num1 = get(nums, ind1);
        int[] num2 = get(nums, ind2);

        if (num1[0] != num2[0]){
            return num1[0] > num2[0] ? 1 : -1;
        }

        return num1[1] > num2[1] ? 1 : -1;
    }

    public int[] get(int[] nums, int index){
        int[] result = {0, 0};
        if (index == -1 || index == nums.length){
            return result;
        }
        result[0] = 1;
        result[1] = nums[index];
        return result;
    }
}
