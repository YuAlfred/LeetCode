package 模拟面试.m2020_6_5;

/**
 * @author : ty
 * @version : 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。  给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * @date : Created in 2020/6/5 23:10
 * @description :
 * @modified By  :
 */
public class M2 {

    public static void main(String[] args) {

    }

    public boolean checkPerfectNumber(int num) {

        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum ==0){
            return false;
        }

        return sum == num;

    }
}
