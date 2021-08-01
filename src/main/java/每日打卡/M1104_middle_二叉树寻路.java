package 每日打卡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1104. 二叉树寻路
 * @date: 2021/7/29 12:09 上午
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * <p>
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= label <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1104_middle_二叉树寻路 {

    public static void main(String[] args) {
        System.out.println(1 << 4);
        M1104_middle_二叉树寻路 m = new M1104_middle_二叉树寻路();
        m.pathInZigZagTree(14);
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>(10);
        // 此时节点在第i层
        int i = getI(label);
        label = pareLeftToRight(label, i);
        while (label > 0) {
            // 如果是奇数层 i本来就从左到右
            if ((i & 1) == 1) {
                path.add(label);
            } else {
                path.add((1 << i) + (1 << (i - 1)) - 1 - label);
            }
            label = (label >> 1);
            i = getI(label);
        }
        Collections.reverse(path);
        return path;
    }


    public int pareLeftToRight(int label, int i) {
        // 此节点在第i层
        // 如果是奇数层 i本来就从左到右
        if ((i & 1) == 1) {
            return label;
        } else {
            return (1 << i) + (1 << (i - 1)) - 1 - label;
        }
    }

    public int getI(int label) {
        int i = 0;
        while (label > 0) {
            label >>= 1;
            i++;
        }
        return i;
    }

}
