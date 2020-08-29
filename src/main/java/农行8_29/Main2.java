package 农行8_29;


/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/8/29 10:12 上午
 * @description :
 * @modified By  :
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {



    public  int get_index(String[] points) {

        int[][] nums = new int[points.length][2];
        int x = 0, y = 0;
        for (int i = 0; i < points.length; i++) {
            String[] s = points[i].split(",");
            nums[i][0] = Integer.parseInt(s[0]);
            x += nums[i][0];
            nums[i][1] = Integer.parseInt(s[1]);
            y += nums[i][1];
        }
        x /= nums.length;
        y /= nums.length;
        double minDis = Math.pow(nums[0][0] - x, 2) + Math.pow(nums[0][1] - y, 2);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            double temp = Math.pow(nums[i][0] - x, 2) + Math.pow(nums[i][1] - y, 2);
            if (temp < minDis) {
                minDis = temp;
                index = i;
            }
        }
        return index;
    }
}
