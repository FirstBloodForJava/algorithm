package com.oycm.binary_search.template_2;

import java.util.Random;

/**
 * @author ouyangcm
 * create 2024/4/8 9:27
 */
public class Solution_1 extends VersionControl {

    int badVersion;

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int n = 2;
        Random random = new Random();
        int bad = random.nextInt(n);
        if (bad == 0){
            bad = 1;
        }
        System.out.println(bad);
        solution.badVersion = bad;

        System.out.println(solution.firstBadVersion(n));
    }

    /**
     * 0代表false,1代表true 出现true的后面全是true
     * 0 0 0 1 1 1 1 如果right = mid - 1 这里就错失了这
     * 0 0 0 0 1 1 1
     * @param n
     * @return 找到这组中第一个出现的true
     */
    public int firstBadVersion(int n) {

        if (n == 1){
            return 1;
        }

        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }

    @Override
    boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

abstract class VersionControl{
    abstract boolean isBadVersion(int version);
}
