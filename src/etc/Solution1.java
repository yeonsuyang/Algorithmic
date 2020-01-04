package etc;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution1 {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String f = s.substring(8, s.length());
        String time = s.substring(0,8);

        System.out.println(f.compareTo("AM"));

        if(f.equals("AM")){
            String[] timeArray = time.split(":");
            if(Integer.parseInt(timeArray[0])== 12){
                return "00:" + timeArray[1] + ":" + timeArray[2];
            }else{
                return time;
            }

        }else{
            String[] timeArray = time.split(":");

            String ans = "";
            int transTime = 0;
            if(Integer.parseInt(timeArray[0]) < 12){
                transTime = Integer.parseInt(timeArray[0]) + 12 ;
            }else{
                transTime = Integer.parseInt(timeArray[0]);
            }
            ans = transTime + ":" + timeArray[1] + ":" + timeArray[2];
            return ans;
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = "07:05:45PM";

        String result = timeConversion(s);
        System.out.println(result);

    }
}

