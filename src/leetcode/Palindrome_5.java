package leetcode;

/**
 * Copyright (C), 2020-2020, Qinghao Sun
 * Author: Sun Qinghao
 * Date: 2020/10/5 8:36 下午
 * FileName: Palindrome_5
 * Description: 寻找最长回文子串
 */

/**
 *解题思想：动态规划
 * 回文串即为正反念都一样
 * 我们利用一个二位boolean数组记录已经遍历过的组合节约时间
 */
public class Palindrome_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];//记录下当前满足条件的回文组合

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {//以右为基础向左边扩展
                //如果相同并且（中间只有一个，即为对称，或者上一个也满足）：满足回文
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }

}
