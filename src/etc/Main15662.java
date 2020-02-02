package etc;

/*
첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다.
상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.

다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고,
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.


총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.

1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
맞닿은 극이 같기 때문에 회전하지 않는다.


1번은 2와. 2번의 6
2번의 2와. 3번의 6
3번의 2와. 4번의 6

12시 방향이 S극인 개수 출력

4
10101111
01111101
11001110
00000010
2
3 -1
1 1

5
10010011
01010011
11100011
01010101
01010011
10
1 1
2 1
3 1
4 1
1 -1
2 -1
3 -1
4 -1
5 1
5 -1

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15662 {

    static int[][] topni;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //톱니바퀴의 개수
        topni = new int[T+1][8];
        int[][] change = new int[T+1][2]; //돌릴 톱니바퀴와 방향 정하기.

        int top = 0;
        int left = 6;
        int right = 2;

        for(int i=1;i<T+1;i++){
            String s = br.readLine();
            for(int j=0;j<8;j++){
                topni[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine()); //회전 횟수

        while(K>0){

            for(int i=1;i<T+1;i++){
                Arrays.fill(change[i],0);
            }

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //톱니바퀴의 번호
            int dir = Integer.parseInt(st.nextToken()); //회전시킬 방향

            change[num][0] = 1;
            change[num][1] = dir;

            if(num > 1){ //왼쪽에도 톱니바퀴가 있다면
                int temp1 = num; //3
                int temp2 = num-1; //2
                while(temp2 > 0){
                    if(topni[temp1][left] != topni[temp2][right]){
                        change[temp2][0] = 1;
                        change[temp2][1] = change[temp1][1] * (-1);
                    }
                    temp1 = temp2;
                    temp2 = temp1 -1;
                }
            }

            if(num < T){
                int temp1 = num;
                int temp2 = num+1;
                while(temp2 <= T){
                    if(topni[temp1][right] != topni[temp2][left]){
                        change[temp2][0] = 1;
                        change[temp2][1] = change[temp1][1] * (-1);
                    }
                    temp1 = temp2;
                    temp2 = temp1 +1;
                }
            }

            for(int i=1;i<T+1;i++){
                if(change[i][0] == 1 && change[i][1] == 1){ //시계방향
                    int temp = topni[i][7];
                    for(int j=6;j>=0;j--){
                        topni[i][j+1] = topni[i][j];
                    }
                    topni[i][0] = temp;
                }
                if(change[i][0] == 1 && change[i][1] == -1){ //반시계방향
                    int temp = topni[i][0];
                    for(int j=0;j<7;j++){
                        topni[i][j] = topni[i][j+1];
                    }
                    topni[i][7] = temp;
                }
            }

            K--;
        }//while 끝

        int ans = 0;

        for(int i=1;i<T+1;i++){
            if(topni[i][top] ==1){
                ans++;
            }
        }

        System.out.println(ans);

    }
}
