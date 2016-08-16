package Algorithms;

/**
 * Created by zhangrunlin on 16/8/16.
 *
 * 基本思路：最小化最大值算法；也就是求的是最大值，但是是最大值中的最小的那一个；那么逻辑应该是很清晰的，两步，找到最大值，再找最大值的最小值；

 基本实现：递归；——这里特别吊的是别个用了个二维数组来比较，用二维数组的序号/位置，来分析n个数的情况——
 */
public class GuessNumberHigherorLowerII {
    public static int getMoneyAmount(int n){
        int[][] table = new int[n+1][n+1];
        return payForRange(table,1,n);
    }

    private static int payForRange(int[][] dp, int start,int end){
        if(start >= end) return 0;
        if(dp[start][end] !=0) return dp[start][end];
        int mininumForCurrentRange = Integer.MAX_VALUE;
        for (int x = start;x<=end;x++){
            int pay = x + Math.max(payForRange(dp,start,x-1),payForRange(dp,x+1,end));
            mininumForCurrentRange = Math.min(mininumForCurrentRange,pay);

        }
        dp[start][end] = mininumForCurrentRange;
        return mininumForCurrentRange;
    }

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(4));
    }
}
