public class TapeEquilibrium {
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;

        int total_sum = 0;
        for(int i = 0; i < A.length; i++) {
            total_sum += A[i];
        }
        int left_sum = 0;
        int right_sum = 0;
        
        for(int P = 1; P < A.length; P++) {
            left_sum += A[P-1];
            right_sum = total_sum - left_sum;

            min = Math.min(Math.abs(left_sum - right_sum), min);
        }
        return min;
    }
}
