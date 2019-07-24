package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (1 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

5 3
1
2
8
4
9

3

공유기를 1, 4, 8 또는 1, 4, 9에 설치하면 가장 인접한 두 공유기 사이의 거리는 3이고, 이 거리보다 크게 공유기를 3개 설치할 수 없다.
 */
public class Main2110 {

    static int[] input;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //집 개수
        int C = sc.nextInt(); //공유기 개수

        input = new int[N];

        for(int i=0;i<N;i++){
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        int lo = input[0];
        int hi = input[N-1];
        int answer = 0;

        while(lo > hi){
            int mid = lo+hi /2; //최대 간격

            int cal = calculate(mid,C); //설치한 개수를 가져왔을 때

            if( cal >= C){
                answer = mid;
                lo = mid -1 ;

            }else{
                hi = mid + 1;
            }

        }

        System.out.println(answer);

    }

    private static int calculate(int mid,int C) {

        int count = 1;
        int now = input[0];

        for(int i=1;i<input.length;i++){
            if((input[i] - now) > mid){ //최대 간격보다 크면 설치
                count ++;

                if(count > C){ //최대간격으로 했을 때 설치하려는 공유기의 개수보다 크다면
                    break;
                }
            }
        }

        return count;
    }
}