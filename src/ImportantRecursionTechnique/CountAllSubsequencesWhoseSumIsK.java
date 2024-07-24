package ImportantRecursionTechnique;

public class CountAllSubsequencesWhoseSumIsK {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 1};
        int target = 2;

        int totalCount = count(arr, 0, 0, target);
        System.out.println(totalCount);

    }

    public static int count(int[] arr, int index, int sum, int target) {

        if(index == arr.length){

            if(sum == target){
                return 1;
            } else
                return 0;
        }

        sum += arr[index];
        int left = count(arr, index + 1, sum, target);

        sum -= arr[index];
        int right = count(arr, index + 1, sum, target);

        return left + right;
    }
}
