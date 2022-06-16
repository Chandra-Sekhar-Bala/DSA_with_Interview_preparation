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
    int a[]={1,2,3};
    int first = a[0]; 
    int second = a[1];

    for(int i = 2; a.size(); ++i){

        if(a[i] > second){
            if(a[i] > first){
                int temp = first;
                second = first;
                first = a[i];
            }else{
                a[i] = second;

            }
        }
    }



    return 0;
}