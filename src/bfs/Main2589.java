package bfs;

/*
보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다.
보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
각 칸은 육지(L)나 바다(W)로 표시되어 있다. 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며,
한 칸 이동하는데 한 시간이 걸린다.
보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.
예를 들어 위와 같이 지도가 주어졌다면 보물은 아래 표시된 두 곳에 묻혀 있게 되고, 이 둘 사이의 최단 거리로 이동하는 시간은 8시간이 된다.

첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다. 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다. 보물 지도의 가로, 세로의 크기는 각각 50이하이다.
첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.
 */
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2589 {

    static int N;
    static int M;
    static char[][] input;
    static int[][] visit;
    static int max;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        input = new char[N][M];

        for(int i=0;i<N;i++) {
            String st = sc.next();
            for(int j=0;j<M;j++) {
                input[i][j] = st.charAt(j);
            }//입력받고
        }

        for (int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] == 'L'){
                    calculate(i,j);
                }
            }
        }

        System.out.println(max);

    }

    private static void calculate(int y, int x) {

        visit = new int[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int hx = p.x + dx[i];
                int hy = p.y + dy[i];

                if(hx < 0 || hy < 0 || hy > N-1 || hx > M-1){
                    continue;
                }

                if(input[hy][hx] != 'W' && (visit[hy][hx] ==0 || visit[hy][hx] > visit[p.y][p.x] + 1 )) {
                    visit[hy][hx] = visit[p.y][p.x] + 1;
                    max = visit[hy][hx] > max ? visit[hy][hx] : max;
                    q.add(new Point(hx,hy));
                }
            }

        }


    }
}
