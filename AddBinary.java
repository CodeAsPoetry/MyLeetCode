package solution;

public class AddBinary {
	
	/**
	 * 其实可以设置一个char类型的进位标志寄存器就行，没有必要每一位都设置，进一步优化时空复杂度
	 * @param a
	 * @param b
	 * @return
	 */
	
    public String addBinary(String a, String b) {
        int max_num = Math.max(a.length(),b.length());
        int max_flag_num = max_num+1;
        
        char[] one_flag = new char[max_flag_num];
        
        char[] a_array = new char[max_flag_num];
        char[] b_array = new char[max_flag_num];
        char[] c_array = new char[max_flag_num];
        
        for(int i=0;i<max_flag_num;i++){
            one_flag[i] = '0';
            a_array[i] = '0';
            b_array[i] = '0';
            c_array[i] = '0';
        }
        
        char[] a_str_array = a.toCharArray();
        char[] b_str_array = b.toCharArray();
        
        for(int i=0;i<a_str_array.length;i++){
            a_array[i] = a_str_array[a_str_array.length-1-i];
        }
        
        for(int i=0;i<b_str_array.length;i++){
            b_array[i] = b_str_array[b_str_array.length-1-i];
        }
        
        for(int i=0;i<max_num;i++){
            if(a_array[i]=='0'&&b_array[i]=='0'){
                if(one_flag[i]=='0'){
                    c_array[i]='0';   
                }else{
                    c_array[i]='1';
                }  
                one_flag[i+1]='0';
            }
            if(a_array[i]=='0'&&b_array[i]=='1'){
                if(one_flag[i]=='0'){
                    c_array[i]='1';
                    one_flag[i+1]='0';
                }else{
                    c_array[i]='0';
                    one_flag[i+1]='1';
                }       
            }
            if(a_array[i]=='1'&&b_array[i]=='0'){
                if(one_flag[i]=='0'){
                    c_array[i]='1';
                    one_flag[i+1]='0';
                }else{
                    c_array[i]='0';
                    one_flag[i+1]='1';
                }       
            }
            if(a_array[i]=='1'&&b_array[i]=='1'){
                if(one_flag[i]=='0'){
                    c_array[i]='0';
                    one_flag[i+1]='1';
                }else{
                    c_array[i]='1';
                    one_flag[i+1]='1';
                }       
            }
        }
        
        String result="";
        
        if(one_flag[max_num]=='0'){
            for(int i=1;i<c_array.length;i++){
                result+=c_array[c_array.length-1-i];
            }
        }else{
            c_array[max_num]='1';
            for(int i=0;i<c_array.length;i++){
                result+=c_array[c_array.length-1-i];
            }
        }
        
        
        return result;
        
        
    }

	public static void main(String[] args) {
		String result = new AddBinary().addBinary("1010", "1011");
		System.out.println(result);

	}

}
