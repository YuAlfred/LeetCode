package 面试笔试.交通银行9_27;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : alfredt
 * @version :
 * @date : Created in 2020/9/27 3:31 下午
 * @description :
 * @modified By  :
 */
public class T2 {

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.graph_circle_checker("{(A->B),(B->C),(C->A)}"));
    }


    public Map<String, String> parent = new HashMap<>();

    public int graph_circle_checker(String graph_string) {
        graph_string = graph_string.trim().substring(1, graph_string.length() - 1);
        if (graph_string.isEmpty()) {
            return 0;
        }
        String[] sides = graph_string.split(",");
        for (String s : sides) {
            s = s.substring(1, s.length() - 1);
            int i = s.indexOf("->");
            String A = s.substring(0, i);
            String B = s.substring(i + 2);
            if (!parent.containsKey(A)) {
                parent.put(A, A);
            }
            if (!parent.containsKey(B)) {
                parent.put(B, B);
            }
            if (findRoot(A).equals(findRoot(B))) {
                return 1;
            }
            parent.put(findRoot(B), findRoot(A));
        }
        return 0;
    }

    public String findRoot(String a) {
        while (!parent.get(a).equals(a)) {
            a = parent.get(a);
        }
        return a;
    }

}
