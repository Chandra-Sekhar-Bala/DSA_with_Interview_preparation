public class MazeProblem {
    public static void main(String[] args) {

        // System.out.println(Count(3, 3));

        int a[] [] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        System.out.println(Counting(a, 0, 0));
        
    }

    static int Counting(int [][] a, int r, int c){

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

    static int Count(int r, int c){

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
