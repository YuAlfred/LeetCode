/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2019/9/17 3:44 下午
 * @description : 6. Z 字形变换
 * @modified By  :
 */
public class A006 {

    public String convert(String s, int numRows) {

//        如果只有一行
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
//        初始化
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
//            找到除数
            int divisor = numRows * 2 - 2;
//            找到当前字母编号除以除数的余数
            int remainder = i % divisor;
//            求出应该放到哪个数组
            int differ;
            if (remainder < divisor / 2) {
                differ = remainder;
            } else {
                differ = divisor - remainder;
            }
            sb[differ].append(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder temp : sb) {
            result.append(temp);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        Solution a = new Solution();
        String res = a.convert("abcdefghijklmnopqrst", 4);
        System.out.println(res);
    }


}

/**
 * 方法二 比方法一更快
 */
class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}

