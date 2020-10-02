package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), 2020-2020, Qinghao Sun
 * Author: Sun Qinghao
 * Date: 2020/10/2 11:05 下午
 * FileName: LongestSubstring_3
 * Description: 无重复字符最长子串
 */
public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")||s==null)return 0;
        int length=s.length();
        int result=1;
        HashSet haschar=new HashSet();
        for(int i=0;i<length;i++){
            haschar.clear();
            for(int j=1;j+i-1<length;j++){
                if(haschar.contains(s.charAt(i+j-1))){
                    break;
                }else{
                    if(result<j)result=j;
                    haschar.add(s.charAt(i+j-1));
                }
            }
        }
        return result;
    }


    public int lengthOfLongestSubstring_offical(String s) {
//        滑动窗口
//        其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca
//        如何移动：我们只要把队列的左边的元素移出就行了，直到满足题目要求！
//        一直维持这样的队列，找出队列出现最长的长度时候，求出解！
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for(int i = 0; i < s.length(); i ++){
                if(map.containsKey(s.charAt(i))){
                    //防止往回跳
                    left = Math.max(left,map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }
            return max;


    }


}
