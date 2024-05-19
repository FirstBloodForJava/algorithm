package com.oycm.algorithm.b;

public class Solution_1 {

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(ints);
        System.out.println(result);
    }

    /**
     * 11.盛最多水的容器：https://leetcode.cn/problems/container-with-most-water/description
     * @param height
     * @return
     */
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

    // 贪心+双指针
    public static int method_2(int[] height){
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            /*result = Math.max((Math.min(height[i], height[j])) * (j-i), result);
            if (height[i] <= height[j]){
                i++;
            }else {
                j--;
            }*/
            // 优化 如果左边的较小,往右移动之后还比之前的较小,这个时候就不用计算比较了,肯定会小于之前的值
            // 同理,右边的也是入职
            int min = Math.min(height[i], height[j]);
            result = Math.max(result, (j-i) * min);

            while (i < j && height[i] <= min){
                i++;
            }
            while (i < j && height[j] <= min){
                j--;
            }
        }

        return result;
    }

}
