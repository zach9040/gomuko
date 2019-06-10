public class GameSetup {
    private static final int WIDTH = 62;
    private static final int HEIGHT = 42;

    public static void boardSetup(Tile[][] goBoard) { //board creation with images
        for (int i = 0; i < goBoard.length; i += 1) {
            for (int j = 0; j < goBoard[0].length; j += 1) {
                goBoard[i][j] = TileSet.BOARD;
            }
        }
        //aesthetic dots
        for (int i = 3; i < goBoard.length; i += 7) {
            for (int j = 3; j < goBoard[0].length; j += 7) {
                goBoard[i][j] = TileSet.DOTBOARD;
            }
        }

        for (int i = 1; i < goBoard.length - 1; i += 1) {
            goBoard[i][0] = TileSet.BBOARD;
            goBoard[i][20] = TileSet.TBOARD;
        } // side
        for (int j = 1; j < goBoard[0].length - 1; j += 1) {
            goBoard[0][j] = TileSet.LBOARD;
            goBoard[20][j] = TileSet.RBOARD;
        } // side
        //corners
        goBoard[0][0] = TileSet.BLACK;
        goBoard[0][20] = TileSet.TLCORNER;
        goBoard[20][20] = TileSet.TRCORNER;
        goBoard[20][0] = TileSet.BRCORNER;
    }


    public static void displaySetup() {

    }

    public static void updateDisplay() {

    }

    public static Tile[][] playGame() {
        Tile[][] goBoard = new Tile[21][21];
        boardSetup(goBoard);
        return goBoard;
    }

}
