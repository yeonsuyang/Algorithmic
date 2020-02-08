package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {

    /*
    현재 위치를 청소한다.
    현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
    왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
    왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
    네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
    네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
    로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

    첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
    둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d
    가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

    로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
     */

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] input;
    static int n,m,ans=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        input = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 받고

        simulation(r,c,d);

        System.out.println(ans);
    }

    public static void simulation(int r,int c,int d){

        if(r > n-1 || c > m-1 || r < 0 || c <0){
            return;
        }

        if(input[r][c] == 0) {
            input[r][c] = 2;
            ans++;
        }else if(input[r][c] == 1){
            return;
        }

        int nextD=d; // 다음 진행할 방향. (왼쪽방향)

        if(d == 0){
            nextD = 3;
        }else{
            nextD -= 1;
        }

        //왼쪽으로 한칸 전진한 위치.
        int nextR = r+dy[nextD];
        int nextC = c+dx[nextD];

        //후진할 위치
        int backR = r+(dy[d]*-1);
        int backC = c+(dx[d]*-1);


        if(input[nextR][nextC] != 1 && input[nextR][nextC] != 2){ //벽이 아니면.
            simulation(nextR,nextC,nextD); // 그 전진 후 그 방향을 청소하러
        }else{//벽이거나 청소했으면
            Boolean bk = true;
            int tempD = nextD;
            while(true){
                if(tempD == 0){
                    tempD = 3;
                }else{
                    tempD -= 1;
                }

                int tempR = r+dy[tempD];
                int tempC = c+dx[tempD];

                if(input[tempR][tempC] == 0){
                    simulation(tempR,tempC,tempD);
                    bk = false;
                    break;
                }

                if(tempD == d){
                    break;
                }
            }

            if(bk) {
                simulation(backR, backC, d); //한칸 후진 후, 방향 유지
            }
        }


    }
}
