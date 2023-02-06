package Assingment1;

import java.util.Scanner;

public class ChessTest {
    public static void main(String[] args) {
        Piece bishop = new Bishop();
        System.out.println(bishop.move());

        Piece pawn = new Pawn();
        System.out.println(pawn.move());

        Piece knight = new Knight();
        System.out.println(knight.move());

        System.out.println("choose piece");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Piece piece = PieceFactory.createPiece(name);
        assert piece != null;
        System.out.println(piece.move());
    }
}
