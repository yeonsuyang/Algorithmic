package dfs;

/*
배추를 재배하려면 배추를 해충으로부터 보호, 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다.
이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어,
그 배추들 역시 해충으로부터 보호받을 수 있다.

구역 개수 구하기.


2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

5
1

 */

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1012 {

    static int[][] input;
    static int[][] visit;
    static int M;
    static int N;
    static int K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트 케이스;

        while(T>0){

            M = sc.nextInt(); //가로
            N = sc.nextInt(); //세로
            K = sc.nextInt(); //배추개수

            input = new int[N][M];
            visit = new int[N][M];

            for(int i=0;i<K;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                input[y][x] = 1;
            }

            int ans = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(input[i][j] == 1 && visit[i][j] == 0){
                        ans ++;
                        calculate(i,j);
                    }
                }
            }

            System.out.println(ans);

            T--;
        }

    }

    private static void calculate(int y, int x) {

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
}
