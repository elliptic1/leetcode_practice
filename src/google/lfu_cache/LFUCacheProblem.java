package google.lfu_cache;

import java.util.ArrayList;
import java.util.HashMap;

public class LFUCacheProblem {
    public static void main(String[] args) {
        LFUCache c = new LFUCache(0);

        // ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

        // [null,null,null,1,null,-1,3,null,-1,3,4]

        c.put(0, 0);
        c.get(0);

    }
}

class LFUCache {

    HashMap<Integer, Integer[]> cache;
    int timestamp;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(); // value, frequency, timestamp
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Integer[] v = cache.get(key);
            v[1] = v[1] + 1;
            v[2] = incTime();
            return v[0];
        } else {
            return -1;
        }
    }

    private int incTime() {
        return timestamp++;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Integer[] v;
        if (cache.containsKey(key)) {
            v = cache.get(key);
            v[0] = value;
            v[1] = v[1] + 1;
            v[2] = incTime();
        } else {

            if (cache.keySet().size() >= capacity) {

                ArrayList<Integer> lfu_keys = new ArrayList<>();
                int f = Integer.MAX_VALUE;
                for (int k : cache.keySet()) {
                    if (cache.get(k)[1] < f) {
                        f = cache.get(k)[1];
                    }
                }
                for (int k : cache.keySet()) {
                    if (cache.get(k)[1] == f) {
                        lfu_keys.add(k);
                        f = cache.get(k)[1];
                    }
                }
                int r = Integer.MAX_VALUE;
                int rk = 0;
                for (int k : lfu_keys) {
                    if (cache.get(k)[2] < r) {
                        r = cache.get(k)[2];
                        rk = k;
                    }
                }
                cache.remove(rk);
            }

            v = new Integer[3];
            v[0] = value;
            v[1] = 1;
            v[2] = incTime();
            cache.put(key, v);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */