package com.oycm.algorithm.cc;

public class Solution_3 {

    /**
     * 1574.删除最短的子数组使剩余数组有序：https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
     * @param arr
     * @return 返回删除最短连续的子数组长度，使得剩余数组是非递减的
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        int ans = n - 1;
        int right = n - 1;
        while (right > 0 && arr[right-1] <= arr[right]) {
            right--;
        }
        // 此时非递减
        if (right == 0) return 0;

        // [0,right-1]左边都删除
        ans = right;

        // 枚举left
        int left = 0;
        while (left == 0 || arr[left-1] <= arr[left]) {
            // arr[left] > arr[right] 从前到后，有顺序
            while (right < n && arr[left] > arr[right]) {
                right++;
            }
            // 通过指针巧妙的移动，避免了重复计算：暴力法，左边非递减和右边非递减组合
            // 到这里要么right = n,或arr[left] <= arr[right](且arr[left-1] <= arr[left]),需要删除[left+1, right)
            ans = Math.min(ans, right - left - 1);
            left++;
        }

        return ans;
    }

    public int leftToRight(int[] arr){
        int n = arr.length;

        int left = 0;
        while (left < n-1 && arr[left] <= arr[left+1]) {
            left++;
        }
        // 是升序的了
        if (left == n-1) return 0;

        // 删除[left+1, n-1] n-1 -(left+1) +1
        int ans = n - left - 1;
        int right = n - 1;
        // 递减
        while (right == n-1 || arr[right-1] <= arr[right]) {


        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3};
        System.out.println(solution.findLengthOfShortestSubarray(arr1));
        System.out.println(solution.findLengthOfShortestSubarray(arr2));
        System.out.println(solution.findLengthOfShortestSubarray(arr3));
    }
}
