import java.io.*;
import java.util.Scanner;

/**
 * @author : alfredt
 * @version : 1.0.0
 * @date : Created in 2019/9/25 10:36 下午
 * @description : 计算最大能力值
 * @modified By  :
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
        //创建Scanner读取系统输入
        Scanner reader = new Scanner(new InputStreamReader(System.in));
        //创建BufferedWriter输出答案
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        // 读取测试组数T
        int T = reader.nextInt();
        // 循环组数
        for (int t = 0; t < T; t++) {
            // 读取个数n
            int n = reader.nextInt();
            // 创建数组存放每天的失误次数
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = reader.nextInt();
            }
            // 三个变量 maxNum存放当前找到的最大能力值，preNum存放前一天的能力值，lastNum存放最后一天的能力值
            int maxNum = Integer.MIN_VALUE;
            int preNUm = 0;
            int lastNum = 0;
            // 从第一天开始循环直到最后一天
            for (int i = 0; i < n; i++) {
                // 暂存这一天计算出来的能力值,初始值为前一天的能力值
                int tempNum = preNUm;
                // 计算出每天的能力值，即前一天的能力值加上比今天失误少的天数减去比今天失误多的天数
                for (int j = i - 1; j >= 0; j--) {
                    // 如果前一天失误比今天少，能力值+1
                    if (a[j] < a[i]) {
                        tempNum++;
                    }
                    // 如果前一天失误比今天多，能力值-1
                    else if (a[j] > a[i]) {
                        tempNum--;
                    }
                }
                // 用今天的能力值覆盖前一天的能力值
                preNUm = tempNum;
                // 如果今天的能力值比最大的能力值还大，覆盖最大能力值
                if (tempNum > maxNum) {
                    maxNum = tempNum;
                }
                // 如果今天的能力值是最后一天的能力值，赋值最后一天的能力值
                if (i == n - 1) {
                    lastNum = tempNum;
                }
            }
            // 输出最大能力值和最后能力值
            writer.write(maxNum + " " + lastNum + "\n");
        }
        // 程序运行结束，输出答案，关闭reader
        writer.flush();
        writer.close();
        reader.close();
    }
}
