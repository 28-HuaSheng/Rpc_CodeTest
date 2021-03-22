package com.test;

/**
 * 排序
 */
public class Sort {

    /**
     * 冒泡
     */
    public void maoPao(){
        int[] array = new int[]{2,3,4,5,1,8,15,54,12,0,191};
        for(int j=array.length-1;j>0;j--){
            //可以在这里加哥flag,如果内循环没有出现排序操作,说明这个数组本身就是排序好的
            for(int i=0;i<j;i++){
                int temp = array[i];
                int compare = array[i+1];
                if(temp>compare){
                    array[i+1] = temp;
                    array[i] = compare;
                }
            }
        }
        for(int x=0;x<array.length;x++){
            System.out.println(array[x]);
        }

    }

    public static void main(String[] args) {

    }

}
