package solution;

public class Solution {

	public int reverse(int x) {
		int x_abs = Math.abs(x);
		String x_str = Integer.toString(x_abs);
		char[] x_char_array = x_str.toCharArray();
		char[] y_char_array = new char[x_char_array.length];
		char[] max_char_array = Integer.toString(2147483647).toCharArray();
		for(int i=0;i<x_char_array.length;i++) {
			y_char_array[x_char_array.length-1-i] = x_char_array[i];
		}
		if(y_char_array.length>=max_char_array.length) {
			for(int i=0;i<x_char_array.length;i++) {
				if(Integer.parseInt(String.valueOf(y_char_array[i]))>Integer.parseInt(String.valueOf(max_char_array[i]))) {
					return 0;
				}
				if(Integer.parseInt(String.valueOf(y_char_array[i]))==Integer.parseInt(String.valueOf(max_char_array[i]))) {
					continue;
				}
				if(Integer.parseInt(String.valueOf(y_char_array[i]))<Integer.parseInt(String.valueOf(max_char_array[i]))) {
					break;
				}
				
			}
			
		}
		int y = Integer.parseInt(String.valueOf(y_char_array));
		if(x<0) {
			return -y;	
		}
        return y;
		

	}

	public static void main(String[] args) {
		int y =new Solution().reverse(2147483412);
		System.out.println(y);
	}

}
