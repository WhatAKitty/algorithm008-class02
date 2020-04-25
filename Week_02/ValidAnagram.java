/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class ValidAnagram {

    /**
     * 审题：
     *  1. 两个字符串比较
     *  2. 异位词定义：字母顺序但是字母相同而组成的一对单词
     *  3. 只有小写字母，不考虑大写情况
     *
     * 额外：
     *  1. 包含unicode编码字母
     * 可能解法：
     *  1. 排序后字符串比较
     *  2. 哈希表统计字母出现的频次
     *  3. 构建256字母的位图，比较索引位碰撞
     *
     * 测试用例：
     * ["", ""] -> true
     * ["", "a"] -> false
     * ["a", "a"] -> true
     * ["anagraaam", "nagaram"] -> false
     * ["anagraabm", "nagaram"] -> false
     * ["anagram", "nagaram"] -> true
     */
    public boolean isAnagram(String s, String t) {
        int[] bit = new int[256];

        for (char c : s.toCharArray()) {
            bit[c] += 1;
        }

        for (char c : t.toCharArray()) {
            bit[c] -= 1;
        }

        for (int i : bit) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
