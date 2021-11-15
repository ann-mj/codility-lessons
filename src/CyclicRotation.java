public class CyclicRotation {
    class Solution {
        public int[] solution(int[] A, int K) {
            if(K == 0 || A.length == 0 || K % A.length == 0) return A;
    
            int[] sol = A;
            for(int i = 1; i <= K % A.length; i++) {
                sol = rotate(sol);
            }
            return sol;
        }
    
        public int[] rotate(int[] a) {
            int[] temp = new int[a.length];
            temp[0] = a[a.length-1];
    
            for(int i=1; i < a.length; i++) {
                temp[i] = a[i-1];
            }
            return temp;
        }
    }
}
