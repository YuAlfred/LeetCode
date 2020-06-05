
/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2019/9/17 8:34 下午
 * @description : 7. 整数反转
 * @modified By  :
 */
public class A007 {

    public static void main(String[] args) {
        A007 a = new A007();
        System.out.println(a.reverse(-2147483648));

        /*System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);*/
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
