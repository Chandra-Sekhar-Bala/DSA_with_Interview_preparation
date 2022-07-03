import java.util.Arrays;

/*
 * 
 * 
 * 
 */

public class MazeProblem {
    public static void main(String[] args) {


        // System.out.println(Count(3, 3));

        int a[] [] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        boolean maze [][] = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        int [][] board = new int [maze.length][maze[0].length];

        System.out.println(Count(3, 7));
        // System.out.println(CountingPaths( "", a, 0, 0));
        // System.out.println(WithDiagonalPaths( "", a, 0, 0));
        // System.out.println("Totoal paths : "+printAllPath("",maze, a,0,0));
        // MatrixPath("", maze, board, a, 0, 0,1);
        
    }

     static void MatrixPath(String path, boolean[][]maze, int board[][],int [][] a, int r, int c, int step){ //

        if(! maze[r][c]){ // if this is already visited then fall back
            return ;
        }

        // Putting the step value :Here cz the last cell will also have values
        board[r][c] = step;
         
        if(r == a.length -1 && c == a[0].length-1 ){ // reach the last cell then print
          for(int []x : board){
            System.out.println(Arrays.toString(x));
          }
          System.out.println();
            return ;
        }

        // marking current pos as visited
        maze[r][c] = false;        

        if(r > 0 ){ // Top case
           MatrixPath(path+'T',maze,board, a, r-1, c, step+1);
        }

        if(c < a[0].length -1){ // right
            MatrixPath(path+'R',maze,board, a, r, c+1,step+1);
        }
       
        if(c > 0 ){ // Left case
           MatrixPath(path+'L',maze,board, a, r, c-1,step+1);
        }

        if(r < a.length -1){ // down
            MatrixPath(path+'D',maze,board, a, r+1, c,step+1);
        }

        // if(r < a.length -1 && c < a[0].length-1){ // Diagonal
        //    calls += printAllPath(path+'d',maze, a, r+1, c+1);
        // }
        
        // Backtracking part : Comeback and erase 
        // While coming back from down recurion calls all the changes that were made should be erased
        maze[r][c] = true;
        board[r][c] = 0;

       return;
    }

    static int printAllPath(String path,boolean[][]maze, int [][] a, int r, int c){ //

        if(!maze[r][c]){ // if this is already visited then fall back
            return 0;
        }

        if(r == a.length -1 && c == a[0].length-1 ){ // reach the last cell then print
            System.out.println(path);
            return 1;
        }

        // marking current pos as visited
        maze[r][c] = false;

        // totla paths count
        int calls = 0;

        if(r > 0 ){ // Top case
           calls += printAllPath(path+'T',maze, a, r-1, c);
        }

        if(c < a[0].length -1){ // right
            calls += printAllPath(path+'R',maze, a, r, c+1);
        }
       
        if(c > 0 ){ // Left case
           calls += printAllPath(path+'L',maze, a, r, c-1);
        }

        if(r < a.length -1){ // down
            calls += printAllPath(path+'D',maze, a, r+1, c);
        }

        // if(r < a.length -1 && c < a[0].length-1){ // Diagonal
        //    calls += printAllPath(path+'d',maze, a, r+1, c+1);
        // }
        
        // Backtracking part : Comeback and erase 
        // While coming back from down recurion calls all the changes that were made should be erased
        maze[r][c] = true;
       return calls;
    }




  // Shows the Actual path eg : dRRD || dd
    static int WithDiagonalPaths(String path, int [][] a, int r, int c){ //
        
        if(r == a.length-1 && c == a[0].length-1 ){
            System.out.println(path);
            return 1;
        }
        int total = 0;

        if(r < a.length-1 ){ // For going Down
            total += WithDiagonalPaths(path + 'D', a, ++r, c); --r;
        }

          if(c < a[0].length-1 && r < a.length-1){ // If reaches the edge cannot move diagonally 
            total += WithDiagonalPaths(path + 'd', a, ++r, ++c); --r; --c;
        }

        if(c < a[0].length-1 ){ // For going Right
            total += WithDiagonalPaths(path + 'R', a, r, ++c); --c;
        }

        return total;
    }


    
    // Shows the Actual path eg : DRRD
    static int CountingPaths(String path, int [][] a, int r, int c){ //
        
        if(r == a.length-1 && c == a[0].length-1 ){
            System.out.println(path);
            return 1;
        }
        int total = 0;

        if(r < a.length-1 ){ // For going Down
            total += CountingPaths(path + 'D', a, ++r, c); --r;
        }

        if(c < a[0].length-1 ){ // For going R
            total += CountingPaths(path + 'R', a, r, ++c); --c;
        }

        return total;
    }

    // Shows the Actual path eg : DRRD
    static int Counting(int [][] a, int r, int c){ //

        //if row or colum is at the end then only one way to reach destination
        if(r == a.length-1 || c == a[0].length-1 ){
            return 1;
        }

        // simple
        // int down = simpleMazeCount(r-1, c);
        // int right = simpleMazeCount(r, c-1);

        // Backtrack method
        int down = Counting (a, ++r, c); --r;
        int right = Counting (a,r, ++c); --c;

        return down + right;
    }

    static int Count(int r, int c){ // Only can move to right and down 

        //if row or colum is at the end then only one way to reach destination
        if(r == 1 || c == 1){
            return 1;
        }

        // simple
        // int down = simpleMazeCount(r-1, c);
        // int right = simpleMazeCount(r, c-1);

        // Backtrack method
        int down = Count(--r, c); ++r;
        int right = Count(r, --c); ++c;

        return down + right;
    }


    
}
