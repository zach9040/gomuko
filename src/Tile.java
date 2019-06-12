import java.io.IOException;
import java.util.Arrays;

public class Tile {
    private String image;
    private final Boolean hasPiece = false;

    //description of tile, as well as image path
    public Tile(String im) {
        image = im;// image goes into image files to pull
    }

    //draws image at these coordinates
    public void draw(double x, double y) {
        try {
            StdDraw.picture(x + 0.5, y + 0.5, image);
        } catch (IndexOutOfBoundsException i) {
            System.out.println("Image not proper size.");
        }
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    //creates copy of double array in case of undo?
    //undo may take a lot of memory to actually use not sure if practical
    public static Tile[][] copy(Tile[][] tiles) {
        if (tiles == null) {
            return null;
        }

        Tile[][] copy = new Tile[tiles.length][];

        int i = 0;
        for (Tile[] column : tiles) {
            copy[i] = Arrays.copyOf(column, column.length);
            i += 1;
        }

        return copy;
    }
}
