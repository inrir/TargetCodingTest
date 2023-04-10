class Solution {
    public long solution(int w, int h) {
        // 대각선으로 지나는 경로를 어떻게 고려할 수 있을까? 개수를 타겟팅할 수 있을까?
        // 불필요한 사각형의 개수 = w + h - 최대공약수 => 아이디어 생각하고 적용해봐야할 듯
        
        long x = Long.valueOf(w); // long 타입으로 올리기
        long y = Long.valueOf(h); // long 타입으로 올리기
        System.out.println(gdc(x, y));
        long answer = x*y - (x + y - gdc(x, y));
        
        return answer;
    }
//     public long small_thing(long a, long b){
//         long min;
//         if(a > b) min = b;
//         else min = a;
        
//         long answer = 1;
        
//         for(long i = 1; i < min; i++){
//             if(a % i == 0 && b % i == 0)
//                 answer = i;
//         }
        
//         return answer;
//     }
    
    public long gdc(long a, long b){ // 유클리드 호제법 => 최대 공약수
        if(a < b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    // 최소 공배수 => a * b / gdc(a, b)
}