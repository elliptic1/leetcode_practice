package bitwise_manip.decode_xor_arr;


import java.util.Arrays;

public class DecodeXORArray {
    public static void main(String[] args) {

        Solution s = new Solution();

        int[] sln = s.decode(new int[]{6,2,7,3}, 4);

        System.out.println(Arrays.toString(sln));

    }
}

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] output = new int[encoded.length+1];

        output[0] = first;

        for (int i = 1; i < encoded.length+1; i++) {
            output[i] = encoded[i-1] ^ output[i-1];
        }

        return output;

    }
}


/*

`first` input will always be the first element of output array

encoded[i] = arr[i] XOR arr[i + 1]

encoded[i] ^ arr[i + 1] = arr[i]

    =>

arr[i + 1] = encoded[i] ^ arr[i]


 */