package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/21 10:32 下午
 * @description : 面试题 16.07. 最大数值
 * @modified By  :
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * <p>
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class M16_7_easy_最大数值 {

    public int maximum(int a, int b) {
        long k = ((long) a - b) >>> 63;
        return (int) (b * k + a * (k ^ 1));
    }
}
