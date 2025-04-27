/*Day 2: Move All Zeroes to End*/
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/move-all-zeroes-to-end-of-array0751*/


import java.util.Arrays;

class Main{

    public static void main(String[] args) {
        int[] arr = {3 ,5 ,0 ,0 ,4};
        pushZerosToEnd(arr);
    }

    static void pushZerosToEnd(int[] arr) {


        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}