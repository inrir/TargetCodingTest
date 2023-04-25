import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        // A, B의 최솟값을 찾아서 던져주면 된다.
        
        Arrays.sort(A);
        Arrays.sort(B);
        // 오름차순과 내림차순 => B를 오름차순 해준다.
        
        int[] tmp = new int[B.length];
        for(int i = 0; i < B.length; i++){
            tmp[i] = B[B.length - 1 - i];
        }
        
        for(int i = 0; i < B.length; i++){
            answer += A[i] * tmp[i];
        }
        
        
        return answer;
    }
}