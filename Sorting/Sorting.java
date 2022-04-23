import java.util.Arrays;

class Sorting{

    public static void main(String [] kichu){
        int [] arr = {6,5,4,3,7};
        BubbleSort(arr);
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

        
         for(int i = 0; i < n ; ++i){
             int maxIndex  = i;
             
             for(int j = 1; j < n-i; ++j)
                 if(arr[maxIndex] < arr[j])
                    maxIndex = j;

            swap(arr, maxIndex, n-i);

        }
    }
    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}