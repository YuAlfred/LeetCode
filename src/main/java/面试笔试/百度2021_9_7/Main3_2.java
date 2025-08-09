package 面试笔试.百度2021_9_7;

import java.util.*;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/7 7:31 下午
 */
public class Main3_2 {

    public static int mod = (int) (1e9 + 7);


    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        in.close();

        char[] cs = s.toCharArray();
        // 统计字母出现次数
        Map<Character, Integer> letterTimes = new HashMap<>();
        for (char c : cs) {
            letterTimes.put(c, letterTimes.getOrDefault(c, 0) + 1);
        }

        //  获得K个字母的可能组合
        List<Set<Character>> list = new ArrayList<>();
        getList(list, letterTimes.keySet().toArray(new Character[0]));

        int ans = 0;

        // 遍历组合
        for (Set<Character> letters : list) {
            int tempAns = 1;
            for (Character letter : letters) {
                tempAns *= getC(letterTimes.get(letter));
                tempAns %= mod;
            }
            ans += tempAns;
            ans %= mod;
        }
        System.out.println(ans);
    }


    public static void getList(List<Set<Character>> list, Character[] letters) {
        for (int i = 0; i < letters.length; i++) {
            for (int j = i + 1; j < letters.length; j++) {
                list.add(new HashSet<>(Arrays.asList(letters[i], letters[j])));
            }
        }
    }

    public static void swap(Character[] letters, int i, int j) {
        Character c = letters[i];
        letters[i] = letters[j];
        letters[j] = c;
    }

    public static int getC(int i) {
        int ans = 1;
        while (i > 0) {
            ans <<= 1;
            ans %= mod;
            i--;
        }
        return ans - 1;
    }
}
