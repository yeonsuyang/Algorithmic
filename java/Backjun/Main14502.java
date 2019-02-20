package study;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 

새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 
2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

27
 */
public class Main14502 {
      
      static int N;
      static int M;
      static int ans = -1;
      static int[][] input;
      static int[][] temp;
      static int[] dx = {-1,1,0,0};
      static int[] dy = {0,0,-1,1};
      
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken()); // 세로
      M = Integer.parseInt(st.nextToken()); // 가로
      
      input = new int[N+1][M+1];
      temp = new int[N+1][M+1];
      
      for(int i=0;i<N;i++){
         st = new StringTokenizer(br.readLine());
         for(int j=0;j<M;j++){
            input[i][j] = Integer.parseInt(st.nextToken()); //입력 받음
            temp[i][j] = input[i][j];
         }
      }

      //벽 3개 세워주기
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
            if(temp[i][j] == 0){
               temp[i][j] = 1;
               changeWall(i,j,1);
               temp[i][j] = 0;
            }
         }
      }
      System.out.println(ans);
   }

   /**
    * 
    * <p>
    * 
    * @since    1.0
    * @author    ysyang - 2019. 2. 13.
    * @param i
    * @param j
    */
   private static void changeWall(int x, int y, int count) {
      // TODO Auto-generated method stub
      if(count == 3){
         bfs();
         return;
      }
      
      for(int i=0; i<N;i++){
         for(int j=0;j<M;j++){
            if(temp[i][j] == 0){
               temp[i][j] = 1;
               changeWall(i,j,count++);
               temp[i][j] = 0;
            }
         }
      }
      
   }

   /**
    * 
    * <p>
    * 
    * @since    1.0
    * @author    ysyang - 2019. 2. 13.
    */
   private static void bfs() {
      
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
            
            if(temp[i][j] == 2){
            Queue<Point> q = new LinkedList<Point>();
            q.add(new Point(0,0));
               
               while(!q.isEmpty()){
                  Point p = q.poll();
                  
                  for(int k=0;k<4;k++){
                     int hx = p.x+dx[k];
                     int hy = p.y+dy[k];
                     
                     if(hx < 0 || hy< 0 || hx > M-1 || hy > N-1){
                        continue;
                     }
                     if(temp[hy][hx] != 0){
                        continue;
                     }
                     
                     temp[hy][hx] = 2;
                     q.add(new Point(hx,hy));
                  }
                  
               }
            }
         }
      }
      
      int count = 0;
      for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
             if(temp[i][j] == 2){
                count++;
             }
            }
         }
      
      if(count < ans || ans == -1){
         ans = count;
      }
      
   }
}
