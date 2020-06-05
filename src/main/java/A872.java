/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/5/28 18:00
 * @description : 872. 叶子相似的树
 * @modified By  :
 */
public class A872 {

    int i = 0;


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] result1 = new int[100];
        int[] result2 = new int[100];
        i=0;
        DLR(root1,result1);
        i=0;
        DLR(root2,result2);
        return compare(result1,result2);
    }

    public void DLR(TreeNode root, int[] result) {
        if (root.left == null && root.right == null) {
            result[i] = root.val;
            i++;
            return;
        }
        if (root.left != null) {
            DLR(root.left, result);
        }
        if (root.right != null) {
            DLR(root.right, result);
        }
    }

    public boolean compare(int[] res1,int[] res2){
        for (int i=0;i<100;i++){
            if (res1[i]!=res2[i])
                return false;
        }
        return true;
    }

}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
