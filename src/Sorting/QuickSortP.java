package Sorting;

public class QuickSortP {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 6, 2, 5, 7, 9, 1, 8};
        int low = 0;
        int high = arr.length - 1;

        quickSort(arr, low, high);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {

        if(low < high){

            int partionIndex = findPivotCorrectPlace(arr, low, high);
            quickSort(arr, low, partionIndex - 1);
            quickSort(arr, partionIndex + 1, high);
        }
    }

    public static int findPivotCorrectPlace(int[] arr, int low , int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i<=high && arr[i] <= pivot){
                i++;
            }

            while (j >= low && arr[j] > pivot ){
                j--;
            }
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
