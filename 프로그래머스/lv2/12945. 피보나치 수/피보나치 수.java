class Solution {
    static int[] keep;
    public int solution(int n) {
        keep = new int[n + 1];
        keep[0] = 0;
        keep[1] = 1;
        int answer = fibo(n);
        
        
        return answer;
    }
    public int fibo(int n){ // dp 메모이제이션 기법을 사용해야 할 듯
        if(keep[n] != 0) return keep[n];
        else if(n == 0) return 0;
        else{
            keep[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
            return keep[n];
        }
    }
}