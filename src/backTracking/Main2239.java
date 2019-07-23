/*
스도쿠는 매우 간단한 숫자 퍼즐이다. 9×9 크기의 보드가 있을 때, 
각 행과 각 열, 그리고 9개의 3×3 크기의 보드에 1부터 9까지의 숫자가 중복 없이 나타나도록 보드를 채우면 된다. 
예를 들어 다음을 보자.



위 그림은 참 잘도 스도쿠 퍼즐을 푼 경우이다. 각 행에 1부터 9까지의 숫자가 중복 없이 나오고, 
각 열에 1부터 9까지의 숫자가 중복 없이 나오고, 각 3×3짜리 사각형(9개이며, 위에서 색깔로 표시되었다)에 
1부터 9까지의 숫자가 중복 없이 나오기 때문이다.

하다 만 스도쿠 퍼즐이 주어졌을 때, 마저 끝내는 프로그램을 작성하시오.

103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107

143628579
572139468
986754231
391542786
468917352
725863914
237481695
619275843
854396127

 */
package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2239 {
   
      static int[][] stoku;
      static int start;
      static int end;
      
   public static void main(String[] args) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      stoku = new int[9][9];
      
      for(int i=0;i<9;i++){
         st = new StringTokenizer(br.readLine());
         for(int j=0;j<0;j++){
            stoku[i][j] = Integer.parseInt(st.nextToken());
         }
      }//입력
      
      start = 0;
      while(start <= 7){
         end = start+3;
         for(int i=start;i<end;i++){
            for(int j=start;j<end;j++){
               if(stoku[i][j] == 0){
                  stoku[i][j] = calcullate(i,j);
               }
            }
         }
         
         start += 3;
      }
      
      for(int i=0;i<9;i++){
         for(int j=0;j<9;j++){
            System.out.print(stoku[i][j]);
         }
         System.out.println();
      }
      
   }
   /**
    * 
    * <p>
    * 
    * @since    1.0
    * @author    ysyang - 2019. 3. 15.
    * @param i
    * @param j
    */
   private static int calcullate(int y, int x) {
      // TODO Auto-generated method stub
      int checkFlag = 0;
      int ans = 0;
      
      for(int i=1;i<=9;i++){
         //사각형 검사
         for(int iy = start; iy<end;iy++){
            for(int jx=start;jx<end;jx++){
               if(stoku[iy][jx] == i){
                  checkFlag = 1;
                  break;
               }
            }
         }
         //가로검사
         for(int jx = 0; jx< 9;jx++){
            if(stoku[y][jx] == i){
               checkFlag = 1;
               break;
            }
         }
         //세로검사    
         for(int iy = 0; iy< 9;iy++){
            if(stoku[iy][x] == i){
               checkFlag = 1;
               break;
            }
         }
         
         if(checkFlag == 0){
            ans = i;
            break;
         }
      }
      return ans;
   }
}