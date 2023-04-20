class Solution {
    // 문제 이해가 전혀 안된다..?? 
    // 바깥쪽 갈색, 중앙쪽 노란색으로 채운다. 
    // 전체 더한 것 x + y = a * b 형태로 나눈다.
    // 후기! 예시를 생각해보면 특정 패턴이 나오는데 해당 특성을 반영해봐라.
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        // 패턴! 노락색이 갈색보다 세로, 가로 각각 2씩 차이난다.
        for(int i = 1; i <= sum; i++){ // yello가 더 크기 때문에
            int a = i; // 세로
            if(sum % i != 0) continue;
            int b = sum / i; // 가로
            
            if(b < a) continue; // 가로보다 세로가 길 경우 삭제
            
            if((a - 2) * (b - 2) == yellow){ // key point
                answer[0] = b;
                answer[1] = a;
                break;
            }
            
            
        }    
        
        
        return answer;
    }
}