package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
    leetcode 1 (两数之和)
    数据结构：数组

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
/*
leetcode2 两数相加
数据结构：链表

题目描述
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/
class Code{

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next=l2;l2.next=l3;

        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(8);
        b1.next=b2;b2.next=b3;
        ListNode result = addTwoNumber(l1, b1);
        ListNode current = result;
        System.out.println(current.value);
        while (current.next!=null){
            System.out.println(current.next.value);
            current = current.next;
        }


    }

    static  ListNode addTwoNumber(ListNode v1,ListNode v2){
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        int carry = 0;
        while (v1!=null || v2!=null){
            int i1 = v1==null?0:v1.getValue();
            int i2 = v2==null?0:v2.getValue();
            int sum = i1+i2+carry;
            ListNode node;
            carry=sum/10; // 1 or 0
            if(sum<10){
                node= new ListNode(sum);
            }else{
                int remainder = sum%10;
                node = new ListNode(remainder);
            }
            current.next = node;
            current = node;
            if(v1!=null){
                v1 =v1.next;
            }
            if(v2!=null){
                v2=v2.next;
            }
        }
        //循环完最后一个也要记得处理
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return pre.next;
    }

}


/*      leetcode 3 (无重复最长子串)
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:
            输入: "abcabcbb"
            输出: 3
            解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:
            输入: s = "bbbbb"
            输出: 1
            解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
            示例 3:
        示例 3:
            输入: s = "pwwkew"
            输出: 3
            解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

            abcdc
*/

class NoRepeatMostLongStr{
    public static void main(String[] args) {
        int res = cal("bbbbb");
        System.out.println(res);
    }

    public static int cal(String ex){
        HashSet<Character> temp = new HashSet<>();
        int length = ex.length();
        int point =-1,result =0;
        for(int i=0;i<length;i++){
            if(i!=0){
                temp.remove(ex.charAt(i-1));//左指针右移,temp删一个
            }
            //右指针小于最大,且前面无重复
            while ((point+1)<length  &&  !temp.contains(ex.charAt(point+1))){
                temp.add(ex.charAt(point+1));
                point++;
            }
            result = Math.max(result,point-i+1);
        }
        return result;
    }
}



/*
leetcode 27.移除元素

给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1：
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

示例 2：
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
*/
class  RemoveElements{
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int targrt = 2;
        int remove = remove(nums, targrt);
        System.out.println(remove);
    }

    public static int remove(int [] nums,int target){
        int left=0;
        int n =nums.length;
        for(int right=0;right<n;right++){
            if(nums[right] != target){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}


/*
     leetcode 88:合并两个有序数组
     给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

         示例 1：
         输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         输出：[1,2,2,3,5,6]

        示例 2：
         输入：nums1 = [1], m = 1, nums2 = [], n = 0
         输出：[1]
          

         提示:
         nums1.length == m + n
         nums2.length == n
         0 <= m, n <= 200
         1 <= m + n <= 200
         -109 <= nums1[i], nums2[i] <= 109
 */

class MergeArray{
    public static  void mergeArr(int[] arr1,int m,int[] arr2,int n){
        int p1=0;
        int p2=0;
        int[] result = new int[m+n];
        int current;
        while (p1<m || p2<n){
            if(p1==m){
                current = arr2[p2++];
            }else if(p2==n){
                current = arr1[p1++];
            }else if(arr1[p1]<arr2[p2]){
                current = arr1[p1++];
            }else {
                current = arr2[p2++];
            }
            result[p1+p2-1] = current;
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            arr1[i] = result[i];
        }



    }

    public static void main(String[] args)  {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        int m=3;
        int n=3;
        mergeArr(num1,m,num2,n);
    }
}



/*
        leetcode 704(二分查找)
        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

        示例 1:
        输入: nums = [-1,0,3,5,9,12], target = 9
        输出: 4
        解释: 9 出现在 nums 中并且下标为 4

        示例 2:
        输入: nums = [-1,0,3,5,9,12], target = 2
        输出: -1
        解释: 2 不存在 nums 中因此返回 -1
*/
class ErFenFind{
    public static void main(String[] args) {

    }
    // 1,2,3,4,5,6,9,15
    public int search(int[] arr,int target){
        int left=0; int right=arr.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid]==target) return mid;
            if(mid<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}





























