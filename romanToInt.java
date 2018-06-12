package solution;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {

	public int romanToInt(String s) {


		int index_iv = s.indexOf("IV");
		int index_ix = s.indexOf("IX");
		int index_xl = s.indexOf("XL");
		int index_xc = s.indexOf("XC");
		int index_cd = s.indexOf("CD");
		int index_cm = s.indexOf("CM");

		int[] x_tag = {index_iv,index_ix,index_xl,index_xc,index_cd,index_cm};

		ArrayList<int[]> list = new ArrayList<int[]>();
		ArrayList<Integer> list_tag = new ArrayList<Integer>();
		for(int i=0;i<x_tag.length;i++) {
			if(x_tag[i]!=-1) {
				int[] temp = {x_tag[i],x_tag[i]+1};
				list.add(temp);
				list_tag.add(x_tag[i]);
				list_tag.add(x_tag[i]+1);
			}
		}


		int sum=0;
		char[] x_char_array = s.toCharArray();
		for(int i=0;i<x_char_array.length;i++) {
			if(list_tag.indexOf(i)==-1) {
				switch (x_char_array[i]) {
				case 'I':
					sum+=1;
					break;
				case 'V':
					sum+=5;
					break;
				case 'X':
					sum+=10;
					break;
				case 'L':
					sum+=50;
					break;
				case 'C':
					sum+=100;
					break;
				case 'D':
					sum+=500;
					break;
				case 'M':
					sum+=1000;
					break;
				}
			}
		}

		Iterator<int[]> it1 = list.iterator();

		while(it1.hasNext()){

			int[] temp = it1.next();
			String ss="";
			for(int i=0;i<2;i++) {
				ss +=x_char_array[temp[i]];
			}
			
			switch (ss) {
			case "IV":
				sum+=4;
				break;
			case "IX":
				sum+=9;
				break;
			case "XL":
				sum+=40;
				break;
			case "XC":
				sum+=90;
				break;
			case "CD":
				sum+=400;
				break;
			case "CM":
				sum+=900;
				break;
			}
		}  


		return sum;

	}

	public static void main(String[] args) {
		int y =new Solution().romanToInt("MCMXCIV");
		System.out.println(y);

	}

}
