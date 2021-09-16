package 每日打卡;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 212. 单词搜索 II
 * @date: 2021/9/16 2:28 下午
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M212_hard_单词搜索_II {

    public Set<String> ans = new HashSet<>();

    public static void main(String[] args) {
        M212_hard_单词搜索_II m = new M212_hard_单词搜索_II();
        m.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"});
    }

    public List<String> findWords(char[][] board, String[] words) {

        // 构造字典树
        DictionaryTree root = new DictionaryTree();
        for (String word : words) {
            DictionaryTree cur = root;
            for (char c : word.toCharArray()) {
                if (null == cur.next[c - 'a']) {
                    cur.next[c - 'a'] = new DictionaryTree();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, new boolean[board.length][board[0].length], i, j, root.next[board[i][j] - 'a'], new StringBuilder());
            }
        }
        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y, DictionaryTree root, StringBuilder path) {
        if (null == root || visited[x][y]) {
            return;
        }
        path.append(board[x][y]);
        visited[x][y] = true;
        if (root.isWord) {
            ans.add(path.toString());
        }
        // 上下左右
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                dfs(board, visited, newX, newY, root.next[board[newX][newY] - 'a'], path);
            }
        }
        path.deleteCharAt(path.length() - 1);
        visited[x][y] = false;
    }

    static class DictionaryTree {

        boolean isWord;
        DictionaryTree[] next;

        public DictionaryTree() {
            this.isWord = false;
            this.next = new DictionaryTree[26];
        }
    }


}
