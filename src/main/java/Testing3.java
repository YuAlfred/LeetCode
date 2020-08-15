import java.util.*;

public class Testing3 {


    public static class Car {
        int x;
        int y;

        public Car(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        PriorityQueue<Car> A = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
        PriorityQueue<Car> B = new PriorityQueue<>(Comparator.comparingInt(o -> o.y));

        int totalA = 0, numA = 0;
        int totalB = 0, numB = 0;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(sc.nextInt(), sc.nextInt());
        }
        for (Car car : cars) {
            if (car.x > car.y) {
                if (numA < a) {
                    A.add(car);
                    totalA += car.x;
                    numA++;
                    continue;
                } else {

                }
            }


        }


    }
}