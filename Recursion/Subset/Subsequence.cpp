/*
Notes: 

 *** What is Subsequence ?
 - if input if "abc" then output will be :
    abc
    ab  
    ac 
    a  
    bc 
    b  
    c

**Order is maintained ^


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

void Subseq(string processed, string raw, int i){
    
    // base condition  
    if(i == raw.length()){
        cout << processed << endl;
        return ;
    }

    // recursion condition 

    char curr = raw[i];

    Subseq(processed+curr,raw, i+1); // taking current
    Subseq(processed,raw, i+1); // not taking current

}

int main(){
    
    Subseq("","abc", 0);
    return 0;
}