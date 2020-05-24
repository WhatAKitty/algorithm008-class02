import java.util.*;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE
 * mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must
 * be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number
 * of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 *
 *
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 *
 *
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 *
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 *
 * @author WhatAKitty
 * @date 2020/05/19
 * @since 1.0.0
 **/
public class MinimumGeneticMutation {

    private static final char[] GENS = new char[] {'A', 'C', 'G', 'T'};

    /**
     * 审题：
     * 1. 规定开始基金
     * 2. 规定目标基因
     * 3. 每次变换过程只允许一个基因突变
     * 4. 每次突变结果都在基因库中存在
     * 可能解法：
     * 1. BFS
     * * BFS循环替换所有因子
     * * BFS根据相差一位递归获取下一层bank内的有效基因
     * 2. DFS
     * 难点：
     * 1. 如何有效生成当前节点的下一个合法基因
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }

        // 用于常数级判断是否存在于基因库
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 遍历当前层的所有突变可能
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (end.equals(current)) {
                    return count;
                }

//                StringBuilder str = new StringBuilder(current);
//                int charslength = str.length();
//                int gensLength = GENS.length;
//                // 突变
//                for (int j = 0; j < charslength; j++) {
//                    char oldChar = str.charAt(j);
//                    for (int k = 0; k < gensLength; k++) {
//                        if (oldChar != GENS[k]) {
//                            str.setCharAt(j, GENS[k]);
//                            String newMutation = str.toString();
//                            if (!visited.contains(newMutation) && bankSet.contains(newMutation)) {
//                                queue.add(newMutation);
//                                visited.add(newMutation);
//                            }
//                        }
//                    }
//                    str.setCharAt(j, oldChar);
//                }

                for (String item : bank) {
                    if (isValid(current, item) && !visited.contains(item)) {
                        queue.add(item);
                        visited.add(item);
                    }
                }
            }

            count++;
        }

        // 不存在可达性路径
        return -1;
    }

    private boolean isValid(String a, String b) {
        if (a.length() != b.length()) return false;
        boolean res = false;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                if (!res) res = true;
                else return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation minimumGeneticMutation = new MinimumGeneticMutation();
        int i = minimumGeneticMutation.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"});
        System.out.println(i);
    }

}
