package solution;
//该算法借鉴状态转换思想，不断剔除负值元素带来的sum减少影响，在剔除负因子的情况下，
//就保证sum求和值至少不会小于几个加数因子，所以跟踪sum最大值的同时也包含跟踪了所有元素的最大值
//所以不用提前把数组元素的最大值赋给SubArraySum
//算法时间复杂度O(n)
public class MaxSubArray1 {
	
	public int maxSubArray(int[] nums) {
        int sum=0;                    //sum初值赋为0
		int SubArraySum=nums[0];      //SubArraySum初值赋为首元素
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];             //累加nums[i]
            if(SubArraySum<sum) {
				SubArraySum = sum;    //跟踪一系列sum的最大值
			}
			if(sum<=0){               //如果sum小于等于0，
				
				if(nums[i]<0){        //判断当前所加元素是否为负
					
					sum = 0;          //如果当前所加元素为负，说明这个元素及其上次累计的sum应该结束了，
					                  //如果确实是所找的最大子序数，也已经存入SubArraySum了，sum置零清空也不影响；
					                  //但是如果不是，就应该开启下一次的sum累计去寻找
					
				}else{
					sum=nums[i];      //如果当前所加元素为正，则应该清空该元素之前的负效应，
					                  //即sum赋值为0,同时把这个小正数纳入下次sum的累计。之所以说它是个小正数，
					                  //是因为它正好抵消前面负效应(即sum=0)或者抵消不了(sum依然为0)
				}
			}	
		}
		return SubArraySum;           
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,-1};
		System.out.println(new MaxSubArray1().maxSubArray(nums));

	}

}
