package Assingment1;

public class PieceFactory {
    public static Piece createPiece(String piece) {
        if (piece.equalsIgnoreCase("Knight"))
            return new Knight();
        else if (piece.equalsIgnoreCase("Pawn"))
            return new Pawn();
        else if (piece.equalsIgnoreCase("Bishop"))
            return new Bishop();
        else return null;
    }
}
