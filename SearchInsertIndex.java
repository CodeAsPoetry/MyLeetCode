package solution;

public class SearchInsertIndex {
	public int searchInsert(int[] nums, int target) {
        int target_index=0;
        
        if(nums.length==0){     //被插入数组为空
            return target_index;
        }else{
            if(target<nums[0]){  //目标值小于第一个元素
                return target_index;
            }else{
                if(target>nums[nums.length-1]){     //目标值大于最后一个元素
                    target_index = nums.length;
                    return target_index;
                }else{
                    
                    for(int i=0;i<nums.length;i++){
                       if(target==nums[i]){         //目标值等于其中某一个元素
                           target_index=i;
                           break;
                       }else{
                           if(target>nums[i]){
                               target_index+=1;     //目标值大于正考察的元素，下一指针
                               continue;
                           }else{
                               break;          //一旦出现目标值小于正考察元素情况，已经找到插入位置了
                           }
                       }
                       
                    }
                    return target_index; 
                    
                }
            }
        }  
  
    }
	
	public static void main(String[] args) {
		
	}

}
