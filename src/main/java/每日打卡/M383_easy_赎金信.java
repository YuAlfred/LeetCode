package 每日打卡;

/**
 * @author : Alfred.T
 * @version : 1.0.0
 * @date : Created in 2021/12/4 0:46
 * @description : M1005_easy_K次取反后最大化的数组和
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 * <p>
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 * <p>
 * 如果可以构成，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M383_easy_赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteMap = new int[26];
        int[] magazineMap = new int[26];
        for (char c : ransomNote.toCharArray()) {
            ransomNoteMap[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magazineMap[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteMap[i] > magazineMap[i]) {
                return false;
            }
        }
        return true;
    }


}
