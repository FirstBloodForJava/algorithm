package com.oycm.algorithm.w;

import java.util.*;

public class Solution_3 {

    /**
     * 2246.相邻字符不同的最长路径
     * https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/
     * @param parent
     * @param s
     * @return
     */
    public int longestPath(int[] parent, String s) {
        return 0;
    }


    public int method_1(int[] parent, String s) {
        int ans = 1;
        // 顺序没有保证，所以结果是有问题的
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = parent.length-1; i >=0 ; i--) {
            int parentInt = parent[i];
            char parentChar = parentInt == -1 ? s.charAt(0) : s.charAt(parentInt);

            if (!temp.containsKey(parentInt)) temp.put(parentInt, 1);
            if (!temp.containsKey(i)) temp.put(i, 1);
            if (s.charAt(i) != parentChar) {
                int parentValue = temp.get(parentInt);
                ans = Math.max(ans, parentValue + temp.get(i));
                parentValue = Math.max(parentValue, temp.get(i) + 1);
                // 更新父最大值
                temp.put(parentInt, parentValue);
            }
        }

        return ans;
    }
    List<Integer>[] tree;
    String s;
    int ans = 0;
    public int method_2(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        tree = new List[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            // 父节点有多少子节点
            tree[parent[i]].add(i);
        }
        dfs(0);
        // 为什么+1? ans是不相等的情况下算的，算的时候没有把拐点算上
        return ans + 1;
    }

    public int dfs(int x) {
        // 记录所有子树的最大值
        int maxLen = 0;
        // 子树遍历完退出循环
        for (Integer y : tree[x]) {
            // 计算每个子树的的长度
            int len = dfs(y) + 1;
            if (s.charAt(x) != s.charAt(y)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    // 加结果位置修改
    public int method_3(int[] parent, String s) {
        int n = parent.length;
        ans = 1;
        this.s = s;
        tree = new List[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            // 父节点有多少子节点
            tree[parent[i]].add(i);
        }
        dfs_2(0);
        // 为什么+1? ans是不相等的情况下算的，算的时候没有把拐点算上
        return ans;
    }
    public int dfs_2(int x) {
        // 记录所有子树的最大值
        int maxLen = 0;
        // 子树遍历完退出循环
        for (Integer y : tree[x]) {
            // 计算每个子树的的长度
            int len = dfs_2(y) + 1;
            if (s.charAt(x) != s.charAt(y)) {
                ans = Math.max(ans, maxLen + len + 1);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] parent = {-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19};
        System.out.println(parent.length);
        String s = "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal";
        System.out.println(solution.method_1(parent, s));
        System.out.println(solution.method_2(parent, s));
        System.out.println(solution.method_3(parent, s));


    }
}
