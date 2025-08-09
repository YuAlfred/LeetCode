package 面试笔试.花旗银行10_7;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/10/7 20:36
 * @description :
 * @modified By  :
 */
public class T3 {

    public String solution(String s) {
        char c = s.charAt(0);
        if (c <= 'Z' && c >= 'A') {
            return "upper";
        } else if (c <= 'z' && c >= 'a') {
            return "lower";
        } else if (c <= '9' && c >= '0') {
            return "digit";
        } else {
            return "other";
        }
    }
}
