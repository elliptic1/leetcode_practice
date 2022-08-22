package google.kickstart.round_e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CW {
    private String[][] cw;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                sb.append(cw[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public CW(String[][] cw) {
        this.cw = cw;
    }

    private Integer rows() {
        return cw.length;
    }

    private Integer cols() {
        return cw[0].length;
    }

    public void setLetter(int i, int j, String letter) {
        cw[i][j] = letter;
    }

    public ArrayList<Word> getAllWords() {
        Set<Word> words = new HashSet<>();

        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                words.addAll(
                        getWordsAt(i, j)
                );
            }
        }

        return new ArrayList<>(words);

    }

    public ArrayList<Word> getWordsAt(int i, int j) {

        Set<Word> words = new HashSet<>();

        // edge case
        if (getType(i, j) == SquareType.BLACK) {
            return new ArrayList<>();
        }

        // search left and right starting at i,j
        int left_bound = j;
        int right_bound = j;

        if (left_bound > 0) {
            while (getType(left_bound - 1, right_bound) == SquareType.LETTER) {
                left_bound--;
            }
        }
        if (right_bound < cols() - 1) {
            while (getType(left_bound, right_bound + 1) == SquareType.LETTER) {
                right_bound++;
            }
        }

        if (right_bound - left_bound == 1) {
            return new ArrayList<>();
        }

        // Now we have left and right bounds for the word
        String[] letters = new String[right_bound - left_bound];
        for (int k = left_bound; k < right_bound; k++) {
            letters[left_bound - k] = cw[i][k];
        }
        Word horizontal_word = new Word(letters, i, left_bound, WordType.HORIZONTAL);

        words.add(horizontal_word);


        // search up and down starting at i,j
        int bottom_bound = i;
        int top_bound = i;

        if (bottom_bound > 0) {
            while (getType(bottom_bound - 1, top_bound) == SquareType.LETTER) {
                bottom_bound--;
            }
        }
        if (top_bound < cols() - 1) {
            while (getType(bottom_bound, top_bound + 1) == SquareType.LETTER) {
                top_bound++;
            }
        }

        if (top_bound - bottom_bound == 1) {
            return new ArrayList<>();
        }

        // Now we have bottom and top bounds for the word
        letters = new String[top_bound - bottom_bound];
        for (int k = bottom_bound; k < top_bound; k++) {
            letters[bottom_bound - k] = cw[i][k];
        }
        Word vertical_word = new Word(letters, top_bound, j, WordType.VERTICAL);

        words.add(vertical_word);


        return new ArrayList<>(words);
    }

    public SquareType getType(int i, int j) {
        if (isKnown(i, j)) {
            return SquareType.LETTER;
        }
        if (isEmpty(i, j)) {
            return SquareType.EMPTY;
        }
        if (isBlack(i, j)) {
            return SquareType.BLACK;
        }
        throw new IllegalStateException("didn't recognize symbol " + cw[i][j]);
    }

    public Boolean isKnown(int i, int j) {
        return cw[i][j].matches("[A-Z]");
    }

    public Boolean isEmpty(int i, int j) {
        return cw[i][j].equals(".");
    }

    public Boolean isBlack(int i, int j) {
        return cw[i][j].equals("#");
    }

    public String getLetter(int i, int j) {
        return cw[i][j];
    }

    public Boolean isSolved() {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                if (getType(i, j) == SquareType.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
