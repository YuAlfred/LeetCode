package 面试笔试.携程2021_4_1;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/4/1 6:59 下午
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String SPackage = in.nextLine();
        String[] packages = SPackage.split(" ");
        int[] price = new int[packages.length];
        for (int i = 0; i < price.length; i++) {
            price[i] = in.nextInt();
        }
        in.nextLine();
        String SValue = in.nextLine();
        String[] value = SValue.split(" ");
        in.close();

        int m = packages.length;
        Set<Integer>[] packageSet = new Set[m];
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (String s : packages[i].split(",")) {
                set.add(Integer.valueOf(s));
            }
            packageSet[i] = set;
        }
        Set<Integer> valueSet = new HashSet<>();
        Map<Integer, Boolean> selected = new HashMap<>();
        for (String s : value) {
            int i = Integer.valueOf(s);
            valueSet.add(i);
            selected.put(i, false);
        }

        dfs(packageSet, price, valueSet, selected, 0, 0);
        System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);

    }

    static int minCost = Integer.MAX_VALUE;

    public static void dfs(Set<Integer>[] packageSet, int[] price, Set<Integer> valueSet,
                           Map<Integer, Boolean> selected, int index, int curPrice) {

        //如果都包含了
        if (allIn(selected)) {
            minCost = Math.min(minCost, curPrice);
        }

        if (index >= packageSet.length) {
            return;
        }
        Set<Integer> curPackage = packageSet[index];
        boolean hasNeed = false;

        for (int i : curPackage) {
            if (selected.containsKey(i) && !selected.get(i)) {
                hasNeed = true;
                break;
            }
        }
        //不选
        dfs(packageSet, price, valueSet, selected, index + 1, curPrice);

        //选
        if (hasNeed) {
            Map<Integer, Boolean> newSelected = new HashMap<>(selected);
            for (int i : curPackage) {
                if (newSelected.containsKey(i) && !newSelected.get(i)) {
                    newSelected.put(i, true);
                }
            }
            dfs(packageSet, price, valueSet, newSelected, index + 1, curPrice + price[index]);
        }
    }

    public static boolean allIn(Map<Integer, Boolean> selected) {
        for (Boolean b : selected.values()) {
            if (!b) {
                return false;
            }
        }
        return true;
    }


}
