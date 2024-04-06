package com.oycm.binary_search.template_1;

// 猜数字大小
public class Solution_2 extends GuessGame {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     *
     * @param num your guess
     * @return -1 num > pick
     *          1 num < pick
     *          0 num = pick
     */
    @Override
    int guess(int num) {
        return 0;
    }
}

abstract class GuessGame {
    abstract int guess(int num);
}
