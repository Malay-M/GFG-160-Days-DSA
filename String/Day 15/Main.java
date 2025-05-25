/*Day 15: Add Binary Strings*/

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/add-binary-strings3805 */

class Main {


    public static void main(String[] args) {
        String s1  = "01001001";
        String s2  = "0110101";

        // s1 = "00100";
        // s2 = "010";


        System.out.println(addBinary(s1, s2));

    }


    public static String trimLeadingZeros(String s) {
        int index = s.indexOf('1');
        return index == -1 ? "0" : s.substring(index);
    }
    

    public static String addBinary(String s1, String s2) {
        String res = "";

        int m = s1.length();
        int n = s2.length();

        if(n > m) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            m = s1.length();
            n = s2.length();
        }
        int index = m -1;
        int carry = 0;
        int digit = 0;
        for(int i = n -1; i >= 0; i--) {
            int a = s1.charAt(index) - '0';
            int b = s2.charAt(i) - '0';

            digit = a + b + carry;

            res = digit % 2 + res;
            carry = (int)Math.floor(digit / 2);

            index--;
        }

        while(index >= 0) {
            int a = s1.charAt(index) - '0';
            digit = a + carry;
            res = digit % 2 + res;
            carry = (int)Math.floor(digit / 2);

            index--;
        }

        if(carry == 1) {
            res = "1" + res;
        }

        return trimLeadingZeros(res);
    }
}