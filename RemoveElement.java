package solution;

public class RemoveElement {
	
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        int k;
        for(int i=0;i<length;i+=k){
            if(nums[i]==val){
                for(int j=i+1;j<length;j++){
                    nums[j-1]=nums[j];
                }
                k=0;
                length-=1;
            }else{
                k=1;
            }
        }
        return length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
