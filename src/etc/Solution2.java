package etc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public class Solution2 {
        static String[] dir = {"UL", "UR", "R", "LR", "LL", "L"};
        static int[] dx = {-2, -2, 0, 2, 2, 0};
        static int[] dy = {-1, 1, 2, 1, -1, -2};
        // Complete the printShortestPath function below.
        static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
            int[][] map = new int[n][n];

            StringBuilder[][] sb = new StringBuilder[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    sb[i][j] = new StringBuilder();
                }
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(i_start,j_start));
            map[i_start][j_start] = 1;

            while(!q.isEmpty()) {
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;
                if(x == i_end && y == j_end) {
                    break;
                }
                String prev = sb[x][y].toString();
                for(int k = 0; k < 6; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(arrayCheck(nx, ny, n, map)) {
                        q.add(new Pair(nx, ny));
                        map[nx][ny] = map[x][y] + 1;
                        sb[nx][ny].append(prev).append(" ").append(dir[k]);
                    }
                }
            }
            if(sb[i_end][j_end].length() == 0) {
                System.out.println("Impossible");
            }
            else {
                sb[i_end][j_end].deleteCharAt(0);
                System.out.println(map[i_end][j_end] - 1);
                System.out.println(sb[i_end][j_end]);
            }
        }
        public static boolean arrayCheck(int x, int y, int n, int[][] map) {
            return (0 <= x && x < n && 0 <= y && y < n && map[x][y] == 0);
        }
        private static final Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] i_startJ_start = scanner.nextLine().split(" ");
            int i_start = Integer.parseInt(i_startJ_start[0]);
            int j_start = Integer.parseInt(i_startJ_start[1]);
            int i_end = Integer.parseInt(i_startJ_start[2]);
            int j_end = Integer.parseInt(i_startJ_start[3]);
            printShortestPath(n, i_start, j_start, i_end, j_end);
            scanner.close();
        }
    }