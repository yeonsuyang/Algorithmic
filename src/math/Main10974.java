package math;


import java.util.ArrayList;
import java.util.Scanner;

/*
N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

ç

1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
 */
public class Main10974 {

    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        calculate(1);
    }

    private static void calculate(int count) {
        for(int i=1;i<=N;i++){
            if(list.contains(i)) {
                continue;
            }else{
                list.add(i);
                if(list.size() == count && N == count){
                    printList();
                }else{
                    calculate(count+1);
                }
            }
            if(list.size() > 0 && list.size() == count) {
                list.remove(list.size()-1);
            }
        }
    }

    private static void printList() {
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }


}
