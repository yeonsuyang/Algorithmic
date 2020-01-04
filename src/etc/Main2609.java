package etc;

import java.util.Scanner;

/*
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오. 24 18
 */
public class Main2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        if(B > A){ //A가 언제나 더 큰 수
            int temp = B;
            B = A;
            A = temp;
        }

        System.out.println(max(A,B));
        System.out.println(min(A,B));
    }

    public static int max(int A, int B){

        int max = 1;

        for(int i = B; i > 0;i--){
            if(A%i == 0 && B%i == 0){
                max = i;
                break;
            }
        }
        return max;
    }

    public static int min(int A, int B){

        int min = A * B;

        for(int i = A; i< A*B;i++){
            if(i%A == 0 && i%B == 0){
                min = i;
                break;
            }
        }

        return min;
    }

}
