package google.kickstart.round_e;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromicCrossword {
    static Scanner myObj;
    static int totalLettersChanged = 0;

    public static void main(String[] args) {
        myObj = new Scanner(System.in);  // Create a Scanner object
        // The first line of the input gives the number of test cases, T. T test cases follow.

        Integer numTestCases = getInputInt();
        for (int i = 0; i < numTestCases; i++) {
            String rowsAndColumnsString = getInputString();

            // The first line of each test case contains two integers, N and M, representing
            // the number of rows and columns in the crossword, respectively.
            String[] rowsAndColumns = rowsAndColumnsString.split(" ");
            int rowsN = Integer.parseInt(rowsAndColumns[0]);
            int colsM = Integer.parseInt(rowsAndColumns[1]);

            String[][] cw = new String[rowsN][colsM];

            /*
        The next N lines represent the N rows of the grid. The i-th row consists of M characters representing Ri,1, Ri,2, …, Ri,M. Each character is one of the following:
        A capital letter of the alphabet (A-Z)
        A period (.) for a missing letter (empty white cell in the example crossword)
        A hash (#) for black cell
             */
            for (int j = 0; j < rowsN; j++) {

                String line = getInputString();
                String[] chars = line.split("");

                for (int k = 0; k < colsM; k++) {
                    cw[j][k] = chars[k];
                }

            }

            // Figure out solution

            int solution = solve(cw);

            System.out.println("Case #" + (i + 1) + ": " + solution);


        }
    }

    private static int solve(String[][] cw_array) {
        /*
2
2 2
A.
.#
4 6
A...#.
B##...
B.###.
A...#.

         */

        // Find words going left to right horizontal and then vertical top to bottom

        CW cw = new CW(cw_array);

        /*
        While(puzzle is not solved) {
        Add allWords to queue.
        For each word in allWords
        1. Analyze the word
        2. Update neighbor words with intersecting letters that have been changed
        3. Add neighbor to queue
        End
        }
         */

        boolean canBeSolved = true;

        while (!cw.isSolved() && canBeSolved) {

            ArrayList<Word> allWords = cw.getAllWords();

            Queue<Word> queue = new ArrayDeque<>();

            queue.addAll(allWords);

            /*
            Need to know if any progress has been made after looking at all the words
             */
            int numberOfFilledInLetters = 0;

            /*
            Need to keep track of the length of the queue and keep a counter during poll()
            When we have poll()ed
             */

            int counter = 0;
            boolean isFirstTimeThrough = true;

            QUEUE_WHILE:
            while (!queue.isEmpty()) {
                if (counter > 0) {
                    counter--;
                } else {
                    // if it's the first time through, don't stop if numberOfFilledInLetters == 0
                    if (numberOfFilledInLetters == 0) {
                        if (isFirstTimeThrough) {
                            isFirstTimeThrough = false;
                        } else {
                            // This is not the first time and there's no new progress
                            // puzzle can't be solved
                            canBeSolved = false;
                            break QUEUE_WHILE;
                        }
                    }

                    // reset the counter
                    counter = queue.size();
                }


                // Get the next word
                Word wordToAnalyze = queue.poll();

                totalLettersChanged += wordToAnalyze.fillInLetters(cw);

                if (!wordToAnalyze.isSolved()) {
                    queue.add(wordToAnalyze);
                }

            }

        }

        return totalLettersChanged;
    }

    private static String getInputString() {
        return myObj.nextLine();
    }

    private static Integer getInputInt() {
        return Integer.parseInt(myObj.nextLine());
    }
}
