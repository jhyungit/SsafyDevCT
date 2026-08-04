package programmers.p181187;

class Solution_Chaeeun {
    public long solution(int r1, int r2) {

        long count = 0;

        long innerDiameter = (long) r1 * r1;
        long outerDiameter = (long) r2 * r2;

        for (long x = 1; x <= r2; x++) {
            long xSquared = x * x;
            
            long minY = 0;
            long maxY = (long) Math.sqrt(outerDiameter - xSquared);
            
            if (xSquared < innerDiameter) {
                minY = (long) Math.ceil(Math.sqrt(innerDiameter - xSquared));
            }

            count += maxY - minY + 1;
        }
        
        return count * 4;
    }
}
