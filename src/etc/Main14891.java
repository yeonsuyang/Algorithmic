package etc;

import java.util.Scanner;

/*
첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다.
상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.

다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고,
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.


총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.

1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.
맞닿은 극이 같기 때문에 회전하지 않는다.


1번은 2와. 2번의 6
2번의 2와. 3번의 6
3번의 2와. 4번의 6


10101111
01111101
11001110
00000010
2
3 -1
1 1

7

 */
public class Main14891 {

    static int[] first;
    static int[] second;
    static int[] third;
    static int[] fourth;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        first = new int[8];
        second = new int[8];
        third = new int[8];
        fourth = new int[8];

        String st = sc.next();
        for(int i=0;i<8;i++){
            first[i] = st.charAt(i) - '0';
        }

        st = sc.next();
        for(int i=0;i<8;i++){
            second[i] = st.charAt(i) - '0';
        }

        st = sc.next();
        for(int i=0;i<8;i++){
            third[i] = st.charAt(i) - '0';
        }

        st = sc.next();
        for(int i=0;i<8;i++){
            fourth[i] = st.charAt(i) - '0';
        }

        int count = sc.nextInt();

        while(count>0){

            int n = sc.nextInt();
            int dir = sc.nextInt();

            if(n == 1){
                num1(0,dir);
            }else if(n ==2){
                num2(0,dir);
            }else if(n ==3){
                num3(0,dir);
            }else {
                num4(0,dir);
            }

            count--;
        }

        int ans = 0;
        if(first[0] == 1){
            ans +=1;
        }
        if(second[0] == 1){
            ans +=2;
        }
        if(third[0] == 1){
            ans += 4;
        }
        if(fourth[0] == 1){
            ans += 8;
        }

        System.out.println(ans);
    }

    //1 왼쪽에서 온 것 , 2 = 오른 쪽에서 온 것

    //시계방향 0->1->2->3->4->5->6->7->0
    //반시계방향 7->6->5->4->3->2->1->0->7

    public static void num1(int loc, int dir){

        boolean go2 = false;

        if(loc != 2 && (first[2] != second[6])){
            go2 = true;
        }

        if(dir == 1){
            int temp = first[7];
            for(int i=6;i>=0;i--){
                first[i+1] = first[i];
            }
            first[0] = temp;
        }else{//반시계
            int temp = first[0];
            for(int i=0;i<7;i++){
                first[i] = first[i+1];
            }
            first[7] = temp;
        }

        if(go2){
            num2(1,-1 * dir);
        }

    }


    public static void num2(int loc, int dir){
        // 1번은 2와. 2번의 6
        // 2번의 2와. 3번의 6
        boolean go1 = false;
        boolean go3 = false;

        if(loc == 0 || loc == 1){
            if(second[2] != third[6]){
               go3 = true;
            }
        }

        if(loc == 0 || loc == 2){
            if(first[2] != second[6]){
                go1 = true;
            }
        }

        if(dir == 1){
            int temp = second[7];
            for(int i=6;i>=0;i--){
                second[i+1] = second[i];
            }
            second[0] = temp;
        }else{//반시계
            int temp = second[0];
            for(int i=0;i<7;i++){
                second[i] = second[i+1];
            }
            second[7] = temp;
        }

        if(loc == 0){
            if(go1){
                num1(2,-1 * dir);
            }

            if(go3){
                num3(1,-1*dir);
            }

        }else if(loc == 1){
            if(go3){
                num3(1,-1*dir);
            }
        }else{
            if(go1){
                num1(2,-1 * dir);
            }
        }
    }



    public static void num3(int loc, int dir){

        boolean go2 = false;
        boolean go4 = false;

        if(loc == 0 || loc == 1){
            if(third[2] != fourth[6]){
                go4 = true;
            }
        }

        if(loc == 0 || loc == 2){
            if(second[2] != third[6]){
                go2 = true;
            }
        }

        //2번의 2와. 3번의 6
        //3번의 2와. 4번의 6
        if(dir == 1){
            int temp = third[7];
            for(int i=6;i>=0;i--){
                third[i+1] = third[i];
            }
            third[0] = temp;
        }else{//반시계
            int temp = third[0];
            for(int i=0;i<7;i++){
                third[i] = third[i+1];
            }
            third[7] = temp;
        }

        if(loc == 0){
            if(go2){
                num2(2,-1*dir);
            }

            if(go4){
                num4(1,-1*dir);
            }
        }else if(loc == 1){
            if(go4){
                num4(1,-1*dir);
            }
        }else{
            if(go2){
                num2(2,-1*dir);
            }
        }
    }



    public static void num4(int loc, int dir){
        //3번의 2와.4번의 6
        boolean go3 = false;

        if(loc != 1 && (third[2] != fourth[6])){
            go3 = true;
        }

        if(dir == 1){
            int temp = fourth[7];
            for(int i=6;i>=0;i--){
                fourth[i+1] = fourth[i];
            }
            fourth[0] = temp;
        }else{//반시계
            int temp = fourth[0];
            for(int i=0;i<7;i++){
                fourth[i] = fourth[i+1];
            }
            fourth[7] = temp;
        }



            if(go3){
                num3(2,-1*dir);
            }

    }


    public static void clock(){

    }



}
