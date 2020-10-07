package 面试笔试.花旗银行10_7;

import java.util.Arrays;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/10/7 20:36
 * @description :
 * @modified By  :
 */
public class T6 {

    public static void main(String[] args) {
        T6 m = new T6();
        System.out.println(m.solution(6));
    }

    public String solution(int N) {
        char[] res = new char[N];
        Arrays.fill(res, 'a');
        if ((N & 1) == 0) {
            res[0] = 'b';
        }
        return new String(res);
    }
}
