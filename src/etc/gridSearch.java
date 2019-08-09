package etc;
/*
2
10 10
7283455864
6731158619
8988242643
3830589324
2229505813
5633845374
6473530293
7053106601
0834282956
4607924137
3 4
9505
3845
3530
15 15
400453592126560
114213133098692
474386082879648
522356951189169
887109450487496
252802633388782
502771484966748
075975207693780
511799789562806
404007454272504
549043809916080
962410809534811
445893523733475
768705303214174
650629270887160
2 2
99
99
 */

import java.io.IOException;

// hackerrank
public class gridSearch {
    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {

        char[][] Garray = new char [G.length][];

        for(int i=0;i<G.length;i++){
            Garray[i] = G[i].toCharArray();
        }

        char[][] Parray = new char[P.length][];

        for(int i=0;i<P.length;i++){
            Parray[i] = P[i].toCharArray();
        }

        boolean ans = false;


        for(int i=0;i<G.length;i++){
            for(int j=0;j<G[i].length();j++){
                if(Garray[i][j] == Parray[0][0] && ans == false){
                   ans =  calculate(i,j,Garray,Parray);
                }
            }
        }


        if(ans == false){
            return "NO";
        }else{
            return "YES";
        }
    }

    public static boolean calculate(int y, int x,char[][] Garray, char[][] Parray){

        if(y+Parray.length-1 > Garray.length-1){
            return false;
        }

        if(x+Parray[0].length-1 > Garray[0].length-1){
            return false;
        }

        for(int i=0;i<Parray.length;i++){
            for(int j=0;j<Parray[i].length;j++){


                if(Parray[i][j] != Garray[y+i][x+j]){
                    return false;
                }

            }
        }



        return true;
    }

    public static void main(String[] args) throws IOException {

       String G[] = {"7283455864", "6731158619","8988242643","3830589324","2229505813","5633845374","6473530293",
               "7053106601","0834282956","4607924137"};

       System.out.println(G[0].length());

        String P[] = {"9505", "3845","3530"};

        System.out.println(gridSearch(G,P));
    }
}
