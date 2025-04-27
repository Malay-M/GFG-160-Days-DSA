/*Day 11: Maximum Product Subarray */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/maximum-product-subarray3604 */

class Main {

    public static void main(String[] args) {
        
        int[] arr = {-2, 6, -3, -10, 0, 2};

        System.out.println(maxProduct(arr));

    }

    static int maxProduct(int[] arr) {
        
        /*Approach 1 */
        /*
        int currMin = arr[0];
        int currMax = arr[0];
        int maxProduct = arr[0];

        for(int i = 1; i < arr.length; i++) {

            int temp = Math.max(arr[i], Math.max(currMin*arr[i], currMax*arr[i]));

            currMin = Math.min(arr[i], Math.min(currMin*arr[i], currMax*arr[i]));
            currMax = temp;

            maxProduct = Math.max(maxProduct, currMax);

        }
        return maxProduct;
        */

        /*Approach 2*/
        int maxprod = -999;

        int leftToRight = 1;
        int rightToLeft = 1;

        int n = arr.length;
        for(int i = 0, j =n-1; i < n; i++, j--) {
            if(leftToRight == 0)
                leftToRight = 1;
            if(rightToLeft == 0)
                rightToLeft = 1;

            leftToRight = leftToRight * arr[i];
            rightToLeft = rightToLeft * arr[j];

            maxprod = Math.max(maxprod, Math.max(leftToRight, rightToLeft));
        }

        return maxprod;
    }
}