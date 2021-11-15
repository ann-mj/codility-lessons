public class PermMissingElem {
    class Solution {
        public int solution(int[] A) {
            boolean[] visit = new boolean[A.length + 2]; // 1 ~ N + 1 visit check
            for(int i = 0; i < A.length; i++) {
                visit[A[i]] = true;
            }
    
            for(int j = 1; j < visit.length; j++) {
                if(!visit[j]) return j;
            }
            
            return 0;
        }
    }
}
