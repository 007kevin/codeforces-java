import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Problem CF1301B
 */
@SuppressWarnings("unchecked")
public class CF1301B {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                int n = in.nextInt();
                long a[] = new long[n];
                long min=Long.MAX_VALUE;
                long max=Long.MIN_VALUE;
                for(int i = 0; i < n; ++i){
                    a[i]=in.nextLong();
                }
                for(int i = 0; i < n; ++i){
                    if (a[i] == -1) continue;
                    if(i - 1 >= 0 && a[i-1] == -1 || i + 1 < n && a[i+1] == -1) {
                        min=Math.min(a[i],min);
                        max=Math.max(a[i],max);
                    }
                }                
                if(min==Long.MAX_VALUE) {
                    out.println("0 0");
                } else {
                    long k = (min+max)/2;
                    for(int i = 0; i < n; ++i)
                        if (a[i]==-1) a[i]=k;
                    long m = Long.MIN_VALUE;
                    for(int i = 0; i < n-1; ++i)
                        m=Math.max(m, Math.abs(a[i+1]-a[i]));
                    out.println(m + " " + k);
                }
            }
        }
    }

    /***********************************************************
     *                        COMMONS                          *
     ***********************************************************/
    static class Pair<A, B> implements Comparable<Pair<A, B>> {
        public A a;
        public B b;
        public Pair(Pair<A, B> p) {
            this(p.a, p.b);
        }

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
 
        public String toString() {
            return a+" "+b;
        }
 
        public int hashCode() {
            return Objects.hash(a, b);
        }
 
        public boolean equals(Object o) {
            if(o instanceof Pair) {
                Pair<A,B> p = (Pair<A,B>) o;
                return a.equals(p.a)&&b.equals(p.b);
            }
            return false;
        }
 
        @Override
        public int compareTo(Pair<A, B> p) {
            int cmp = ((Comparable<A>) a).compareTo(p.a);
            if(cmp==0) {
                return ((Comparable<B>) b).compareTo(p.b);
            }
            return cmp;
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
