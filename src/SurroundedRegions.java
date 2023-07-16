package src;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] checked = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !checked[i][j]) {
                    List<int[]> currPath = new ArrayList<>();
                    if (isSurrounded(board, i, j, checked, currPath)) {
                        for (int[] temp : currPath) {
                            board[temp[0]][temp[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, int x, int y, boolean[][] checked, List<int[]> currPath) {
        currPath.add(new int[]{x, y});
        checked[x][y] = true;

        boolean isSurrounded = x > 0 && x < board.length - 1 && y > 0 && y < board[x].length - 1;

        if (x > 0 && board[x - 1][y] == 'O' && !checked[x - 1][y]) {
            isSurrounded = isSurrounded(board, x - 1, y, checked, currPath) || isSurrounded;
        }

        if (x < board.length - 1 && board[x + 1][y] == 'O' && !checked[x + 1][y]) {
            isSurrounded = isSurrounded(board, x + 1, y, checked, currPath) || isSurrounded;
        }

        if (y > 0 && board[x][y - 1] == 'O' && !checked[x][y - 1]) {
            isSurrounded = isSurrounded(board, x, y - 1, checked, currPath) || isSurrounded;
        }

        if (y < board[x].length - 1 && board[x][y + 1] == 'O' && !checked[x][y + 1]) {
            isSurrounded = isSurrounded(board, x, y + 1, checked, currPath) || isSurrounded;
        }

        return isSurrounded;
    }
}
