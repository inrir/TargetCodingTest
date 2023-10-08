class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        //DFS로 +,- 경우 모두 탐색해주기
        
        DFS(target, numbers, 0, 0);
        return answer;
    }
    
    public void DFS(int target, int[] numbers, int count, int sum){
        // count == numbers.length 일 경우 return
        if(count == numbers.length){
            // target == sum 경우 충족 answer++;
            if(target == sum){
                answer++;
            }
            return;
        }
        
        DFS(target, numbers, count + 1, sum + numbers[count]);
        DFS(target, numbers, count + 1, sum - numbers[count]);
        
    }
        
}