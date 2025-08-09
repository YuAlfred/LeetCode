package 面试笔试.农行2021_4_27;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/27 3:27 下午
 */
public class Main3 {


    public static void main(String[] args) {
        Main3 m = new Main3();
        System.out.println(m.encryption("hello", "234137"));
    }

    int indexKey = 0;


    public String encryption(String plaintext, String key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char a = plaintext.charAt(i);
            int numKey = nextKey(key);
            if (i % 2 == 0) {
                //偶数位置加
                if (a + numKey > 'z') {
                    a -= 26;
                }
                a += numKey;
            } else {
                //奇数为减少
                if (a - numKey < 'a') {
                    a += 26;
                }
                a -= numKey;
            }
            sb.append(a);
        }
        return sb.toString();
    }

    public int nextKey(String key) {
        int res = key.charAt(indexKey) - '0';
        indexKey++;
        if (indexKey >= key.length()) {
            indexKey = 0;
        }
        return res;
    }

}
