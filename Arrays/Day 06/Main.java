/*Day 6: Majority Element II */

/*https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/majority-vote */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
        int[] nums  = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};

        System.out.println(findMajority(nums));
    }

     public static List<Integer> findMajority(int[] nums) {
        
        /*Approach 1*/
        /* 
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            if(hashmap.containsKey(nums[i])) {
                int value = hashmap.get(nums[i]);
                value++;
                hashmap.put(nums[i], value);
                if(value > (nums.length / 3)) {
                    if(!list.contains(nums[i])) {
                        list.add(nums[i]);
                    }
                }
            } else {
                hashmap.put(nums[i], 1);
            }

        }
        System.out.println(hashmap.toString());
        */



        /*Approach 2 (Moore's voting algorithm)*/
        List<Integer> list = new ArrayList<>();

        int element1 = -1, element2 = -1;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {

            if(nums[i] == element1) {
                count1++;
            } else if(nums[i] == element2) {
                count2++;
            } else if(count1 == 0) {
                element1 = nums[i];
                count1++;
            } else  if(count2 == 0) {
                element2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }


        if(element1 > element2) {
            int temp = element1;
            element1 = element2;
            element2 = temp;
        }


        count1 = 0;
        count2 = 0;
        for(int i =0; i < n; i++) {
            if(nums[i] == element1) 
                count1++;
            
            if(nums[i] == element2)
                count2++;
        }

        
        

        if(count1 > n/3) {
            list.add(element1);
        } 
        if(count2 > n/3) {
            list.add(element2);
        }

        
        return list;
    }
}