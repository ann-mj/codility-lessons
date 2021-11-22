import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1157 {
    static FastReader scan = new FastReader();
    
    public static void main(String[] args) {
        String alphabets = scan.nextLine().toLowerCase();
        char[] listAlphabet = alphabets.toCharArray();
        HashMap<Character,Integer> alphabetCount = new HashMap<>();
        for(char i : listAlphabet){
            alphabetCount.put(i, 1);
        }
        
        
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return st.nextToken();
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
