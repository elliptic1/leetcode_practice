package feb_challenge.number_of_one_bits;

import java.util.HashMap;


public class NumberOfOneBits {

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.hammingWeight(10));

    }

}

class Solution {

    HashMap<Integer, Integer> memory = new HashMap<>();

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        int count = 0;

        for (int i = 0; i<32; i++) {
            int temp = n;
            int bit = (temp >> i) & 1;
            if (bit == 1) {
                count++;
            }
        }

        memory.put(n, count);
        return count;

    }
}
