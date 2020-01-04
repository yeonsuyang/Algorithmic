package etc;

import java.awt.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution3 {

    static int[][] visit;
    static int[] dx = {-1,1,0,0,1,-1,1,-1};
    static int[] dy = {0,0,1,-1,1,-1,-1,1};

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {

        int ans =0;
        int count = 0;
        visit = new int [matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(visit[i][j] == 0 && matrix[i][j] == 1){

                    count = bfs(i,j,matrix);
                    ans = count > ans ? count : ans;
                }
            }
        }

        return ans;
    }

    public static int bfs(int y,int x,int[][] matrix){

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visit[y][x] = 1;
        int count = 1;

        while (!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<8;i++){
                int hy = p.y + dy[i];
                int hx = p.x + dx[i];

                if(hy < 0 || hx < 0 || hy > matrix.length -1 || hx > matrix[0].length -1){
                    continue;
                }

                if(matrix[hy][hx] == 0 || visit[hy][hx] == 1){
                    continue;
                }

                visit[hy][hx] = 1;
                q.add(new Point(hx,hy));
                count++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       int[][] matrix = {{0,0,1,1},{0,0,1,0},{0,1,1,0},{0,1,0,0},{1,1,0,0}};
       System.out.println(connectedCell(matrix));
    }
}
