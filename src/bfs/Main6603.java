package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {

    static int[] output;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean Flag = true;

        while(Flag) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                Flag = false;
            }else {
                int[] input = new int[N];
                output = new int[6];

                for(int i=0;i<N;i++) {
                    input[i] = Integer.parseInt(st.nextToken());
                }

                print(input,0,0);
                System.out.println();
            }
        }

    }

    private static void print(int[] input, int count,int start) {
        // TODO Auto-generated method stub
        for(int i=start;i<input.length;i++) {

            if(count == 0 && i > input.length-5) {
                break;
            }
            output[count] = input[i]; //0이면 1이들어감
            if(count < 5) {
                print(input,count+1,i+1);
            }else if(count == 5) {
                for(int j=0;j<output.length;j++) {
                    System.out.print(output[j] + " ");
                }
                System.out.println();
            }

        }
    }
}
