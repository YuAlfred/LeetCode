package 程序员面试经典;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 面试题 17.11. 单词距离
 * @date: 2020/10/30 10:44 上午
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M17_11_middle_单词距离 {
    public int findClosest(String[] words, String word1, String word2) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                map.get(word).add(i);
            } else {
                List temp = new ArrayList();
                temp.add(i);
                map.put(word, temp);
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            min = Math.min(Math.abs(l1.get(i) - l2.get(j)), min);
            if (l1.get(i) > l2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return min;
    }
}












