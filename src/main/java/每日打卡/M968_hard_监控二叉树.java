package 每日打卡;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/22 3:48 下午
 * @description : 968. 监控二叉树
 * @modified By  :
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-cameras
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M968_hard_监控二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int minCameraCover(TreeNode root) {
        return putCamera(root)[1];
    }

    public int[] putCamera(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0, 0};
        }
        int[] arr = new int[3];
        int[] l = putCamera(root.left);
        int[] r = putCamera(root.right);
        arr[0] = 1 + Math.min(l[1], l[2]) + Math.min(r[1], r[2]);
        arr[1] = Math.min(arr[0], Math.min(l[0] + r[1], l[1] + r[0]));
        arr[2] = Math.min(arr[1], l[1] + r[1]);
        return arr;
    }


}







