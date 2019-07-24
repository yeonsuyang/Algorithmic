package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11559 {

    static int N = 12;
    static int M = 6;
    static char[][] input;
    static int[][] visit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count = 0;
    static int change = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        input = new char[N][M];
        visit = new int[N][M];

        for(int i=0;i<N;i++) {
            String st = sc.next();
            for(int j=0;j<M;j++) {
                input[i][j] = st.charAt(j);
            }//입력받고
        }

        //터트리고
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] != '.'){
                    visit[i][j] = 1;
                    bomb(i,j);
                }
            }
        }//한바퀴돌면서 터트리고 나면

        if(change > 0){//터트려진게 있으면
            count++;
            changeInput();
        }

        //터트리고
        //떨구고
        //터트리고
        System.out.println(count);
    }


    private static void changeInput() {
        // TODO Auto-generated method stub
        //내리고
        for(int j=0;j<M;j++){
            int charEnd = -1;
            int charStart = -1;
            int blankEnd = -1;
            for(int i=0;i<N;i++){
                if(input[i][j] != '.'){
                    charEnd = i;
                    if(charStart == -1){
                        charStart = i;
                    }
                }else{
                    blankEnd = i;
                    if(charStart != -1 && blankEnd - charEnd > 0){
                        int temp = blankEnd - charEnd;
                        for(int k=charEnd;k>=charStart;k--){
                            input[k+temp][j] = input[k][j];
                            input[k][j] = '.';
                        }
                        charStart = charStart+temp;
                        charEnd = charEnd+temp;

                    }
                }
            }
        }
        change = 0;
        visit = new int[N][M]; // visit 초기화

        //다시 터트리러 갔다.
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] != '.'){
                    visit[i][j] = 1;
                    bomb(i,j);
                }
            }
        }
        //만약 또 내려야되면 내리고
        if(change > 0){//터트려진게 있으면
            count++;
            changeInput();
        }
        //아니면 끝
    }


    private static void bomb(int y, int x) {

        Queue<Point> q= new LinkedList<Point>(); //터트릴 거 찾는 리스트
        Queue<Point> bombList= new LinkedList<Point>(); //터트릴 때 쓸 리스트
        q.add(new Point(x,y));
        bombList.add(new Point(x,y));

        char c = input[y][x];

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int hx = p.x + dx[i];
                int hy = p.y + dy[i];

                if(hx < 0 || hy < 0 || hy > N-1 || hx > M-1){
                    continue;
                }

                if(input[hy][hx] != c || visit[hy][hx] == 1){//다르면 패스
                    continue;
                }

                q.add(new Point(hx,hy));
                bombList.add(new Point(hx,hy));
                visit[hy][hx] = 1;
            }
        }

        if(bombList.size() >= 4){ //4개 이상이면 터트리기.
            change++; //터트릴게 있었다는 뜻.
            while(!bombList.isEmpty()){
                Point b = bombList.poll();
                input[b.y][b.x] = '.';//터트림
            }
        }

    }


}
