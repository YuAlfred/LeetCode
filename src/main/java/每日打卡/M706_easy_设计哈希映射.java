package 每日打卡;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author alfredt
 * @version 1.0.0
 * @description: 706. 设计哈希映射
 * @date: 2021/3/14 2:38 下午
 */
public class M706_easy_设计哈希映射 {

    class MyHashMap {

        class Pair {
            int key;
            int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public void setKey(int key) {
                this.key = key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        int BASE_SIZE = 1009;
        LinkedList[] linkedLists;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            linkedLists = new LinkedList[BASE_SIZE];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            LinkedList<Pair> list = linkedLists[key % BASE_SIZE];
            if (list == null) {
                list = new LinkedList<>();
                linkedLists[key % BASE_SIZE] = list;
            }

            Iterator<Pair> it = list.iterator();
            Pair head;
            while (it.hasNext()) {
                head = it.next();
                if (head.key == key) {
                    head.value = value;
                    return;
                }
            }
            list.add(new Pair(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            LinkedList<Pair> list = linkedLists[key % BASE_SIZE];
            if (list == null) {
                list = new LinkedList<>();
                linkedLists[key % BASE_SIZE] = list;
            }

            Iterator<Pair> it = list.iterator();
            Pair head;
            while (it.hasNext()) {
                head = it.next();
                if (head.key == key) {
                    return head.value;
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            LinkedList<Pair> list = linkedLists[key % BASE_SIZE];
            if (list == null) {
                list = new LinkedList<>();
                linkedLists[key % BASE_SIZE] = list;
            }

            Iterator<Pair> it = list.iterator();
            Pair head;
            while (it.hasNext()) {
                head = it.next();
                if (head.key == key) {
                    it.remove();
                    return;
                }
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

}
