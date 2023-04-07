
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Loc{
        int pos;
        int count;
        Loc(int pos, int count){
            this.pos = pos;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int fin = Integer.parseInt(input[1]);


        int min = Integer.MAX_VALUE;
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(start, 0));
        boolean[] visited = new boolean[100001]; // 최대 움직일 수 있는 거리는 100000인 점을 고려한다.

        while(!queue.isEmpty()){ // 다양한 방법으로 목적지에 도달하기 때문에 경우마다 다른 count가 나오기 때문에 종합한 후에 출력해야 한다.
            Loc tmp = queue.poll();
            visited[tmp.pos] = true;
            if(tmp.pos == fin)
                min = Math.min(min, tmp.count);

            if(tmp.pos * 2 <= 100000 && !visited[tmp.pos * 2]) queue.offer(new Loc(tmp.pos*2, tmp.count));
            if(tmp.pos+1 <= 100000 && !visited[tmp.pos + 1]) queue.offer(new Loc(tmp.pos+1, tmp.count + 1));
            if(tmp.pos-1 >= 0 && ! visited[tmp.pos - 1]) queue.offer(new Loc(tmp.pos-1, tmp.count + 1));
//            int nx = tmp.pos * 2;
//            if(nx >= 100001) continue;
//            if(!visited[nx]){
//                queue.offer(new Loc(nx, tmp.count));
//                visited[nx] = true;
//            }
//
//            int[] dx = {-1, 1};
//            for(int i = 0; i < 2; i++){
//                nx = tmp.pos + dx[i];
//                if(nx < 0 || nx >= 100001) continue;
//                if(!visited[nx]){
//                    queue.offer(new Loc(nx, tmp.count + 1));
//                    visited[nx] = true;
//                }
//            }
        }

        System.out.println(min);

    }


}
