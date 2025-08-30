class Solution {
public:
    //2nd approach
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        unordered_map<int,int> um;
        for(int i = 0; i<nums.size(); i++){
            int t = target - nums[i];
            auto it = um.find(t);
            if(it != um.end()){
                ans.push_back(i);
                ans.push_back(it->second);
                return ans;
            }
            um[nums[i]] = i;
        }
        return ans;
    }
    
    //1st Approach
//     vector<int> twoSum(vector<int>& nums, int target) {
    
//         vector<int> ans;
//         int t = target;
//         for(int i = 0; i<nums.size(); i++){
//             t -= nums[i];
//             auto it = find(nums.begin()+i+1,nums.end(), t);
//             if(it != nums.end()){
//                 ans.push_back(i);
//                 ans.push_back(it - nums.begin());
//                 break;
//             }
//             t = target;
//         }
//         return ans;
//     }
};