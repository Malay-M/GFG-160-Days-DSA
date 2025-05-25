/*Day 18: Search Pattern (KMP-Algorithm) */
/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/search-pattern0205 */

import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        System.out.println(search(pat, txt));
        
    }

    static ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int[] lps = new int[pat.length()];
    

        constructLPS(pat, lps);

        System.out.println(Arrays.toString(lps));


        int n = txt.length();
        int m = pat.length();

        int i = 0, j = 0;
        while(i < n) {

            if(txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if(j == m) {
                    ans.add(i-j);
                    j = lps[j-1];
                } 

            } else {

                if(j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }

            }


        }


        return ans;
    }




    static void constructLPS(String pat, int[] lps) {

        int prefix = 0, suffix = 1;


        while(suffix < pat.length()) {

            if(pat.charAt(prefix) == pat.charAt(suffix)) {
                lps[suffix] = prefix+1;
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

    }

}