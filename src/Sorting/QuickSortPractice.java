package Sorting;

public class QuickSortPractice {

    public static void main(String[] args) {
        int [] arr = new int[] {4, 6, 2, 5, 7, 9, 1, 3};
        quickSortPractice(arr, 0, arr.length - 1);
        for(int i: arr){
            System.out.print(i + " ");
        }

    }

    public static void quickSortPractice(int []arr, int low, int high) {

        if(low < high){

            int partitionIndex = findPivot(arr, low, high);
            quickSortPractice(arr, low, partitionIndex - 1);
            quickSortPractice(arr, partitionIndex + 1, high);
        }
    }

    public static int findPivot(int[] arr, int low, int high){

        int pivotEle = arr[low];
        int i = low;
        int j = high;

        while (i < j){

            while (arr[i] <= pivotEle && i<=high){
                i++;
            }

            while (arr[j] > pivotEle && j>= low){
                j--;
            }

            if(i < j){
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
