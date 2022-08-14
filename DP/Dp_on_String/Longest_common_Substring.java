package DP.Dp_on_String;

/**
 *  Same as L-C-Subseq
 * Approach : 
 *  Recustion : 
 *  It has to be contigious:
 *  I will keep a counter as if at any point it does not match then I can check if my current ans is greater then 
 * the rest of them or not?
 * 
 * 
 * // Tabulation:
 *  dp[i][j] -> I refers to the String_1 and j to then String_2 
 *  so if they match they has to be contigious and in do 2d array it has to be diagonal
 *  Solution:
 *   - Fill for only diagonal part
 *   - if ith char match witl jth then take the i-th and j-1th add 1 and save it to dp[i][j]
 *   - Keep an ans variable to sore the max answer on then go : Same for if you want to print 
 * 
 */

public class Longest_common_Substring {
    public static void main(String[] args) {
        String s1  =  "abcd";
        String s2 = "dbca";
        System.out.println(longestCommonSubstr(s1, s2)); 
    }   
    static int longestCommonSubstr(String s1, String s2){
        // code here
        int i = s1.length();
        int j = s2.length();
        int dp [][] = new int[i+1][j+1];
        
        // for(int x [] : dp)
        // Arrays.fill(x, -1);
        
        return solve(s1, s2, i, j, 0, dp);
        // return tabu(s1, s2, i, j);
    }
    
    static int tabu(String s1, String s2, int ind1, int ind2){
        int dp [][] = new int[ind1+1][ind2+1];
        int ans = 0;
        // for printing
        int row = 0, col = 0;
        for(int i = 1; i <= ind1; i++){
            
            for(int j = 1; j <= ind2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // ans = Math.max(ans, dp[i][j]);
                    if(ans < dp[i][j]){
                     ans =  dp[i][j];
                     row = i; 
                     col = j;
                    }
                }
            }
        }
        // print bro:
        StringBuilder str = new StringBuilder();
        while(dp[row][col] != 0){
            str.append(s1.charAt(row));
            row --;
            col --;
        }
        
        System.out.println("Longest Common Substring is : "+str.toString());
         
        return ans;
    }
    
    
    static int solve(String s1, String s2, int i, int j, int ct, int[][]dp){
        
        if(i == 0 || j ==0){
            return ct;
        }
        
        // if(dp[i][j] != 0) return dp[i][j];
        
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = Math.max(ct+1, solve(s1, s2, i-1, j-1, ct+1, dp));
         return dp[i][j] = Math.max(
            solve(s1,s2, i, j-1, 0, dp), 
            solve(s1, s2, i-1, j, 0, dp));
    }
}
