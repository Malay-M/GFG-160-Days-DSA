/*Day 12: Max Circular Subarray Sum */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/max-circular-subarray-sum-1587115620 */

class Main {
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        
        System.out.println(circularSubarraySum(arr));
    }

    public static int circularSubarraySum(int arr[]) {
        /*Approach 1 */
        /*
        int ans = 0;
        int n = arr.length;

        int suffixSum = arr[n-1];
        int[] maxSuffix = new int[n+1];
        maxSuffix[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--) {
            suffixSum = suffixSum + arr[i];
            maxSuffix[i] = Math.max(maxSuffix[i+1], suffixSum);
        }

        int circularSum = arr[0], normalSum = arr[0];
        int prefix = 0, currSum = 0;

        for(int i = 0; i < n; i++) {
            currSum = Math.max(currSum+arr[i], arr[i]);
            normalSum = Math.max(normalSum, currSum);

            prefix = prefix + arr[i];

            circularSum = Math.max(circularSum, prefix + maxSuffix[i+1]);
        }

        ans = Math.max(normalSum, circularSum);
        return ans;
        */

        
        /*Approach 2*/
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];
        int totalSum = 0;

        for(int i =0; i < arr.length; i++) {

            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum+arr[i], arr[i]);
            minSum = Math.min(currMinSum, minSum);

            totalSum = totalSum + arr[i];
        }

        int normalSum = currMaxSum;
        int circularSum = totalSum - minSum;

        if(normalSum == minSum) {
            return normalSum;
        }

        return Math.max(normalSum, circularSum);

    }
}