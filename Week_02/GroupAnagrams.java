import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @author WhatAKitty
 * @date 2020/04/25
 * @since 1.0.0
 **/
public class GroupAnagrams {

    /**
     * 审题：
     * 1. 分组异位词
     * 2. 只考虑小写字母
     * 3. 结束输出不需要排序
     * 可能解法：
     * 1. 所有单词按照字母顺序排序，存入map（排序后单词，原单词列表），输出map的values即可
     * 2. 定义char[]，存入map（String，原单词列表），输出map的values即可
     * 测试用例：
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mappings = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (char c : str.toCharArray()) {
                chars[c - 'a']++;
            }
            mappings.compute(new String(chars), (k, list) -> {
                if (list == null) {
                    list = new  ArrayList<>();
                }

                list.add(str);
                return list;
            });
        }

        return new ArrayList<>(mappings.values());
    }

}
