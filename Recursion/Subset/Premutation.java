/***
Notes: 
 *** What is permutation ?
 - if input if "abc" then output will be :
    cba
    bca
    bac
    cab
    acb
    abc

*** Thoughts about Permutaion : 

**Base Condition : 
    - When raw is empty no need further calls;
    *I'm taking 2 parameters
      - Processed : Where my answer lies 
      - raw : String given by user

** To make Permutation: 
    - Not leaving any item behind, just interchaing the places;

**Where to take or reject ??
 - In processed as this will contain my answer ;

*** Recursion call ??
 - Unline subset, recursion call is not constanthere
    -- Recursion call = (processed.size + 1)

 *** Conclusion :

  - At each call :  
  Taking the first char of raw and putting it into every possible places in the processed string/ArrayList/Vector

   Reduce the raw by one...
   
*/

public class Premutation {
    public static void main(String[] args) {
    
        // nos of permutation from N numbers are N!
        Permutaions("", "abc");


    }

    static void Permutaions(String processed, String raw ){

        // base condition 
        if(raw.length() == 0){
            System.out.println(processed);
            return;
        }

        // Recursion leap of faith
        
        char curr = raw.charAt(0);

        for(int i = 0; i <= processed.length() ; ++i){

            String prev = processed.substring(0,i);
            String last = processed.substring(i,processed.length());
            
            Permutaions(last+curr+prev, raw.substring(1));
        }

    }


}
