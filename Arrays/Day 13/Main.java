/*Day 13: Smallest Positive Missing */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/smallest-positive-missing-number-1587115621 */

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};

        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        

        /*Approach 1*/
        /*
        int value = 1;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < value) {
                continue;
            }

            if(arr[i] == value) {
                value++;
            }

            if(arr[i] > value) {
                break;
            }
        }
        return value;
        */

        /*Approach 2 */
        /*
        int n = arr.length;
        boolean[] visit = new boolean[n];

        for(int i =  0; i < arr.length; i++) {

            if(0 < arr[i] && arr[i] <= n) {
                visit[arr[i]-1] = true;
            }

        }
        int i = 0;
        while(visit[i]) {
            i++;
        }
        return i+1;
        */

        /*Approach 3 (Cycle Sort) */

        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            
            while(0 < arr[i] && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {

                    int temp = arr[i];
                    arr[i] = arr[arr[i] - 1];
                    arr[temp - 1] = temp;
    
            }
        }
        int count = 1;
        for(int i = 0; i < n; i++) {
            if(arr[i] == count) {
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}