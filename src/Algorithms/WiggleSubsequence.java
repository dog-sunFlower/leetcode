package Algorithms;

/**
 * Created by zhangrunlin on 16/8/14.
 * 贪心算法
 */
public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int maxLen = 1;
        Boolean preInt = null;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] > nums[i-1]  &&  (preInt == null || !preInt) ){
                preInt=true;
                maxLen++;
            }else if ((nums[i] < nums[i-1] && (preInt == null || preInt) )){
                preInt=false;
                maxLen++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int [] nums = {3,3,3,2,5};
        System.out.println(wiggleMaxLength(nums));
    }
}
