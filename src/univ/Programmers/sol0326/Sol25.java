package univ.Programmers.sol0326;

public class Sol25 {
    class Solution {
        public long[] solution(long[] numbers) {
            // 보다 큰수를 찾기
            // 이진 형태에서 차이가 2 or 1 인 첫 수를 찾는다.
            // Integer.toString(n, x); // remember
            long[] answer = new long[numbers.length];
            boolean check = true;
            for(int i = 0 ; i < numbers.length; i++){
                long index = numbers[i] + 1;
                long fix = numbers[i];
                if(fix % 2 == 0){
                    answer[i] = index;
                }else{
                    String tmp = Long.toString(fix, 2);
                    if(tmp.contains("0")){ // 0 포함시 2번째
                        int point = tmp.lastIndexOf("0");
                        tmp = tmp.substring(0, point) + "10"+ tmp.substring(point+2, tmp.length());
                        answer[i] = Long.parseLong(tmp, 2);
                    }else{
                        answer[i] = Long.parseLong("10" + tmp.substring(1,tmp.length()), 2); // 2진수 -> Long
                    }
                }
            }
            // 규칙 존재
            //     while(check){
            //         String tmp = Long.toString(index^fix, 2);
            //         tmp = tmp.replaceAll("0",""); // 문장의 길이는 총 개수로 규정할 수 있다.
            //         if(tmp.length() == 1 || tmp.length() == 2){
            //             answer[i] = index;
            //             check = false;
            //         }
            //         index++;
            //     }
            //     check = true;
            // }
            // System.out.println("" + Integer.toString(10^4,2).replaceAll("0+",""));
            return answer;
        }
    }
}
