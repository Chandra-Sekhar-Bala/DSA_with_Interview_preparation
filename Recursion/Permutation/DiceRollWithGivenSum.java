/*
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/ - not completed as it is a dp question
 * Given a interget N and 
 */

public class DiceRollWithGivenSum{
    public static void main(String[] args) {

        System.out.println(diceHelper(0,0,1,6,3,3));

    }

     static int diceHelper(int ans, int depth, int n, int k, int target, int raw){
        //base case
        
        if(depth == n){
            if(target == ans){
                return 1;
            }
            return 0;
        }
        
        
        // 
        int i = 1;
        int sum = 0;
        
        while(i <= k && raw-i >= 0){
            sum += diceHelper(ans+i, ++depth, n, k, target, Math.abs(i-raw));
            --depth;
            ++i;
        }
        
        return (sum % ((int)Math.pow(10, 9)+7));
        
    }



      static void helper(String ans, String raw){
        System.out.println(raw.length());
        if(raw.isEmpty()){

        System.out.println(ans);
            return;
        }
        char ch = raw.charAt(raw.length()-1);
        helper(ans+ch, raw.substring(raw.length()-1));

    }
}