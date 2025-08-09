package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/25 19:01
 * @description : 剑指 Offer 12. 矩阵中的路径
 * @modified By  :
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M12_middle_矩阵中的路径 {


    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findLetter(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean findLetter(char[][] board, String word, int i, int j, int p) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || p < 0 || board[i][j] != word.charAt(p)) {
            return false;
        }
        if (p >= word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '/';
        boolean result = findLetter(board, word, i + 1, j, p + 1) ||
                findLetter(board, word, i - 1, j, p + 1) ||
                findLetter(board, word, i, j + 1, p + 1) ||
                findLetter(board, word, i, j - 1, p + 1);
        board[i][j] = temp;
        return result;
    }

}



