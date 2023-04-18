class Solution {
    public int solution(int n) {
        int answer = n; // 변형할 것
        
        // 1. 보다 큰 수 2. 2진수시 1의 갯수가 같다 3. 조건 만족하는 제일 작은 수
        // int target = Integer.toBinaryString(n).replaceAll("0", "").length(); // 1 갯수
        int first_count = 0;
        String tmp = Integer.toBinaryString(n);
        for(int i = 0; i < tmp.length(); i++){
            if(tmp.charAt(i) == '1') first_count++;
        }
        
        while(true){
            answer++; // 값 증가하고 비교
            // int compare = Integer.toBinaryString(answer).replaceAll("0", "").length();
            int second_count = 0;
            String tmptmp = Integer.toBinaryString(answer);
            for(int i = 0; i < tmptmp.length(); i++){
                if(tmptmp.charAt(i) == '1') second_count++;
            }
            
            if(first_count == second_count)
                break;
        }
        
        // 판단해야 할 것
        // 1.라이브러리를 사용하는 것이 효율성 측면에서 안 좋은 거 같다.
        // 2. 규칙성이 무조건적으로 존재할 것 같다. 
        
        return answer;
    }
}