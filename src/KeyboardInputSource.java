import edu.princeton.cs.introcs.StdDraw;

public class KeyboardInputSource implements InputSource {

    public KeyboardInputSource() {
    }
//used for the main screen
    public char getNextKey() {
        if (StdDraw.hasNextKeyTyped()) {
            char c = Character.toUpperCase(StdDraw.nextKeyTyped());
            return c;
        }
        char hi = ' ';
        return hi;
    }

    public boolean possibleNextInput() {
        return true;
    }
}
