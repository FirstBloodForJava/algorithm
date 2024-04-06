package com.oycm.binary_search.template_1;

public class Solution_1 {

    // x的平方根
    public static void main(String[] args) {
        System.out.println(mySqrt(6));

    }

    public static int mySqrt(int x) {
        return sqrt(x);
    }

    public static int sqrt(int x){
        int result = -1;
        int left = 0;
        int right = x;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (((long) mid * mid) <= x){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }
}
