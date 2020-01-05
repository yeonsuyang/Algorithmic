package math;

/*
양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9613 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //case


        while (n > 0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int lenth = Integer.parseInt(st.nextToken()); //입력으로 주어지는 수는 1000000을 넘지 않는다.


            int[] input = new int[lenth];
            for (int i=0;i<input.length;i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<input.length;i++){
                for(int j=i+1;j<input.length;j++){
                   sum += gcd(input[i],input[j]);
                }
            }

            System.out.println(sum);
            n--;

        }

    }

    public static int gcd(int a, int b){

        while(b>0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}
