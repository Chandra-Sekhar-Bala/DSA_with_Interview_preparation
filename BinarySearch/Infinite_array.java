public class Infinite_array {
    public static void main(String [] args){
       
       int[] arr = {1,3,5,6,44,56,56,66,69,91,100};

       System.out.print("Position: "+infiniteSearch(arr,56));
    }

    static int infiniteSearch(int [] arr, int target){

        /*
        When full size was given we use n/2 untill 1: now just reverse the logic
        
        - start from the 2 and increase the size 
        - if my target is greater then end pointer go on moving end pointer
        
        */
        int start = 0;
        int end = 1;
        
        while(target > arr[end]) {
            int newStart = end+1;
            // end = previous + new chunk * 2
            end = end + (end - start + 1)*2;
            start = newStart;
        }
        return binarySearch(arr,target,start,end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        
        while(start <= end){
            int mid = start + (end-start) / 2;
            
            if(target < arr[mid]) // target lies on left
                end = mid -1;
            else if (target > arr[mid]) // target lies on right
                start = mid + 1;
            else 
                return mid; // ans found
        }
        return -1;
    }
}