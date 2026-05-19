package programmers.p92342;

import java.util.*;

class Solution {
    final int MAX_SCORE = 10;
    int[] answer, tempInfo, apeachInfo;
    int maxDiff = -1;
    
    public int[] solution(int n, int[] info) {
        tempInfo = new int[MAX_SCORE + 1];
        apeachInfo = info;
        
        dfs(0, 0, n);
        
        if (maxDiff == -1) return new int[]{-1};
        return answer;
    }
    
    void dfs(int index, int diff, int remainArrow){
        if (index == MAX_SCORE) {
            tempInfo[MAX_SCORE] = remainArrow;
            if (diff > 0) {
                eval(diff);
            }
            return;
        }
        
        int needArrow = apeachInfo[index] + 1;
        int score = MAX_SCORE - index;
        
        if (remainArrow >= needArrow){
            tempInfo[index] = needArrow;
            dfs(index + 1, diff + score, remainArrow - needArrow);
            tempInfo[index] = 0;
        }
        
        if (apeachInfo[index] == 0){
            dfs(index + 1, diff, remainArrow);   
        }
        else {
            dfs(index + 1, diff - score, remainArrow);   
        }
        
    }
    
    void eval(int diff) {
        if (maxDiff < diff){
            maxDiff = diff;
            answer = tempInfo.clone();
        }
        
        else if (maxDiff == diff){
            if(isTempBetter()){
                answer = tempInfo.clone();
            }
        }    
    }
    
    boolean isTempBetter(){
        for (int i = MAX_SCORE; i >= 0; i--){
            if (tempInfo[i] > answer[i]) return true;
            if (tempInfo[i] < answer[i]) return false;
        }
        return false;
    }
}
