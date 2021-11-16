public class MaxDoubleSliceSum {
    class Solution {
        public int solution(int[] A) {
            int N = A.length;
            int[] leftSum = new int[N]; // y 인덱스 기준 좌측합이 될 수 있는 값 중 최대값
            int[] rightSum = new int[N]; // y 인덱스 기준 우측합이 될 수 있는 값 중 최대값 (음수인 경우 0)
            // y 는 1 이상 N-2 이하 이다.
            for(int i = 2; i < N-1; i++) {
                leftSum[i] = Math.max(0, leftSum[i-1] + A[i-1]); // y 가 i 일때
            }
    
            for(int i = N-3; i >= 1; i--) {
                rightSum[i] = Math.max(0, rightSum[i+1] + A[i+1]); // 어떤 값이든 우리는 Y, Z 를 연속해서 놓으면 0으로 만들수 있다
            }
            
            int max = 0;
    
            for(int i = 1; i < N-1; i++) {
                max = Math.max(max, leftSum[i] + rightSum[i]);
            }
    
            return max;
        }
    }
}
