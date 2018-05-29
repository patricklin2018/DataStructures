//
//  Created by Patrick-Lin on 11/3/28.
//  Copyright © 2016年 Patrick-Lin. All rights reserved.
//

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> hsmap;
        map<int, int>::iterator it;
        int index=0;
        
        for(auto i:nums){
            if ((it  = hsmap.find(target-i)) != hsmap.end()) {
                break;
            }
            if (hsmap.find(i)==hsmap.end()) {
                hsmap[i]=index;
            }
            index++;
        }
        return vector<int>{it->second, index};
    }
};