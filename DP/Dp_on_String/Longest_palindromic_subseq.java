package DP.Dp_on_String;
import java.util.Arrays;


/***
 * 
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Approach:
 *  Palindromic means : If we write it in reverse order it'll still be same.
 *  So if we reverse the string and check LCS of original ans reverse we'll get our answer
 *  
 * (Both common means : in straight and reverse order they haven't changed!! hence palindrome)
 */

public class Longest_palindromic_subseq {
    public static void main(String[] args) {
        
    }

    static public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        
        int dp [][] = new int[s1+1][s2+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        
        // return solve( text1, s1, text2, s2, dp);
        return tabu(text1, s1, text2, s2);
        
    }
    
    static int tabu(String s1, int i, String s2, int j){
        int dp[][] = new int [i+1][j+1];
        
        for(int ind = 0; ind <=i; ind++)
            dp[ind][0] = 0;
        
        for(int ind = 0; ind <=j; ind++)
            dp[0][ind] = 0;
        
        
        for(int ind1 = 1; ind1 <=i; ind1++){
            for(int ind2 = 1; ind2 <=j; ind2++){
        
                if(s1.charAt(ind1-1) == s2.charAt(ind2-1) )
                    dp[ind1][ind2] =  1 + dp[ind1-1][ind2-1];
                else
                dp[ind1][ind2] = Math.max(
                    dp[ind1-1] [ind2],
                    dp[ind1][ind2-1]);
                
            }
        }
        
         /*
        // printing LCS O(n+m)
        char [] lcs = new char[dp[i][j]];
        int indx = dp[i][j] -1;
        for(int n = i, m = j; n > 0 && m > 0; ){
            // if matches add to ans and move digonally
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                lcs[indx--] = s1.charAt(n-1);
                n --;
                m --;
            }
            // check prev row or col has greter value:
            
            else if(dp[n][m-1] > dp[n-1][m]) 
            // prev col > prev row:
                m--;
            
            // prev row > prev col:
            else n --;
        }
        
        System.out.println(lcs);
        */
        
        return dp[i][j];
    }
    static int solve(String s1, int ind1, String s2, int ind2, int [][]dp){
        if(ind1  == 0 || ind2 == 0)
            return 0;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        
        if(s1.charAt(ind1-1) == s2.charAt(ind2-1) )
            return dp[ind1][ind2] =  1 + solve(s1, ind1-1, s2, ind2-1, dp);
        
        return dp[ind1][ind2] = Math.max(
            solve(s1, ind1-1, s2, ind2, dp), 
            solve(s1, ind1, s2, ind2-1, dp));
    }
    
}
