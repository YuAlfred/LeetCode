package 每日打卡;

/**
 * @author : Alfred
 * @version : 1.0.0
 * @date : Created in 2021/11/14 17:15
 * @description : 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M677_middle_键值映射 {


    class MapSum {

        Dictionary root;

        public MapSum() {
            root = new Dictionary(0);
        }

        public void insert(String key, int val) {
            Dictionary cur = root;
            for (char c : key.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Dictionary(0);
                }
                cur = cur.next[c - 'a'];
            }
            cur.val = val;
        }

        public int sum(String prefix) {
            Dictionary cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.next[c - 'a'] == null) {
                    return 0;
                }
                cur = cur.next[c - 'a'];
            }
            return dfs(cur);
        }

        public int dfs(Dictionary root) {
            if (root == null) {
                return 0;
            }
            int ans = 0;
            for (Dictionary dictionary : root.next) {
                ans += dfs(dictionary);
            }
            ans += root.val;
            return ans;
        }
    }

    class Dictionary {
        Dictionary[] next = new Dictionary[26];
        int val;

        public Dictionary(int val) {
            this.val = val;
        }
    }

}
