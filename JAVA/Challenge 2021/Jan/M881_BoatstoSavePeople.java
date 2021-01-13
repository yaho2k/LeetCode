import java.util.Arrays;

public class M881_BoatstoSavePeople {

    /*
     * Example 1: Input: people = [1,2], limit = 3 Output: 1 Explanation: 1 boat (1,
     * 2)
     * 
     * Example 2: Input: people = [3,2,2,1], limit = 3 Output: 3 Explanation: 3
     * boats (1, 2), (2) and (3)
     * 
     * Example 3: Input: people = [3,5,3,4], limit = 5 Output: 4 Explanation: 4
     * boats (3), (3), (4), (5)
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] people = {1,2};
        int[] people = {2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10};
//        int[] people = {3,5,3,4};
        //int[] people = {3,2,2,1};
        int limit = 50;
        int result = sol.numRescueBoats(people, limit);
        System.out.print(result);

    }
/*     Input:
    [3,2,2,1]
    3
    Output:
    4
    Expected:
    3 */

  /*   Input:
[2,49,10,7,11,41,47,2,22,6,13,12,33,18,10,26,2,6,50,10]
50
Output:
9
Expected:
11 */
    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);

            int heavy = people.length-1;
            int light = 0;

            int count = 0;
            int sum = 0;

         while(light< people.length && heavy>=0 && light <= heavy){
                sum = people[heavy];
                count++;
                if(light <= heavy && sum + people[light] <= limit){
                    sum = sum + people[light];
                        light++;
                }
                heavy--;
                sum = 0;
            }
            
            return count;
        }
    }
}
