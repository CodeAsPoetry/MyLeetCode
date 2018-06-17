package solution;

public class RemoveDup {
	
	public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int loc = 0;
        int k;
        for(int i=1;i<length;i+=k){
            if(nums[i]==nums[loc]){
                for(int j=i+1;j<nums.length;j++){
                    nums[j-1]=nums[j];       
                }
                k=0;
                length-=1;
            }else{
                k=1;
                loc+=1;
            }    
        }
        return length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
