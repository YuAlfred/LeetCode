package 面试笔试.农行2021_9_13;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/13 2:59 下午
 */
public class Main1 {

    public int ans = 0;

    public static void main(String[] args) {
        Main1 m = new Main1();
        System.out.println(m.numPossible("AABBCC"));
    }

    public int numPossible(String tiles) {
        dfs(tiles.toCharArray(), 0);
        System.out.println(ans);
        return ans;
    }

    public void dfs(char[] tiles, int index) {
        if (index >= tiles.length) {
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < tiles.length; i++) {
            if (used.contains(tiles[i])) {
                continue;
            } else {
                used.add(tiles[i]);
                ans++;
            }
            swap(tiles, i, index);
            dfs(tiles, index + 1);
            swap(tiles, i, index);
        }
    }

    public void swap(char[] tiles, int i, int j) {
        char c = tiles[i];
        tiles[i] = tiles[j];
        tiles[j] = c;
    }

}
