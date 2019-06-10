import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.princeton.cs.introcs.StdDraw;

import static java.lang.StrictMath.floor;

public class Play {
    private static final int BLACK = 0;
    private static final int WHITE = 1;
    private static int playerChoice;

    public static void playGame(InputSource input, TileRenderer renderer, Tile[][] board) {
    }

    public static boolean colorScreen(InputSource input, GameScreen game) {
        game.chooseColorScreen();
        while (input.possibleNextInput()) {
            char pieceChoice = input.getNextKey();
            switch (pieceChoice) {
                case 'B':
                    playerChoice = BLACK;
                    return true;
                case 'W':
                    playerChoice = WHITE;
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

        renderer.initialize(31, 21);
        renderer.renderFrame(board);
        //gameplay from now on i think
        System.out.println("right before");
        playGame(input, renderer, board);

        Point pos = MouseInfo.getPointerInfo().getLocation();
        while (true) {
            int x = (int) floor(StdDraw.mouseX());
            int y = (int) floor(StdDraw.mouseY());
            try {
                board[x][y] = TileSet.BLCORNER;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("out");
            }
        }

    }
}
