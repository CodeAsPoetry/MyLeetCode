class Solution {
    public int majorityElement(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }else{
                    continue;
                }
            }
        }
        return nums[(Integer)(nums.length/2)];
        
    }
}
