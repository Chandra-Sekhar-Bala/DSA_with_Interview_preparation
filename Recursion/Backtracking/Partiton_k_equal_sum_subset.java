public class Partiton_k_equal_sum_subset{

    /**
     * Problem link : https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     * Given an integer array nums and an integer k, return true if it is possible to 
     * divide this array into k non-empty subsets whose sums are all equal.
     * 
     * Input: nums = [4,3,2,3,5,2,1], k = 4
     * Output: true
     *  (5), (1, 4), (2,3), (2,3) with equal sums.
     * 
     * 
     * Approach:
     * I have to fill k bucket with the target of (sum/k);
     * Constrains: Elements can be taken only once, 
     * I have to try out all the possible ways : Yes recusrion
     * Solve:
     *  1. At each step I will take(is possible) and not_take 
     *      Hence if I'm taking it, it should be marked as taken
     *  2. If ans Is found run the same for k-1th ans;
     * 
     */
    public static void main(String[] args) {
        
        int nums[] = {2,1,4,5,6};
        int k = 3;

        System.out.println(canPartitionKSubsets(nums, k));
    }

    static boolean canPartitionKSubsets(int[] nums, int k) {
        
        int n = nums.length;
        // N numbers cannno be divided into N+1 right?
        if(k > n ) return false;
        
        // n numbers can be divided into n pieces
        // if(k == n) return true;
        
        int sum = 0;
        
        for(int x : nums)
             sum += x;

        // if summ is not even it can't be partitioned into k;
        if(sum % k != 0 ) return false;
        
        int target = sum/k;
        
        boolean [] taken = new boolean[n];
        
        return helper(nums, 0, target, k, 0, taken);
    }

     static boolean helper_solve(int nums[], int sum, int target, int k, int curr_i, boolean[] taken){

    // base cases
        // if k-1 nums are there : k'th ans is also there
        if(k == 1) return true;
        
    if(sum == target)
     return helper_solve(nums, 0, target, k-1, 0, taken);
        
    if(sum > target || curr_i >= nums.length ) return false;
        
        
      // recursive case
        for(int i = 0; i < nums.length ; ++i){

        if( !taken[i] ){
            
            // first marked that ive taken it
             taken[i] = true;
            
            // if this indx gives me ans potential ans then let it be marked as visited and return for another one
             if(helper_solve(nums, sum + nums[i] , target, k, i+1 , taken))
                return true;
            
            // backtrack
              taken[i] = false;
            }
        }
    
    return false;
    }
    
    
    // Getting TLE
    static boolean helper(int nums[], int sum, int target, int count, int i, boolean[] taken){
     
        // k numbers of subset have been genereted
        if(count == 0) return true;
        
        // found one ans now find again untill k
        if(sum == target){

            return helper(nums, 0, target, count-1, 0, taken);
        }
        
        
        // exceeding case
        if(i >= nums.length || sum > target) return false;
        
        
        // it's taken? : move to next one
        if(taken[i]){
            
            return helper(nums, sum, target, count, i+1, taken);
        }
               
        // taking the current one
        
        taken[i] = true;
        boolean take = helper(nums, sum + nums[i], target, count, i+1, taken);
        
        // if this i'th one gives me answer then it shound be taken in future !!
        taken[i] = take;
        
        boolean not_take = helper(nums, sum , target, count, i+1, taken);
        
        return take || not_take;
    }
}
//Remove this while you do squash
