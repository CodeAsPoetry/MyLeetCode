package solution;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
        int lastword_length=0;
        char[] s_array = s.toCharArray();
        for(int i=0;i<s_array.length;i++){
            if(s_array[s_array.length-1-i]!=' '){
                lastword_length+=1;
                continue;
            }else{
                if(lastword_length==0){      //针对 “a " 情况
                    lastword_length=0;
                    continue;
                }else{
                    return lastword_length;
                }
                
            }
        }
        return lastword_length;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
