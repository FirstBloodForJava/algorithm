package com.oycm.algorithm.b;

public class Solution_1 {

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(ints);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {

        return method_1(height);
    }

    // 暴力枚举+一点优化 时间复杂度n^2
    public static int method_1(int[] height){
        int result = 0;
        for (int i = 0; i < height.length-1; i++) {
            int right = height.length-1;
            while (i < right){
                if (height[right] >= height[i]){
                    result = Math.max(result, height[i]*(right-i));
                    break;
                }else {
                    result = Math.max(result,height[right]*(right-i));
                    right--;
                    while (i < right && height[right]<=height[right+1]){
                       right--;
                    }
                }
            }
        }

        return result;
    }

}
