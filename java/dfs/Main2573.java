package dfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는 일년마다 그 칸에 동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.

이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오.
만일 전부 다 녹을 때까지  두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다

첫 줄에는 이차원 배열의 행의 개수와 열의 개수를 나타내는 두 정수 N과 M이 한 개의 빈칸을 사이에 두고 주어진다.
N과 M은 3 이상 300 이하이다. 각 칸에 들어가는 값은 0 이상 10 이하이다.
배열에서 빙산이 차지하는 칸의 개수, 즉, 1 이상의 정수가 들어가는 칸의 개수는 10,000 개 이하이다. 배열의 첫 번째 행과 열, 마지막 행과 열에는 항상 0으로 채워진다.

첫 줄에 빙산이 분리되는 최초의 시간(년)을 출력한다. 만일 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다.

5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0

2
 */
public class Main2573 {

    static int N;
    static int M;
    static int[][] input;
    static int[][] temp;
    static int[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year=0;
        boolean allmelt = true;
        int count = 0;

        while(allmelt && count < 2){ //카운트가 2보다 높아졌거나, 다 녹았으면 끝
            temp = new int[N][M];
            year++;
            //녹이기
            allmelt = calculate();

            //다 녹아있었다면
            if(!allmelt){
                year = 0;
                break;
            }

            input = temp;
            //영역 구분
            count = 0;
            visit = new int[N][M];


            for(int i=0;i<N;i++) {
                for (int j = 0; j < M; j++) {
                    if (input[i][j] > 0 && visit[i][j] == 0) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
        }

        System.out.println(year);

    }

    private static boolean calculate() {

        boolean f = false;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] > 0) {
                    f = true;
                    int tc = input[i][j] - melt(i, j);
                    temp[i][j] = tc > 0 ? tc : 0;
                }else{
                    temp[i][j] = 0;
                }
            }
        }

        return f;
    }

    private static void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[y][x] = 1;

        while (!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int hy = p.y + dy[i];
                int hx = p.x + dx[i];

                if(hy < 0 || hx < 0 || hy > N-1 || hx > M-1){
                    continue;
                }

                if(visit[hy][hx] == 1 || input[hy][hx] == 0){
                    continue;
                }

                visit[hy][hx] = 1;
                q.add(new Point(hx,hy));
            }
        }

    }

    private static int melt(int y, int x) {
        int count = 0;

        for(int i=0;i<4;i++){
            int hx = x + dx[i];
            int hy = y + dy[i];

            if(input[hy][hx] == 0){
                count ++;
            }
        }

        return count;
    }
}
