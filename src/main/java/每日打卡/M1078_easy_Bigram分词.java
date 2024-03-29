package 每日打卡;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/26 18:52
 * @description : 1078. Bigram 分词
 * <p>
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1078_easy_Bigram分词 {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new LinkedList<>();
        String[] words = text.trim().split(" ");
        for (int i = 1; i < words.length - 1; i++) {
            if (words[i].equals(second) && words[i - 1].equals(first)) {
                ans.add(words[i + 1]);
            }
        }
        return ans.toArray(new String[0]);
    }


}
