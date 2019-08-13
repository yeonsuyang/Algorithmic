package backTracking;

/*
서양 장기인 체스에는 대각선 방향으로 움직일 수 있는 비숍(bishop)이 있다. <그림 1>과 같은 정사각형 체스판 위에 B라고 표시된 곳에 비숍이 있을 때
비숍은 대각선 방향으로 움직여 O로 표시된 칸에 있는 다른 말을 잡을 수 있다.

그런데 체스판 위에는 비숍이 놓일 수 없는 곳이 있다. <그림 2>에서 체스판에 색칠된 부분은 비숍이 놓일 수 없다고 하자.
이와 같은 체스판에 서로가 서로를 잡을 수 없도록 하면서 비숍을 놓는다면 <그림 3>과 같이 최대 7개의 비숍을 놓을 수 있다.
색칠된 부분에는 비숍이 놓일 수 없지만 지나갈 수는 있다.

정사각형 체스판의 한 변에 놓인 칸의 개수를 체스판의 크기라고 한다. 체스판의 크기와 체스판 각 칸에 비숍을 놓을 수 있는지 없는지에 대한 정보가 주어질 때,
서로가 서로를 잡을 수 없는 위치에 놓을 수 있는 비숍의 최대 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 체스판의 크기가 주어진다. 체스판의 크기는 10이하의 자연수이다. 둘째 줄부터 아래의 예와 같이 체스판의 각 칸에 비숍을 놓을 수 있는지 없는지에 대한 정보가 체스판 한 줄 단위로 한 줄씩 주어진다.
비숍을 놓을 수 있는 곳에는 1, 비숍을 놓을 수 없는 곳에는 0이 빈칸을 사이에 두고 주어진다.

첫째 줄에 주어진 체스판 위에 놓을 수 있는 비숍의 최대 개수를 출력한다.

5
1 1 0 1 1
0 1 0 0 0
1 0 1 0 1
1 0 0 0 0
1 0 1 1 1

7

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1799 {

    static int[][] input;
    static int[][] bishop;
    static int black_ans;
    static int white_ans;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //체스 크기
        input = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bishop = new int[N][N];

        Bcalculate(0, 0, 0);
        Wcalculate(0, 1, 0);

        System.out.println(black_ans + white_ans);
    }

    private static void Bcalculate(int x, int y, int count) {

        if (x > N - 1 || y > N - 1) {
            if (count > black_ans) {
                black_ans = count;
            }
            return;
        }


        for (int i = y; i < N; i++) {
            for (int j = x; j < N; j++) {

                if (bishop[i][j] == 0 && valid(j, i)) {
                    bishop[i][j] = 1;
                    count++;
                }


                if (j == N - 1) {
                    Bcalculate(1, i + 1, count);
                } else if (j == N - 2) {
                    Bcalculate(0, i + 1, count);
                } else {
                    Bcalculate(j + 2, i, count);
                }
                bishop[i][j] = 0;
                count--;

            }

        }
    }

    private static void Wcalculate(int x, int y, int count) {

        if (x > N - 1 || y > N - 1) {
            if (count > white_ans) {
                white_ans = count;
            }
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = x; j < N; j++) {
                if (bishop[i][j] == 0 && valid(j, i)) {
                    bishop[i][j] = 1;
                    count++;
                }

                if (j == N - 1) {
                    Wcalculate(1, i + 1, count);
                } else if (j == N - 2) {
                    Wcalculate(0, i + 1, count);
                } else {
                    Wcalculate(j + 2, i, count);
                }
                bishop[i][j] = 0;
                count--;

            }
        }

    }

    private static boolean valid(int x, int y) {

        if (input[y][x] == 0) {
            return false;
        }

        int[] dx = {-1, 1};
        int[] dy = {-1, -1};
        //대각선을 검사해서 //위만 검사해도 된다고 생각.. !
        for (int i = 1; i <= y; i++) {
            for (int j = 0; j < 2; j++) {
                int hx = x + (i * dx[j]);
                int hy = y + (i * dy[j]);

                if (hx < 0 || hy < 0 || hx > N - 1 || hy > N - 1) {
                    continue;
                }
                if (bishop[hy][hx] == 1) {
                    return false; //이미 비숍이 세워져있으면 리턴
                }
            }
        }
        return true; //끝까지 없었다면 패스
    }
}
