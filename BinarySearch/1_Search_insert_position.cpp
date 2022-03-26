/*
When binary search loop ends:

 1. the start pointer points the next smallest value I am lookin for [ if my targer is 6, start may be at 7]
 2. The end.low pointer points the prev max value I am looking for


35. Search Insert Position [https://leetcode.com/problems/search-insert-position/]
*/

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
    
        int start = 0, end = nums.size();;
       
        while (start < end){
            int mid = (start + end)/2;
            
            // if value found 
            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid] > target)
                
                end = mid;
            else 
                start = mid + 1;
            
        }
        return start; 

        // as the array was in ascending order - else I has to return end pointer
        
    }
};