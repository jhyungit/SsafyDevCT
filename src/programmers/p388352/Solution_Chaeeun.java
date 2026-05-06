package programmers.p388352;

import java.io.*;
import java.util.*;

class Solution {
    final int CODE_LENGTH = 5;
    int maxNumber, queryCount;
    int[][] q;
    int[] ans;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.maxNumber = n;
        this.queryCount = ans.length;
        this.q = q;
        this.ans = ans;
        int result = 0;
        
        // 정답과 겹치는 숫자가 가장 큰 친구 고르기
        int maxIdx = 0, maxAns = 0;
        for (int i = 0; i < queryCount; i++){
            if (maxAns < ans[i]){
                maxAns = ans[i];
                maxIdx = i;
            }
        }
        
        // 해당 인덱스로 가능한 모든 code 구하기
        List<int[]> completeCodes = getValidCodeSet(maxIdx);
        
        // 나머지 시도들에 대해서 일치하는 숫자 개수가 맞는 것만 남기기
        for(int[] code: completeCodes){
            boolean valid = true;
            for(int i = 0; i < queryCount; i++){
                if (i == maxIdx) continue;
                int overlapCnt = getOverlapCnt(code, q[i]);
                if (overlapCnt != ans[i]){
                    // 하나라도 틀리면 false
                    valid = false;
                    break;
                }
            }
            
            if (valid) result++;
            
        }
        return result;
    }
    
    // 두 코드에서 겹치는 개수 찾기
    int getOverlapCnt(int[] aCode, int[] bCode){
        int overlapCnt = 0;
        int aIdx = 0, bIdx = 0;
        while (aIdx < CODE_LENGTH && bIdx < CODE_LENGTH){
            if (aCode[aIdx] == bCode[bIdx]){
                overlapCnt++;
                aIdx++;
                bIdx++;
            }
            else if(aCode[aIdx] < bCode[bIdx]){
                aIdx++;
            }
            else{
                bIdx++;
            }
        }
        return overlapCnt;
    }
    
    int sourceNumbers[];
    int targetPickCount;
    int choiceCnt;
    boolean choose[];
    
    List<int[]> getValidCodeSet(int maxIdx){
        List<int[]> selectedFromBaseQuery = new ArrayList<>();
        List<int[]> selectedFromOutsideBaseQuery  = new ArrayList<>();
        
        // 1. 기준 query 안에서 ans[maxIdx]개의 숫자 고르기
        sourceNumbers = q[maxIdx].clone();
        targetPickCount = ans[maxIdx];
        choiceCnt = CODE_LENGTH;
        choose = new boolean[choiceCnt];
        
        dfs(0, 0, selectedFromBaseQuery);
        
        // 2. 기준 query 외의 숫자 sourceNumbers 만들기
        choiceCnt = maxNumber - CODE_LENGTH;
        int outsideNumbers[] = new int[choiceCnt];
        
        int qIdx = 0, cIdx = 0;
        for(int n = 1; n <= maxNumber; n++){
            if (qIdx < CODE_LENGTH && q[maxIdx][qIdx] == n){
                qIdx++;
            }
            else{ 
                outsideNumbers[cIdx++] = n;
            }
        }
        
        // 3. 2번 내에서 5 - ans[maxIdx]개의 숫자 고르기
        sourceNumbers = outsideNumbers;
        targetPickCount = CODE_LENGTH - ans[maxIdx];
        choose = new boolean[choiceCnt];
        
        dfs(0, 0, selectedFromOutsideBaseQuery);
        
        // 4. 1번과 3번 더해서 5자리 code 만들기
        List<int[]> completeCodes = new ArrayList<>();
        
        for(int[] basePart: selectedFromBaseQuery){
            for(int[] outsidePart: selectedFromOutsideBaseQuery){
                int[] mergedCode = mergeSortedParts(basePart, outsidePart, ans[maxIdx]);
                completeCodes.add(mergedCode);
            }            
        }
        
        return completeCodes;
    }
    
    int[] mergeSortedParts(int[] basePart, int[] outsidePart, int basePartLen){
        int outsidePartLen = CODE_LENGTH - basePartLen;
        int sorted[] = new int[CODE_LENGTH];
        
        int bIdx = 0, oIdx = 0;
        int sIdx = 0;
        
        while(bIdx < basePartLen && oIdx < outsidePartLen){
            if (basePart[bIdx] < outsidePart[oIdx]){
                sorted[sIdx++] = basePart[bIdx++];
            }
            else{
                sorted[sIdx++] = outsidePart[oIdx++];
            }                    
        }

        while (bIdx < basePartLen){
            sorted[sIdx++] = basePart[bIdx++];
        }
        while (oIdx < outsidePartLen){
            sorted[sIdx++] = outsidePart[oIdx++];
        }

        return sorted;
    }
    
    
    void dfs(int depth, int choosen, List<int[]> list){
        if (choosen == targetPickCount){
            int[] newCode = new int[targetPickCount];
            int j = 0;
            for(int i = 0; i < choiceCnt; i++){
                if (choose[i]){
                    newCode[j] = sourceNumbers[i];
                    j++;
                }
            }
            list.add(newCode);
            return;
        }
        if (depth == choiceCnt){
            return;
        }
        choose[depth] = true;
        dfs(depth+1, choosen+1, list);
        choose[depth] = false;
        dfs(depth+1, choosen, list);
        
    }
}

/*
테스트 1 〉	통과 (0.61ms, 93.4MB)
테스트 2 〉	통과 (1.92ms, 75.7MB)
테스트 3 〉	통과 (0.07ms, 89MB)
테스트 4 〉	통과 (0.37ms, 92.9MB)
테스트 5 〉	통과 (0.08ms, 89.2MB)
테스트 6 〉	통과 (0.19ms, 92.4MB)
테스트 7 〉	통과 (0.68ms, 70.8MB)
테스트 8 〉	통과 (1.53ms, 83.4MB)
테스트 9 〉	통과 (3.77ms, 94.4MB)
테스트 10 〉	통과 (4.53ms, 81.4MB)
테스트 11 〉	통과 (3.06ms, 74.4MB)
테스트 12 〉	통과 (26.79ms, 95.5MB)
테스트 13 〉	통과 (16.52ms, 89.4MB)
테스트 14 〉	통과 (36.05ms, 94.1MB)
테스트 15 〉	통과 (24.22ms, 93.4MB)
테스트 16 〉	통과 (26.22ms, 96.9MB)
테스트 17 〉	통과 (16.89ms, 94.6MB)
테스트 18 〉	통과 (3.22ms, 89.3MB)
테스트 19 〉	통과 (13.94ms, 88.6MB)
테스트 20 〉	통과 (2.48ms, 80.1MB)
*/
