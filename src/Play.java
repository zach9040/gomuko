import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.princeton.cs.introcs.StdDraw;
import groovy.lang.MetaClassImpl;

import static java.lang.StrictMath.floor;

public class Play {
    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static final int ORIGINAL = 2;
    private static int[] player1;
    private static int[] player2;
    private static int currentPlayer = 0;
    private static boolean winCondition = false;
    private static Tile[][] copy;

    private static void resetGame() {
        winCondition = false;
    }


    private static void changePlayers() {
        currentPlayer = (currentPlayer + 1) % 2;
    }

    private static Tile getPlayerColor() {
        if (currentPlayer == 0) {
            return TileSet.BLACK;
        } else {
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


    public static void playGame(InputSource input, TileRenderer renderer, Tile[][] board) {
        board[0][0] = getPlayerColor();
        int[] player;
        loop : while (true) {
            if (currentPlayer % 2 == 0) {
                player = new int[] {player1[0], player1[1]};
            } else {
                player = new int[] {player2[0], player2[1]};
            }
            char move = input.getNextKey();
            switch (move) {
                case 'W' :
                    move(0, 1, board);
                    break;
                case 'A' :
                    move (-1, 0, board);
                    break;
                case 'S' :
                    move (0, -1, board);
                    break;
                case 'D' :
                    move (1, 0, board);
                    break;
                case 'J':
                    if (copy[player[0]][player[1]] != TileSet.WHITE && copy[player[0]][player[1]] != TileSet.BLACK) {
                        copy[player[0]][player[1]] = board[player[0]][player[1]];
                        if (currentPlayer % 2 == 0) {
                            player1 = new int[] {0, 0};
                        } else {
                            player2 = new int[] {0, 0};
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
            board[x + xMove][y + yMove] = getPlayerColor();
            board[x][y] = copy[x][y];
            if (currentPlayer % 2 == 0) {
                player1 = new int[] {x + xMove, y + yMove};
            } else {
                player2 = new int[] {x + xMove, y + yMove};
            }
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Invalid Move");
        }
    }

    private static boolean confirmMove(InputSource input) {
        char confirm = input.getNextKey();
        if (confirm == 'J') {
            return true;
        }
        return false;
    }

    public static boolean colorScreen(InputSource input, GameScreen game) {
        game.chooseColorScreen();
        while (input.possibleNextInput()) {
            char pieceChoice = input.getNextKey();
            switch (pieceChoice) {
                case 'B':
                    //playerChoice = BLACK;
                    return true;
                case 'W':
                    //playerChoice = WHITE;
                    return true;
                case 'Q': //go back to first screen
                    System.out.println(pieceChoice);
                    return false;
            }
        }
        return false;
    }

    public static void setScreens(InputSource input, GameScreen game) {
        loop : while (input.possibleNextInput()) {
                char start = input.getNextKey();
                switch (start) {
                    case 'P' : //continue
                        boolean startGame = colorScreen(input, game);
                        if (startGame) {
                            break loop;
                        }
                        game.startScreen();
                        break;
                    case 'C': // credits
                        game.creditScreen();
                        break;
                    case 'H': //how to play
                        game.helpScreen();
                        break;
                    case 'Q': // go back to start
                        game.startScreen();
                        break;
                }
            }
        }

    public static void main(String[] args) {

        GameScreen game = new GameScreen();
        TileRenderer renderer = new TileRenderer();
        InputSource input = new KeyboardInputSource();
        game.initialize();
        game.startScreen();


        setScreens(input, game); // intro screens
        //create board
        Tile[][] board = GameSetup.playGame();
        copy = Tile.copy(board);

        renderer.initialize(31, 21);
        renderer.renderFrame(board);
        //gameplay from now on i think
        player1 = new int[] {0, 0};
        player2 = new int[] {0, 0};
        currentPlayer = 0;
        while (!winCondition) {
            playGame(input, renderer, board);
            GameSetup.displaySetup();
            changePlayers();
        }


    }
}