package 面试笔试.农行2021_9_13;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/13 2:59 下午
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 m = new Main2();
        System.out.println(m.check("car", "race"));
    }

    public boolean check(String s1, String s2) {
        Map<Character, Integer> s1CharNumberMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1CharNumberMap.put(c, s1CharNumberMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> s2CharNumberMap = new HashMap<>();
        int i = 0;
        while (i < s1.length()) {
            char c = s2.charAt(i);
            s2CharNumberMap.put(c, s2CharNumberMap.getOrDefault(c, 0) + 1);
            i++;
        }
        int l = 0, r = i;
        if (equals(s1CharNumberMap, s2CharNumberMap)) {
            System.out.println("true");
            return true;
        }
        while (r < s2.length()) {
            char lc = s2.charAt(l);
            char rc = s2.charAt(r);
            s2CharNumberMap.put(lc, s2CharNumberMap.get(lc) - 1);
            s2CharNumberMap.put(rc, s2CharNumberMap.getOrDefault(rc, 0) + 1);
            if (equals(s1CharNumberMap, s2CharNumberMap)) {
                System.out.println("true");
                return true;
            }
            l++;
            r++;
        }
        System.out.println("false");
        return false;
    }

    public boolean equals(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.keySet().size() != m2.keySet().size()) {
            return false;
        }
        for (Character character : m1.keySet()) {
            if (!Objects.equals(m1.get(character), m2.get(character))) {
                return false;
            }
        }
        return true;
    }

}
