package 多线程.轮流打印;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/22 2:49 下午
 * 三个线程，轮流依次打印，每次打印三个数，到36为止
 */
public class Main {

    static int type = 1;
    static int num = 1;

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (Main.class) {
                while (num <= 36) {
                    if (type == 1) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + num++);
                        }
                        type = 2;
                        Main.class.notifyAll();
                    } else {
                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (Main.class) {
                while (num <= 36) {
                    if (type == 2) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + num++);
                        }
                        type = 3;
                        Main.class.notifyAll();
                    } else {
                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (Main.class) {
                while (num <= 36) {
                    if (type == 3) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName() + " " + num++);
                        }
                        type = 1;
                        Main.class.notifyAll();
                    } else {
                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

