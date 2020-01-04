package etc;

/*

준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다.
E : 지구
S : 태양
M : 달

(1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)

우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다.
1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.

예를 들어, 15년은 15 15 15로 나타낼 수 있다. 하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다. 이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.

첫째 줄에 세 수 E, S, M이 주어진다. 문제에 나와있는 범위를 지키는 입력만 주어진다.

첫째 줄에 E S M으로 표시되는 가장 빠른 연도를 출력한다. 1 1 1은 항상 1이기 때문에, 정답이 음수가 나오는 경우는 없다.

1 16 16
16

1 2 3
5266


15 28 19
7980
 */


import java.util.Scanner;

public class Main1476 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt(); //지구 <= 15
        int S = sc.nextInt(); //태양 <= 28
        int M = sc.nextInt(); //달 <= 19

        while (true){
            if(E == S && E == M){
                System.out.println(E);
                break;
            }else{
                if(E < M){
                    E += 15;
                }else if(M < S){
                    M += 19;
                }else{
                    S += 28;
                }
            }
        }
    }
}
