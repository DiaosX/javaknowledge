package com.my.javabasic.arithmetic.breakwords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
public class BreakWordSplit {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("A");
        words.add("World");
        String source = "HelloAWorld";
        System.out.println("拆分结果:" + wordBreak(source, words));

        List<String> subStringList = splitSubString(source);
        subStringList.forEach(System.out::println);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);//为了快速查字典，放到一个无重复的集合里
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (dp[i] && set.contains(s.substring(i, j + 1)))//前面的都可查，后面一段也可查
                    dp[j + 1] = true;
            }
        }
        return dp[len];
    }

    public static List<String> splitSubString(String s) {
        int len = s.length();
        List<String> subString = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                subString.add(s.substring(i, j + 1));
            }
        }
        return subString;
    }
}
