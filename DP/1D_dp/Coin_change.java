public class Coin_change {

    /***
     *  https://leetcode.com/problems/coin-change/
     *
     * Approach: 
     * - Kinda like permutation problem -
     * - Where I get to choose all the elements inifnite time to form a sum i.e amount 
     * - 
     * At each step I have k options to choose from ( where k is the size of coins array)
     * Sudo code: 
     *  At each step I will run to loop to iterate over all the elements of coins 
     *  - I will subtract ' amount with i'th coin' 
     *  - Then ask the recusrion to give me the rest of ans
     * - Also, in loop i neede to compare between the current choices 
     *  So consided this choice as one step : so the mini = Min(mini, 1+ recursion())   
     *  
     * __ Base case: 
     * if ( amount ) is 0 means we've found our answer return 0 
     * 
     */
    public static void main(String[] args) {
        
    }

    static int solve_rec(int coins[], int amount){

       // int ans = helper_rec(coins, amount);;
        int dp [] = new int [amount+1];
        
        int ans  = helper_memo(coins, amount, dp); 
        
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;

        
    }
    
    
    // T.C: O(n * amount) SC: O(n) {amount}
     static int helper_tabu(int[] coins, int amount, int dp[]){
        
        // Bottom - up -> 
         dp[0] = 0;
                 
        for(int i = 0; i <= amount; ++i){
            for(int j = 1 ; j < coins.length ; ++j){
                dp [i] = Math.min(dp[i], dp[amount - dp[j]] );
            }
        }
         
         return dp[amount-1];
        
    
    }
    
    
    // T.C: O(n * amount) SC: O(n) {amount}
     static int helper_memo(int[] coins, int amount, int dp[]){
        
        //base case 
        if(amount == 0) return 0;
        
        // if it gets out of bound
        if(amount < 0 ) return Integer.MAX_VALUE;
         
         
         // dp sol 
         if(dp[amount] != 0) return dp[amount];
        
        int mini = Integer.MAX_VALUE;
        // k choise to make i.e length of array
         
        for(int i = 0;  i < coins.length; ++i){
            int ans = helper_memo (coins, amount - coins[i], dp);
            
            if(ans != Integer.MAX_VALUE)
                mini = Math.min(mini, ans + 1); // +1 cz it has be count as one step
        }
        
        return dp[amount] = mini;
    
    }
    
    static int helper_rec(int[] coins, int amount){
        
        //base case 
        if(amount == 0) return 0;
        
        // if it gets out of bound
        if(amount < 0 ) return Integer.MAX_VALUE;
        
        int mini = Integer.MAX_VALUE;
        // k choise to make i.e length of array
        for(int i = 0;  i < coins.length; ++i){
            
            int ans = helper_rec (coins, amount - coins[i]);
            
            if(ans != Integer.MAX_VALUE)
                mini = Math.min(mini, ans + 1); 
        }
        
        return mini;
    
    }
}