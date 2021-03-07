package 多线程.LRU;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/7 1:19 下午
 */
public class LRUTest {

    public static void main(String[] args) {

    }

}

class LRU<K, V> {

    int max;
    LinkedHashMap<K, V> map;
    ReentrantLock lock;

    public LRU(int max) {
        this.max = max;
        map = new LinkedHashMap<>();
        lock = new ReentrantLock();
    }

    public void visit(K key, V value) {
        lock.lock();
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == max) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
        lock.unlock();
    }
}
