public class BinaryGap {
    class Solution {
        public int solution(int N) {
            String binaryString = Integer.toBinaryString(N);
            int max_count = 0;
            int count = 0;
    
            for(int i=1; i<binaryString.length(); i++) {
                // 0
                if(binaryString.charAt(i) == '0') count++;
                else {
                    max_count = Math.max(max_count, count); // 1
                    count = 0;
                }
            }
    
            return max_count;
        }
    }
}
