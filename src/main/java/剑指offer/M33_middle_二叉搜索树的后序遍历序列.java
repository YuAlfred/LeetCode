package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/8/4 21:19
 * @description : 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @modified By  :
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M33_middle_二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        verifyPostorder(new int[]{5, 4, 3, 2, 1});
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int root = postorder[j];
        int p = i;
        while (p < j && postorder[p] < root) {
            p++;
        }
        int m = p;
        while (p < j && postorder[p] > root) {
            p++;
        }
        return (p == j) && recur(postorder, i, m-1) && recur(postorder, m, j - 1);
    }


}
