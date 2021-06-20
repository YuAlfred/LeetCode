package 每日打卡;

import java.util.List;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 1239. 串联字符串的最大长度
 * @date: 2021/6/19 12:14 上午
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1239_middle_串联字符串的最大长度 {


    public int maxLength(List<String> arr) {

        boolean[] showed = new boolean[26];
        int l = 0, r = 0;
        int res = 0, maxRes = 0;
        while (r < arr.size()) {
            String subString = arr.get(r);
            for (char c : subString.toCharArray()) {
                while (showed[c - 'a']) {
                    String preString = arr.get(l);
                    for (char c1 : preString.toCharArray()) {
                        showed[c1 - 'a'] = false;
                        res--;
                    }
                    l++;
                }
                showed[c - 'a'] = true;
                res++;
                maxRes = Math.max(res, maxRes);
            }
            r++;
        }
        return maxRes;
    }


}
