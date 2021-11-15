public class MissingInteger {
    class Solution {
        public int solution(int[] A) {
            boolean[] visit = new boolean[1000001];

            for (int i = 0; i < A.length; i++) {
                if (A[i] > 0)
                    visit[A[i]] = true;
            }

            for (int j = 1; j < visit.length; j++) {
                if (!visit[j])
                    return j;
            }
            return 0;
        }
    }
}
