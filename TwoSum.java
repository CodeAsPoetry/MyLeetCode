package twoNumbersNum;

public class Solution {
	
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(j==i){
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }else{
                    continue;
                }                
            }
        }
        result[0]=-1;
        result[1]=-1;
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
