package W8_16;

/**
 * @author : ty
 * @version :
 * @date : Created in 2020/8/19 21:16
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Testing2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int n = in.nextInt();
        String[] guss = new String[n];
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            guss[i] = in.next();
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        in.close();

        char[] result = new char[p];
        for (int i = 0; i < p; i++) {
            result[i] = 'a';
        }

        while (add(result, result.length - 1)) {
            if (isRepeat(result)) {
                continue;
            }
            boolean non = true;
            for (int i = 0; i < n; i++) {
                if (getA(result, guss[i].toCharArray()) != a[i]) {
                    non = false;
                    break;
                }
                if (getB(result, guss[i].toCharArray()) != b[i]) {
                    non = false;
                    break;
                }
            }
            if (non) {
                System.out.println(result);
                return;
            }
        }
    }


    public static boolean add(char[] a, int n) {
        if (n == 0 && a[n] == 'z') {
            return false;
        }

        if (a[n] != 'z') {
            a[n] = (char) (a[n] + 1);
            return true;
        } else {
            if (add(a, n - 1)) {
                a[n] = 'a';
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isRepeat(char[] a) {
        Set<Character> set = new HashSet<>();
        for (char c : a) {
            if (set.contains(c)) {
                return true;
            } else {
                set.add(c);
            }
        }
        return false;
    }

    public static int getA(char[] a, char[] target) {
        int A = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target[i]) {
                A++;
            }
        }
        return A;
    }

    public static int getB(char[] a, char[] target) {
        int result = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target[i]) && i != map.get(target[i])) {
                result++;
            }
        }
        return result;
    }
}