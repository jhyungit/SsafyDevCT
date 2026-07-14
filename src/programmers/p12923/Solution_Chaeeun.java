package programmers.p12923;

class Solution {
    private static final int MAX_BLOCK = 10_000_000;
    
    public int[] solution(long begin, long end) {
        int len = (int) (end - begin + 1);
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++){
            answer[i] = findLargestDivisor(begin + i);
        }
        
        return answer;
    }
    
    public int findLargestDivisor(long n){
        if (n == 1) {
            return 0;
        }
        
        int candidate = 1;
        double sqrtOfN = Math.sqrt(n);
        
        for(long divisor = 2; divisor <= sqrtOfN; divisor++){
            if (n % divisor == 0) {
                long largeDivisor = n / divisor;
                
                if (largeDivisor <= MAX_BLOCK) {
                    return (int) largeDivisor;
                }
                candidate = (int) divisor;
            }            
        }
        
        return candidate;
    }
}
