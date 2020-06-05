import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author ：ty
 * @date ：Created in 2019/3/15 23:17
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class A942 {

    public static int[] diStringMatch(String S) {
        int temp = 0;
        int i = 1;
        int N = S.length();
        int[] A = new int[N + 1];
        for (char a : S.toCharArray()) {
            if (a == 'I') {
                A[i] = i;
} else {
        temp = i;
        while (temp > 0 && S.charAt(temp - 1) != 'I') {
        A[temp] = A[temp - 1];
        temp--;
        }
        A[temp] = i;
        }
        i++;
        }
        return A;
        }

public static void main(String[] args) {
        System.out.println(ReflectionToStringBuilder
        .toString(diStringMatch("IDIDDDI"), ToStringStyle.MULTI_LINE_STYLE));
        }


        }
