public class House_robber {

    /*
    Problem : https://leetcode.com/problems/house-robber/
    ***Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

    Question is similar to:
    Maximun sum of array, 
    constrain: cannot pick two adjacent items

    Pattern: 
    1. Represent the problem according to Indexces
    2. Do all the stuffs with that indexwa
    3. Return max or min or sum ;
    
    
    Approach: 
    
    1. Try out all the ways (Recursion) and give the maximun one { TLE  T.C = O(2^N)}
    2. Dynamic Programming way 
        i) Mamoization : T.C = O(n)  S.C = O(n)[stack] + O(n)[dp array]
        ii) Tabulation : T.C = O(n)  S.C = O(n)[dp array]
    
    */

    public static void main(String[] args) {

         int [] nums = {1,2,3,1};
            
        // return rob_rec(nums, nums.length -1);
        
//         int dp [] = new int[nums.length];
        
//         for(int i = 0; i < nums.length ; ++i) dp[i] = -1;
        
//         return rob_memo(dp, nums, nums.length-1);
        
        
//           int dp [] = new int[nums.length];
        
//         for(int i = 0; i < nums.length ; ++i) dp[i] = 0;
        
//         return rob_tabu(dp, nums);
        
        System.out.println(rob_cons(nums));
}
    
    
     // T.C = O(n)  S.C = O(1)
    static int rob_cons(int [] nums){
        int prev = nums[0]; 
        int prev2 = 0;
        
        for(int i = 0 ; i< nums.length ; ++i){
            
            int fs = nums[i] + (i > 1 ? prev2 : 0);
            int curr = Math.max(fs, prev);
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
    
    
     // T.C = O(n)  S.C = O(n)[dp array]
    static int rob_tabu(int [] dp, int [] nums){
        
        // base case as per memoization
        dp[0] = nums[0];
        
        for(int i = 1; i < nums.length ; ++i){
            // pick the one and not the adjecent one
            int pick = nums[i] + (i > 1 ? dp[i-2] : 0);
                
            // pic the next one and not the current 
            int not_pick = 0 + dp[i-1];
            
            // store max till now
            dp[i] = Math.max(pick, not_pick);
            
        }
        // max residens at the end;
        return dp[nums.length-1];
    }
    
    
    
        // T.C = O(n)  S.C = O(n)[stack] + O(n)[dp array]
      static int rob_memo(int [] dp, int [] nums, int indx){
        
        // base case
        if(indx == 0 )
            return nums[indx];
        // index can be -1 sometimes
        if(indx < 0) return 0;
          
          // DP solution
          
          if ( dp[indx] != -1) return dp[indx];
        
        // Recerence relationship
        
        // pick the current one and not the next one
        int pick = nums[indx] + rob_memo(dp, nums, indx-2);
        
        // not pick the current one and pick the next one
        int not_pick = 0 + rob_memo(dp, nums, indx-1);
        
        
        return dp[indx] = Math.max(pick, not_pick);
        
    }
    
    static int rob_rec(int [] nums, int indx){
        
        // base case
        if(indx == 0 )
            return nums[indx];
        // index can be -1 sometimes
        if(indx < 0) return 0;
        
        // Recerence relationship
        
        // pick the current one and not the next one
        int pick = nums[indx] + rob_rec(nums, indx-2);
        
        // not pick the current one and pick the next one
        int not_pick = 0 + rob_rec(nums, indx-1);
        
        
        return Math.max(pick, not_pick);
        
    }
    
}
