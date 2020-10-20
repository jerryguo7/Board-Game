# Board-Game
This board game has a variety of pieces that move across the game board.

Assume that the game board is an 8 X 8 grid. The position is a coordinate ([x, y]) on the board, with the values of x and y each taking a value between 0 and 7. The top left corner of the board is taken to be the origin ([0, 0]).

create location [fast][flexible] – Create a Piece and place it in a given initial location of the form x y. By default a Piece is slow and nonflexible.

Examples: ‘create 1 1’→would create a slow nonflexible Piece at location [1, 1]

‘create 1 1 fast’→would create a fast nonflexible Piece at location [1,1]

‘create 1 1 flexible’→would create a slow flexible Piece at location [1, 1]

‘create 1 1 fast flexible’→would create a fast flexible Piece at location [1, 1]

The create command should be followed by a prompt asking the user to ‘enter the name and the colour of the Piece’.

move location direction [spaces] – Move a Piece from a given location of the form x y, in a direction given as one of four possible Strings: ‘left’, ‘right’, ‘up’ or ‘down’ (the last two only apply to flexible Pieces). The optional [spaces] parameter is only applicable to FastPieces, and specifies how many places to move a Piece.

Examples: ‘move 5 5 left 3’→moves the Piece at (5,5) by 3 spaces to the left. In order for this to work, the piece at (5,5) must be a fast Piece.

‘move 5 5 up 2’→moves the Piece at (5,5) two spaces up. In order for this to work, the piece at (5,5) must be a fast flexible Piece.

‘move 5 5 right’→moves the Piece at (5,5) one space to the right. In order for this to work, the Piece can be a slow Piece or a slow flexible pPiece or a fast piece or a fast flexible Piece. If it is a fast Piece or a fast flexible Piece, you would invoke the method move(right, 1) indicating that it is to be moved 1 space to the right.

‘move 5 5 up’→moves the Piece at (5,5) one space up. In order for this to work, the Piece must be a slow flexible Piece or a fast flexible Piece. If it is a fast flexible Piece,you would invoke the method move(up, 1) indicating that it is to be moved 1 space up.

‘move 5 5 left 1’→moves the Piece at (5,5) one space to the left. In order for this to work, it can be a slow Piece or a slow flexible Piece or a fast Piece or a fast flexible Piece. If it is a slow Piece or a slow flexible Piece, you would invoke the method move(left) since the Piece can only move by one space.
