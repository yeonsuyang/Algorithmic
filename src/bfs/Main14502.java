package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502{

    static int[][] input;
    static int[][] visit;
    static int[][] copyInput;
    static int[][] copyVisit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int ans = -1;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        input = new int[N][M];
        visit = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                input[i][j] = Integer.parseInt(st.nextToken()); //input 받기
            }
        }

        //벽 3 세우기.

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(input[i][j] == 0 && visit[i][j] == 0) {//빈칸이면서 방문한 적이 없으면
                    input[i][j] = 1;
                    visit[i][j] = 1;
                    createWall(1); //벽 갯수와 함께 보내기.
                    input[i][j] = 0;
                }
            }
        }

        System.out.println(ans);
    }

    private static void createWall(int countWall) {

        if(countWall > 3) {
            return;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(input[i][j] == 0 && visit[i][j] == 0) {//빈칸이면서 방문한 적이 없으면
                    input[i][j] = 1;
                    if(countWall == 2) {
                        copyInput();//바이러스뿌리러가기.
                    }else {
                        createWall(countWall + 1); //벽 갯수와 함께 보내기.
                    }
                    input[i][j] = 0;
                }
            }
        }

    }

    private static void copyInput() {
        copyInput = new int[N][M];
        copyVisit = new int[N][M];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                copyInput[i][j] = input[i][j];
            }
        }

        //바이러스뿌리기
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(copyInput[i][j] == 2 && copyVisit[i][j] == 0) {
                    copyVisit[i][j] = 1;
                    spreadVirus(i,j);
                }
            }
        }

        int safeZone = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(copyInput[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        //개수세기 안정영역의 최대값 구하기

        if(ans == -1 || ans < safeZone) {
            ans = safeZone;
        }
    }

    private static void  spreadVirus(int y, int x) {

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x,y));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0;i<4;i++) {
                int hy = p.y + dy[i];
                int hx = p.x + dx[i];

                if(hy < 0 || hx < 0 || hy > N-1 || hx > M-1) {
                    continue;
                }

                if(input[hy][hx] == 1 || copyVisit[hy][hx] == 1) {
                    continue;
                }

                q.add(new Point(hx,hy));
                copyInput[hy][hx] = 2;
                copyVisit[hy][hx] = 1;
            }
        }
    }
}
