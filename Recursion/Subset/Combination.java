/***
Notes: 
 *** What is Combination ?

 - Subset/Subseq + bound(k/..)

 - if input if "1234" and k = 2 then output will be :
    12
    13
    14
    23
    24
    34   

**Order is maintained ^


*** Thoughts about Combination: 

**Base Condition : 
    - When raw is empty no need further calls;
    *I'm taking 3 parameters
      - Processed : Where my answer lies 
      - raw : String given by user
      - k : bound of the output

** To make Combination: 
    same as subset just slight change on base condition
    - When processed reaches the size of k, show it on the screen!
*/


public class Combination {

    public static void main(String[] args) {

        generateCombination("", "1234", 2);
        
    }


    static void generateCombination(String processed, String raw, int k){
        
        if(processed.length() == k || raw.length() == 0){
            System.out.println(processed);
            return ;
        }
        
        generateCombination(processed+raw.charAt(0), raw.substring(1), k);
        //case: Taking the current 

        if(processed.length() + raw.length() <= k) return;

        generateCombination(processed, raw.substring(1), k); 
        //Case: Not taking current

    }
}
