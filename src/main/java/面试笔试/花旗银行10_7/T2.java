package 面试笔试.花旗银行10_7;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/10/7 20:36
 * @description :
 * @modified By  :
 */
public class T2 {

    public int solution(int[] A) {
        int res = 1;
        for (int a : A) {
            if (a < 0) {
                res *= -1;
            } else if (a == 0) {
                return 0;
            }
        }
        return res;
    }
}
