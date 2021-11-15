import java.util.Arrays;

public class PermCheck {
    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            if(A.length == 1 && A[0] == 1) return 1;
    
            Arrays.sort(A); // 최대값 찾기 위한 sort
            if(A[0] != 1) return 0;
    
            for(int i = 0; i < A.length - 1; i++) {
                if(A[i] + 1 != A[i+1]) return 0;
            }
    
            return 1;
        }
    }
}
