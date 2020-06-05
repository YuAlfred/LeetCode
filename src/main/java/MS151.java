/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/4/10 12:51 下午
 * @description : 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * @modified By  :
 */
public class MS151 {


    public static void main(String[] args) {
        MS151 m = new MS151();
        System.out.println(m.reverseWords("hello woled"));
    }

    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuffer bf = new StringBuffer();
        for (String item : array) {
            if (!item.isEmpty()) {
                bf.insert(0, item + " ");
            }
        }
        String result = bf.toString();
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

}
