package 面试笔试.交通银行9_27;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/27 3:31 下午
 * @description :
 * @modified By  :
 */
public class T1 {


    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.find_prime(new Integer[]{3,5,11,12});
    }

    public Integer[] find_prime(Integer[] nums) {
        List<Integer> res = new LinkedList<>();
        for (Integer i : nums) {
            if (isPrime(i)) {
                res.add(i);
            }
        }
        return res.toArray(new Integer[res.size()]);
    }

    public boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
