package simulation;

import java.awt.*;
import java.util.*;

public class Main3190 {

    /*
    'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
    게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치(1,1)하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.
    뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.
    1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
    2. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
    3. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
    4. 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.

    N (2 ≤ N ≤ 100) // 보드의 크기
    K  (0 ≤ K ≤ 100) // 사과의 개수
    다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
    L  (1 ≤ L ≤ 100) 뱀의 방향 변환 횟수
    게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

    첫째 줄에 게임이 몇 초에 끝나는지 출력한다.

6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

9
     */

    static int time = 0;
    static int[][] board;
    static int N,K,L;
    static Map<Integer,String> map;
    static Queue<Point> q;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 보드의 크기
        board = new int[N][N];
        K = sc.nextInt(); // 사과의 개수

        for(int i=0;i<K;i++){
            int y = sc.nextInt() -1;
            int x = sc.nextInt() -1;

            board[y][x] = 1;
        }

        L = sc.nextInt(); // 뱀의 방향 변환 횟수
        map  = new HashMap<>();

        for(int i=0;i<L;i++){
            map.put(sc.nextInt(), sc.next());
        }
        //   남
        // 서  동
        //   북

        //동 : 0 , 북 : 1, 서 : 2, 남 : 3
        //D 이면 +1 , L 이면 -1
        q = new LinkedList<Point>();
        q.add(new Point(0,0));
        time ++;
        calculate(0,1,0);
        System.out.println(time);
    }

    private static void calculate(int y, int x, int dir) {

        if(y < 0 || x < 0 || y > N-1 || x > N-1){
            return;
        }

        Point p = new Point(y,x);
        if(q.contains(p)){ // 머리가 간 위치에 몸이 있으면 끝.
            return;
        }else if(board[y][x] == 0){//사과가 없으면
            //젤 처음 넣었던 꼬리 빼주기.
            q.poll();
        }else{
            board[y][x] = 0;
        }

        //그리고 지금 자리는 넣어주기.
        q.add(p);

        if(map.containsKey(time)){  // 초가 지나면 방향 바꿔주기.
            String ro = map.get(time);
            if(ro.equals("D")){
                if(dir < 3)  dir += 1; else  dir = 0;
            }else{
                if(dir > 0)  dir -= 1; else  dir = 3;
            }
        }

        int ny = y + dy[dir];
        int nx = x + dx[dir];
        time ++;
        calculate(ny,nx,dir);
    }
}