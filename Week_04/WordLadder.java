import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
 * transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
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
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author WhatAKitty
 * @date 2020/05/20
 * @since 1.0.0
 **/
public class WordLadder {

    /**
     * 审题：
     * 1. 从开始字符串转化到目标字符串
     * 2. 每次转化只能改变一个字符
     * 3. 转化过程必须在字典中存在
     * 4. 不存在返回0
     * 5. 所有单词具有相同长度
     * 6. 都为小写
     * 7. 不存在重复单词
     * 8. 开始和结束单词都非空，且两者不相同
     * 9. 返回变换过程的单词长度
     * 可能解法：
     * 1. BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (endWord.equals(cur)) {
                    return count;
                }

                for (String word : wordList) {
                    if (!visited.contains(word) && isValid(cur, word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }

            count++;
        }

        return 0;
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
        WordLadder wordLadder = new WordLadder();
        wordLadder.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
    }

}
