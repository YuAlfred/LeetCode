package 程序员面试经典;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2020/9/22 3:10 下午
 * @description : 面试题 16.10. 生存人数
 * @modified By  :
 * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
 * <p>
 * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
 * <p>
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 * 提示：
 * <p>
 * 0 < birth.length == death.length <= 10000
 * birth[i] <= death[i]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/living-people-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M16_10_middle_生存人数 {

    public static void main(String[] args) {
        maxAliveYear(new int[]{1972, 1908, 1915, 1957, 1960, 1948, 1912, 1903, 1949, 1977, 1900, 1957, 1934, 1929, 1913, 1902, 1903, 1901},
            new int[]{1997, 1932, 1963, 1997, 1983, 2000, 1926, 1962, 1955, 1997, 1998, 1989, 1992, 1975, 1940, 1903, 1983, 1969});
    }

    public static int maxAliveYear(int[] birth, int[] death) {
        int[] birthI = new int[101];
        int[] deathI = new int[101];
        for (int i = 0; i < birth.length; i++) {
            birthI[birth[i] - 1900]++;
            deathI[death[i] - 1900]++;
        }
        int max = 0, year = birth[0];
        int temp = 0;
        for (int i = 0; i < birthI.length; i++) {
            temp = (birthI[i] + temp);
            if (temp > max) {
                max = temp;
                year = i + 1900;
            }
            temp -= deathI[i];
        }
        return year;
    }
}













