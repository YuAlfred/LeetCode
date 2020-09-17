package 面试笔试.字节跳动.挑战字符串;

/**
 * @author : ty
 * @version : 字符串相乘
 * @date : Created in 2020/6/7 17:34
 * @description : 1.0.0
 * @modified By  :
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class M4 {

    public static void main(String[] args) {
        M4 m = new M4();
        System.out.println(m.multiply("082", "092"));
    }

    public String multiply(String num1, String num2) {

        if (num1.isEmpty() || num2.isEmpty()) {
            return "";
        }

        /**
         * 存储结果，位数最高不超过两个乘数位数之和
         */
        char[] result = new char[num1.length() + num2.length()];
        //赋值每位为0
        for (int i = 0; i < result.length; i++) {
            result[i] = '0';
        }

        for (int i = num1.length() - 1; i >= 0; i--) {

            //进位
            int add = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = result[i + j + 1] - '0' + multi + add;

                result[i + j + 1] = (char) (sum % 10 + '0');
                add = sum / 10;
            }

            result[i] += add;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != '0' ) {
                return String.copyValueOf(result, i, result.length - i);
            }
        }

        return "0";
    }
}
