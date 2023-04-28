import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /**
     * 백준 15863 감시
     *
     */

    static int[] dx = {-1, 0, 1, 0}; // 하, 상
    static int[] dy = {0, 1, 0, -1}; // 좌, 우
    static int N;
    static int M;
    static int[][] nums;
    static int[][] temp_nums;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        N = Integer.parseInt(tmp[0]); // 세로 길이
        M = Integer.parseInt(tmp[1]); // 가로 길이

        nums = new int[N][M]; // 값 들을 넣을 도구

        ArrayList<cctv> cctvs = new ArrayList<>();
        int min = 0; // 빈칸을 모두 측정해줄 것.
        // 1, 3, 4: 4가지 방향으로 하고
        // 2: 2가지 방향
        // 5: 1가지 방향

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(nums[i][j] != 0 && nums[i][j] != 6){ // cctv에 해당하는 것 모두 담기
                    cctvs.add(new cctv(i, j, nums[i][j]));
                }
                if(nums[i][j] == 0) min++; // 현재 빈칸의 갯수 모두 저장
            }
        }

        if(min == 0){ // 예외처리
            System.out.println(min);
            System.exit(0);
        }

        for(int i = 0; i < (1<<(2 * cctvs.size())); i++){ // cctv의 갯수와 방향에 해당하는 모든 경우를 탐지 => 4 ^ cctv
            int temp = i;
            temp_nums = new int[N][M];
            for(int k = 0; k < N; k++){
                System.arraycopy(nums[k], 0, temp_nums[k], 0, M); // 복사할 수 있는 메소드...!!!!!!!
            }

            for(int j = 0; j < cctvs.size(); j++){ // 해당 방향에 따른 행위 실시 -> 총 방향 경우의 수는 위의 for문이 실행 중
                int kind = cctvs.get(j).kind;
                int x = cctvs.get(j).x;
                int y = cctvs.get(j).y;
                int dir = temp % 4;
                temp /= 4; // 4개의 사이클로 가니깐

                if(kind == 1){
                    fill(dir, x, y);
                }else if(kind == 2){
                    fill(dir, x, y);
                    fill(dir + 2, x, y);
                }else if(kind == 3){
                    fill(dir, x, y);
                    fill(dir + 1, x, y);
                }else if(kind == 4){
                    fill(dir, x, y);
                    fill(dir + 1, x, y);
                    fill(dir + 2, x, y);
                }else{ // 5
                    fill(dir, x, y);
                    fill(dir + 1, x, y);
                    fill(dir + 2, x, y);
                    fill(dir + 3, x, y);
                }
            }

            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(temp_nums[j][k] == 0){
                        count++;
                    }
                }
            }

            min = Math.min(min, count);
            if(min == 0){
                System.out.println(min);
                System.exit(0);
            }
        }

        System.out.println(min);

    }

    public static void fill(int dir, int x, int y){ // 한 방향을 모두 채워주기
        dir %= 4; // 모든 방향으로 보는데 값이 초과해도 5 -> 1

        for(int i = 0; i < 8; i++){ // 8인 이유는 N, M의 최대 값이 8이므로 해당 영역을 모두 닿을 수 있다.
            x += dx[dir];
            y += dy[dir];

            if(x >= 0 && x < N && y >= 0 && y < M){
                if(temp_nums[x][y] == 0){
                    temp_nums[x][y] = 7; // # : 7
                }else if(temp_nums[x][y] == 6){
                    return; // 확장 방향에 대해서 막혔기 때문에, return 처리.
                }
            }
        }


    }

    static class cctv{
        int x;
        int y;
        int kind;
        cctv(int x, int y, int kind){
            this.x = x;
            this.y = y;
            this.kind = kind;
        }
    }
}
