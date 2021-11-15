import java.util.*;

public class CountSemiprimes {
    class Solution {
        public int[] solution(int N, int[] P, int[] Q) {
            // write your code in Java SE 8
            boolean[] primeChecked = new boolean[50001];
            boolean[] semiPrimeChecked = new boolean[50001];

            List<Integer> primes = new LinkedList<>(); // 궁룰
            int[] answers = new int[P.length];

            // 소수를 찾는다
            primes.add(2);
            semiPrimeChecked[4] = true;

            for (int i = 3; i < 50001; i = i + 2) {
                if (i % 2 == 0 || primeChecked[i]) {
                    continue;
                }
                primes.add(i);

                // 부분소수? 를 찾아 비교한다 악수문제
                for (Integer a : primes) {
                    int value = i * a;
                    if (value > 50000)
                        break;
                    semiPrimeChecked[value] = true; // true : 부분소수가 맞다는 거임
                }

                for (int j = i + i; j < 50001; j = j + i) {
                    primeChecked[j] = true; // 얘가 true 면 소수가 아니라는 거임
                }
            }

            int[] sum = new int[50001];

            // 누적 합
            for (int i = 4; i < 50001; i++) {
                sum[i] = sum[i - 1];
                if (semiPrimeChecked[i])
                    sum[i]++;
            }

            for (int i = 0; i < P.length; i++) {
                int p = P[i];
                int q = Q[i];

                if (semiPrimeChecked[p])
                    answers[i] = sum[q] - sum[p] + 1;
                else
                    answers[i] = sum[q] - sum[p];
            }

            return answers;
        }
    }
}