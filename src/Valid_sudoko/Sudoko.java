package Valid_sudoko;

import WordPattern.WordPattern;

/**
 * Created by namrataojha on 5/15/16.
 */
public class Sudoko {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if ( m[ (board[i][j] - '1')]) {
                        return false;
                    }
                    m[ (board[i][j] - '1')] = true;
                }
            }
        }

        //check each row
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (m[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        m[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        char[][] grid = {{'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                        {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '8', '7', ',', '.', '.', '.', '3', '1'},
                        {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                        {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                        {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
                        {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                        {'.', '.', '5', '2', '.', '6', '3', '.', '.'}};
        Sudoko s = new Sudoko();
        System.out.println(s.isValidSudoku(grid));

    }
}
