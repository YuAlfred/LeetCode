package 多线程.LRU;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author alfredt
 * @version 1.0.0
 * @description:
 * @date: 2021/3/7 1:19 下午
 */
public class LRUCache<K, V> {

    LinkedHashMap<K, V> cache = new LinkedHashMap<>();

    public void cache(K key, V value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() >= 3) {
            Iterator<K> it = cache.keySet().iterator();
            K first = it.next();
            cache.remove(first);
        }
        cache.put(key, value);
    }
    //
    // @Override
    // public Iterator iterator() {
    //
    //     Iterator<Map.Entry<K, V>> it = cache.entrySet().iterator();
    //     return new Iterator() {
    //         @Override
    //         public boolean hasNext() {
    //             return it.hasNext();
    //         }
    //
    //         @Override
    //         public Object next() {
    //             Map.Entry entry = it.next();
    //             return entry.getKey();
    //         }
    //     };
    // }


    public static void main(String[] argv) {
        LRUCache lru = new LRUCache<String, Integer>();
        lru.cache("A", 1);
        lru.cache("B", 2);
        lru.cache("C", 3);
        lru.cache("D", 4);


        lru.cache("C", 10);
        // System.out.println(
        //     "leave <-" +
        //         StreamSupport.stream(lru.spliterator(), false)
        //             .map(x -> x.toString())
        //             .collect(Collectors.joining("<-"))
        // );
        System.out.print("leave <- ");
        for (Object s : lru.cache.keySet()) {
            System.out.print((String) s + " <- ");
        }

    }


}
