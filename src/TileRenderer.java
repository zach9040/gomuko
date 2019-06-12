import java.awt.*;

public class TileRenderer {
    private static final int TILE_SIZE = 32;
    private int width;
    private int height;
    private int xOffset = 0; //used for messing around with display, where empty space will be
    private int yOffset = 0;

    public void initialize(int w, int h) {
        this.width = w;
        this.height = h;
        StdDraw.setCanvasSize(width * TILE_SIZE, height * TILE_SIZE);
        Font font = new Font("Monaco", Font.BOLD, TILE_SIZE - 2);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        StdDraw.clear(new Color(0, 0, 0));

        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    public void renderFrame(Tile[][] board) {
        int numXTiles = board.length;
        int numYTiles = board[0].length;
        StdDraw.clear(new Color(100, 0, 0));
        for (int x = 0; x < numXTiles; x += 1) {
            for (int y = 0; y < numYTiles; y += 1) {
                if (board[x][y] == null) {
                    throw new IllegalArgumentException("Position at position x=" + x + ", y=" + y
                            + " is null.");
                }
                board[x][y].draw(x + xOffset, y + yOffset);
            }
        }
        StdDraw.show();
    }
}
