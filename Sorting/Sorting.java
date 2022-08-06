import java.util.Arrays;

class Sorting{

    public static void main(String [] kichu){
        int [] arr = {7,6,5,3,4,2,1};
        // BubbleSort(arr);
        quick_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        
    }

    /*
    1. Bubble Sort
    At every step comparing adjacent elements
    At the end of the compare and swaping the largest element will be at the end.  */
    static void BubbleSort(int [] arr){
        int n = arr.length - 1;
        boolean isAsc;
        
        for(int i = 0; i < n; ++i){
            isAsc = false;
            for(int j = 1; j < n-i; ++j){
                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                    isAsc = true;
                }
            }
            // if no greater element found in the entire array means it is sorted
            if(!isAsc) return;
        }
    }

    static void SelectionSort(int [] arr){
        int n = arr.length - 1;
        /**
         *  Select an element and put it at it's right position
         */
         for(int i = 0; i < n-1 ; ++i){
             int maxIndex  = i;
             
             for(int j = 1; j < n-i; ++j)
                 if(arr[maxIndex] < arr[j])
                    maxIndex = j;

            swap(arr, maxIndex, n-i);

        }
    }

    /*
     * Not stable | In place (O(1)) 
     * This holds a emenet called pivot : any element
     * Intution : Move all the element great than  pivot ro right and smaller to left:
     * check for the left and right side of pivot     
     * 
     */
    static void quick_sort(int num[], int low, int hi){
        
        if(low >= hi)
            return;

        int s = low; 
        int e = hi;
        int mid = s + (e - s)/2;
        int pivot = num[mid];

        while( s <= e){
            // if array is alreay sort it will not sort it:
            while(num[s] < pivot) s++;
            while(num[e] > pivot) e--;

            if(s <= e){
                int temp = num[s];
                num[s++] = num[e];
                num[e--] = temp;
            }
        }
        // Pivot is at correct : sort the two halfs

        // Not sending **s+1 or e-1** cz suppose s and e was pointing at pivot and it swapped with it then s pointing to pivot+1 and end to pivot-1, if again do +1 or -1 that element is missing out!!!
        quick_sort(num, low, e); 
        quick_sort(num, s, hi);

    }


    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}