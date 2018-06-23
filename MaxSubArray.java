package solution;

public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		int SubArraySum=0;
		int HeadToEnd_index=0;
		int EndToHead_index=0;
		int[] HeadToEnd_sum_array= new int[nums.length];
		int[] EndToHead_sum_array= new int[nums.length];
		int HeadToEnd_sum=0;
		int EndToHead_sum=0;
		
		int HeadToEnd_sum_max=-2147483648;           //不能赋值为0,非常有可能出现负数
		int EndToHead_sum_max=-2147483648;
		
		for(int i=0;i<nums.length;i++) {
			HeadToEnd_sum+=nums[i];
			HeadToEnd_sum_array[i]=HeadToEnd_sum;
		}
		
		for(int i=0;i<HeadToEnd_sum_array.length;i++) {
			if(HeadToEnd_sum_max<HeadToEnd_sum_array[i]) {
				HeadToEnd_sum_max = HeadToEnd_sum_array[i];
				HeadToEnd_index = i;
			}else {
				continue;
			}
		}
		
		
		for(int i=0;i<nums.length;i++) {
			EndToHead_sum+=nums[nums.length-1-i];
			EndToHead_sum_array[nums.length-1-i]=EndToHead_sum; 
		}
		
		for(int i=0;i<EndToHead_sum_array.length;i++) {
			if(EndToHead_sum_max<EndToHead_sum_array[i]) {
				EndToHead_sum_max = EndToHead_sum_array[i];
				EndToHead_index = i;
			} else {
				continue;
			}
		}
		System.out.println(HeadToEnd_index);
		System.out.println(EndToHead_index);
		
		System.out.println(HeadToEnd_sum_max);
		System.out.println(EndToHead_sum_max);
		
		System.out.println("-------------------------");
		
		if(HeadToEnd_index>=EndToHead_index) {           //交叠，交叠部分累加求和
			for(int i=EndToHead_index;i<=HeadToEnd_index;i++) {
				SubArraySum+=nums[i];
			}
		}else {               //不交叠，分三段递归考虑，每段直到分到出现交叠为止，最后在三段之中取其最大值
			int SubArraySum1;
			int SubArraySum2;
			int SubArraySum3;
			//从EndToHead_index开始考虑 nums
			//从HeadToEnd_index开始考虑 nums
			//从HeadToEnd_index到EndToHead_index开始考虑 nums
			//上面两种情况都得考虑
			int[] newnums1 = new int[nums.length-EndToHead_index];
			for(int i=0;i<newnums1.length;i++) {
				newnums1[i] = nums[EndToHead_index+i];
			}
			SubArraySum1 = maxSubArray(newnums1);
			
			int[] newnums2 = new int[HeadToEnd_index+1];
			for(int i=0;i<newnums2.length;i++) {
				newnums2[i] = nums[i];
			}
			SubArraySum2 = maxSubArray(newnums2);
			
			if(EndToHead_index-HeadToEnd_index-1==0) {    // 针对HeadToEnd_index，EndToHead_index紧挨者，没有中间那段
				SubArraySum = Math.max(SubArraySum1,SubArraySum2);
			}else {
				int[] newnums3 = new int[EndToHead_index-HeadToEnd_index-1];
				for(int i=0;i<newnums3.length;i++) {
					newnums3[i] = nums[i+HeadToEnd_index+1];
				}
				SubArraySum3 = maxSubArray(newnums3);
			
				//SubArraySum1,SubArraySum2,SubArraySum3取其最大值
				int SubArraySum12 = Math.max(SubArraySum1, SubArraySum2);
			    int SubArraySum23 = Math.max(SubArraySum2, SubArraySum3);
			    SubArraySum = Math.max(SubArraySum12,SubArraySum23);
			}
			
			
		}
			
		return SubArraySum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8};
		System.out.println(new MaxSubArray().maxSubArray(nums));

	}

}
