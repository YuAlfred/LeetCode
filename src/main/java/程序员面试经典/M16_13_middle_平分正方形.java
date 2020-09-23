package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/23 9:29 上午
 * @description : 面试题 16.13. 平分正方形
 * @modified By  :
 * 给定两个正方形及一个二维平面。请找出将这两个正方形分割成两半的一条直线。假设正方形顶边和底边与 x 轴平行。
 * <p>
 * 每个正方形的数据square包含3个数值，正方形的左下顶点坐标[X,Y] = [square[0],square[1]]，以及正方形的边长square[2]。所求直线穿过两个正方形会形成4个交点，请返回4个交点形成线段的两端点坐标（两个端点即为4个交点中距离最远的2个点，这2个点所连成的线段一定会穿过另外2个交点）。2个端点坐标[X1,Y1]和[X2,Y2]的返回格式为{X1,Y1,X2,Y2}，要求若X1 != X2，需保证X1 < X2，否则需保证Y1 <= Y2。
 * <p>
 * 若同时有多条直线满足要求，则选择斜率最大的一条计算并返回（与Y轴平行的直线视为斜率无穷大）。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * square1 = {-1, -1, 2}
 * square2 = {0, -1, 2}
 * 输出： {-1,0,2,0}
 * 解释： 直线 y = 0 能将两个正方形同时分为等面积的两部分，返回的两线段端点为[-1,0]和[2,0]
 * 提示：
 * <p>
 * square.length == 3
 * square[2] > 0
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bisect-squares-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_13_middle_平分正方形 {

    public static void main(String[] args) {
        cutSquares(new int[]{249, -199, 5}, new int[]{-1, 136, 76});
    }


    public static double[] cutSquares(int[] square1, int[] square2) {
        double[] m1 = new double[2];
        double[] m2 = new double[2];
        m1[0] = square1[0] + square1[2] / 2.0;
        m2[0] = square2[0] + square2[2] / 2.0;
        m1[1] = square1[1] + square1[2] / 2.0;
        m2[1] = square2[1] + square2[2] / 2.0;

        double rate, b = 1;
        if (m1[0] == m2[0]) {
            return new double[]{m1[0], Math.min(square1[1], square2[1]), m2[0],
                Math.max(square1[1] + square1[2], square2[1] + square2[2])};
        } else if (m1[1] == m2[1]) {
            rate = 0;
        } else {
            rate = (m1[1] - m2[1]) / (m1[0] - m2[0]);
            b = m1[1] - rate * m1[0];
        }
        if (rate == 0) {
            return new double[]{Math.min(square1[0], square2[0]), m1[1],
                Math.max((square1[0] + square1[2]), (square2[0] + square2[2])), m2[1]};
        } else if (rate >= 1 || rate <= -1) {
            double y1 = Math.min(square1[1], square2[1]);
            double y2 = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
            double x1 = (y1 - b) / rate;
            double x2 = (y2 - b) / rate;
            if (x1<=x2){
                return new double[]{x1, y1, x2, y2};
            }else {
                return new double[]{x2, y2, x1, y1};
            }
        } else {
            double x1 = Math.min(square1[0], square2[0]);
            double x2 = Math.max(square1[0] + square1[2], square2[0] + square2[2]);
            double y1 = rate * x1 + b;
            double y2 = rate * x2 + b;
            return new double[]{x1, y1, x2, y2};
        }
    }
}















