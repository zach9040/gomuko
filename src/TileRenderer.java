import java.awt.*;

public class TileRenderer {
    private static final int TILE_SIZE = 32;
    private int width;
    private int height;

    public void initialize(int w, int h) {
        width = w;
        height = h;
        StdDraw.setCanvasSize(width * TILE_SIZE, height * TILE_SIZE);
        Font font = new Font("Times New Roman", Font.BOLD, TILE_SIZE - 4);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(new Color(0, 0, 0));
        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    public void renderFrame(Tile[][] board) {
        int xTiles = board.length;
        int yTiles = board[0].length;
        for (int x = 0; x < xTiles; x += 1) {
            for (int y = 0; y < yTiles; y += 1) {
                board[x][y].draw(x, y);
            }
        }
        StdDraw.show();
    }
}
