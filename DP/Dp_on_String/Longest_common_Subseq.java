package DP.Dp_on_String;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Given two strings text1 and text2, return the length of their 
 * subsequence. If there is no common subsequence, return 0.
 * For example, "wace" is a subsequence of "abcde"
 *  output = 3 (ace)
 * 
 * Brute force: 
 *  I can genereate all the subseq of both strings. Save then and check for each which one of them 
 *  are matching and also the longest one : Exponential time + Extra space
 * 
 *** Optimized recursion solution:**
 *  - I have to generate all the possible subseq it is for sure!!
 *  - Then generate and check at them same time lol
 *  How ?:
 *  1. Keep two pointer i for String_1 and j for String_2
 *  2. If i'th char matches with j'the then move both pointer together
 *  3. If not matches :
 *      - There might be a case where i the mathces with j+1'th or vise-varse
 *      - Create 2 call (move i'th and not j'th) and (move j'th and not i'th);
 *** As I dont need all of calls sum I will return from where I'm getting cz adding them up 
 *    will be causing taking duplicate
 */
public class Longest_common_Subseq {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adbc";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    static public int longestCommonSubsequence(String text1, String text2) {
        int s1 = text1.length();
        int s2 = text2.length();
        
        int dp [][] = new int[s1+1][s2+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        
        // return solve( text1, s1, text2, s2, dp);
  return tabu(text1, s1, text2, s2);
        
    }
    
   static  int tabu(String s1, int i, String s2, int j){
        int dp[][] = new int [i+1][j+1];
        
        // base case covered by default lol
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
