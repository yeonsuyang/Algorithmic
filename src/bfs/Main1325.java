package bfs;

/*
해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다.
이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.

5 4
3 1
3 2
4 3
5 3

1 2
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1325 {
    static ArrayList<Integer>[] input;
    static int[] answer;
    static int[] visit;
    static int max;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        M = Integer.parseInt(st.nextToken()); //줄 수

        input = new ArrayList[N];
        answer = new int[N];
        visit = new int[N];

        for(int i=0;i<N;i++){
            input[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            input[B-1].add(A-1);
        }

        for(int i=0;i<N;i++){
                answer[i] = calculate(i);
                max = answer[i] > max ? answer[i] : max;
        }

        for(int i=0;i<N;i++){
            if(answer[i] == max) {
                System.out.print(i+1 + " ");
            }
        }


    }

    private static int calculate(int point) {
        int cal = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(point);

        visit = new int[N];
        visit[point] = 1;

        while(!q.isEmpty()){
            int p = q.poll();

            for(int i=0;i<input[p].size();i++){
                int temp = input[p].get(i);
                if(visit[temp] == 0) {
                    q.add(input[p].get(i));
                    visit[input[p].get(i)] = 1;
                    cal++;
                }
            }
        }

        return cal;
    }
}
