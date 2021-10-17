class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int i = 0,j = nums.length-1;
        // 双指针，从两头向中间逼近
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                ans[0] = nums[i];
                ans[1] = nums[j];
                return ans;
            }
        }
        return new int[0];
    }
}