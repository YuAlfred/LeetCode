package 面试笔试.BOOS直聘2021_10_16;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/10/16 16:51
 * @description :
 */
public class M4 {

    public static void main(String[] args) {
        M4 m = new M4();
        System.out.println(m.smallest(100000));
    }

    public long smallest(long randomData) {
        String s = String.valueOf(randomData);
        return Long.valueOf(find(s));
    }

    public String find(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }
        char smallest = '9';
        for (char c : s.toCharArray()) {
            smallest = (char) Math.min(smallest, c);
        }
        char first = s.charAt(0);
        if (first == smallest) {
            return first + find(s.substring(1));
        } else {
            StringBuilder ans1b = new StringBuilder(s.substring(1));
            for (int i = 0; i < ans1b.length(); i++) {
                if (ans1b.charAt(i) > first) {
                    ans1b.insert(i, first);
                    break;
                }
                if (i == ans1b.length() - 1) {
                    ans1b.append(first);
                    break;
                }
            }
            StringBuilder ans2b = new StringBuilder(s);
            for (int i = ans2b.length() - 1; i >= 0; i--) {
                if (ans2b.charAt(i) == smallest) {
                    ans2b.deleteCharAt(i);
                    ans2b.insert(0, smallest);
                    break;
                }
            }
            String ans1 = ans1b.toString();
            String ans2 = ans2b.toString();
            return ans1.compareTo(ans2) > 0 ? ans2 : ans1;
        }
    }

}
