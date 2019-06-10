import java.util.Arrays;

public class Tile {
    private final String image;
    private final Boolean hasPiece = false;
    private final int piece = 0; // 0 is none, 1 is black, 2 is white

    //description of tile, as well as image path
    public Tile(String im) {
        image = im; // image goes into image files to pull
    }

    //draws image at these coordinates
    public void draw(double x, double y) {
        if (image != null) {
            try {
                StdDraw.picture(x + 0.5, y + 0.5, image); //need to figure out proper sizes later
                return;
            } catch (IllegalArgumentException e) {
                // Exception happens because the file can't be found. In this case, fail silently
                // and just use the character and background color for the tile.
                System.out.println("it broke");
            }
        }
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void addPiece(int x) {
        if (x == 1) {
            //add black piece to tile
        } else if (x == 2) {
            //add white piece to tile
        } else {
            System.out.println("not valid piece");
        }
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
