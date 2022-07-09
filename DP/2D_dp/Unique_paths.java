public class Unique_paths {

 /***
  * Problem: https://leetcode.com/problems/unique-paths/
  *
  *** From a[0,0] to reach a[m, n] how many unique paths are there?
  *   if m = 3 and  n = 7;
  *     then O/P = 28
  *** Constrains : I can move only RIGHT or BOTTOM
  * Approach :
 ***-> Try out all the possible way from staring point.. somthing like recusrsion...?
  * - From current position I will ask recursion to give the uniq paths from right and bottom 
  * - I will add those paths ans return it;
  *
  */
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        
      int [][] dp = new int[m][n];
        // return helper(m, n);
            
        System.out.println(helperTabu(m-1, n-1, dp));
        printDP(dp);
    }
    
    
    static void printDP(int dp[][]){
        
        for(int [] x: dp)
            System.out.println(Arrays.toString(x));
}
    
     // TC: O((m*n))  SC: O(m*n)[dp array]
    static int helperTabu(int r, int c, int dp[][]){
        // base case
        
        for(int i = 0; i <= r; i++){
            for(int j = 0; j <= c; j++){
                
                if(i == 0 && j == 0){// Found the path lol
                    dp[i][j] = 1;
                    continue;
                }
                
                
                int top = 0;
                int left = 0;
                
                if(r == 0 && c == 0) dp[i][j] = 1;
                
                if(i > 0) top = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];
                
                dp[i][j] = top+left;
                }
            }
        
        return dp[r][c];
            
        }
        
    
    
      // TC: O(m*n)  SC: O(Path)[stack] + O(m*n)[dp array]
    static int helper_memoiztion(int r, int c, int dp[][]){
        // base case
        if(r == 0 && c == 0)
            return 1;
        if(r <0 || c < 0) return 0;
        
        
        // converting  to DP - Memoization
        if(dp[r][c] != 0) return dp[r][c];
        
        // move top - Right
        int top = helper_memoiztion(r-1, c, dp);
        
        // move left - Bottom
        int left = helper_memoiztion(r, c-1, dp);
        
        return dp[r][c] = top+left;
        
        
    }
    
    
    // TC: O(2^(m*n)): Every cell has 2 paths |  SC: O(N)[stack]
    static int helper(int r, int c){
        // base case
        if(r == 1 || c == 1)
            return 1;
        
        int top = 0, left = 0;
        
        if( r >= 0)
             top = helper(r-1, c);
        
        // move left - Bottom
        
            left = helper(r, c-1);
        
        return top+left;
        
        
    }
}