package 每日打卡;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 3:17 下午
 * @description : 501. 二叉搜索树中的众数
 * @modified By  :
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M501_easy_二叉搜索树中的众数 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int length = 0, size = 0;

    public int[] findMode(TreeNode root) {
        find(root);
        int[] res = new int[size];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == length) {
                res[i] = e.getKey();
                i++;
            }
        }
        return res;
    }

    public void find(TreeNode root) {
        if (root == null) {
            return;
        }
        int times = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, times);
        if (times > length) {
            length = times;
            size = 1;
        } else if (times == length) {
            size++;
        }
        find(root.left);
        find(root.right);
    }


}
