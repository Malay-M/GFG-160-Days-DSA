/*Day 10: Kadane's Algorithm */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/kadanes-algorithm-1587115620 */

class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));

    }

    static int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for(int i = 1; i < arr.length; i++) {

            maxEnding = Math.max(maxEnding+arr[i], arr[i]);

            res = Math.max(maxEnding, res);

        }

        return res;
        
    }
}