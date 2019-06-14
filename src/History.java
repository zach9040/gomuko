public class History { // modified double linked list to keep track of move history

    private boolean player; // true black, false white
    private Move curr;
    private Move prev;
    private Move next;
    private int size;

    public History(boolean player) {
        this.player = player;
    }

    private class Move {
        int[] move;
        Move next;
        Move prev;

        private Move(int[] move, Move next, Move prev) {
            this.move = move;
            this.next = next;
            this.prev = prev;
        }

        private int[] getMove() {
            return move;
        }

        @Override
        public String toString() {
            String text = "";
            for (int i : move) {
                text += Integer.toString(i);
            }
            return text;
        }
    }

    public void addMove(int[] move) {
        if (curr == null) {
            curr = new Move(move, null, null);
        } else {  // clears moves in front, if there are moves
            prev = curr;
            curr = new Move(move, null, prev);
            next = null;
        }
    }

    public int[] goBack() {
        if (prev != null) {
            Move placeholder = prev.prev;
            next = curr;
            curr = prev;
            prev = placeholder;
            return next.getMove();
        }
        return null;
    }

    public int[] goForward() {
        if (next != null) {
            Move placeholder = next.next;
            prev = curr;
            curr = next;
            next = placeholder;
            return prev.getMove();
        }
        return null;
    }

    public int[] getMove() {
        return curr.move;
    }

    public void printPlayerHistory() {

    }

    /*public static void main(String[] args) {
        History h = new History(false);
        h.addMove(new int[] {10, 10});
        h.addMove(new int[] {20, 20});
        System.out.println(h.curr);
        h.goBack();
        System.out.println(h.curr);
        h.addMove(new int[] {30, 30});
        System.out.println(h.curr);
        h.addMove(new int[] {40, 40});
        h.goForward();
        System.out.println(h.curr);
        System.out.println(h.prev);
    }*/
}
