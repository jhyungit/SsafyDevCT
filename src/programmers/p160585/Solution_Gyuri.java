import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> validState = new HashSet<>();
    
    boolean cmp(char a, char b, char c) {
        // ... 은 done이 아님
        return a != '.' && a == b && b == c;
    }
    
    boolean isDone(char[][] b) {
        // horizontal
        if (cmp(b[0][0], b[0][1], b[0][2])) return true;
        if (cmp(b[1][0], b[1][1], b[1][2])) return true;
        if (cmp(b[2][0], b[2][1], b[2][2])) return true;
        // vertical
        if (cmp(b[0][0], b[1][0], b[2][0])) return true;
        if (cmp(b[0][1], b[1][1], b[2][1])) return true;
        if (cmp(b[0][2], b[1][2], b[2][2])) return true;
        // diagonal
        if (cmp(b[0][0], b[1][1], b[2][2])) return true;
        if (cmp(b[0][2], b[1][1], b[2][0])) return true;
        
        return false;
    }
    
    // board -> hash
    String toHash(char[][] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                sb.append(b[i][j]);
        
        return sb.toString();
    }
    
    void dfs(char[][] b, int turn) {
        // snapshot current board
        String key = toHash(b);
        if (validState.contains(key)) return; // 이미 탐색 완료
        validState.add(key); // 아니면 신규 저장

        // is game over?
        if (isDone(b)) return;
        
        char nxtCh = (turn == 0) ? 'O' : 'X';
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (b[i][j] == '.') {
                    b[i][j] = nxtCh;
                    dfs(b, 1-turn);
                    b[i][j] = '.'; // reset
                }
            }
        }
    }

    public int solution(String[] board) {
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                b[i][j] = '.';
        
        dfs(b, 0);

        // board -> hash
        StringBuilder sb = new StringBuilder();
        for (String row : board)
            sb.append(row);
        String curState = sb.toString();

        // is valid?
        return validState.contains(curState) ? 1 : 0;
    }
}