package com.oycm.algorithm.dc;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ouyangcm
 * create 2024/8/6 16:22
 */
public class Solution_1_3143 {


    /**
     * 1600
     * 3143.正方形中的最多点数：https://leetcode.cn/problems/maximum-points-inside-the-square/description/
     * @param points 二维数组,points[i]表示第i个点的坐标(s.length == points.length)
     * @param s
     * @return 合法正方形中可以包含的最多点数（正方形的中心在(0,0),所有的边平行于坐标轴,且正方形内不存在标签相同的两个点,这个正方形是合法正方形）,返回合法正方形中可以包含的最多点数
     */
    public int maxPointsInsideSquare(int[][] points, String s) {
        int ans = 0;

        return ans;
    }

    public static void main(String[] args) throws URISyntaxException {

        //
        String pattern = "(?<=^(?:https?|ftps?)://)[^:/]+(?::\\d+)?(?:/v\\d+)?(?=/)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher("http://localhost:8080/v1/demo/get");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(matcher.matches());

        System.out.println(matcher.replaceFirst("go"));


        System.out.println(Pattern.compile("[a-zA-Z]([a-zA-Z]|\\d|\\+|\\.|-)*:.*").matcher("//localhost:8080/v1/demo/get").matches());

        System.out.println("password=123&".replaceAll("password=[^&]+", "$0123"));

        URI uri = new URI("ws://localhost:3001");

        System.out.println(uri);

        Object i = 1;
        System.out.println(i.toString());
        uri = null;
        System.out.println("a\r1");

        System.out.println("\u001c");

        System.out.println(Pattern.compile("[\\p{Cc}\\p{Cn}\\p{Co}\\p{So}\\p{Mn}]").matcher("\u001c\u0020").replaceAll("?"));
    }
}
