package greedy;

/*
Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.

끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고,
각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때,
적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.

첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.

4 2
12 3
15 4

12
 */

import java.util.Scanner;

public class Main1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //끊어진 기타 줄
        int M = sc.nextInt(); //기타줄 브랜드

        int six = sc.nextInt();
        int one = sc.nextInt();

        for(int i=0;i<M-1;i++){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            six = (six>input1)?input1:six;
            one = (one>input2)?input2:one;
        }

        int count = N;
        int answer = 0;

        while(count > 0) {
            if (count > 6) {
                answer += six;
                count -= 6;
            } else {
                //곱한 가격이 6개묶음보다 크면 6개묶음사고
                if((count*one) > six){
                    answer += six;
                    count -= count;
                }else{//아니면 낱개
                    answer += (count*one);
                    count -= count;
                }

            }
        }

        System.out.println(answer);

    }
}
