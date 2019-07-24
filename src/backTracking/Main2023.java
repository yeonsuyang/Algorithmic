package backTracking;

import java.util.Scanner;

public class Main2023 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        calculate(1,"");

        System.out.println(sb.toString());
    }

    private static void calculate(int index, String z) {

        if(index > N){
            return;
        }

        String temp = z;
        for(int i=1;i<=9;i++){

            if(index == 1 && i == 1){
                continue;
            }
            temp += i;
            if(getPrime(Integer.parseInt(temp))) {
                if (index == N) {
                    sb.append(temp + "\n");
                } else if(index < N){
                    calculate(index + 1, temp);
                } else {
                    continue;
                }
            }

            temp = z;
        }
    }


    private  static boolean getPrime( int num){

        boolean isPrime = true;

        int sqrt = (int) Math.sqrt(num);

        for (int n = 2; n <= sqrt; n++) {
            if (num % n == 0) {
                isPrime = false;
                }
            }
        return isPrime;

    }

}
