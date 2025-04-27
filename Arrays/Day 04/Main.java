/*Day 4: Rotate Array */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/rotate-array-by-n-elements-1587115621 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateArr(arr, 2);
    }    

    static void rotateArr(int arr[], int d) {
        // add your code here

        /*Approach 1 */
        /*
        for(int i = 0; i < d; i++) {

            for(int j = 0; j < arr.length - 1; j++) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        */


        /*Approach 2 (Juggling Algorithm)*/
        /* 
        int n = arr.length;
        d = d % n;

        int cycle = gcd(n, d);
        System.out.println(cycle);

        for(int i = 0; i < cycle; i++) {

            int currIndex = i;
            int startElem = arr[i];
            int nextIndex = 0;
            while(true) {
                nextIndex = (currIndex + d) % n;

                if(nextIndex == i) {
                    break;
                } 
                arr[currIndex] = arr[nextIndex];
                currIndex = nextIndex;
                
            }
            arr[currIndex] = startElem;

        }
        */




        int n = arr.length;

        d = d % n;

        reverse(arr, 0, d - 1);
        reverse(arr, d  , n - 1);

        reverse(arr, 0, n -1);


        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr, int start, int end) {

        while(start <= end) {
            int temp  = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }


    static int gcd(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else if(b > a) {
                b = b - a;
            }
        }
        return a;
    }

}
