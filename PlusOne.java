package solution;

import java.util.Arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int newlength=digits.length; 
		int i;
		for(i=0;i<digits.length;i++){
			if(digits[i]!=9){
				break;
			}else {
				continue;
			}
		}
		if(i==digits.length){
			newlength=digits.length+1; 
		}
		int[] result = new int[newlength];
		int flag=0;
		if(newlength==digits.length) {
			for(i=0;i<digits.length;i++) {
				if(digits[digits.length-1-i]+1!=10) {
					result[result.length-1-i]=digits[digits.length-1-i]+1;
					flag=result.length-1-i;
					System.out.println(flag);
					break;
				}else {
					result[result.length-1-i]=0;
					continue;
				}

			}

			for(int k=0;k<result.length;k++) {
				if(k>flag) {
					result[k] = 0;
				}else {
					if(k==flag) {
						result[k] = digits[k]+1;
					}else {
						result[k]=digits[k];
					}
				}
			}
		}else {
			result[0]=1;
			for(i=1;i<result.length;i++) {
				result[i]=0;
			}
		}



		return result;
	}

	public int[] plusOne1(int[] digits) {   //对大整数溢出
		long digits_int=0;
		for(int i=0;i<digits.length;i++) {
			digits_int+=Math.pow(10, i)*digits[digits.length-1-i];
		}
		long result_int = digits_int+1;
		System.out.println(result_int);
		
		
		int j=0;
		while(result_int/(Math.pow(10, j))>=1) {
			j+=1;
		}
		int[] result = new int[j];
		
		
		
		for(int k=0;k<j;k++) {
			result[k] = (int) ((result_int % Math.pow(10, j-k)) / (Math.pow(10, j-k-1)));
			
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits= {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
		System.out.println(Arrays.toString(new PlusOne().plusOne1(digits)));

	}

}
