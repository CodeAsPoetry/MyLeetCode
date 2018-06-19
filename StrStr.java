package solution;

public class StrStr {
	
	  public int strStr(String haystack, String needle) {
	        int index_first=0;
	        //IDE中equals和“==”都可以，leetcode中“==”无法通过。
	        if(needle.equals("")){
	            return index_first;
	        }else{
	            char[] hays = haystack.toCharArray();
	            char[] need = needle.toCharArray();
	            //母串后移
	            for(int i=0;i<hays.length;i++){
	                index_first=i;
	                int j=0;
	                int k;
	                int num=0;
                    for(k=index_first;k<hays.length;k++){
                    	if(j>=need.length) {
                    		break;
                    	}else {
                    		if(hays[k]==need[j]){
	                            j+=1;     //考查字串中的下一个字符
	                            num+=1;   //计数变量加一
	                        }else {
	                        	break;    //出现不同，索引找错，考虑母串的下一个字符
	                        }
                    	}
                    	if(num==need.length){   //计数变量等于子串长度
                            return index_first;
                        }  
                    }
                                                 
	            }
	           
	           return -1; 
	        }
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hello";
		String needle = "ll";
		System.out.println(needle.equals(""));
		System.out.println((new StrStr().strStr(haystack,needle)));

	}

}
