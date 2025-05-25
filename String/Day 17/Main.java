/*Day 17: Non Repeating Character */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/non-repeating-character-1587115620 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        // s = "hello";

        System.out.println(nonRepeatingChar(s));
    }

    public static char nonRepeatingChar(String s) {
        
        /*Approach 1 */

        /*

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        System.out.println(map.toString());
        
        for(char ch: s.toCharArray()) {
            if(map.get(ch) == 1) {
                return ch;
            }
        }
        return '$';

        */





        /*Approach 2 */
        int[] visited = new int[26];
        Arrays.fill(visited, -1);


        for(int i = 0; i < s.length(); i++) {

            if(visited[s.charAt(i)-'a'] == -1) {
                visited[s.charAt(i)-'a'] = i;
            } else {
                visited[s.charAt(i)-'a'] = -2;
            }
        }


        int min = 9999;
        for(int i = 0; i < visited.length; i++) {

            if(visited[i] >= 0) {
                min = Math.min(min, visited[i]);
                System.out.println(min);
            }
        }

        return (min==999) ? '$' : s.charAt(min);
        
    }
}