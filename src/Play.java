import static java.lang.StrictMath.floor;

public class Play {
    private static int[] player1;
    private static int[] player2;
    private static int currentPlayer = 0;
    private static boolean winCondition = false;
    private static Tile[][] copy;
    static TileRenderer renderer;

    private static void changePlayers() {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    private static Tile getPlayerColor(boolean placeholder) {
        if (currentPlayer == 0) {
            if (placeholder) {
                return TileSet.BLACKMOVE;
            }
            return TileSet.BLACK;
        } else {
            if (placeholder) {
                return TileSet.WHITEMOVE;
            }
            return TileSet.WHITE;
        }
    }

    private static int[] getCurrentPlayer() {
        if (currentPlayer == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    private static boolean notOccupied(int[] player) {
        if (copy[player[0]][player[1]] != TileSet.WHITE && copy[player[0]][player[1]] != TileSet.BLACK) {
            return true;
        }
        return false;
    }


    public static void playGame(InputSource input, TileRenderer renderer, Tile[][] board) {
        board[10][10] = getPlayerColor(true);
        int[] player;
        loop : while (true) {
            if (currentPlayer % 2 == 0) {
                player = new int[] {player1[0], player1[1]};
            } else {
                player = new int[] {player2[0], player2[1]};
            }
            if (StdDraw.isMousePressed()) {
                int x = (int) floor(StdDraw.mouseX()) - player[0];
                int y = (int) floor(StdDraw.mouseY()) - player[1];
                move(x, y, board);
            }
            char move = input.getNextKey();
            switch (move) {
                case 'W' :
                    move(0, 1, board);
                    break;
                case 'A' :
                    move(-1, 0, board);
                    break;
                case 'S' :
                    move(0, -1, board);
                    break;
                case 'D' :
                    move(1, 0, board);
                    break;
                case 'J':
                    if (notOccupied(player)) {
                        copy[player[0]][player[1]] = getPlayerColor(false);
                        board[player[0]][player[1]] = copy[player[0]][player[1]];
                        if (currentPlayer % 2 == 0) {
                            player1 = new int[] {10, 10};
                        } else {
                            player2 = new int[] {10, 10};
                        }
                        break loop;
                    }
                    System.out.println("Invalid Move");
                    break;
            }
            renderer.renderFrame(board);
        }
        renderer.renderFrame(board);
    }

    private static void move(int xMove, int yMove, Tile[][] board) {
        int[] player = getCurrentPlayer();
        int x = player[0];
        int y = player[1];
        try {
            if (xMove != 0 || yMove != 0) {
                board[x + xMove][y + yMove] = getPlayerColor(true);
                board[x][y] = copy[x][y];
                if (currentPlayer % 2 == 0) {
                    player1 = new int[] {x + xMove, y + yMove};
                } else {
                    player2 = new int[] {x + xMove, y + yMove};
                }
            }
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Invalid Move");
        }
    }

    public static void setScreens(InputSource input, GameScreen game) {
        loop : while (input.possibleNextInput()) {
            char start = input.getNextKey();
            switch (start) {
                case 'P' : //continue
                    break loop;
                case 'C': // credits
                    game.creditScreen();
                    break;
                case 'H': //how to play
                    game.helpScreen();
                    break;
                case 'B': // go back to start
                    game.startScreen();
                    break;
                case 'Q': // quit
                    System.exit(0);
            }
        }
    }

    private static void resetGame(Tile[][] board) {
        player1 = new int[] {10, 10};
        player2 = new int[] {10, 10};
        currentPlayer = 0; //set first player to black
        winCondition = false;
        copy = Tile.copy(board);
        renderer = new TileRenderer();
    }

    public static void play(InputSource input) {
        GameScreen game = new GameScreen();
        game.initialize();
        game.startScreen();

        setScreens(input, game); // intro screens

        Tile[][] board = GameSetup.playGame();
        resetGame(board);

        renderer.initialize(21, 21);
        renderer.renderFrame(board);

        while (!winCondition) {
            //GameSetup.displaySetup();
            playGame(input, renderer, board);
            winCondition = CheckBoard.winCheck(getPlayerColor(false), copy);
            if (winCondition) {
                System.out.println("Game Over");
                game.initialize();
                game.winnerScreen(getPlayerColor(false));
            } else {
                changePlayers();
            }
        }
    }


    public static void main(String[] args) {
        InputSource input = new KeyboardInputSource();
        play(input);
        checkReplay : while (input.possibleNextInput()) {
            char replay = input.getNextKey();
            switch (replay) {
                case 'Q' :
                    System.exit(0);
                case 'R':
                    play(input);
            }
        }
    }
}
