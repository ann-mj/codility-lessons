public class BinarySearch {
   
    public static void main(String[] args) {
        int[] A = {1,2,3,5,6,7,8};
        System.out.println(lower_bound(A, 0, 6, 1));
    }

    public static int lower_bound(int[] A, int L, int R , int X) {
        // A[L...R] 에서 X 미만의 수(X보다 작은 수) 중 제일 오른쪽 인덱스
        // 즉 X 보다 작은 것의 갯수를 구한다.
        // L은 1부터 시작함

        int result = L - 1;
        while( L <= R) {
            int mid = (L+R) / 2;
            if(A[mid] < X) { // X 미만 일 때는 A[mid] < X , X 이하 일 때는 A[mid] <= X
                L++;
                result = mid;
            } else {
                R = mid - 1;
            }
        }
        if(result < 0) return 0;
        return result + 1;
    }

}
