package com.oycm.binary_search.template_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author ouyangcm
 * create 2024/4/9 15:21
 */
public class Solution_2 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        Solution_2 solution = new Solution_2();
        System.out.println(solution.findClosestElements(arr, 4, 3));
        System.out.println(solution.method_2(arr, 4, 3));
        System.out.println(solution.binarySearchFirstMax(arr, 6));
        System.out.println(solution.binarySearchLastMin(arr, 3));
    }


    /**
     * |a - x| < |b - x| 或者 |a - x| == |b - x| 且 a < b
     * @param arr 升序排序数组
     * @param k 1 <= k <= arr.length
     * @param x 给定的x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        return method_1(arr, k, x);
    }

    /**
     * 将给定的数组按和x的距离排序出来，截取指定长度的数组，然后排序返回
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> method_1(int[] arr, int k, int x){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            if (Math.abs(o1-x) == Math.abs(o2-x)) {
                return o1 < o2 ? -1 : 1;
            }else {
                return Math.abs(o1-x) < Math.abs(o2-x) ? -1 : 1;
            }
        });
        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }

    public List<Integer> method_2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int right = binarySearchFirstMax(arr, x);
        int left = right - 1;
        int i = 0;
        Stack<Integer> leftList = new Stack<>();
        List<Integer> rightList = new ArrayList<>();
        while (i < k){
            if (left == -1){
                rightList.add(arr[right]);
                right++;
            }else if (right == arr.length){
                leftList.push(arr[left]);
                left--;
            }else {
                if (Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                    leftList.push(arr[left]);
                    left--;
                }else {
                    rightList.add(arr[right]);
                    right++;
                }
            }
            i++;
        }
        if (!leftList.isEmpty()){

            while (!leftList.empty()){
                list.add(leftList.pop());
            }
        }
        if (!rightList.isEmpty()){
            list.addAll(rightList);
        }

        return list;
    }

    /**
     * 给定升序数组，找出第一个大于等于x的索引,如果x > arr[length-1] 则返回 length-1
     * @param arr 升序数组
     * @param x
     * @return
     */
    public int binarySearchFirstMax(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int result = right;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] >= x){
                result = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return result;
    }

    /**
     * 给定升序数组，找出最后一个小于等于x的索引,如果x < arr[0] 则返回 0
     * @param arr 升序数组
     * @param x
     * @return
     */
    public int binarySearchLastMin(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        int result = left;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] <= x){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }
}
