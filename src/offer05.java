public class offer05 {
    class Solution {
        public String replaceSpace(String s) {
            int n = s.length();
            char[] array = new char[n*3];
            int newLength = 0;
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c == ' '){
                    array[newLength] = '%';
                    newLength++;
                    array[newLength] = '2';
                    newLength++;
                    array[newLength] = '0';
                    newLength++;
                } else{
                    array[newLength] = c;
                    newLength++;
                }
            }
            String str = new String(array,0,newLength);
            return str;
        }
    }
}
