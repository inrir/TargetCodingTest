class Solution {
    static int[] dp;
    public int solution(int n) {
        int answer = 0;
        // 무조건적으로 DP
        // 백준에서 한 거 같은데, 피보나치 형태
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        return dp(n);
    }
    public int dp(int i){
        if(dp[i] != 0){
            return dp[i];
        }
        if(i == 1){
            return dp[1];
        }
        if(i == 2){
            return dp[2];
        }
        
        dp[i] = dp(i - 1) % 1000000007 + dp(i - 2) % 1000000007;
        
        return dp[i] % 1000000007;
        
    }
}