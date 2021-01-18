package 每日打卡;

import java.util.*;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/1/18 12:06
 * @description : 721. 账户合并
 * @modified By  :
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *  
 * <p>
 * 提示：
 * <p>
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M721_middle_账户合并 {

    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Integer> emailIntegerMap = new HashMap<>();
        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailNameMap.put(email, name);
                if (!emailIntegerMap.containsKey(email)) {
                    emailIntegerMap.put(email, count++);
                }
            }
        }
        int n = emailNameMap.keySet().size();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<Integer, List<String>> res = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 2; i < account.size(); i++) {
                union(emailIntegerMap.get(account.get(i - 1)), emailIntegerMap.get(account.get(i)));
            }
        }
        for (Map.Entry<String, Integer> entry : emailIntegerMap.entrySet()) {
            int i = entry.getValue();
            String email = entry.getKey();
            int root = findRoot(i);
            List<String> list = res.getOrDefault(root, new LinkedList<>());
            list.add(email);
            res.put(root, list);
        }
        List<List<String>> lRes = new LinkedList<>();
        for (List<String> list : res.values()) {
            Collections.sort(list);
            list.add(0, emailNameMap.get(list.get(0)));
            lRes.add(list);
        }
        return lRes;
    }

    public int findRoot(int key) {
        while (parent[key] != key) {
            parent[key] = parent[parent[key]];
            key = parent[key];
        }
        return key;
    }

    public void union(int a, int b) {
        parent[findRoot(b)] = findRoot(a);
    }
}
