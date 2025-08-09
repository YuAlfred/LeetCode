package 面试笔试.农行2021_9_6;

import org.apache.commons.lang3.StringUtils;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/6 2:30 下午
 */
public class Main3 {

    public static void main(String[] args) {

    }

    public String[] scoresort(String[] names, String[] scores) {
        int[] total = new int[3];
        for (int i = 0; i < 3; i++) {
            String[] score = scores[i].split(",");
            for (String s : score) {
                total[i] += Integer.parseInt(s);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                if (total[i] < total[j]) {
                    int temp = total[i];
                    total[i] = total[j];
                    total[j] = temp;
                    String name = names[i];
                    names[i] = names[j];
                    names[j] = name;
                }
            }
        }

        return names;
    }

}
