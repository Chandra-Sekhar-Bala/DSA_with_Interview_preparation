import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class NQueen {

    public static void main(String[] args) {

        int [][] board = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
        };

        nQueen(board, 0);
    }

    static void nQueen(int [][] board, int r){

        // base case
        if(r == board.length){

            for(int [] x : board){

                System.out.println(Arrays.toString(x));
            }
            System.out.println();
            return;
        }

        // Placing the queen
        for (int col = 0; col < board.length; col++) {

            // check if we can place queen at current position!
            if(isSafe(board,r,col)){

                // plce the queen
                board[r][col] = 1;

                // check for below ans 
                nQueen(board, r+1);

                // clear changes - Backtrack
                board[r][col] = 0;
            }
            
        }
    }

    static boolean isSafe(int [][] board, int row, int col){

        // check for the column
        int r = 0;
        while(r < row){
            if(board[r][col]==1){
                return false;
            }
            r++;
        }

        // check for left diagonal 
        r = row;
        int c = col;

        while(r>=0 && c >=0){
            
            if(board[r][c] == 1){
                return false;
            }
            r--; c--;
        }

        // check for right diagonal 
        r = row;
        c = col;

        while(r >= 0 && c < board.length){
            
            if(board[r][c] == 1){
                return false;
            }
            r--; c++;
        }

        return true;
    }
    
}
