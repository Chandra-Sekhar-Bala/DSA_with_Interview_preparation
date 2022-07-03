/*
problem : https://leetcode.com/problems/combination-sum/
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
** Intution and Approach: 
    -Simple taking and not taking case:
    -Modification: 
        While taking I will take the current one ultimate number of times untill is exceed to target
        Not takig case:  will ignore the current one and proceed witn the next one 

    If ans found retuen bro
*/

#include <bits/stdc++.h>
using namespace std;

    
vector<vector<int>> helper(vector<int>& processed, int sum, vector<int>& num, int i, int target){
        
        vector<vector<int>> ans;
        // base case
       
       // Either all elements have been taken or Sum became greater
        if(i == num.size() || sum >= target ){
           
           // check if the current sum is = target or not?
            if(sum == target){    
               // push into the answer
               ans.push_back(processed);
            }

           return ans;
        }
       
       // recursive case :
       
       // taking case: 
       processed.push_back(num[i]);
       // same number can be choosen ultimate number of times that why i is not increased
       vector<vector<int>> left = helper(processed, sum+num[i], num, i, target);
       
            // Backtracking
            processed.pop_back();
       
       
       // not taking case
       vector<vector<int>> right = helper(processed, sum, num, i+1, target);
       
       // add all answers from left
       for(vector<int> x : left){
           ans.push_back(x);
       }
       
        // add all answers from right
       for(vector<int> x : right){
           ans.push_back(x);
       }
       
       return ans;
        
    }
    
 vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    
        vector<int> processed;
        return helper(processed, 0, candidates, 0, target);
        
    }

int main(){
        
    vector<int> candidate;
    candidate.push_back(2);
    candidate.push_back(3);
    candidate.push_back(6);
    candidate.push_back(7);
    vector<vector<int>> ans = combinationSum(candidate, 7);

    for(vector<int> x : ans){
        cout << "[";
        for(int y : x){
            cout << y << ",";
        }   
        cout << "]" << endl;
    }

}   