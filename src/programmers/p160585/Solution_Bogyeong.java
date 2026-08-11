package programmers.p160585;

class Solution_Bogyeong {
    private static final int BOARD_LENGTH = 3;
    private static int oCnt = 0, xCnt = 0;
    
    public int solution(String[] board) {
        char[][] charBoard = init(board);
        
        boolean isValid = isCountValid(charBoard) && isVictoryValid(charBoard);
        return isValid ? 1 : 0;
    }
    
    private char[][] init(String[] strBoard) {
        char[][] charBoard = new char[BOARD_LENGTH][BOARD_LENGTH];
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                charBoard[i][j] = strBoard[i].charAt(j);
            }
        }
        
        return charBoard;
    }
    
    private boolean isCountValid(char[][] board) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                if (board[i][j] == 'O') {
                    ++oCnt;
                } else if (board[i][j] == 'X') {
                    ++xCnt;
                }
            }
        }
        
        return oCnt == xCnt || oCnt == xCnt+1;
    }
    
    private boolean isVictoryValid(char[][] board) {
        boolean oVictory = false, xVictory = false;
        char first;
        
        // 가로
        for (int i = 0; i < BOARD_LENGTH; i++) {
            first = board[i][0];
            if (first == '.') continue;
            
            int j = 1;
            while (j < BOARD_LENGTH) {
                if (board[i][j] != first) break;
                ++j;
            }
            if (j != BOARD_LENGTH) continue;
            
            if (first == 'O') oVictory = true;
            else              xVictory = true;
        }
        
        // 세로
        for (int j = 0; j < BOARD_LENGTH; j++) {
            first = board[0][j];
            if (first == '.') continue;
            
            int i = 1;
            while (i < BOARD_LENGTH) {
                if (board[i][j] != first) break;
                ++i;
            }
            if (i != BOARD_LENGTH) continue;
            
            if (first == 'O') oVictory = true;
            else              xVictory = true;
        }
        
        // 대각선 \ 방향
        first = board[0][0];
        if (first != '.') {
            int i = 1;
            while (i < BOARD_LENGTH) {
                if (board[i][i] != first) break;
                ++i;
            }
            if (i == BOARD_LENGTH) {
                if (first == 'O') oVictory = true;
                else              xVictory = true;
            }
        }
        
        // 대각선 / 방향
        first = board[0][BOARD_LENGTH-1];
        if (first != '.') {
            int i = 1;
            while (i < BOARD_LENGTH) {
                if (board[i][BOARD_LENGTH-i-1] != first) break;
                ++i;
            }
            if (i == BOARD_LENGTH) {
                if (first == 'O') oVictory = true;
                else              xVictory = true;
            }
        }
        
        if (!oVictory && !xVictory) return true;
        if (oVictory && xVictory) return false;
        
        if (oVictory) {
            return oCnt == xCnt + 1;
        }
        
        return oCnt == xCnt;
    }
}
