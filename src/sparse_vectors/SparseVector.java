package sparse_vectors;

import java.util.ArrayList;

class SparseVectorDotProduct {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,0,0,0,0,3,0,0,3,0,0,0};
        int[] nums2 = new int[]{0,0,2,0,0,4,3,0,0,2,0,0,0};
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }
}

class SparseVector {

    ArrayList<Integer> positions = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();

    SparseVector(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
           if (nums[i] != 0) {
               positions.add(i);
               values.add(nums[i]);
           }
        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int sum = 0;

        ArrayList<Integer> commonPositions = intersection(positions, vec.positions);

        for (int i : commonPositions) {
            int pi = positions.indexOf(i);
            int vpi = vec.positions.indexOf(i);
            sum += values.get(pi) * vec.values.get(vpi);
        }

        return sum;
    }

    public ArrayList<Integer> intersection(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i : al1) {
            if (al2.contains(i)) {
                intersection.add(i);
            }
        }
        return intersection;
    }
}

/*

Store positions and values for sparse array elements in two arrays

dot product:
1. Find the intersections of the positions ArrayLists
2. sum the product of values array entries at those indicies

 */
