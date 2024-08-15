package univ.Programmers.sol0319;

public class Sol14 {
    class Solution
    {
        public int solution(int n, int a, int b)
        {
            // 1, 2 -> 1
            // 3, 4 -> 2
            int answer = 0;
            while(true){

                a = a/2 + a%2;
                b = b/2 + b%2;

                answer++;  // 한 게임 끝

                if(a == b){
                    break;
                }
            }


            return answer;
        }

//     public int check(int tmp){

//         for(int i = 1; i <=20; i++){
//             if(tmp <= (int)Math.pow(2,i) && tmp >= (int)Math.pow(2,i-1) + 1){
//                 return i;
//             }
//         }

//         return -1;
//     }
    }
}
