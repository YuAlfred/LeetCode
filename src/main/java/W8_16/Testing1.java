package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        String[] sNums = input.trim().split(" ");
        StringBuffer[] bNums = new StringBuffer[sNums.length];
        for (int i = 0; i < sNums.length; i++) {
            StringBuffer s = new StringBuffer(Long.toBinaryString(Long.valueOf(sNums[i])));
            while (s.length() < 32) {
                s.insert(0, "0");
            }
            for (int j = 0; j < 31; j += 2) {
                char temp = s.charAt(j);
                s.replace(j, j + 1, String.valueOf(s.charAt(j + 1)));
                s.replace(j + 1, j + 2, String.valueOf(temp));
            }
            bNums[i] = s;
        }
        String head = bNums[0].substring(30, 32);
        for (int i = 1; i < bNums.length; i++) {
            bNums[i].insert(0, head);
            head = bNums[i].substring(32, 34);
        }
        bNums[0].insert(0, head);

        for (StringBuffer s : bNums) {
            System.out.print(Long.valueOf(s.substring(0,32),2) + " ");
        }
    }
}