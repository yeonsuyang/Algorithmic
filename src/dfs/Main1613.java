package dfs;

/*
임진왜란이 -> 병자호란, 무오사화 -> 기묘사화

세준이가 알고 있는 일부 사건들의 전후 관계들이 주어질 때, 주어진 사건들의 전후 관계도 알 수 있을까? 이를 해결하는 프로그램을 작성해 보도록 하자.
첫째 줄에 첫 줄에 사건의 개수 n(400 이하의 자연수)과
알고 있는 사건의 전후 관계의 개수 k(50,000 이하의 자연수)

앞줄 -> 뒷줄
다음에는 사건의 전후 관계를 알고 싶은 사건 쌍의 수 s(50,000 이하의 자연수)이 주어진다.

다음 s줄에는 각각 서로 다른 두 사건의 번호가 주어진다. 사건의 번호는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

s줄에 걸쳐 물음에 답한다. 각 줄에 만일 앞에 있는 번호의 사건이 먼저 일어났으면 -1, 뒤에 있는 번호의 사건이 먼저 일어났으면 1, 어떤지 모르면(유추할 수 없으면) 0을 출력한다.

사건의 개수 n, 사건이 전후 관계 개수 k
5 5
1 2
1 3
2 3
3 4
2 4
3
1 5
2 4
3 1

0
-1
1

배열에 할당된 크기를 넘어서 접근했을 때
전역 배열의 크기가 메모리 제한을 초과할 때
지역 배열의 크기가 스택 크기 제한을 넘어갈 때
0으로 나눌 떄
라이브러리에서 예외를 발생시켰을 때
재귀 호출이 너무 깊어질 때
이미 해제된 메모리를 또 참조할 때
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main1613 {
    static int N;
    static int K;
    static ArrayList<Integer>[] input;
    static int[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //사건의 개수
        K = sc.nextInt(); //주어지는 개수

        input = new ArrayList[N];

        for(int i=0;i<N;i++){
            input[i] = new ArrayList<Integer>();
        }


        for(int i=0;i<K;i++) {
            int front = sc.nextInt();
            int back = sc.nextInt();

            input[front-1].add(back-1);
        }

        int S = sc.nextInt(); //알고 싶은 개수
        for(int i=0;i<S;i++){
           int front = sc.nextInt();
           int back = sc.nextInt();

           if(calculate(front-1,back-1)){

               System.out.println(-1);
           }else if(calculate(back-1,front-1)){
               System.out.println(1);
           }else{
                System.out.println(0);
            }
        }

    }

    private static boolean dfs(int front,int back) {

        boolean f = false;
        visit[front] = 1;

        for(int i=0;i<input[front].size();i++){
            int temp = input[front].get(i);
            if(temp == back){
                return true;
            }

            if(visit[input[front].get(i)] == 0) {
                f = dfs(temp,back);

                if (f == true) {
                    return true;
                }
            }
        }

        return f;
    }

    private static boolean calculate(int front,int back) {

        boolean f = false;
        visit = new int[N];

        f = dfs(front,back);

        return f;
    }
}
