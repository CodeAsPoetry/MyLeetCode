class Solution {
    public boolean isPalindrome(int x) {
        char[] x_char_array = Integer.toString(x).toCharArray();
        char[] y_char_array = new char[x_char_array.length];
        for(int i=0;i<=x_char_array.length-1;i++){
            y_char_array[x_char_array.length-1-i] = x_char_array[i];
        }
        
        for(int i=0;i<=x_char_array.length-1;i++){
            if(y_char_array[i]!=x_char_array[i]){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }
}