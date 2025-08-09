package 面试笔试.BOOS直聘2021_10_16;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/10/16 16:33
 * @description :
 */
public class M1 {

    public static void main(String[] args) {
        M1 m = new M1();
        System.out.println(m.railEncode("Hello, World!", 3));
    }

    public String railEncode(String data, int n) {
        StringBuilder[] sbs = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            sbs[i] = new StringBuilder();
        }
        int p = 0;
        int way = 1;
        for (int i = 0; i < data.toCharArray().length; i++) {
            sbs[p].append(data.charAt(i));
            p += way;
            if (p == n) {
                p = n - 2;
                way = -1;
            }
            if (p == -1) {
                p = 1;
                way = 1;
            }
        }
        String ans = "";
        for (StringBuilder sb : sbs) {
            ans += sb;
        }
        return ans;
    }

}
