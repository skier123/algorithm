package leetcode;

public class reverseWords_557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int end=chars.length;
        char a=' ';
        int first=0;
        int last=0;
        for (int i =0; i<end; i++) {
            if(chars[i]==' '){
                last=i-1;
                while(first<last){
                    a=chars[first];
                    chars[first]=chars[last];
                    chars[last]=a;
                    first+=1;
                    last-=1;
                }
                first=i+1;
            }else if(i==end-1){
                last=i;
                while(first<last){
                    a=chars[first];
                    chars[first]=chars[last];
                    chars[last]=a;
                    first+=1;
                    last-=1;
                }

            }
        }

        return String.copyValueOf(chars);
    }
}
