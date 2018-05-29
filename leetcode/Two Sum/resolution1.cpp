//
//  Created by Patrick-Lin on 11/3/28.
//  Copyright © 2016年 Patrick-Lin. All rights reserved.
//

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int index=0, num;
        vector<pair<int, int>> newVec;
        newVec.reserve(nums.size());
        for (auto i:nums) {
            newVec.push_back(pair<int,int>(i, index++));
        }
        sort(begin(newVec), end(newVec),
             [&](const pair<int, int> &v1, const pair<int, int> &v2){
                 return  v1.first<v2.first;
             }
             );
        
        auto p_left=newVec.begin();
        auto p_right=newVec.end()-1;
        num=p_left->first+p_right->first;
        
        while (num!=target) {
            if (num<target) {
                p_left++;
            }
            else{
                p_right--;
            }
            num=p_left->first+p_right->first;
        }
        
        return vector<int>{p_left->second, p_right->second};
    }
};