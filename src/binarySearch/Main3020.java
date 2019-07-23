package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main3020{
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        int N = scan.nextInt(); //N미터
        int H = scan.nextInt(); //높이

        int[] j = new int[N/2]; //종유석
        int[] s = new int[N/2]; //석순
        int[] obstacle_s = new int[H+1];
        int[] obstacle_j = new int[H+1];

        for(int i=0; i<(N/2); i++){
            s[i] = scan.nextInt(); //차례로 입력
            obstacle_s[s[i]]++;
            j[i] = scan.nextInt();
            obstacle_j[j[i]]++;

        }
        for(int i=H-1;i>=1;i--){
            obstacle_s[i] = obstacle_s[i] + obstacle_s[i+1]; // 4= 4+5 , 3 = 3+4 , 2 = 2+3
            obstacle_j[i] = obstacle_j[i] + obstacle_j[i+1];
        }

        int cnt = 0;
        int min = N;

        for(int i=0; i< H;i++){ // 모든 높이동안
            int temp = obstacle_s[i+1]+ obstacle_j[H-i];

            if(temp < min){
                min = temp;
                cnt = 1;
            }else if(temp == min){
                cnt++;
            }
        }

        System.out.println(min+" "+cnt);
    }
}

