package 每日打卡;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author alfred
 * @version 1.0.0
 * @date: 2024/10/7 21:28
 * @description: 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * <p>
 * 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面 positioni 英里处，并且有 fueli 升汽油。
 * <p>
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * <p>
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * <p>
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 1, startFuel = 1, stations = []
 * 输出：0
 * 解释：可以在不加油的情况下到达目的地。
 * 示例 2：
 * <p>
 * 输入：target = 100, startFuel = 1, stations = [[10,100]]
 * 输出：-1
 * 解释：无法抵达目的地，甚至无法到达第一个加油站。
 * 示例 3：
 * <p>
 * 输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * 输出：2
 * 解释：
 * 出发时有 10 升燃料。
 * 开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
 * 然后，从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
 * 并将汽油从 10 升加到 50 升。然后开车抵达目的地。
 * 沿途在两个加油站停靠，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target, startFuel <= 109
 * 0 <= stations.length <= 500
 * 1 <= positioni < positioni+1 < target
 * 1 <= fueli < 109
 */
public class M871_hard_最低加油次数 {

    /**
     * @param target    目的地位置
     * @param startFuel 初始油量
     * @param stations  stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面 positioni 英里处，并且有 fueli 升汽油。
     * @return 最低加油次数
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            // 没油可加
            return target <= startFuel ? 0 : -1;
        }

        if (target <= startFuel) {
            // 不用加油就能到，剪枝
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int totalFuel = startFuel;
        int ret = 0;
        for (int[] station : stations) {
            int position = station[0];
            int fuel = station[1];
            if (totalFuel < position) {
                // 这个加油站走不到，要加油了
                while (totalFuel < position && !queue.isEmpty()) {
                    ret++;
                    int store_fuel = queue.poll();
                    totalFuel += store_fuel;
                }
            }

            // 加完油还是不够就完啦
            if (totalFuel < position) {
                return -1;
            }

            // 把这个加油站的油驾到有序队列里
            queue.offer(fuel);
        }

        if (totalFuel >= target) {
            return ret;
        } else {
            while (totalFuel < target && !queue.isEmpty()) {
                ret++;
                int store_fuel = queue.poll();
                totalFuel += store_fuel;
            }
        }

        return totalFuel >= target ? ret : -1;
    }


}
