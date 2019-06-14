public class CheckBoard { // used to contain wincheck

    public static boolean winCheck(Tile Player, Tile[][] board) {
        if (horizontalCheck(Player, board) || verticalCheck(Player, board) || diagonalCheck(Player, board)) {
            return true;
        }
        return false;
    }

    public static boolean horizontalCheck(Tile Player, Tile[][] board) {
        for (int i = 0; i < board.length - 5; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == Player) {
                    if (board[i + 1][j] == Player && board[i + 2][j] == Player
                    && board[i + 3][j] == Player && board[i + 4][j] == Player) {
                        try { //check if more than 5
                            if (board[i - 1][j] == Player || board[i + 5][j] == Player) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean verticalCheck(Tile Player, Tile[][] board) {
        for (int j = 0; j < board.length - 5; j += 1) {
            for (int i = 0; i < board[0].length; i += 1) {
                if (board[i][j] == Player) {
                    if (board[i][j + 1] == Player && board[i][j + 2] == Player
                            && board[i][j + 3] == Player && board[i][j + 4] == Player) {
                        try { //check if more than 5
                            if (board[i][j - 1] == Player || board[i][j + 5] == Player) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean diagonalCheck(Tile Player, Tile[][] board) {
        //pos orientation
        for (int i = 0; i < board.length - 4; i += 1) {
            for (int j = 0; j < board[0].length - 4; j += 1) {
                if (board[i][j] == Player) {
                    if (board[i + 1][j + 1] == Player && board[i + 2][j + 2] == Player
                            && board[i + 3][j + 3] == Player && board[i + 4][j + 4] == Player) {
                        try { //check if more than 5
                            if (board[i - 1][j - 1] == Player || board[i + 5][j + 5] == Player) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        return true;
                    }
                }
            }
        }
        //neg orientation
        for (int i = 0; i < board.length - 4; i += 1) {
            for (int j = 4; j < board.length; j += 1) {
                if (board[i][j] == Player) {
                    if (board[i + 1][j - 1] == Player && board[i + 2][j - 2] == Player
                            && board[i + 3][j - 3] == Player && board[i + 4][j - 4] == Player) {
                        try { //check if more than 5
                            if (board[i - 1][j + 1] == Player || board[i + 5][j - 5] == Player) {
                                return false;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
