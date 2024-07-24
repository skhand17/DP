package Sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 6, 2, 5, 7, 9, 1, 3};
        qs(arr, 0, arr.length - 1);

        for(int i: arr){
            System.out.print(i + " ");
        }
    }


    public static void qs(int[] arr, int low, int high) {

        if(low < high){

            int partitionIndex = findPivot(arr, low, high);
            qs(arr, low, partitionIndex - 1);
            qs(arr, partitionIndex + 1, high);
        }
    }

    private static int findPivot(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j= high;

        while(i < j){

            /*
            Trying to keep all elements lesser than the pivot on the left
            *
             */
            while(arr[i] <= pivot && i <= high){
                i++;
            }
            /*
            * Trying to keep all elements greater than the pivot on right
            * */
            while(arr[j] > pivot && j >= low){
                j--;
            }

            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
