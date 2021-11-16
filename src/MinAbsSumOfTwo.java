import java.util.Arrays;

public class MinAbsSumOfTwo {
    class Solution {
        public int solution(int[] A) {
            int N = A.length;
            if(N == 1) return Math.abs(A[0]*2);
            
            Arrays.sort(A);
            int min = Integer.MAX_VALUE;
            if(A[0] > 0) {
                // 최소값이 0보다 크다면
                min = A[0]*2;
                return min;
            }
    
            if(A[N-1] < 0) {
                // 최대값이 0보다 작다면
                min = Math.abs(A[N-1]*2);
                return min;
            }
    
            int l = 0;
            int r = N-1;
            for(int i= 0; i < N; i++) {
                if(A[i] == 0) return 0; // 0 이 하나라도 있으면 최소값은 0
            }
    
            while(l <= r) {
                int sum = A[l] + A[r];
                int absSum = Math.abs(sum);
                min = Math.min(min, absSum);
                if(absSum == 0) return 0;
                if(sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
    
            return min;
        }
    }
}
