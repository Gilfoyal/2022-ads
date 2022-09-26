package company.vk.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public final class Brackets {
    private Brackets() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        String input = in.next();
        Map<Character, Character> pairs = Map.of('(', ')', '[', ']', '{', '}');
        Deque<Character> deque = new ArrayDeque<>();
        for (char bracket : input.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                deque.addLast(bracket);
            } else if (deque.isEmpty()) {
                System.out.println("no");
                return;
            } else {
                char last = deque.pollLast();
                if (bracket != pairs.get(last)) {
                    System.out.println("no");
                    return;
                }
            }
        }
        if (deque.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static final class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}