package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점은 물에 잠긴다고 가정한다.

이제 위와 같은 지역에 많은 비가 내려서 높이가 4 이하인 모든 지점이 물에 잠겼다고 하자.
이 경우에 물에 잠기는 지점을 회색으로 표시하면 다음과 같다.

물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다.
위의 경우에서 물에 잠기지 않는 안전한 영역은 5개가 된다(꼭짓점으로만 붙어 있는 두 지점은 인접하지 않는다고 취급한다).

또한 위와 같은 지역에서 높이가 6이하인 지점을 모두 잠기게 만드는 많은 비가 내리면 물에 잠기지 않는 안전한 영역은 아래 그림에서와 같이 네 개가 됨을 확인할 수 있다.

N은 2 이상 100 이하의 정수이다. 둘째 줄부터 N개의 각 줄에는 2차원 배열의 첫 번째 행부터 N번째 행까지 순서대로 한 행씩 높이 정보가 입력된다.
각 줄에는 각 행의 첫 번째 열부터 N번째 열까지 N개의 높이 정보를 나타내는 자연수가 빈 칸을 사이에 두고 입력된다. 높이는 1이상 100 이하의 정수이다.

첫째 줄에 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력한다.

5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7

5


 */
public class Main2468 {

    static int N;
    static int[][] input;
    static int[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        input = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int k=2;k<100;k++){
            visit = new int[N][N];
            int count = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(input[i][j] > k && visit[i][j] == 0) {
                        count++;
                        bfs(k, i, j);
                    }
                }
            }

            if(ans <= count){
                ans = count;
            }else{
                break;
            }
        } // k for 문 끝


        System.out.println(ans);
    }

    private static void bfs(int k, int y, int x) {
        Queue<Point> q = new LinkedList();
        q.add(new Point(x,y));
        visit[y][x] = 1;

        while (!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int hy = p.y + dy[i];
                int hx = p.x + dx[i];


                if(hy < 0 || hx < 0 || hy > N-1 || hx > N-1){
                    continue;
                }

                if(input[hy][hx] <= k || visit[hy][hx] != 0){
                    continue;
                }

                visit[hy][hx] = 1;
                q.add(new Point(hx,hy));
            }
        } //while 끝
    }
}
