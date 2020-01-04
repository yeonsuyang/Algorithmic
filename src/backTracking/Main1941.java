package backTracking;

/*
총 25명의 여학생들로 이루어진 여학생반은 5*5의 정사각형 격자 형태로 자리가 배치되었고, 얼마 지나지 않아 이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다. 곧 모든 여학생이 ‘이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며,
 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.

위기의식을 느낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다. ‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.

이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.

'S'(이다‘솜’파의 학생을 나타냄) 또는 'Y'(임도‘연’파의 학생을 나타냄)을 값으로 갖는 5*5 행렬이 공백 없이 첫째 줄부터 다섯 줄에 걸쳐 주어진다.

첫째 줄에 ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 출력한다.

YYYYY
SYSYS
YYYYY
YSYYS
YYYYY

2
 */

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main1941 {

    static int ans;
    static char[][] input = new char[5][5];
    static int[][] visit = new int[5][5];
    static int[][] visit2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Stack<Point> s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            input[i] = temp.toCharArray();
        }

        s = new Stack<Point>();

        for (int i = 0; i < 4; i++) { // 마지막 줄 부터 시작해봤자 7개가 안되기 때문에
            for (int j = 0; j < 5; j++) {
                visit[i][j] = 1;
                visit2 = new int[5][5];
                calculate(i, j, 0);
            }
        }

        System.out.println(ans);

    }


    private static void calculate(int y, int x, int som) {

        s.push(new Point(x, y));
        visit2[y][x] = 1;

        if (input[y][x] == 'S') {
            som++;
        }

        if (s.size() == 7) {

            if (som >= 4) {
                ans++;
            }
            s.pop(); //7개가 됐으면 꺼내기.
            return;
        }

        for (int i = 0; i < 4; i++) {
            int hy = y + dy[i];
            int hx = x + dx[i];

            if(hy < 0 || hx < 0 || hy > 4 || hx > 4){
                continue;
            }

            if (visit[hy][hx] != 0 || visit2[hy][hx] != 0) {
                continue;
            }
            calculate(hy, hx, som);
        }

        s.pop();
        if(input[y][x] == 'S'){
            som--;
        }
    }


}
