package dijkstra;

/*

헛간의 개수는 N(2 <= N <= 20,000)개


모든 헛간은 M(1<= M <= 50,000)개 길
또한 어떤 헛간에서 다른 헛간으로는 언제나 도달 가능하다고 생각해도 좋다. 

1번헛간에서 가장 먼 헛간 출력

첫 번째는 숨어야 하는 헛간 번호를(만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다), 
두 번째는 그 헛간까지의 거리를, 세 번째는 그 헛간과 같은 거리를 갖는 헛간의 개수를 출력해야한다.


6 7 
3 6
4 3
3 2
1 3
1 2
2 4
5 2

4 2 3 //숨어야하는 헛간번호(같은거면 제일 작은) //거리 //같은 헛간 개수 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main6118 {

   static Farm[] dis;
   static ArrayList<Integer> map[];

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken()); // 헛간 개수
      int m = Integer.parseInt(st.nextToken()); // 헛간 양방향의 길

      dis = new Farm[n];
      map = new ArrayList[n];
      
      for(int i=0;i<n;i++) {
    	  map[i] = new ArrayList<>();
    	  dis[i] = new Farm(i,0);
      }
      for (int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int y = Integer.parseInt(st.nextToken())-1;
         int x = Integer.parseInt(st.nextToken())-1;

         map[y].add(x);
         map[x].add(y);
      }

      calculate();
      
      int count = 1;
      
      Arrays.sort(dis);

      for (int i = 1; i < dis.length; i++) {
         if (dis[0].distance == dis[i].distance) {
        	 count++;
         }else {
        	 break;
         }
      }
      System.out.print((dis[0].num+1)+" " +dis[0].distance+ " " + count);
   }

   private static void calculate() {

      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.add(0);
      
      while (!pq.isEmpty()) {
         int f = pq.poll();

         for (int i = 0; i < map[f].size(); i++) {
        	   int temp = map[f].get(i);
        	   
        	   if(temp == 0) {
        		   continue;
        	   }
               if(dis[temp].distance != 0 && dis[temp].distance <= dis[f].distance + 1){
                  continue;//dis가 0이 아니면서 +1한것보다 작으면 pass
               }
               
               dis[temp].distance = dis[f].distance + 1;
               pq.add(temp);
               //크거나 0이면 +1. 그리고 q에 넣기 
            }
         
      }
   }

}

class Farm implements Comparable<Farm> {

   int num;
   int distance;

   public Farm(int num, int distance) {
      // super();
      this.num = num;
      this.distance = distance;
   }

   @Override
   public int compareTo(Farm target) {
	  if(this.distance == target.distance) {
		  return Integer.compare(this.num, target.num);
	  }
      return Integer.compare(target.distance,this.distance);
   }
}