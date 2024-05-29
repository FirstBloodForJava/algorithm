package com.oycm.algorithm.a;

public class Solution_10 {

    /**
     * 2748.美丽下标对的数目：https://leetcode.cn/problems/number-of-beautiful-pairs/description/
     * @param nums
     * @return nums[i]的第一个数字和nums[j]最后一个数字互质的一对的数量
     */
    public int countBeautifulPairs(int[] nums) {
        // 互质和前面的情况不一样，结果不是一一对应的
        // 例如1+59和1+119在前面会是归在一类1或59，每个都有对应的结果
        // 11 12和31，但是23也和31互质，所以这里可以在加一层循环，保证所以的都被循环到
        int ans = 0;
        int[] leftCache = new int[10];
        for (int num : nums) {
            int j = num % 10;
            for (int i = 1; i < 10; i++) {
                // 有数字才进行比较
                if (leftCache[i] > 0 && gcd(i, j) == 1) ans += leftCache[i];
            }

            // 记录i的数量
            while (num >= 10){
                num /= 10;
            }
            leftCache[num]++;
        }

        return ans;
    }

    /**
     * 辗转相除法求最大公约数
     * @param x
     * @param y
     * @return x 和 y的最大公因数 结果为1表示互质
     */
    private int gcd(int x, int y) {
        while (x != 0) {
            int temp = x;
            x = y % x;
            y = temp;
        }
        return y;
    }

    public static void main(String[] args) {
        Solution_10 solution = new Solution_10();
        int[] nums = {756,1324,2419,495,106,111,1649,1474,2001,1633,273,1804,2102,1782,705,1529,1761,1613,111,186,412};
        System.out.println(solution.countBeautifulPairs(nums));
        System.out.println(solution.gcd(24, 60));
    }
}
