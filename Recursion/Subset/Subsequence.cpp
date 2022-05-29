/* With strings its subsequence 

raw : String given by user
processed : Which are processed from raw string 
LoGiC : At every function call im calling 2 recursion >>>
 1-> Taking the currnt char with processed
 2-> Not taking the current char with the processed


*/

#include<iostream>
using namespace std;

void Subseq(string processed, string raw){

    if(raw.size() == 0){
        cout << processed << endl;
        return ;
    }

    // recusrion condition 

    char curr = raw[0];

    Subseq(processed+curr,raw.substr(1)); // taking current
    Subseq(processed,raw.substr(1)); // not taking current

}

int main(){
    
    Subseq("","abc");
    return 0;
}

