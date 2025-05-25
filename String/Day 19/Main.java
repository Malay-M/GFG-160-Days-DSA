/*Day 18: Min Chars to Add for Palindrome */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/minimum-characters-to-be-added-at-front-to-make-string-palindrome */


import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        

        String s = "aacecaaaa";

        System.out.println(minChar(s));
    }


    public static int minChar(String s) {
        
        /*Approach 1: Naive Approach */
        /*
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0 && !isPalindrome(s, 0, i)) {
            count++;
            i--;
        }
        return count;
        */



        /*Approach 2 (Using LPS array)*/
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        s = s + "$" + rev;

        int[] lps = constructLpsArray(s);

        return n - lps[lps.length - 1];
    }


    public static int[] constructLpsArray(String pat) {

        int prefix = 0, suffix = 1;
        int n = pat.length();
        int[] lps = new int[n];

        while(suffix < n) {
            if(pat.charAt(prefix) == pat.charAt(suffix)) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            } else {
                if(prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                } else {
                    prefix = lps[prefix -1];
                }
            }
        }

        // System.out.println(Arrays.toString(lps));
        return lps;
    }


    

    public static boolean isPalindrome(String s, int start, int end) {

        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) 
                return false;
            
            start++;
            end--;
        }
        return true;
    }


}