package Sorting;

public class MergeSortPractice {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 5, 6, 1, 2, 7, 10, 6,8,9};
        msp(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i + " ");
        }

    }

    public static void msp(int[] arr, int low, int high) {

        if(low == high)
            return;
        int mid = (low + high)/2;
        msp(arr, low, mid);
        msp(arr, mid + 1, high);
        merge(arr, low , mid, high);

    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int leftPointer = low;
        int rightPointer = mid + 1;
        int[] temp = new int[arr.length];
        int i =0;
        while (leftPointer <= mid && rightPointer <=high) {

            if(arr[leftPointer] <= arr[rightPointer]){
                temp[i] = arr[leftPointer];
                i++;
                leftPointer++;
            } else {
                temp[i] = arr[rightPointer];
                i++;
                rightPointer++;
            }
        }

        while (leftPointer <= mid){
            temp[i] = arr[leftPointer];
            leftPointer++;
            i++;
        }

        while (rightPointer <= high){
            temp[i] = arr[rightPointer];
            rightPointer++;
            i++;
        }

        for(int k=low; k<=high; k++){
            arr[k] = temp[k - low];
        }
    }
}
