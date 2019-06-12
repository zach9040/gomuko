import java.awt.*;

public class GameScreen {
    private static int width = 50;
    private static int height = 50;
    private static int midWidth = width / 2;
    private static int midHeight = height / 2;

    public GameScreen() { }

    public void initialize() {
        StdDraw.setCanvasSize(width * 16, height * 16);
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);
    }

    public void startScreen() {
        StdDraw.clear(Color.WHITE);

        StdDraw.text(midWidth, height - 2, "Gomoku");
        StdDraw.text(midWidth, midHeight + 2, "Play Game (P)");
        StdDraw.text(midWidth, midHeight, "How to Play (H)");
        StdDraw.text(midWidth, midHeight - 2, "Credits (C)");

        StdDraw.show();
    }

    public void helpScreen() {
        StdDraw.clear(Color.WHITE);

        StdDraw.text(midWidth, height - 2, "Gomoku is a game that utilizes the Go Board.");
        StdDraw.text(midWidth, height - 4, "The aim of the game is to get five in a row.");

        StdDraw.text(midWidth, midHeight - 2, "The position of the piece can be controlled by");
        StdDraw.text(midWidth, midHeight - 4, "WASD or mouseclicks.");
        StdDraw.text(midWidth, midHeight - 8, "Press J to confirm the move.");

        StdDraw.text(midWidth, 2, "Good Luck!");
        StdDraw.show();
        //explain how game works
    }


    public void creditScreen() {
        StdDraw.clear(Color.WHITE);

        StdDraw.text(midWidth, height - 2, "Gomoku is a game that I used to ");
        StdDraw.text(midWidth, height - 4, "really enjoy as a kid, playing");
        StdDraw.text(midWidth, height - 6, "with family members in China, so I ");
        StdDraw.text(midWidth, height - 8, "decided to create a recreation of it using");
        StdDraw.text(midWidth, height - 10, "Java's StdDraw to create a engine based ");
        StdDraw.text(midWidth, height - 12, "on image tiles to form a board.");
        StdDraw.show();
        //say why i made it
    }

    public void optionScreen() {
        //choose whether 1 v 1 or 1 v computer (later)
    }

    public void winnerScreen(Tile winner) {
        StdDraw.clear(Color.WHITE);

        String win;
        if (winner == TileSet.BLACK) {
            win = "Player 1";
        } else {
            win = "Player 2";
        }

        StdDraw.text(midWidth, midHeight + 2, win + "  wins!");
        StdDraw.text(midWidth, midHeight - 4, "Press R to Replay");
        StdDraw.text(midWidth, midHeight - 6, "Press Q to Quit");
        StdDraw.show();
    }
}
