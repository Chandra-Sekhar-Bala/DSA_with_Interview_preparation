/*
I had to search for first and last occurence in a sorted array, hence I tried to:
    1. Made a method to find position and passed a boolen that do I need to find the last or first occurence.

    2. if(first):
            Then, if I got the value then end pointer will be at mid-1 [end = mid-1] (might have another same value before it)
        
        if( last) :
         start = mid +1 (last occurence of that value can be more)

34. Find First and Last Position of Element in Sorted Array
*/

  vector<int> searchRange(vector<int>& arr, int target) {
        
        vector<int> ans(2,-1);
        
        int first = binarySearch(arr, target, true);
        int last = binarySearch(arr, target, false);
        
        ans [0] = first;
        ans [1] = last;
        return ans;
        
    }
    
    int binarySearch(vector<int> arr, int target, bool firstPosition){

        int start = 0;
        int end = arr.size()-1;
        int ans = -1;
        while(start <= end ){
            int mid = start +(end - start) /2 ;
             
            if(target > arr[mid])
                 start = mid + 1;
           else if(target < arr[mid])
                end = mid -1 ;
            else 
            {
                ans = mid;
                
                if (firstPosition)
                    end = mid -1 ;
                else 
                    start = mid+1;
            }
        }
         return ans;
     }

