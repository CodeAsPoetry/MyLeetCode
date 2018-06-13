package solution;

public class Solution {

	 public String longestCommonPrefix(String[] strs) {
	        String common_prefix="";
	        if(strs.length!=0) {
	        	int maxlength=strs[0].length();
		        
		        int minlength=strs[0].length();
		        int minlength_index = 0;
		        for(int i=0;i<strs.length;i++){
		            if(maxlength<strs[i].length()){
		                maxlength = strs[i].length();
		            }
		            if(minlength>strs[i].length()) {
		            	minlength = strs[i].length();
		            	minlength_index = i;
		            }
		        }
		        char[][] charss = new char[strs.length][maxlength];
		        
		        for(int i=0;i<strs.length;i++){
		        	charss[i] = strs[i].toCharArray();
		        }
		        
		        for(int j=0;j<minlength;j++) {
		        	char temp_char=charss[minlength_index][j];
		        	int num=0;
		        	for(int i=0;i<strs.length;i++) {
		        		
			        	if(charss[i][j]==temp_char) {
			        		num+=1;
			        		
			        	}else {
			        		
			        		break;
			        	}	
			        }
		        	if(num==strs.length) {
		        		common_prefix+=temp_char;
		        		
		        	}else {
		        		
		        		break;
		        	}
	        		
	        	}
	        }
	        
	        
	        return common_prefix;
	    }

	public static void main(String[] args) {
		
		String[] strs = {};
		String common_prefix = new Solution().longestCommonPrefix(strs);
		System.out.println(common_prefix);

	}

}
