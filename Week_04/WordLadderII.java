import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author WhatAKitty
 * @date 2020/05/20
 * @since 1.0.0
 **/
public class WordLadderII {

    /**
     * 审题：
     * 1. 从开始单词转化到结束单词
     * 2. 每次转化只能改变一个字母
     * 3. 所有的转化都可在字典中找到
     * 4. 不存在则返回空列表
     * 5. 所有字典相同长度
     * 6. 小写字母构成
     * 7. 不存在重复单词
     * 8. 开始和结束单词非空，且两者不同
     * 9. 输出所有的最短转化路径
     * 可能解法：
     * 1. DFS + stack - 超时
     * 2. BFS + DFS, BFS寻找最短路径，DFS寻找所有解
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Stack<List<String>> result = new Stack<>();

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        dfs(beginWord, endWord, wordList, visited, path, result);

        return result;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, Set<String> visited, List<String> path, Stack<List<String>> result) {
        if (beginWord.equals(endWord)) {
            if (!result.empty()) {
                while (!result.empty() && result.peek().size() > path.size()) {
                    result.pop();
                }
            }
            if (result.empty() || result.peek().size() == path.size()) {
                result.add(new ArrayList<>(path));
            }

            return;
        }

        for (String word : wordList) {
            if (!visited.contains(word) && isValid(word, beginWord)) {
                path.add(word);
                visited.add(word);
                dfs(word, endWord, wordList, visited, path, result);
                path.remove(path.size() - 1);
                visited.remove(word);
            }
        }
    }

    private boolean isValid(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        boolean differentOne = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (differentOne) {
                    // 第二次不同，直接返回false
                    return false;
                }

                // 第一次不同标记
                differentOne = true;
            }
        }

        // 只有一次不同
        return true;
    }

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        wordLadderII.findLadders("qa", "sq", List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"));
    }


}
