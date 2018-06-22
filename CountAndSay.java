package solution;

public class CountAndSay {
	/**
	 * 由上一个字符串得到下一个字符串
	 * @param str 上一个字符串
	 * @return 下一个字符串
	 */
	public String getStr(String str) {
		String out = "";
		char[] str_array = str.toCharArray();
		int k=1;
		for(int i=0;i<str_array.length;i+=k) {
			int num=1;   //计数变量
			for(int j=i+1;j<str_array.length;j++) {
				if(str_array[j]==str_array[i]) {
					k+=1;      //考察变量的下一个与当前相同，外指针移动应跳过下一个
					num+=1;    
				}else {
					k=num;     //外指针应该跳跃到num个单元之后
					break;
				}
			}
			
			out = out+Integer.toString(num)+str_array[i];
			
		}
		return out;
	}
    
	/**
	 * 递归实现
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if(n==1) {
			return "1";
		}else {
			if(n==2) {
				return "11";
			}else {
				String out = "";
				char[] str_array = countAndSay(n-1).toCharArray();
				int k=1;
				for(int i=0;i<str_array.length;i+=k) {
					int num=1;
					for(int j=i+1;j<str_array.length;j++) {
						if(str_array[j]==str_array[i]) {
							k+=1;
							num+=1;
						}else {
							k=num;
							break;
						}
					}
					
					out = out+Integer.toString(num)+str_array[i];
					
				}
				return out;
			}
		}
		

	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountAndSay().countAndSay(5));

	}

}
