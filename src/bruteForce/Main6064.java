package bruteForce;

import java.util.Scanner;

/*
<x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다. <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다.
예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다. <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다.
네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.

입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터는 한 줄로 구성된다. 각 줄에는 네 개의 정수 M, N, x와 y가 주
출력은 표준 출력을 사용한다. 각 테스트 데이터에 대해, 정수 k를 한 줄에 출력한다. 여기서 k는 <x:y>가 k번째 해를 나타내는 것을 의미한다. 만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.

3
10 12 3 9
10 12 7 2
13 11 5 6


3 13 23 33 43
9 21 33
 */
public class Main6064 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        while (count>0){
            int M = sc.nextInt();
            int N = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();

            int lcm = lcm(M,N);

            if(x<=M && y <= N && x == y){
                System.out.println(x); //그냥 출력
            }else if(x> M || y > N) {
                System.out.println(-1);
            }else
            {
                while(x != y) {

                    if(x > lcm || y > lcm){
                        System.out.println(-1);
                        break;
                    }

                    if (y < x) {//M이 더 큰 경우, N이 더 작을 테니까
                        y += N;
                    } else {
                        x += M;
                    }

                    if(x==y){
                        System.out.println(x);
                    }
                }
            }
            count--;
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
