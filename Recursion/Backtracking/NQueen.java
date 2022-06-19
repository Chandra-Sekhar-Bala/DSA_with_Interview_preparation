import java.util.Arrays;

/*
 *** What is N-Queen?
 * - Given a NxN matrix - put a queen at each row. 
 *** Condition:
 *  -Queen can move  right, left and dialonally i,e One row can contaion one queen
 * Place the queen that way they do't eliminate themselves
 * 
 *** Thought prrocess: ***
 * -> Is there is need of recursion??
 *  Yes, as I can break it into smaller problem
 *      - I can place a queen at I'th row and move down, now worry about i-1 row and so on
 * 
 *** -> Parameters in recursion call?
 *  - The board and the row - col can be reduced with loop
 *  **-> Base case:
 *      - When my row exceeded the size ( row == board.length ), that means all queens has been placed
 *  
 *** -> Recursion call ?
 *  - Move column from 0 to size if the board.length.
 *  - At each position (row,col) check if it safe to place a queen here?
 *  - If (yes):
 *      place the queen here
 *      Break down the problmes to (row+1) ans so on
 *     *** Am i missing something?
 *          - Suppose the last row left to place queen. But the last row cannot contain a queen because of previous Queens position
 *            So I need to check for other place to put a queen i.e (current-1'th) row. But as I've already placed a queen, it
 *            will be ambiguous to put another one at the same row. That's why while we backtrack clear all the changes made by 
 *            that call;
 * 
 *          - While coming back from recusrion stack I've to remove queen from that position
 *  - else
 *      - Move on without making andy changes
 * 
 ***-> isSafe() function :
 *      - Current row will not have any Queen 
 *      - No need to check for below as queen hasen't been palced there yet
 *      - Chec for top columns, left and right diagonal :
 *          - Top cols : row 0 to current and col is current column
 *          - Right diagonal : row and column is decrested until any of them become 0
 *          - Left diagonal : row is decresed untill 0, and column is incresded unitil the last column 
 */

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
