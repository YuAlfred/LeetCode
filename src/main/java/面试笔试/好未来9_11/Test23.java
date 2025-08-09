package 面试笔试.好未来9_11;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/11 6:00 下午
 * @description :
 * @modified By  :
 */


import java.util.*;

public class Test23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        Map<Character, Integer> map = new HashMap<>();
        for (char a : s.toCharArray()) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
                if (map.get(a) == 3){
                    System.out.println(a);
                    return;
                }
            }
        }
        System.out.println("没有出现三次的字符");
    }
}
