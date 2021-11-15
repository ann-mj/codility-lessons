import java.util.Arrays;

public class OddOccurrencesInArray {
    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            Arrays.sort(A);

            for (int j = 0; j < A.length;) {
                if (j + 1 == A.length)
                    return A[j];
                if (A[j] != A[j + 1])
                    return A[j];
                if (A[j] == A[j + 1]) {
                    if (j + 2 < A.length) {
                        j = j + 2;
                    } else {
                        j++;
                    }
                }
            }

            return 0;
        }
    }
}
