import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

Question : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Notes: 

 *** What is Letter Combination ?

    Input: digits = "23" : 2-> "abc" & 3 -> "def"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

**Order is maintained ^


*** Thoughts about Letter Combination : 

**Base Condition : 
    - When raw is empty no need further calls;
    *I'm taking 3 parameters
      - Processed : Where my answer lies 
      - raw : String given by user
      - mapStr : To map string values with raw : raw[0] => 2 = map[2] => "abc"

** TO make Letter Combination : 
    - Length of raw selects size of i't output.

***Thought Process :

  - At each call :  
  1. I'm first taking the raw[0] char as int, then from map I got the mapped string;
  2. Now I need to loop for size of the mapped string
  3. Make a recusion call for each mapped charcter by adding the i'th mapped string to the andwer
  4. Reduce the raw by one.

*/


public class PhoneNumber {

    public static void main(String[] args) {
    
        // String digits = "23";
        // StringBuilder _digits = new StringBuilder(); 
    
        //  for (int i = 0; i < digits.length(); i++) {

        // int x = digits.charAt(i) - '0';
        // _digits.append(--x);
        // }
        
        // Phone("", _digits.toString());


        // Love babbar approach
        ArrayList<String> map = new ArrayList<String>(
            Arrays.asList("","",
               "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
            ));

        List<String> ans = PhoneCombo("", "23", map);

        System.out.println(ans.toString());
    }

    static List<String> PhoneCombo(String ans,String raw,ArrayList<String> mapx){

        ArrayList<String> answer = new ArrayList<String>();

        if(raw.isEmpty()){
            answer.add(ans);
            return answer;
        }

        int index = raw.charAt(0) - '0';
        String curentStr = mapx.get(index);

        for (int i = 0; i < curentStr.length(); i++) 
            answer.addAll(PhoneCombo(ans+curentStr.charAt(i), raw.substring(1), mapx));

        return answer;

    }


    static void Phone(String ans, String raw){

        if(raw.isEmpty()){
            System.out.println(ans);
            return;
        }

        int digit = raw.charAt(0) -  '0';

        for (int i = (digit-1)*3 ; i < (digit)*3 ; i++) {
            char curr = (char) ('a'+i);
            Phone(ans+curr, raw.substring(1));
        }


    }

}
