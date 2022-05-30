/*
Notes: 
*** Thoughts about Subset & Subsequence: 

**Base Condition : 
    - When raw is empty no need further calls;
    *I'm taking 2 parameters
      - Processed : Where my answer lies 
      - raw : String given by user

** TO make subset/sunsequence: 
    -I'm either taking the first raw char or rejecting it.

**Where to take or reject ??
 - In processed as this will contain my answer ;
 

***Conclusion :

  - At each call :  I need 2 recursion calls,
   one for taking the first char  - with processed
   and one is for rejecting it - with processed

   Reduce the raw by one.

*/



#include<iostream>
using namespace std;

void Subseq(string processed, string raw){
    
    // base condition  
    if(raw.size() == 0){
        cout << processed << endl;
        return ;
    }

    // recursion condition 

    char curr = raw[0];

    Subseq(processed+curr,raw.substr(1)); // taking current
    Subseq(processed,raw.substr(1)); // not taking current

}

int main(){
    
    Subseq("","abc");
    return 0;
}