/*Day 16: Anagram */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/anagram-1587115620 */

class Main {

    public static void main(String[] args) {

        String s1 = "geeks";
        String s2 = "kseeg";

        // s1 = "allergy";
        // s2 = "allergic";

        System.out.println(areAnagrams(s1, s2));

    }


    public static boolean areAnagrams(String s1, String s2) {

        int[] freq = new int[26];

        if(s1.length() != s2.length()) {
            return false;
        }

        for(int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)-'a']++;
        }

        for(int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i)-'a']--;
        }

        for(int i = 0;i < freq.length; i++) {
            if(freq[i] != 0) {
                return false;
            }

        }

        return true;
    }

}