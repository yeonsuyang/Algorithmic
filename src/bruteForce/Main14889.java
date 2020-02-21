package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14889 {
    /*
    스타트 팀: S12 + S21 = 1 + 4 = 5
    링크 팀: S34 + S43 = 2 + 5 = 7
    1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.

    스타트 팀: S13 + S31 = 2 + 7 = 9
    링크 팀: S24 + S42 = 6 + 4 = 10

    첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
    첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.
     */

    static int[][] input;
    static int N;
    static int ans = -1;
    static List<Integer> p = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = new int[N+1][N+1];

        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }// input

        //순열 구하기.

        for(int i=1;i<=N/2;i++){
            p.add(i);

            if(p.size() == N/2){
                calculate();
            }else if(p.size() < N/2){
                permutation(i+1);
            }

            p.remove(p.size()-1);
        }


        System.out.println(ans);

    }

    private static void permutation(int start) {
        for(int i=start;i<N+1;i++){
            p.add(i);

            if(p.size() == N/2){
                calculate();
            }else if(p.size() < N/2){
                permutation(i+1);
            }

            p.remove(p.size()-1);
        }
    }

    public static void calculate(){

        List<Integer> noneP = new LinkedList<>();

        for(int i=1;i<N+1;i++){
            if(!p.contains(i)){
                noneP.add(i);
            }
        }

        int phap = 0;
        int nonphap = 0;

        for(int i=0;i<(p.size()/2)+1;i++){
            for(int j=i+1;j<p.size();j++){
                phap += (input[p.get(i)][p.get(j)] + input[p.get(j)][p.get(i)]);
                nonphap += (input[noneP.get(i)][noneP.get(j)] + input[noneP.get(j)][noneP.get(i)]);
            }
        }

        int chai = Math.abs(phap - nonphap);
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i) + " , " + noneP.get(i));
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + phap + " + " +nonphap + " = "+chai);

        if(ans == -1 || chai < ans){
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡans = "+chai);
            ans = chai;
        }
    }
}