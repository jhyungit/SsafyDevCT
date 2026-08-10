package programmers.p160585;

class Solution_Chaeeun. {
    String[] board;
    int countOfO = 0;
    int countOfX = 0;
    
    public int solution(String[] board) {
        this.board = board;
        
        if (!isCountValid()) return 0;     
        
        // O가 이김?
        boolean lineOfO = hasLineOf('O');
        
        // X가 이김?
        boolean lineOfX = hasLineOf('X');
        
        // O가 이기면 O돌이 하나 더 많아야함
        if (lineOfO && countOfO != countOfX + 1) {
            return 0;
        }
        
        // X가 이기면 X돌이랑 개수가 같아야함
        if (lineOfX && countOfO != countOfX) {
            return 0;
        }
        
        // 둘 다 이기면 안됨
        if (lineOfO && lineOfX){
            return 0;
        }
        
        return 1;
    }
    
    boolean isCountValid(){        
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == '.') continue;
                if (c == 'O') {
                    countOfO++;
                }
                else {
                    countOfX++;
                }
            }
        }
        if (countOfO == countOfX || countOfO == countOfX + 1) return true;
        return false;
    }
    
    boolean hasLineOf(char c) {
        // 가로 찾기
        for (int i = 0; i < 3; i++){
            if (board[i].charAt(0) == c 
                && board[i].charAt(1) == c
                && board[i].charAt(2) == c) {
                return true;
            }
        }
        
        // 세로 찾기
        for (int i = 0; i < 3; i++){
            if (board[0].charAt(i) == c 
                && board[1].charAt(i) == c
                && board[2].charAt(i) == c) {
                return true;
            }
        }
        
        // 대각선 찾기
        if (board[1].charAt(1) != c) return false;
        if ((board[0].charAt(0) == c && board[2].charAt(2) == c)
           || (board[2].charAt(0) == c && board[0].charAt(2) == c)) {
            return true;
        }
        
        return false;
    }
}
