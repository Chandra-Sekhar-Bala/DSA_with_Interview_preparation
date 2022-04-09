#include<bits/stdc++.h>
using namespace std;
    
    int findPivot(vector<int> &arr){
        
        int start = 0;
        int end = arr.size()-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(mid < end && arr[mid] > arr[mid+1]) //gotcha
                return mid;
            
            else if(mid > start && arr[mid] < arr[mid-1]) // gotcha
                return mid-1;
            
            else if(arr[start] >= arr[mid]) // Mid pointing to 2nd half
                end = mid-1;
            
            else 
                start = mid +1; 
            // +1 because if mid would be my answer it won't be able to pass 
            // above 2 checks, so +1/-1
            
        }
        
        return -1;
           
    }
    
    int binarySearch(vector<int> &arr, int target,int start,int end){

         while(start <= end ){
            int mid = start +(end - start) /2 ;
        
            if(target > arr[mid])
                 start = mid + 1;
           else if(target < arr[mid])
                end = mid -1 ;
             else return mid;
         }
       
         return -1;
     }

     int search(vector<int>& arr, int target) {        
        
        // Pivot -> From where array started rotating 
        int pivot = findPivot(arr);
        int ans = 0;
        
        if(pivot == -1){
            // That means array is not rotated, need simple binary search 
            return binarySearch(arr, target, 0,arr.size()-1);
        }
        else{
            if(target >= arr[0])
                return binarySearch(arr, target, 0,pivot);
         else
             return binarySearch(arr, target, pivot+1, arr.size()-1);
        }
        
        return -1;
        
    }

int main(){
   vector<int> arr {1,2};
   cout << search(arr,2);
    return 0;
}