import java.util.Arrays;

/*
 * The traditional sudoku solver game
 * -
 *** Thougt process
 * -> At each call Im moving from every row and col
 * -> If any cell is containig 0 :
 *          1. Try to put any value from 0-9 if it is safe!!
 *          2. Get a callback from below recusrion calls that putting this value was a good choise or not 
 *          3. If yes that means sudoku is solved 
 *          4. Else backtrack : Remove that value and try another one
 * 
 * 
 * 
 */

public class SudokuSolver{
    public static void main(String[] args) {

       int [][] sudoku = { 
        {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
        {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
        {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
        {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
        {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };
        if(solveSudoku(sudoku)){
            printSudoku(sudoku);
        }else
        System.out.println("Canno be solved");
    }

    static boolean solveSudoku(int [][] board){


        for(int row = 0; row < board.length ; ++row){
            
            for(int col = 0; col < board.length ; ++col){

                if(board[row][col] == 0){
                    for( int num = 1; num <= 9 ; ++num){
                        if(isSafe(board, row, col, num)){
                        // safe to put or not?
                            board[row][col] = num;
                            // recursion call 
                            if(solveSudoku(board)){
                                return true;
                            }else{
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
               
            }
        }
        return true;
    }

    static void printSudoku(int [][] board){
        for(int [] x : board){
            System.out.println(Arrays.toString(x));
        }
    }

    static boolean isSafe(int [][] board, int row, int col, int value){


        // check for row  & column
        for (int i = 0; i < board.length; i++) {
            // for row
            if(board[i][col] == value){
                return false;
            }
            // for column
            if(board[row][i] == value){
                return false;
            }        
        }
    

        // The box 
        int sqrt = (int) Math.sqrt(board.length);
        int r = row - row % sqrt; 
        int c = col - col % sqrt;

        for(int i = r; i < r + sqrt; ++i){
            for(int j = c ; j < c + sqrt; ++j){
                    if(board[i][j] == value){
                        return false;
                    }   
                }
            }

        return true;
    
    }
}