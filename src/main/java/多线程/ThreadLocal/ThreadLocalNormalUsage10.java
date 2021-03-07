package 多线程.ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/7 3:25 下午
 * <p>
 * <p>
 * <p>
 * 演示ThreadLocal用法二：避免传参
 */
public class ThreadLocalNormalUsage10 {

    public static void main(String[] args) {
        new Service1().process();
    }


}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

//生成User对象，类似web中的过滤器，每个请求都要经过他
class Service1 {

    public void process() {
        User user = new User("haha");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }

}


//其他服务
class Service2 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service 2: " + user.getUserName());
        new Service3().process();
    }

}

//其他服务
class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service 3: " + user.getUserName());
    }

}


class User {
    String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}