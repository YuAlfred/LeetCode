package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/24 8:45 下午
 * @description : 面试题 16.08. 整数的英语表示
 * @modified By  :
 * 给定一个整数，打印该整数的英文描述。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/english-int-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_8_hard_整数的英语表示 {


    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String n = String.valueOf(num);
        int i = n.length();
        String s = "", last = "";
        while (i - 3 >= 0) {
            String tmp = threeNumber(n.substring(i - 3, i));
            if (tmp == null)
                tmp = "";
            else
                tmp = tmp + last;
            s = tmp + s;
            last = nextThree(last);
            i = i - 3;
        }
        if (i > 0) {
            String tmp = threeNumber(n.substring(0, i)) + last;
            s = tmp + s;
        }
        return s.substring(1);
    }

    String threeNumber(String n) {
        if (n.equals("000") || n.equals("00") || n.equals("0"))
            return null;
        String s = "";
        String tmp = null;
        if (n.length() == 3) {
            tmp = oneConvert(n.charAt(0));
            if (tmp != null) {
                s += " " + tmp + " Hundred";
            }
            tmp = convert(n.charAt(1));
            if (tmp != null) {
                if (!tmp.isEmpty())
                    s += " " + tmp;
                tmp = oneConvert(n.charAt(2));
                if (tmp != null)
                    s += " " + tmp;
            } else {
                tmp = tenConvert(n.charAt(2));
                s += " " + tmp;
            }
        } else if (n.length() == 2) {
            tmp = convert(n.charAt(0));
            if (tmp != null) {
                s += " " + tmp;
                tmp = oneConvert(n.charAt(1));
                if (tmp != null)
                    s += " " + tmp;
            } else {
                tmp = tenConvert(n.charAt(1));
                s += " " + tmp;
            }
        } else {
            tmp = oneConvert(n.charAt(0));
            if (tmp != null)
                s += " " + tmp;
        }
        return s;
    }

    String nextThree(String last) {
        switch (last) {
            case "":
                return " Thousand";
            case " Thousand":
                return " Million";
            case " Million":
                return " Billion";
            default:
                return "";
        }
    }

    String convert(char c) {
        switch (c) {
            case '1':
                return null;
            case '2':
                return "Twenty";
            case '3':
                return "Thirty";
            case '4':
                return "Forty";
            case '5':
                return "Fifty";
            case '6':
                return "Sixty";
            case '7':
                return "Seventy";
            case '8':
                return "Eighty";
            case '9':
                return "Ninety";
            default:
                return "";
        }
    }

    String tenConvert(char c) {
        switch (c) {
            case '1':
                return "Eleven";
            case '2':
                return "Twelve";
            case '3':
                return "Thirteen";
            case '4':
                return "Fourteen";
            case '5':
                return "Fifteen";
            case '6':
                return "Sixteen";
            case '7':
                return "Seventeen";
            case '8':
                return "Eighteen";
            case '9':
                return "Nineteen";
            default:
                return "Ten";
        }
    }

    String oneConvert(char c) {
        switch (c) {
            case '1':
                return "One";
            case '2':
                return "Two";
            case '3':
                return "Three";
            case '4':
                return "Four";
            case '5':
                return "Five";
            case '6':
                return "Six";
            case '7':
                return "Seven";
            case '8':
                return "Eight";
            case '9':
                return "Nine";
            default:
                return null;
        }
    }
}
