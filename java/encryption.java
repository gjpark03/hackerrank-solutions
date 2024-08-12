import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        double stringLength = s.length();
        double stringRoot = Math.sqrt(stringLength);
        int row = (int) Math.floor(stringRoot);
        int col = (int) Math.ceil(stringRoot);
        
        if(row * col < stringLength) {
            row = col;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                int index = j * col + i;
                if(index < stringLength) {
                    sb.append(s.charAt(index));
                }
            }
            if(i < col - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
