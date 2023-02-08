package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Boj 1920 수 찾기
 *
 * input: N, contents, M, contents
 *
 * process:
 * N, M 1 ~ 100,000
 * contents -2^31 ~ 2^31
 *
 * output: if it exist, 1 or not 0
 *
 * algo:
 * Boj 10815와 동일한 흐름 => HashMap or binary search
 */
public class Boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N  = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            map.put(st.nextToken(), 0);
        }

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < M; i++){
            if(map.containsKey(st.nextToken())){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }

    // 만약에 이분 탐색으로 가능하다면

    /**
     *
     * @param arr 주어진 배열
     * @param key 배열에서 찾아야 하는 키값
     * @return key에 대한 인덱스 or -1(없음)
     */
    static int BinarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){ // left가 커지면 끝
            int mid = (left + right) / 2; // 중간 값 찾기

            if(key < arr[mid]) { // 왼쪽으로 이동
                right = mid - 1;
            }else if(key > arr[mid]){ // 오른쪽으로 이동
                left = mid + 1;
            }else{ // find it
                return mid;
            }
        }
        return -1; // no find

    }
}
