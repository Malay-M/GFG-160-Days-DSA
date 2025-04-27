/*Day 1: Second Largest*/
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735 */

class Main {
    public static void main(String[] args) {
        
        int arr[] = {1,1,1,1};
        System.out.println(getSecondLargest(arr));

    }

    public static int getSecondLargest(int[] arr) {
        int max = -1, sMax = -1;
        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > max) {
                sMax = max;
                max = arr[i];
            } else if(arr[i] > sMax && max != arr[i]) {
                sMax = arr[i];
            }
        }
        return sMax;
    }
}