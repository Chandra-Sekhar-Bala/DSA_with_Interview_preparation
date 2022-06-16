
#include<iostream>
using namespace std;
int main(){
    

    int a[]={1,2,3,5,6,7,8};
    int first = a[0]; 
    int second = a[1];

    for(int i = 2; i < 7; ++i){
        if(a[i] > second){
        if(a[i] > first){
                int temp = first;
                second = first;
                first = a[i];
                }else{
                a[i] = second;
                }}}

    cout << first << endl;
    cout << second;



    return 0;
}