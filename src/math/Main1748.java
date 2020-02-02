package math;

/*0
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
첫째 줄에 N(1≤N≤100,000,000)이 주어진다.

120

252

 */

import java.util.Scanner;

public class Main1748 {
    public static void main(String[] args) {


        //123456789 = 9
        //10 = 11
        //111213141516171819 = 9 * 2 이렇게 10줄 = 180
        //101102103104105106107108109 = 9*3 이렇게 100줄

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;
        int count = 1;

        for(int i=10;i<=1000000000;i*=10){
            if(n>=i){
                ans +=( 9 * count) * (i/10);
                count++;
            }else{
                ans += ((n - (i/10)) + 1) * count;
               break;
            }
        }

        System.out.println(ans);

    }
}
