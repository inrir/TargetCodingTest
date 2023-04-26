class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        // 부호를 변동하여 target을 맞출 수 있는 경우를 정하자.
        answer = 0;
        DFS(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 깊이가 도달했을 때
            if(sum == target) answer++;
            return; // end sign
        }
        
        DFS(numbers, depth+1, target, sum + numbers[depth]);
        DFS(numbers, depth+1, target, sum - numbers[depth]);
        
    }
}