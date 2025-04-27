/*Day 3: Reverse an Array*/
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/reverse-an-array */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reverseArray(arr);
    }    

    public static void reverseArray(int arr[]) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;   
            low++;
            high--;
        }

        System.out.println(Arrays.toString(arr));

    }
}
