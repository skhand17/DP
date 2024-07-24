package Sorting;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 2, 4, 1, 5, 6, 2 ,4};
        mergeSort(arr, 0, arr.length - 1);

        for(int i: arr){
            System.out.print(i + " ");
        }

    }

    public static void mergeSort(int[] arr, int low, int high){

        if(low == high)
            return;

        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[arr.length];
        int left = low;
        int right = mid + 1;
        int i=0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                i++;
                left++;
            } else {
                temp[i] = arr[right];
                i++;
                right++;
            }
        }

        while(left <= mid){
            temp[i] = arr[left];
            i++;
            left++;
        }

        while(right <= high){
            temp[i] = arr[right];
            i++;
            right++;
        }

        for(int j=low; j<=high; j++){
            arr[j] = temp[j - low];
        }

    }
}
