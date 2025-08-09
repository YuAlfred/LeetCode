package 面试笔试.农行8_29;


/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/8/29 10:12 上午
 * @description :
 * @modified By  :
 */

public class Main {

    public String triCoding(int num) {
        String sNum = Integer.toString(num, 3);
        StringBuffer res = new StringBuffer();
        for (char a : sNum.toCharArray()) {
            if (a == '0') {
                res.append("@");
            } else if (a == '1') {
                res.append("$");
            } else if (a == '2') {
                res.append("&");
            }
        }
        return res.toString();
    }
}
