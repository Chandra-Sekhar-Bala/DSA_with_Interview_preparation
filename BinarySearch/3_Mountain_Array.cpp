#include<bits/stdc++.h>
using namespace std;
/*
    [3,4,5, 6 ,5,3,2]
    > There exist one element i which is greater then i+1 and i-1
    


    Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/


class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        // Question similar to 
        // Celling of a number in a sorted array
        
        
        if(arr.size() < 3) return -1;
        
      int start = 0;
      int end = arr.size() -1;
      
        while(start != end){
        
            int mid = start + (end-start)/2;
            
            
            if(arr[mid] > arr[mid+1])
                end = mid;
            // On descending part of the array
            // Mid maybe my answer but Ive to check for left side
                
            else if( arr[mid] < arr[mid+1])
                start = mid+1;
            // On the ascending part of the array so start sould move forward
                
        }
        return start;
        
    }
};