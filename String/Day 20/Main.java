/*Day 20: Strings Rotations of Each Other */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/check-if-strings-are-rotations-of-each-other-or-not-1587115620 */


import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        
        String s1 = "mightandmagic";
        String s2 = "andmagicmigth";

        System.out.println(areRotations(s1, s2));        

    }

    public static boolean areRotations(String s1, String s2) {
        
        /*Approach 1 (Naive Approach) */
        /*
        int n = s1.length();
        for(int i = 0; i < n; i++) {

            if(s1.equals(s2)) {
                return true;
            }
            char last = s1.charAt(n-1);
            s1  = last + s1.substring(0, n-1);
        }
        return false;
        */


        /*Approach 2 (KMP Algorithm) */
        
        s1 = s1 + s1;
        int[] lps = constructLpsArray(s2);

        int i = 0, j =0;
        int n = s1.length();
        int m = s2.length();
        while(i < n) {

            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if(j == m) {
                    return true;
                }

            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
 

        }

        return false;

        


    }



    public static int[] constructLpsArray(String s1) {
        int n = s1.length();
        int[] lps = new int[n];
        int prefix = 0, suffix = 1;

        while(suffix < n) {
            if(s1.charAt(prefix) == s1.charAt(suffix)) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            } else {

                if(prefix == 0) {

                    lps[suffix] = 0;
                    suffix++;

                } else {
                    prefix = lps[prefix - 1];
                }
            }


        }
        return lps;
    }


}