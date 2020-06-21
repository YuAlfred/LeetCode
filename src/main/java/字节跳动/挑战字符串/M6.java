package 字节跳动.挑战字符串;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/11 21:49
 * @description : 简化路径
 * @modified By  :
 * <p>
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * <p>
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 * <p>
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 * <p>
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */
public class M6 {

    public static void main(String[] args) {
        M6 m6 = new M6();
        System.out.println(m6.simplifyPath("/../"));
    }

    /**
     * 思路： 出入栈
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] splits = path.split("/");

        for (String s : splits) {
            switch (s) {
                case ".": {
                    continue;
                }
                case "..": {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                }
                case "":{
                    continue;
                }
                default: {
                    stack.push(s);
                }
            }
        }

        StringBuffer bf = new StringBuffer();

        if (stack.empty()){
            return "/";
        }
        while (!stack.empty()) {
            bf.insert(0, stack.pop());
            bf.insert(0, "/");
        }
        return bf.toString();

    }
}
