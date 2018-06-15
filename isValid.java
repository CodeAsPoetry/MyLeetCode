package solution;

public class Solution {
	
	public boolean isValid(String s) {
		char[] s_char_array = s.toCharArray();
		char[] top_char_array = new char[s.length()];
		int top=-1;
		for(int i=0;i<s_char_array.length;i++) {
			if(s_char_array[i]=='('||s_char_array[i]=='['||s_char_array[i]=='{') {
				top+=1;
				top_char_array[top]=s_char_array[i];
			}
			if(s_char_array[i]==')') {
				if(top==-1) {
					return false;
				}else {
					if(top_char_array[top]=='(') {
						top-=1;
						continue;
					}else {
						return false;
					}
				}	
			}
			if(s_char_array[i]==']') {
				if(top==-1) {
					return false;
				}else {
					if(top_char_array[top]=='[') {
						top-=1;
						continue;
					}else {
						return false;
					}
				}	
			}
			if(s_char_array[i]=='}') {
				if(top==-1) {
					return false;
				}else {
					if(top_char_array[top]=='{') {
						top-=1;
						continue;
					}else {
						return false;
					}
				}	
			}		
		}
		if(top==-1) {
			return true;
		}else {
			return false;
		}
		
	}



	public static void main(String[] args) {



		System.out.println(new Solution().isValid("()[]{}"));

	}

}
