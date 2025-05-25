/*Day 14: Implement Atoi */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/implement-atoi */


class Main {
    public static void main(String[] args) {
        // String s = "-123";
        // String s = "  -";
        String s = " 1231231231311133";
        // String s = "23213";
        System.out.println(myAtoi(s));

        // System.out.println(Integer.MIN_VALUE);
    }

    public static int myAtoi(String s) {
        int sign = 1, res = 0, index = 0;


        while(index < s.length() && s.charAt(index) == ' ') {
            index++;
        }


        if(index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            if(s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }


        while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {

            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/ 10 && s.charAt(index)-'0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }


            res = 10 * res +(s.charAt(index) - '0');
            index++;

        }

        return sign * res;

    }
}