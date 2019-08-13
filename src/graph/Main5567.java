package graph;

/*
상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고,
이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다.
이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다.
다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다.
첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.

은 상근이의 친구이다. 또, 3과 4는 친구이기 때문에, 4는 상근이의 친구의 친구이다. 5와 6은 친구도 아니고, 친구의 친구도 아니다. 따라서 2,3,4 3명의 친구를 결혼식에 초대한다.

6
5
1 2
1 3
3 4
2 3
4 5

3
 */


import java.util.Scanner;
import java.util.ArrayList;

public class Main5567 {

    static int count;
    static int N;
    static ArrayList<Integer>[] input;
    static int[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 친구가 몇명 까지 있는 지


        input = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            input[i] = new ArrayList<Integer>();
        }


        int L = sc.nextInt(); //몇 줄인 지

        for (int i = 0; i < L; i++) {

            int y = sc.nextInt();
            int x = sc.nextInt();

            if(x != 1) {
                input[y].add(x);
            }
            if(y != 1) {
                input[x].add(y);
            }
        }


        for (int i = 0; i < input[1].size(); i++) {
            int c = input[1].get(i);
            if (answer[c] == 0) {
                answer[c] = 1;
                count++;
            }

            for (int j = 0; j < input[c].size(); j++) {
                int temp = input[c].get(j);
                if (answer[temp] == 0) {
                    answer[temp] = 1;
                    count++;
                }
            }

        }


        System.out.println(count);

    }
}

