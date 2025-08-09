package 每日打卡;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2021/1/1 11:02
 * @description : 605. 种花问题
 * @modified By  :
 * <p>
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */
public class M605_easy_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        int emp = 1;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 1) {
                emp = 0;
            } else {
                if (emp > 0 && flowerbed[i + 1] == 0) {
                    res++;
                    emp = 0;
                } else {
                    emp++;
                }
            }
        }
        if (emp > 0 && flowerbed[flowerbed.length - 1] == 0) {
            res++;
        }
        return res >= n;
    }
}
