package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/18 3:26 下午
 * @description : 面试题 08.10. 颜色填充
 * @modified By  :
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * <p>
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * <p>
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * <p>
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 *  
 * <p>
 * 提示：
 * <p>
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M8_10_easy_颜色填充 {

    public static void main(String[] args) {
        M8_10_easy_颜色填充 m = new M8_10_easy_颜色填充();
        m.floodFill(new int[][]{{0, 0, 0,}, {0, 1, 1}}, 1, 1, 1);
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return floodFill(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || newColor == oldColor) {
            return image;
        }
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            floodFill(image, sr - 1, sc, newColor, oldColor);
            floodFill(image, sr + 1, sc, newColor, oldColor);
            floodFill(image, sr, sc - 1, newColor, oldColor);
            floodFill(image, sr, sc + 1, newColor, oldColor);
        }
        return image;
    }


}
