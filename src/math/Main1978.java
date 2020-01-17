package math;

import java.util.Scanner;

/*
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
주어진 수들 중 소수의 개수를 출력한다.

4
1 3 5 7

3

 */
public class Main1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int ans = 0;

        while (N > 0){
            if(decimal(sc.nextInt())){
                ans++;
            }

            N--;
        }

        System.out.println(ans);
    }

    public static Boolean decimal(int num){


        if(num == 1){
            return false;
        }

        if(num == 2){
            return true;
        }

        if(num % 2 == 0){
            return false;
        }

        for(int i = 3;i<num;i+=2){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
