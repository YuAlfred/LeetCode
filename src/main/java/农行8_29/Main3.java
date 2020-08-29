package 农行8_29;


import java.util.Arrays;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/8/29 10:12 上午
 * @description :
 * @modified By  :
 */

public class Main3 {
    public static void main(String[] args) {
        getPokerOrder(new String[]{"s1", "s3", "s9", "s4", "h1", "p3", "p2", "q5", "q4", "q9", "k2", "k1",});
    }

    public static String[] getPokerOrder(String[] cards) {
        Arrays.sort(cards, (o1, o2) -> {
            int i1 = Integer.parseInt(o1.substring(1));
            int i2 = Integer.parseInt(o2.substring(1));
            char c1 = o1.charAt(0);
            char c2 = o2.charAt(0);
            if (c1 == c2) {
                return i1 - i2;
            } else {
                return getNum(c1) - getNum(c2);
            }
        });

        return cards;
    }

    public static int getNum(char a) {

        switch (a) {
            case 'k':
                return 1;
            case 's':
                return 2;
            case 'h':
                return 3;
            case 'p':
                return 4;
            case 'q':
                return 5;
        }
        return 0;
    }

}
