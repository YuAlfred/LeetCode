package 每日打卡;

import java.math.BigInteger;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 483. 最小好进制
 * @date: 2021/6/18 4:00 下午
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 * <p>
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 * 示例 2：
 * <p>
 * 输入："4681"
 * 输出："8"
 * 解释：4681 的 8 进制是 11111。
 * 示例 3：
 * <p>
 * 输入："1000000000000000000"
 * 输出："999999999999999999"
 * 解释：1000000000000000000 的 999999999999999999 进制是 11。
 *  
 * <p>
 * 提示：
 * <p>
 * n的取值范围是 [3, 10^18]。
 * 输入总是有效且没有前导 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-good-base
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M483_hard_最小好进制 {

    public static void main(String[] args) {
        M483_hard_最小好进制 m = new M483_hard_最小好进制();
        m.smallestGoodBase("15");
    }

    public BigInteger MAX_LONG = new BigInteger(String.valueOf(Long.MAX_VALUE));

    public String smallestGoodBase(String n) {
        BigInteger bn = new BigInteger(n);
        BigInteger res = bn.subtract(BigInteger.ONE);
        String bin = "111";
        while (new BigInteger(bin, 2).compareTo(bn) <= 0) {
            long l = 2, r = bn.longValue();
            while (l <= r) {
                long mid = (l + (r - l) / 2);
                BigInteger bigMid = new BigInteger(String.valueOf(mid));
                BigInteger temp = paresLong(bin, bigMid);
                int compareRes = temp.compareTo(bn);
                if (compareRes == 0) {
                    res = res.compareTo(bigMid) > 0 ? bigMid : res;
                    break;
                } else if (compareRes > 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            bin = bin + "1";
        }

        return res.toString();

    }

    public BigInteger paresLong(String bin, BigInteger radix) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < bin.length(); i++) {
            res = res.add(radix.pow(i));
            if (res.compareTo(MAX_LONG) > 0) {
                return res;
            }
        }
        return res;
    }


}
