package Algorithms;

/**
 * Created by zhangrunlin on 16/8/14.
 *
 * dp，dp[i]表示当target为i 时，有多少种组合。

 * 状态转移方程：dp[i]=Σdp[i-nums[k]]  0<=k<=nums.length

 * 当然，需要考虑当i-nums[k]为0时，表示数组中有target，则此时dp[i]为1,

 * 时间复杂度O(n^2)
 */



public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >0 ){
                    dp[i] += dp[i - nums[j]];
                }else if(i - nums[j] == 0){
                    dp[i] +=1;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int target =1;
        System.out.println(combinationSum4(nums,target));
    }
}
