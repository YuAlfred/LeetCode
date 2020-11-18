package 每日打卡;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 318. 最大单词长度乘积
 * @date: 2020/11/18 4:41 下午
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M318_middle_最大单词长度乘积 {

    public static void main(String[] args) {
        M318_middle_最大单词长度乘积 m = new M318_middle_最大单词长度乘积();
        m.maxProduct(new String[]{"ccd", "accaceddeeeaefc", "bcaffa", "bbcfafbb", "accacfebbabbeedfbfdb", "beddecbffcdaededdaefdedfdea", "cf", "ddafdcbd", "bbafacebacaefdaffccebddff", "ebccffcddbeddccacceccaec", "becfbfdccdfdeadfbfaddbcded", "cbabeaaeabefedbaeaedc", "dfadbbdbead", "cafaefdcd", "eccdbfceafeeeacfcddc", "dbabbcdbb", "abfbfbffcbebde", "cfaadaa", "fc", "faebcabb", "adbacebabcaaccbdeaffff", "aeaefccf", "dbacbeeabdbcdfccabebaecfef", "ecdadeefcaddffaececffa", "defcabf", "abbcecbccbdaebaecaefabed", "dfeeebcbaaefc", "aecccbcbbdddb", "dcfabacec", "fccfbacbacddeaaea", "dfdbfacbacbecb", "cbfeebdbfecb", "cffaacacbde", "aafd", "bdcebbbebd", "afeffadcfcdacfba", "dafeefbcdfaffcfacee", "dcbbebfbedafedcdbab", "cafaf", "bcbcccfdebdd", "efaaaacccff", "cffbead", "ebcfccfcddffdec", "fffdfdcec", "beeafefbdfa", "cdfdbccfbaaeffcabab", "ddadcbabbcb", "decfaeabbecebaebeaddedae", "cdcbfffbebae", "aeccefcbcbbddfdc", "ffefedaf", "cddbabccafaffeafeedcbedbdad", "eddeeccfedcefadfdfebfacb", "aca", "ffdcafaddcddf", "ef", "bbbbffe", "ffccfebabaadcffacbbb", "cbdeddfddffacbeeeebafebabda", "ddeecb", "cffdc", "edcffcebadf", "becbcadcafddcfbbeeddbfffcab", "abcbaceeaeaddd", "cfeffceebfaeefadaaccfa", "eaccddb", "caeafbfafecd", "becaafdbaadbfecfdfde", "ecabaaeafbfbcbadaac", "bdcdffcfaeebeedfdfddfaf", "dbbfbaeecbfcdebad", "cceecddeeecdbde", "beec", "adbcfdbfdbccdcffffbcffbec", "bbbbfe", "cdaedaeaad", "dadbfeafadd", "fcacaaebcedfbfbcddfc", "ceecfedceac", "dada", "ccfdaeffbcfcc", "eadddbbbdfa", "beb", "fcaaedadabbbeacabefdabe", "dfcddeeffbeec", "defbdbeffebfceaedffbfee", "cffadadfbaebfdbadebc", "fbbadfccbeffbdeabecc", "bdabbffeefeccb", "bdeeddc", "afcbacdeefbcecff", "cfeaebbbadacbced", "edfddfedbcfecfedb", "faed", "cbcdccfcbdebabc", "efb", "dbddadfcddbd", "fbaefdfebeeacbdfbdcdddcbefc", "cbbfaccdbffde", "adbcabaffebdffad"});
    }

    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int bit = 0;
            for (char a : words[i].toCharArray()) {
                bit |= (1 << (a - 'a'));
            }
            nums[i] = bit;
        }
        int res = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}



















