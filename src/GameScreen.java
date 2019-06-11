import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class GameScreen {
    private static int width = 50;
    private static int height = 50;
    private static int midWidth = width / 2;
    private static int midHeight = height / 2;

    public GameScreen() { }

    public void initialize() {
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
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

        StdDraw.text(midWidth, midHeight, "Good Luck!");
        StdDraw.show();
        //explain how game works
    }


    public void creditScreen() {
        StdDraw.clear(Color.WHITE);

        StdDraw.text(midWidth, height - 2, "Gomoku is a game.");
        StdDraw.show();
        //say why i made it
    }

    public void optionScreen() {
        //choose whether 1 v 1 or 1 v computer (later)
    }
}
