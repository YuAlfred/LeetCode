package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/16 10:19 上午
 * @description : 面试题 05.04. 下一个数
 * @modified By  :
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closed-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M5_4_middle_下一个数 {


    public static void main(String[] args) {
        findClosedNumbers(571603719);
    }

    public static int[] findClosedNumbers(int num) {
        int[] res = new int[2];
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        while (sb.length() < 31) {
            sb.insert(0, "0");
        }
        char[] a = sb.toString().toCharArray();
        int oneNum = 0;
        int i = a.length - 1, j = 0;
        for (; i >= 0; i--) {
            if (a[i] == '1' && (i == 0 || a[i - 1] != '0')) {
                oneNum++;
                continue;
            }
            if (a[i] == '1') {
                a[i] = '0';
                a[i - 1] = '1';
                for (j = a.length - 1; j > i; j--) {
                    if (oneNum > 0) {
                        a[j] = '1';
                        oneNum--;
                    } else {
                        a[j] = '0';
                    }
                }
                res[0] = Integer.valueOf(new String(a), 2);
                break;
            }
        }
        if (res[0] == 0) {
            res[0] = -1;
        }
        oneNum = 0;
        a = sb.toString().toCharArray();
        i = a.length - 1;
        for (; i >= 0; i--) {
            if (a[i] == '1' && (i == a.length - 1 || a[i + 1] != '0')) {
                oneNum++;
                continue;
            }
            if (a[i] == '1') {
                oneNum++;
                a[i] = '0';
                for (j = i + 1; j < a.length; j++) {
                    if (oneNum > 0) {
                        a[j] = '1';
                        oneNum--;
                    } else {
                        a[j] = '0';
                    }
                }
                res[1] = Integer.valueOf(new String(a), 2);
                break;
            }
        }
        if (res[1] == 0) {
            res[1] = -1;
        }
        return res;
    }
}



