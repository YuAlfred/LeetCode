package 面试笔试.华为2021_9_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/9/15 7:33 下午
 */
public class Main3 {

    static double maxPrice = 0;
    static List<Passenger> maxPath;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Passenger> passengers = new ArrayList<>(15);
        while (in.hasNext()) {
            String[] s = in.nextLine().split(",");
            passengers.add(new Passenger(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }
        in.close();

        List<Passenger> path = new ArrayList<>();
        dfs(passengers, path, 1);

        for (Passenger passenger : maxPath) {
            System.out.print(passenger.name + " ");
        }
    }

    public static void dfs(List<Passenger> passengers, List<Passenger> path, int index) {
        if (index > 5) {
            double count = 0;
            for (Passenger passenger : path) {
                count += passenger.price;
            }
            if (count > maxPrice) {
                maxPrice = count;
                maxPath = new ArrayList<>(path);
            }
            return;
        }
        // 选一个乘客上
        for (Passenger passenger : passengers) {
            if (passenger.from == index) {
                path.add(passenger);
                dfs(passengers, path, passenger.to);
                path.remove(path.size() - 1);
            }
        }
        // 或者不上
        dfs(passengers, path, index + 1);
    }

    static class Passenger {
        String name;
        int from;
        int to;
        double price;

        public Passenger(String name, int from, int to) {
            this.name = name;
            this.from = from;
            this.to = to;
            price = (to - from) * 100 * (1 - (to - from - 1) * 0.1);
        }
    }

}
