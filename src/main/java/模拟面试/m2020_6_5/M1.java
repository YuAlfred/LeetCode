package 模拟面试.m2020_6_5;

/**
 * @author : ty
 * @version : 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * @date : Created in 2020/6/5 22:20
 * @description :
 * @modified By  :
 */
public class M1 {

    public static void main(String[] args) {
        M1 M1 = new M1();
        int[] B = M1.sortedSquares(new int[]{-4, -1, 0, 3, 10});

        for (int b : B) {
            System.out.print(b + ",");
        }


    }

    public int[] sortedSquares(int[] A) {

        int[] B = new int[A.length];
        int p_i = 0;

        //正负交界的位置（0或正）
        int p_zero = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                p_zero = A.length - 1;
            }
            if (A[i] >= 0) {
                if (i > 0 && A[i - 1] + A[i] > 0){
                    p_zero = i-1;
                }else {
                    p_zero = i;
                }
                break;
            }
        }

        B[p_i] = (int) Math.pow(A[p_zero], 2);
        p_i++;

        int p_negative = p_zero, p_positive = p_zero;

        while (p_negative - 1 >= 0 && p_positive + 1 < A.length) {
            if (A[p_negative - 1] + A[p_positive + 1] >= 0) {
                B[p_i] = (int) Math.pow(A[p_negative - 1], 2);
                p_i++;
                p_negative--;
            } else {
                B[p_i] = (int) Math.pow(A[p_positive + 1], 2);
                p_i++;
                p_positive++;
            }
        }

        while (p_negative - 1 >= 0) {
            B[p_i] = (int) Math.pow(A[p_negative - 1], 2);
            p_i++;
            p_negative--;
        }

        while (p_positive + 1 < A.length) {
            B[p_i] = (int) Math.pow(A[p_positive + 1], 2);
            p_i++;
            p_positive++;
        }

        return B;
    }


}
