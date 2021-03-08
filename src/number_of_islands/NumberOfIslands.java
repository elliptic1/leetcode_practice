package number_of_islands;


import java.util.ArrayList;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] grid = new char[][]{
                {'1', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '0'}
        };

        System.out.println("Num of islands: " + s.numIslands(grid));
    }
}

class Solution {
    ArrayList<Integer> toBeVisited = new ArrayList<>();
    ArrayList<Integer> notVisited = new ArrayList<>();
    char[][] grid;
    int numberOfIslands = 0;
    int n = 0;
    int m = 0;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        for (int i = 0; i < m * n; i++) {
            if (isLand(i)) {
                notVisited.add(i);
            }
        }

        while (notVisited.size() > 0) {

            int a = notVisited.get(0);

            if (a >= 0) {
                System.out.println("Next island....");
                ++numberOfIslands;
                toBeVisited.add(a);
                notVisited.remove((Integer) a);
            }

            while (toBeVisited.size() > 0) {
                System.out.println("[while] toBeVisited is " + toBeVisited);
                toBeVisited.stream().findFirst().ifPresent(this::explore);
            }

        }

        return numberOfIslands;
    }

    // purpose: If we find a neighbor square that's land and not visited,
    // add it to the toBeVisited array
    private void explore(int i) {
        System.out.println("exploring " + i);
        int row = i % m;
        int col = i - row * n;

        System.out.println("toBeVisited: " + toBeVisited);
        System.out.println("notVisited: " + notVisited);
        System.out.println("removing " + i);
        toBeVisited.remove((Integer) i);
        notVisited.remove((Integer) i);

        // Left
        // Check if we are not on the left edge already:
        if (col != 0) {
            System.out.println("Left");
            maybeVisit(i - 1);
        }

        // Right
        if (col != n - 1) {
            System.out.println("Right");
            maybeVisit(i + 1);
        }

        // Top
        if (row != 0) {
            System.out.println("Top");
            maybeVisit(i - n);
        }

        // Bottom
        if (row != m - 1) {
            System.out.println("Bottom");
            maybeVisit(i + n);
        }

    }

    private void maybeVisit(int a) {
        System.out.println("maybe visit " + a);
        System.out.println("Not visited is " + notVisited);
        if (notVisited.contains(a)) {
            System.out.println(" - Adding " + a);
            toBeVisited.add(a);
        }
    }

    private boolean isLand(int i) {
        System.out.println("isLand i = " + i + ", m = " + m + ", n = " + n);
        int col = i % n;
        int row = (i - col) / n;
        System.out.println("row: " + row + ", col: " + col);

        return grid[row][col] == '1';
    }
}

/*

0 1 2 3 row 0
4 5 6 7 row 1
8 91011 row 2

i = row * 4 + col

ex: i=7, 1*4 + 3, row 1, col 3

i = row * n + col

given i = 7, 7 mod 4 is 3, 3 is col

row is (i - col) / n

 */
