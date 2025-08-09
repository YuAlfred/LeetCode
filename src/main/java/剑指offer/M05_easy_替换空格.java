package 剑指offer;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/7/6 19:58
 * @description : 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @modified By  :
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M05_easy_替换空格 {

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

}
