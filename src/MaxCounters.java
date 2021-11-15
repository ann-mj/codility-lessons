public class MaxCounters {
    class Solution {
        public int[] solution(int N, int[] A) {
            // write your code in Java SE 8
            int[] ans = new int[N];
            int[] sol = new int[N];
    
            int cur_max = 0;
            int final_max = 0;
            int max_index = -1; // 아무것도 없는 경우
    
            for(int i = 0; i < A.length; i++) {
                // increase or Max Count
                if(1 <= A[i] && A[i] <= N) {
                    if(ans[A[i] - 1] < final_max) {
                        ans[A[i] -1] = final_max;
                    }
                
                    ans[A[i]-1]++;
                    cur_max = Math.max(ans[A[i]-1], cur_max); // A[2] = 4 인 경우, cur_max 만 update
                } else if(A[i] == N + 1) {
                    final_max = cur_max;
                    max_index = i; // i 번째 이전의 cnt 값은 필요가 없음.
                }
            }
    
            for(int k = max_index + 1; k < A.length; k++) {
                sol[A[k]-1]++;
            }
    
            for(int j = 0; j < N; j++) {
                sol[j] += final_max;
            }
            
            return sol;
        }
    }
}
