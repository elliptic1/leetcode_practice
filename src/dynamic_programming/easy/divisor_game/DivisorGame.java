package dynamic_programming.easy.divisor_game;

import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DivisorGame {
    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.that(s.divisorGame(2) == true, "n = 2 failed");
        Assert.that(s.divisorGame(3) == false, "n = 3 failed");
        Assert.that(s.divisorGame(33) == false, "n = 33 failed");
    }
}

class Solution {

    HashMap<Integer, List<Integer>> divisorMemory = new HashMap<>();
    HashMap<Integer, Boolean> gameMemory = new HashMap<>();

    Boolean isAlicesMove = false;

    public boolean divisorGame(int N) {

        if (N <= 0) {
            throw new IllegalStateException("Non-positive input");
        }

        isAlicesMove = !isAlicesMove;

        log((isAlicesMove ? "Alice" : "Bob") + "'s move: " + N);

        if (N == 1) {
            log((isAlicesMove ? "Alice" : "Bob") + " loses");
            return !isAlicesMove;
        }

        if (gameMemory.containsKey(N)) {
            log("Current player wins: " + gameMemory.get(N));
            return isAlicesMove && gameMemory.get(N);
        }

        List<Integer> divisors;

        if (divisorMemory.containsKey(N)) {
            divisors = divisorMemory.get(N);
        } else {
            divisors = primeFactors(N);
            divisorMemory.put(N, divisors);
            log("put N: " + N + " divs " + divisors);
        }

        if (divisors.size() == 0) {
            gameMemory.put(N, false);
            return !isAlicesMove;
        }

        for (int d : divisors) {
            log("N = " + N + "  d = " + d);
            if (divisorGame(N - d) == isAlicesMove) {
                log(" - Chose " + (N - d));
                gameMemory.put(N, isAlicesMove);
                return isAlicesMove;
            }
        }

        log("");
        gameMemory.put(N, !isAlicesMove);
        return !isAlicesMove;

    }

    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    private void log(String s) {
        System.out.println(s);
    }
}

// 1. If there are no divisors, return false if alice's move, else true
