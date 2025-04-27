/*Day 5: Next Permutation */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/next-permutation5226 */

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        
        int[] arr = {3, 4, 2, 5, 1};
        nextPermutation(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {

        int pivot = -1;
        for(int i = arr.length - 1; i > 0; i--) {

            if(arr[i] > arr[i-1]) {
                pivot = i-1;
                break;
            }
        }

        if(pivot == -1) {
            reverse(arr);
        } else {

            for(int i = arr.length -1; i > pivot; i--) {
                if(arr[i] > arr[pivot]) {
                    int temp = arr[i];
                    arr[i] = arr[pivot];
                    arr[pivot] = temp;
                    break;
                }
            }

            sort(arr, pivot);

        }

        

    }

    static void sort(int[] arr,int pivot) {
        
        for(int i = pivot+1; i < arr.length; i++) {
            for(int j = pivot+1; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    static void reverse(int[] arr) {
        int start = 0; 
        int end = arr.length - 1;

        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}