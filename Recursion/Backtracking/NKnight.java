import java.util.Arrays;
/**
 * Similar to N-Queen lol
 */

public class NKnight {
    
    static int count;
    public static void main(String[] args) {


        int [][] board = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        };
        solveKnight(board, 0, 0, board.length);
        System.out.println("Till now: "+ count);
        count = 0;
        // solveKnightX(board, 0, board.length);
        System.out.println("now: "+ count);
        
    }

    static void solveKnight(int [][] board, int row,int col, int knight){
        // base case
        if(knight == 0){
            count++;
            System.out.println(count);

            for(int [] x: board){
                System.out.println(Arrays.toString(x));
            }
            System.out.println();

            return;
        }

        if(row == board.length) return;

        if(col == board.length){
            solveKnight(board, row+1, 0, knight);
            return;
        }

        if(row == board.length-1 && col == board.length) return;

        // recursive 
        if(isSafe(board, row, col)){
            board[row][col] = 1;
            solveKnight(board, row, col+1, knight-1);
            board[row][col] = 0;// backtrack
        }

        solveKnight(board, row, col+1, knight);
    }

    static void solveKnightX(int [][] board, int row,int knight){
        // base case
        if(knight == 0){
            count++;

            for(int [] x: board){
                System.out.println(Arrays.toString(x));
            }
            System.out.println();

            return;
        }

        if(row == board.length) return;


        for(int c = 0; c < board.length ; ++c){
            if(isSafe(board, row, c)){
                board[row][c] = 1;
                solveKnightX(board, row+1, knight-1);
                board[row][c] = 0;

            }
        }

        solveKnightX(board, row+1, knight);

    }

    private static boolean isSafe(int[][] board, int row, int col) {

        // is valid check

        if(isValid(board, row-2, col+1)){

            if(board[row-2][col+1] == 1){
                return false;
            }
        }
    
        
        if(isValid(board, row-2, col-1)){

            if(board[row-2][col-1] == 1){
                return false;
            }
        }

        if(isValid(board, row-1, col-2)){

            if(board[row-1][col-2] == 1){
                return false;
            }
        }

        if(isValid(board, row-1, col+2)){

            if(board[row-1][col+2] == 1){
                return false;
            }
        }


        return true;
    }

    static boolean isValid(int [][] board, int row, int col){

    // System.out.println(row + ","+col+ " -> "+((row >= 0 && row < board.length) && (col >= 0  && col < board.length)));

        return ((row >= 0 && row < board.length) && (col >= 0  && col < board.length));

    }
    
    
}
