class Solution {
    // 1 or 2
    // dp? 
    static int fin;
    static int[] dp;
    public long solution(int n) {
        long answer = 0;
        dp = new int[n + 1];
        fin = n; 
        dp[1] = 1;
        if(n == 1) return dp[n];
        
        dp[2] = 2;
        if(n == 2) return dp[n];
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer = dp[n];
    
        return answer;
    }
    
   
}