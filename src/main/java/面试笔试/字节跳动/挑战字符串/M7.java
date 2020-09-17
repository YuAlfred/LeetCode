package 面试笔试.字节跳动.挑战字符串;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2020/6/11 22:18
 * @description : 复原IP地址
 * @modified By  :
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class M7 {

    public static void main(String[] args) {
        M7 m7 = new M7();
        List<String> result = m7.restoreIpAddresses("000256");
        System.out.println("");
    }


    /**
     * 解题思路：递归
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        recursion(result, "", s, 0);
        return result;
    }

    public void recursion(List<String> l, String address, String s, int p) {

        if (p == 4 && s.isEmpty()) {
            l.add(address.substring(0, address.length() - 1));
            return;
        } else if (p == 4 || s.isEmpty()) {
            return;
        }

        //尝试在第一个数字后面加点

        recursion(l, address + s.substring(0, 1) + ".", s.substring(1), p + 1);

        //尝试在第二个数字后面加点
        //第一个数字不能为0且总长度大于2
        if (s.length() < 2 || s.charAt(0) == '0') {
            return;
        }
        //在第二个数字后面加点
        recursion(l, address + s.substring(0, 2) + ".", s.substring(2), p + 1);

        //尝试在第三个数字后面加点
        //第二个数字小于5，第三个数字小于5且总长度大于三且第一个数字小于2
        if (s.length() < 3 || s.charAt(0) > '2'|| (s.charAt(0) == '2' && s.charAt(1) > '5') || (s.charAt(0) =='2' && s.charAt(1) =='5' && s.charAt(2) > '5') ) {
            return;
        }

        //在第三个数字后面加点
        recursion(l, address + s.substring(0, 3) + ".", s.substring(3), p + 1);

    }

}
