package leetcode;

import java.util.HashMap;

/**
 * Copyright (C), 2020-2020, Qinghao Sun
 * Author: Sun Qinghao
 * Date: 2020/9/30 9:14 下午
 * FileName: TwoSum_1
 * Description: LeetCode_1 two sum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * 解题思路： 利用hashmap以数值为键值添加，同时查找是否有符合的已添加项
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Integer k;
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            if((k=map.get(target-nums[i]))!=null){
                arr[0]=k;
                arr[1]=i;
                return arr;
            }
            map.put(nums[i],i);
        }
        return null;

    }
}
