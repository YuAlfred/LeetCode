package 面试笔试.农行2021_4_27;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/27 3:17 下午
 */
public class Main2 {


    public static void main(String[] args) {
        Main2 m = new Main2();
        m.getMaxNeighbour(new String[]{"57818", "29735", "31118", "14275", "58919"}, 0, 4);
    }

    public int getMaxNeighbour(String[] value_matrix, int row, int col) {

        int[][] dir = {{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dir.length; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow >= 0 && newRow < value_matrix.length && newCol >= 0 && newCol < value_matrix[newRow].length()) {
                max = Math.max(max, value_matrix[newRow].charAt(newCol) - '0');
            }
        }
        return max;
    }
}
