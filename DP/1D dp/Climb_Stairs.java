public class Climb_Stairs {
    /*** Those who cannot remember the past.
     * Are condemmed to repeat it. 
     *                          - DP
     */
    /** Problem: 
     * https://leetcode.com/problems/climbing-stairs/
     * ***
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb 
     * the top?
     * ***
     * 
     * Approach: 
     *  Try all the possible ways to reach n, from 0 - Recu...
     *  For reach step I have 2 optio : 
     *      Take one step at a time
     *      Take two step at a time
     * Combine those steps and return the answer simple
     * 
     * As there is a overlaping subproblm I can use Dynamic Programmig
     * (Draw this on pen and paper and you'll get it)
     */
    public static void main(String[] args) {
     
        int n = 5;
        int dp[] = new int[n+1];

        System.out.println("Steps needed to reach : "+ n +" is :"+countStep(n, dp));
    }
    
    
    static int countStep(int n, int []dp){

        // base case
    if(n <= 1) return 1;
    
    // if ans already exist for any step return it
    if(dp[n] != 0) return dp[n];
       
    // store the the strps : from taking one ans two steps combined
     return dp[n] = (countStep(n-1, dp) + countStep(n-2, dp) );
        
    }
}
