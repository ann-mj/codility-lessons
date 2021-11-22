package boj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int x,y;
    static int[][] map;
    static int[] square = new int[7]; // 주사위, 1~6 index
    static int[] instructions;
    static int[][] directions = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; // 차례대로 동, 서, 북, 남
    static void input() {
        N = scan.nextInt(); // 세로 크기, r 과 관련 있음
        M = scan.nextInt(); // 가로 크기, c 와 관련 있음
        x = scan.nextInt();
        y = scan.nextInt();
        K = scan.nextInt(); // 총 횟수
        map = new int[N][M]; // 0,0 부터 N-1,M-1 까지
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        instructions = new int[K];
        for(int i = 0; i<K; i++) {
            instructions[i] = scan.nextInt();
        }
    }
    
    static void rotate(int direction) {
        
        int[] temp = new int[7];
        for(int i=1; i<7; i++) {
            temp[i] = square[i];
        }
        switch(direction) {
            case 1: // 동쪽
                square[3] = temp[2];
                square[4] = temp[3];
                square[6] = temp[4];
                square[2] = temp[6];
                break;
            case 2: // 서쪽
                square[6] = temp[2];
                square[2] = temp[3];
                square[3] = temp[4];
                square[4] = temp[6];
                break;
            case 3: // 북쪽
                square[6] = temp[1];
                square[1] = temp[3];
                square[3] = temp[5];
                square[5] = temp[6];
                break;
            case 4: // 남쪽
                square[3] = temp[1];
                square[5] = temp[3];
                square[6] = temp[5];
                square[1] = temp[6];
                break;
        }
    }

    static boolean move(int direction) {
        // 방향에 따른 좌표 계산하기
        int nx = x + directions[direction][0]; // r
        int ny = y + directions[direction][1]; // c
       
        // 바깥으로 이동하려는 경우에는 무시한다.
        if(nx >= N || ny >= M || nx < 0 || ny < 0) {
            return false; // 이동 불가
        }
       
        x = nx;
        y = ny;
        return true;
    }

    static void pro() {
        for(int i = 0; i<K; i++) {
            // map 의 좌표 이동
            if(move(instructions[i])) {
                rotate(instructions[i]); // 주사위만 회전
                if(map[x][y] == 0) {
                    map[x][y] = square[6];
                } else {
                    square[6] = map[x][y];
                    map[x][y] = 0;
                }
                sb.append(square[3]).append('\n');
            }
         }
         System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                while(st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return str;
        }
    }
}
