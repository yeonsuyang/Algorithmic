package greedy;

/*
언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.

그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.

이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.

2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1

4 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 면접자 수

            int[][] input = new int[N][2];

            StringTokenizer st;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                input[i][0] = Integer.parseInt(st.nextToken());
                input[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input, new Comparator<int []>() {
                public int compare(final int[] e1,final int[] e2) {
                    return Integer.compare(e1[0], e2[0]);
                }
            });
            int answer = caculate(N, input);

            System.out.println(answer);
        }
    }

    private static int caculate(int n, int[][] input) {
        int count = 1; // 1등 한명은 무조건
        int value = input[0][1];

        for (int i = 1; i < n; i++) {
            if(input[i][1] < value) {
                count++;
                value = input[i][1];
            }
        }
        return count;
    }
}
