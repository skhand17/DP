package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* Placing N Queens in N*N ChessBoard
*
* */
public class NQueens {

    public static List<List<String>> solveNQueens(int n){

        List<List<String>> result = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, result);
        return result;

    }

    public static void solve(int col, char[][]board, int[] leftRow,
                             int[] lowerDiagonal, int[] upperDiagonal, List<List<String>> result) {


//        base condition

        if(col == board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0; row< board.length; row++){
            if(leftRow[row] == 0 &&
                    lowerDiagonal[row + col] == 0 &&
                        upperDiagonal[board.length -1 + col - row] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col+1, board, leftRow, lowerDiagonal, upperDiagonal, result);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;

            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String args[]) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }
}
