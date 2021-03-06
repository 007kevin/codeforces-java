import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem CF1321C
 */
public class CF1321C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            String s = in.next();
            String a = "zyxwvutsrqponmlkjihgfedcba";
            for(int i = 0; i < a.length(); ++i) {
                s = remove(a.charAt(i), s);
            }
            out.print(n - s.length());
        }

        public String remove(char c, String s) {
            String r="";
            for(int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == c) {
                    out.print(c);
                    if (!((i!=0&&(s.charAt(i-1)+1)==c) || (i!=s.length()-1&&(s.charAt(i+1)+1)==c))) {
                        r += c;
                    }
                }
            }
            return r;
        }

    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }

    static class IOHandler {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);

        public void cleanup() {
            out.close();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
