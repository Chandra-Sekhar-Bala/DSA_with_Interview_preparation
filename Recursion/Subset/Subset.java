import java.util.*;

public class Subset {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(SubsetRec(new ArrayList<>(), "ABC")));

         ArrayList<List<Character>> ans = SubsetRecx(new ArrayList<>(), "ABC");

         for(List<Character> x : ans){
             System.out.println(x.toString());
         }

    }

    static void printSubset(ArrayList<Character> processed, String raw){

        if(raw.length() == 0){
            System.out.println(processed.toString());
            return;
        }

        ArrayList<Character> newObj = new ArrayList<>();
        newObj.addAll(processed); // new object because it will be changed in future...
        newObj.add(raw.charAt(0)); 

        printSubset(newObj, raw.substring(1));
        printSubset(processed, raw.substring(1));

    }

    static ArrayList<List<Character>> SubsetRecx(ArrayList<Character> processed, String raw){

         ArrayList<List<Character>> ans = new ArrayList<>();
      
        if(raw.length() == 0){
            ans.add(processed);
            return ans;
        }

        ArrayList<Character> newObj = new ArrayList<>();
        newObj.addAll(processed);
        newObj.add(raw.charAt(0));
        ArrayList<List<Character>> left =  SubsetRecx(newObj, raw.substring(1));ArrayList<List<Character>> right = SubsetRecx(processed, raw.substring(1));

        ans.addAll(left);
        ans.addAll(right);
        return ans;
      
    }
    
}