/*Day 9: Minimize the Heights II */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/minimize-the-heights3351 */

import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        
        int k = 2;
        int[] arr = {3,9,12,16,20};
        
        

        System.out.println(getMinDiff(arr, k));
    }

    static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        
        Arrays.sort(arr);

        int diff = arr[n-1] - arr[0];
        for(int i = 1; i < n; i++) {

            if(arr[i] - k < 0) {
                continue;
            }

            int minh = Math.min(arr[0] + k, arr[i] - k);

            int maxh = Math.max(arr[i-1] + k, arr[n-1] - k);

            diff = Math.min(diff, maxh - minh);

        }
        return diff;
    }


}