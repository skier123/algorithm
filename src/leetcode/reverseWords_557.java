package leetcode;
/*
反转字符串中每个单词的字符顺序，
同时仍保留空格和单词的初始顺序
@author Qinghao Sun mnisun@126.com
 */
public class reverseWords_557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int end=chars.length;
        char a=' ';
        int first=0;
        int last=0;
        for (int i =0; i<end; i++) {
            if(chars[i]==' '){
                last=i-1;//当遍历到空字符，标记位置
                while(first<last){//首尾交换
                    a=chars[first];
                    chars[first]=chars[last];
                    chars[last]=a;
                    first+=1;
                    last-=1;
                }
                first=i+1;//更新首部标记
            }else if(i==end-1){//结尾单独进行
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
