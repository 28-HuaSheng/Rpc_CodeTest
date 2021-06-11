package com.test;

import java.util.HashMap;
import java.util.Map;

/*
    题目描述：
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
*/
public class TwoSum {

    public static  Integer[] getResult(Integer[] array, Integer target){
        Map<Integer,Integer/*index*/> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            Integer thisVal = array[i];
            Integer toFind = target - thisVal;
            if(map.containsKey(toFind)){
                return new Integer[]{map.get(toFind),i};
            }
            map.put(thisVal,i);
        }
        return new Integer[]{};
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 7, 11, 15};
        Integer target = 17;
        Integer[] result = getResult(arr, target);
        for(int i = 0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print(",");
        }
    }



}
