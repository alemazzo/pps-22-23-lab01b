package e1;

import java.util.Collections;
import java.util.Set;

public class BoardImpl implements Board {

    private final Set<Piece> pieces;
    private final int size;

    public BoardImpl(Set<Piece> pieces, int size) {
        this.pieces = pieces;
        this.size = size;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Set<Piece> getPieces() {
        return Collections.unmodifiableSet(this.pieces);
    }
}
