package 面试笔试.花旗银行10_7;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/10/7 20:36
 * @description :
 * @modified By  :
 */
public class T4 {

    public String solution(String s, int K) {
        String[] week = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int day = 0;
        if (s.equals(week[1])) {
            day += 1;
        } else if (s.equals(week[2])) {
            day += 2;
        } else if (s.equals(week[3])) {
            day += 3;
        } else if (s.equals(week[4])) {
            day += 4;
        } else if (s.equals(week[5])) {
            day += 5;
        } else if (s.equals(week[6])) {
            day += 6;
        }
        day += K;
        day = day % 7;
        return week[day];
    }
}
