package path_crossing;

import java.util.HashSet;

public class PathCrossing {
    public static void main(String[] args) {
        Solution s = new Solution();

        String path = "NESWW";

        System.out.println(s.isPathCrossing(path));
    }
}

class Solution {
    public boolean isPathCrossing(String path) {

        int[] coords = new int[2];
        HashSet<String> cpath = new HashSet<>();
        cpath.add("0.0");

        for (String d : path.split("")) {
            switch (d) {
                case "N": {
                    coords[1]++;
                    break;
                }
                case "S": {
                    coords[1]--;
                    break;
                }
                case "E": {
                    coords[0]++;
                    break;
                }
                case "W": {
                    coords[0]--;
                    break;
                }
            }
            String key = coords[0] + "." + coords[1];
            if (cpath.contains(key)) {
                return true;
            } else {
                cpath.add(key);
            }
        }

        return false;
    }
}
