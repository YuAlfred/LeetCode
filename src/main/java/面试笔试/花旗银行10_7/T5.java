package 面试笔试.花旗银行10_7;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/10/7 20:36
 * @description :
 * @modified By  :
 */
public class T5 {

    public String solution(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'm') {
                sb.append("-");
                i += 4;
            } else {
                sb.append("+");
                i += 3;
            }
        }
        return sb.toString();
    }
}
