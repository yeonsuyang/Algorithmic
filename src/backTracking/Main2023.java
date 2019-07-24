package backTracking;

import java.util.Scanner;

public class Main2023 {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        calculate(1,"");
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
                    System.out.println(temp);
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

                for (int n = 2; n <= num/2; n++) {
                    if (num % n == 0) {
                        isPrime = false;
                    }
                }
        return isPrime;

    }

}
