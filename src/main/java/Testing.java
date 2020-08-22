import java.util.*;

public class Testing {

    public static void main(String[] args) {
        String num = "51162119960621717";
        int mod = 0;
        mod += 7 * (num.charAt(0) - '0');
        mod += 9 * (num.charAt(1) - '0');
        mod += 10 * (num.charAt(2) - '0');
        mod += 5 * (num.charAt(3) - '0');
        mod += 8 * (num.charAt(4) - '0');
        mod += 4 * (num.charAt(5) - '0');
        mod += 2 * (num.charAt(6) - '0');
        mod += 1 * (num.charAt(7) - '0');
        mod += 6 * (num.charAt(8) - '0');
        mod += 3 * (num.charAt(9) - '0');
        mod += 7 * (num.charAt(10) - '0');
        mod += 9 * (num.charAt(11) - '0');
        mod += 10 * (num.charAt(12) - '0');
        mod += 5 * (num.charAt(13) - '0');
        mod += 8 * (num.charAt(14) - '0');
        mod += 4 * (num.charAt(15) - '0');
        mod += 2 * (num.charAt(16) - '0');

        mod %= 11;
        System.out.println(mod);
    }

}