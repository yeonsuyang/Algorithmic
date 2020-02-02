package etc;

/*

1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.

4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다. 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

이 추측은 아직도 해결되지 않은 문제이다.

백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.

각 테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다.
만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다. 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.

8
20
42
0

8 = 3 + 5
20 = 3 + 17
42 = 5 + 37
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main6588 {


    static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Arrays.fill(isPrime,true);
        getPrime(1000000);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            loop1: for(int i=2;i<=n/2;i++){
                if(isPrime[i] && isPrime[n-i]){
                    System.out.println(n+" = "+i+" + "+(n-i));
                    break loop1;
                }

                if(i==n/2){
                    System.out.println("Goldbach's conjecture is wrong.");
                }
            }

        }
    }

    private static void getPrime(int MAX) {
        for (int i = 2; i <= MAX; i++) {
            for (int j = i * 2; j <= MAX; j += i) {
                if (!isPrime[j]) {continue;}
                isPrime[j] = false;
            }
        }
    }
}

