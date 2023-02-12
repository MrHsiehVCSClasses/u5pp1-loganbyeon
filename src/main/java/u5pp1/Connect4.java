package u5pp1;

public class Connect4 {

    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static final int RED = 1;
    public static final int BLACK = -1;
    public static final int EMPTY = 0;

    public static boolean isFull(int[][] board){
        /**
         * returns true if all spaces are full  
         * if row and col is empty = not full
         */
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
 
    public static boolean isBoardValid(int[][] board){
        /**
         * if row is empty and row above is not empty = invalid
         * if row is full and row above is full = valid
         */
        for(int row = board.length - 1; row > 0; row--){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == EMPTY && board[row - 1][col] != EMPTY){
                    return false;
                }
            }
        }    
        return true;   
    }
 
    public static int getWinner(int[][] board){
        boolean red = false;
        boolean black = false;
        //Checks 4 horizontal
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length - 3; col++){
                if(board[row][col] == RED){
                    if(board[row][col + 1] == RED && 
                            board[row][col + 2] == RED && 
                            board[row][col + 3] == RED){
                            red = true;
                            break;
                    }
                }
                if(board[row][col] == BLACK){
                    if(board[row][col + 1] == BLACK && 
                            board[row][col + 2] == BLACK && 
                            board[row][col + 3] == BLACK){
                            black = true;
                            break;
                    }
                }
            }
        }
        //Checks 4 vertical
        for(int row = 0; row < board.length - 3; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == RED){
                    if(board[row + 1][col] == RED && 
                            board[row + 2][col] == RED && 
                            board[row + 3][col] == RED){
                            red = true;
                            break;
                    }
                }
                if(board[row][col] == BLACK){
                    if(board[row + 1][col] == BLACK && 
                            board[row + 2][col] == BLACK && 
                            board[row + 3][col] == BLACK){
                            black = true;
                            break;
                    }
                }
            }
        }
        //Checks 4 up diagonal
        for(int row = 0; row < board.length - 3; row++){
            for(int col = 0; col < board[0].length - 3; col++){
                if(board[row][col] == RED){
                    if(board[row + 1][col + 1] == RED && 
                            board[row + 2][col + 2] == RED && 
                            board[row + 3][col + 3] == RED){
                            red = true;
                            break;
                    }
                }
                if(board[row][col] == BLACK){
                    if(board[row + 1][col + 1] == BLACK && 
                            board[row + 2][col + 2] == BLACK && 
                            board[row + 3][col + 3] == BLACK){
                            black = true;
                            break;
                    }
                }
            }
        }
        //Checks 4 down diagonal
        for(int row = 0; row < board.length - 3; row++){
            for(int col = board[0].length - 1; col > 2; col--){
                if(board[row][col] == RED){
                    if(board[row + 1][col - 1] == RED && 
                            board[row + 2][col - 2] == RED && 
                            board[row + 3][col - 3] == RED){
                            red = true;
                            break;
                    }
                }
                if(board[row][col] == BLACK){
                    if(board[row + 1][col - 1] == BLACK && 
                            board[row + 2][col - 2] == BLACK && 
                            board[row + 3][col - 3] == BLACK){
                            black = true;
                            break;
                    }
                }
            }
        }
        //Both red and black wins
        if(red && black){
            return BOTH_WIN;
        }
        //Only red wins
        else if(red){
            return RED_WIN;
        }
        //Only black wins
        else if(black){
            return BLACK_WIN;
        }
        //Neither wins
        return NO_WINNER;
    }
}
