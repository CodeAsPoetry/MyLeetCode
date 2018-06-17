package solution;

public class RemoveDup {
	
	public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int loc = 0;
        int k;
        // loc指针，指向待考察元素的前一个元素
        for(int i=1;i<length;i+=k){
            if(nums[i]==nums[loc]){
            	//找到重复项，前移一个位置
                for(int j=i+1;j<nums.length;j++){
                    nums[j-1]=nums[j];       
                }
                //因为删除了重复项，下一个考察项的索引和删除前正准备考察项的索引一致，故i不动
                k=0;
                length-=1;
            }else{
            	//没找到重复项，指针前移
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
