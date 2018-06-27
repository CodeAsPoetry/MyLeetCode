package solution;

public class MySqrt {

	 public int mySqrt(int x) {
	        int sum=0;
	        int value=0;
			for(int i=0;;i++) {
				if(sum>x) {
					value=i-1;
	                break;
				}else {
					if(sum==x) {
						value=i;
	                    break;
					}else {
						sum+=2*i+1;
						if(sum>=0) {           //判断是否溢出
							continue;
						}else {
	                        value=i;
							break;
						}
					}	
				}
			}
			return value;
	    }

	public static void main(String[] args) {
		System.out.println(new MySqrt().mySqrt(8));

	}

}
