package graph;

/*
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 같은 사각형
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.
둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
입력의 마지막 줄에는 0이 두 개 주어진다.

각 테스트 케이스에 대해서, 섬의 개수를 출력한다.


1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

0
1
1
3
1
9
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {

    static  int[][] input;
    static  int[][] visit;//
    static int w;
    static int h;
    static int[] dx = {-1,-1,1,1,1,-1,0,0};
    static int[] dy = {-1,1,-1,1,0,0,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken()); //가로
            h = Integer.parseInt(st.nextToken()); //세로

            if(w == 0 && h == 0){
                break; //둘다 0 0 이면 종료
            }

            input = new int[h][w];
            visit = new int[h][w];


            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(input[i][j] == 1 && visit[i][j] == 0){
                        bfs(i,j);
                        count ++;
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void bfs(int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[y][x] = 1;

        while(!q.isEmpty()){

            Point p = q.poll();

            for(int i=0;i<8;i++){
                int hy = p.y + dy[i];
                int hx = p.x + dx[i];


                if(hy < 0 || hx < 0 || hy > (h-1) || hx > (w-1) ){
                    continue;
                }

                if(input[hy][hx] == 0 || visit[hy][hx] == 1){
                    continue;
                }

                visit[hy][hx] = 1;
                q.add(new Point(hx,hy));
            }
        }
    }

}
