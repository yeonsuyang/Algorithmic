package dfs;

/*
출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다.
맥주 한 박스에는 맥주가 20개 들어있다. 목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다.

편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다.

편의점, 상근이네 집, 펜타포트 락 페스티벌의 좌표가 주어진다. 상근이와 친구들이 행복하게 페스티벌에 도착할 수 있는지 구하는 프로그램을 작성하시오.
첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)

각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).

다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)

송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)




2 // 테스트 케이스 수 들
2 // 맥주파는 편의점 개수 n
0 0 // 상근이네 집 좌표
1000 0 // 편의점 좌표 1000/50 = 20  20병 끝 + 20병
1000 1000 // 편의점 좌표  1000 2
2000 1000 // 락페스티벌
2
0 0
1000 0
2000 1000
2000 2000

happy
sad
 */

import java.util.Scanner;
import java.awt.*;

public class Main9205 {
    static int N;
    static Point[] input;
    static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T > 0) {
            N = sc.nextInt();
            input = new Point[N+2];
            visit = new int[N+2];

            for (int i = 0; i < N + 2; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                input[i] = new Point(x,y);
            }


                boolean ans = dfs(0);

                if (ans) {
                    System.out.println("happy");
                } else {
                    System.out.println("sad");
                }
            T--;
        }
    }

    public static boolean dfs(int h){

        visit[h] = 1;
        //현재위치면 트루.
        if(h == input.length-1){
            return true;
        }


        //현재 위치에서 그냥 목적지에 도착할 수 있다면 트루.
        if(Math.abs(input[input.length-1].x - input[h].x) + Math.abs(input[input.length-1].y - input[h].y) < 1000){
            return true;
        }

        int minimum = 1001; //최소거리 구하기.
        int next = - 1 ; //다음 목적지
        int left = -1;
        //다음 편의점들 중에 더 가까운 편의점으로 가기.
        for(int i=1;i<input.length;i++) {

            int cal = Math.abs(input[i].x - input[h].x) + Math.abs(input[i].y - input[h].y);
            if (cal <= 1000 && visit[i] == 0) {
                if (next == -1) {
                    minimum = cal;
                    next = i; //최소 거리로 가기.
                } else {
                    int mok = Math.abs(input[input.length - 1].x - input[i].x) + Math.abs(input[input.length - 1].y - input[i].y);

                    if (left == -1 || left > mok) { // 목적지 쪽으로 가야하니까..
                            minimum = cal;
                            next = i; //최소 거리로 가기.
                            left = Math.abs(input[input.length - 1].x - input[i].x) + Math.abs(input[input.length - 1].y - input[i].y);
                        }
                    }
                }
            }


        //근데 가장 가까운 편의점이 이미 1000보다 크면 false;
        if(next == -1){
            return false;
        }
        //System.out.println(next);
        return dfs(next);
    }
}
