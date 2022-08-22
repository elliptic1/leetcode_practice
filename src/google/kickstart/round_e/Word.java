package google.kickstart.round_e;

import java.util.Arrays;

public class Word {
    private String[] data;
    private int startRow;
    private int startCol;
    private WordType type;

    public Word(String[] data, int row, int col, WordType type) {
        this.data = data;
        this.startRow = row;
        this.startCol = col;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Word{" +
                "data=" + Arrays.toString(data) +
                ", startRow=" + startRow +
                ", startCol=" + startCol +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Word)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Word w = (Word) obj;

        return toString().equals(w.toString());
    }

    public void update(String[][] cw) {
        if (type == WordType.HORIZONTAL) {
            for (int i = 0; i < data.length; i++) {
                data[i] = cw[startRow][startCol + i];
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                data[i] = cw[startRow + i][startCol];
            }
        }
    }

    /*
    returns the number of filled in letters
     */
    public int fillInLetters(CW cw) {

        System.out.println("Filling in " + cw);

        boolean progressMade = false;
        int lettersFilledIn = 0;

        /*
        When the word is all empty letters, there's no analysis to be done.
         */
        if (isAllEmpty()) {
            return 0;
        }

       /*
       If any on one side are known that are not on the other side, fill them in
        */

        for (int i = 0; i < data.length; i++) {
            if (!data[i].equals(data[data.length-1-i])) {
                lettersFilledIn++;
                progressMade = true;
                System.out.println("progress made");
                if (getType(i) == SquareType.LETTER) {
                    data[data.length-1-i] = data[i];
                } else {
                    data[i] = data[data.length-1-i];
                }
            }
        }

        // Replace data in cw with data from data
        if (progressMade) {
            if (type == WordType.HORIZONTAL) {
                for (int i = 0; i < data.length; i++) {
                    cw.setLetter(startRow, startCol + i, data[i]);
                }
            } else {
                for (int i = 0; i < data.length; i++) {
                    cw.setLetter(startRow + i, startCol, data[i]);
                }
            }
        }

        return lettersFilledIn;

    }

    private Boolean isAllEmpty() {
        for (int i = 0; i < data.length; i++) {
            if (!isEmpty(i)) {
                return false;
            }
        }
        return true;
    }

    private SquareType getType(int i) {
        if (isKnown(i)) {
            return SquareType.LETTER;
        }
        if (isEmpty(i)) {
            return SquareType.EMPTY;
        }
        if (isBlack(i)) {
            return SquareType.BLACK;
        }
        throw new IllegalStateException("didn't recognize symbol " + data[i]);
    }

    private Boolean isKnown(int i) {
        return data[i].matches("[A-Z]");
    }

    private Boolean isEmpty(int i) {
        return data[i].equals(".");
    }

    private Boolean isBlack(int i) {
        return data[i].equals("#");
    }

    private String getLetter(int i) {
        return data[i];
    }

    public Boolean isSolved() {
        for (int i = 0; i < data.length; i++) {
            if (getType(i) != SquareType.LETTER) {
                return false;
            }
        }
        return true;
    }

}
