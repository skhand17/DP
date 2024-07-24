package BackTracking.Practice;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray {

    public static void main(String[] args) {
        char[] arr = new char[]{'a','b','c'};
        List<List<Character>> resultant = generatePerm(arr);
        for(List<Character> li: resultant){
            System.out.println(li);
        }
    }

    public static List<List<Character>> generatePerm(char[] arr){
        List<List<Character>> resultant = new ArrayList<>();
        perms(arr, 0, resultant);
        return resultant;
    }

    private static void perms(char[] arr, int index, List<List<Character>> resultant) {

        if(index == arr.length){
            List<Character> list = new ArrayList<>();
            for(Character ch: arr){
                list.add(ch);
            }
            resultant.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(i, index, arr);
            perms(arr, index + 1, resultant);
            swap(i, index, arr);
        }
    }

    private static void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
