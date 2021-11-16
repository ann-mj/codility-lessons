public class MaxSliceSum {
    class Solution {
        public int solution(int[] A) {
            // 카데인 알고리즘을 이용하자. 부분합 최대값 구하기
            int N = A.length;
            int[] partSum = new int[N]; // partSum[i] : 0부터 i 까지 배열에서, 부분합의 최대값을 가지고 있음
            partSum[0] = A[0];
            int max = partSum[0];
            for (int i = 1; i < N; i++) {
                partSum[i] = Math.max(partSum[i - 1] + A[i], A[i]); // 이전까지 부분합의 최대값과 현재값을 더한 값과 현재값 중에서 뭘 선택할지 결정하는 과정
                max = Math.max(partSum[i], max);
            }

            return max;
        }
    }
}
