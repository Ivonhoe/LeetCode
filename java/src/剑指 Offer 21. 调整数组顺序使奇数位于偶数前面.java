class Solution {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            while(i<j && (nums[i]&1)==1){
                i++;
            }
            while(i<j && (nums[j]&1)==0){
                j--;
            }
            if(i<j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j){
        if(i!=j){
            nums[i]=nums[i]^nums[j];
            nums[j]=nums[i]^nums[j];
            nums[i]=nums[i]^nums[j];
        }
    }
}