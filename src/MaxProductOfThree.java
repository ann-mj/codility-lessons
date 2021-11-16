import java.util.Arrays;

public class MaxProductOfThree {
    // you can also use imports, for example:
    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);

            int N = A.length;

            int a = A[N - 1] * A[N - 2] * A[N - 3]; // 양양양 , 음음음 , 음양양 인 경우
            int b = A[N - 1] * A[0] * A[1]; // 음음양 인 경우

            return Math.max(a, b);
        }
    }

}
