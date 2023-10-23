package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bispo;
import chess.pieces.Cavalo;
import chess.pieces.Piao;
import chess.pieces.Rainha;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				
				mat[i][j] = (ChessPiece) board.piece(i, j);
				
			}
			
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		return (ChessPiece)capturedPiece;
		
	}
	
	private Piece makeMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		return capturedPiece;
		
	}
	
	private void validateSourcePosition(Position position) {
		
		if(!board.thereIsAPiece(position)) {
			
			throw new ChessException("there is no piece on source position");
			
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {
			
			throw new ChessException("There is no possible moves for the chosen piece");
			
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		
		if(!board.piece(source).possibleMove(target)) {
			
			throw new ChessException("The chosen piece can't move to target position.");
			
		}
		
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		
	}
	
	private void initialSetup() {
//	------------------------ BRACO ------------------------------------	
		placeNewPiece('a', 8, new Torre(board, Color.WHITE));
		placeNewPiece('h', 8, new Torre(board, Color.WHITE));
		
		placeNewPiece('b', 8, new Cavalo(board, Color.WHITE));
		placeNewPiece('g', 8, new Cavalo(board, Color.WHITE));
		
		placeNewPiece('c', 8, new Bispo(board, Color.WHITE));
		placeNewPiece('f', 8, new Bispo(board, Color.WHITE));
		
		placeNewPiece('a', 7, new Piao(board, Color.WHITE));
		placeNewPiece('b', 7, new Piao(board, Color.WHITE));
		placeNewPiece('c', 7, new Piao(board, Color.WHITE));
		placeNewPiece('d', 7, new Piao(board, Color.WHITE));
		placeNewPiece('e', 7, new Piao(board, Color.WHITE));
		placeNewPiece('f', 7, new Piao(board, Color.WHITE));
		placeNewPiece('g', 7, new Piao(board, Color.WHITE));
		placeNewPiece('h', 7, new Piao(board, Color.WHITE));
//	------------------------ PRETO ------------------------------------	
		placeNewPiece('a', 1, new Torre(board, Color.BLACK));
		placeNewPiece('h', 1, new Torre(board, Color.BLACK));
		
		placeNewPiece('b', 1, new Cavalo(board, Color.BLACK));
		placeNewPiece('g', 1, new Cavalo(board, Color.BLACK));
		
		placeNewPiece('c', 1, new Bispo(board, Color.BLACK));
		placeNewPiece('f', 1, new Bispo(board, Color.BLACK));
		
		placeNewPiece('a', 2, new Piao(board, Color.BLACK));
		placeNewPiece('b', 2, new Piao(board, Color.BLACK));
		placeNewPiece('c', 2, new Piao(board, Color.BLACK));
		placeNewPiece('d', 2, new Piao(board, Color.BLACK));
		placeNewPiece('e', 2, new Piao(board, Color.BLACK));
		placeNewPiece('f', 2, new Piao(board, Color.BLACK));
		placeNewPiece('g', 2, new Piao(board, Color.BLACK));
		placeNewPiece('h', 2, new Piao(board, Color.BLACK));
		
		placeNewPiece('e', 1, new Rei(board, Color.BLACK));
		placeNewPiece('d', 1, new Rainha(board, Color.BLACK));
		
		placeNewPiece('e', 8, new Rei(board, Color.WHITE));
		placeNewPiece('d', 8, new Rainha(board, Color.WHITE));
	}
	
}
