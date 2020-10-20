/* The Board class will hold the 8 X 8 game board.
 * Each position of the board either contains a Piece or is empty
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
import java.util.*;
public class Board extends Piece{
    ArrayList <String> boardGame;
    private String direction;
    SlowPiece slowPiece;
    FastPiece fastPiece;
    SlowFlexible slowFlexible;
    FastFlexible fastFlexible;

    //constructors
    public Board(){

    }

    public Board(String name, String colour, String speed, Point position, String direction) {
        super(name, colour, speed, position);
        boardGame = new ArrayList <String>();
        this.direction = direction;
    }

    //Create an empty Board
    public void Create(){
        for (int i = 0; i < 64; i++) {
            boardGame.add("-");
        }
    }

    //Add the piece to the specified location
    public void Add (Piece piece){
        //Get the position
        int xpos = (int) (piece.getPosition().getX());
        int ypos = (int) (piece.getPosition().getY());
        int pointValue = ypos * 8 + xpos;

        //Add the piece to a location only if none exist at that location.
        //Otherwise error message will be displayed
        if (xpos < 8 && xpos > -1 && ypos < 8 && ypos > -1
                && boardGame.get(pointValue).equals("-")) {
            boardGame.set(pointValue, piece.getName() + piece.getColour() + piece.getSpeed());
        } else {
            System.out.println("Error: the piece cannot be added");
        }
    }


    //Move the piece from the old location to the new location
    public boolean MakeItMove (int pointValue, int newPointValue){
        String str = boardGame.get(pointValue);

        //Only move the piece when the new location does not already have a piece.
        //Otherwise error message will be displayed
        if (boardGame.get(newPointValue).equals("-")) {
            boardGame.set(newPointValue, str);
            boardGame.set(pointValue, "-");
            return true;
        } else {
            System.out.println("Error: the piece cannot be moved");
            return false;
        }
    }


    public void Move(String name, String colour, String speed, Point point, String direction, int n){
        //Get the location values
        int originalXPos = (int) point.getX();
        int originalYPos = (int) point.getY();
        int pointValue = originalYPos * 8 + originalXPos;
        int newPointValue = 0;
        String str = ""; //Initialize

        //Only move the piece when the requested location is in the range of 8 X 8 game board.
        //Otherwise error message will be displayed
        if (originalXPos < 8 && originalXPos > -1 && originalYPos < 8 && originalYPos > -1) {
            str = boardGame.get(pointValue); //Get the piece info from location value

            //Only move the piece when there is a piece at this location.
            //Otherwise error message will be displayed
            if (!str.equals("-")) {
                //Get the speed info from piece info
                String flexible = str.substring(str.length() - 2);
                String nonFlexible = str.substring(str.length() - 1);
                if (flexible.equals("FF")) {
                    speed = "FF";
                } else if (flexible.equals("SF")) {
                    speed = "SF";
                } else if (nonFlexible.equals("F")) {
                    speed = "F";
                } else if (nonFlexible.equals("S")) {
                    speed = "S";
                }


                switch (speed) {
                    case "S":
                        slowPiece = new SlowPiece(name, colour, speed, point, direction);

                        //Check if the requested direction is valid
                        if (slowPiece.move(direction)) {
                            //Get the new point value when it can be moved
                            newPointValue = (int) (slowPiece.getPosition().getY() * 8 +
                                    slowPiece.getPosition().getX());
                            //Check if the piece can be successfully moved
                            //If it moves, display the done message
                            if (MakeItMove(pointValue, newPointValue)) {
                                System.out.println("Piece at (" + originalXPos + "," +
                                        originalYPos + ") moved " +
                                        direction + " by 1 space");
                            }
                        }
                        break;
                    case "F":
                        fastPiece = new FastPiece(name, colour, speed, point, direction);

                        //Check if the requested direction is valid
                        if (fastPiece.move(direction, n)) {
                            //Get the new point value when it can be moved
                            newPointValue = (int) (fastPiece.getPosition().getY() * 8 +
                                    fastPiece.getPosition().getX());
                            //Check if the piece can be successfully moved
                            //If it moves, display the done message
                            if (MakeItMove(pointValue, newPointValue)) {
                                if (n == 1) {
                                    System.out.println("Piece at (" + originalXPos + "," +
                                            originalYPos + ") moved " +
                                            direction + " by 1 space");
                                } else {
                                    System.out.println("Piece at (" + originalXPos + "," +
                                            originalYPos + ") moved " +
                                            direction + " by " + n + " spaces");
                                }
                            }
                        }
                        break;
                    case "SF":
                        slowFlexible = new SlowFlexible(name, colour, speed, point, direction);

                        //Check if the requested direction is valid
                        if (slowFlexible.move(direction)) {
                            //Get the new point value when it can be moved
                            newPointValue = (int) (slowFlexible.getPosition().getY() * 8 +
                                    slowFlexible.getPosition().getX());
                            //Check if the piece can be successfully moved
                            //If it moves, display the done message
                            if (MakeItMove(pointValue, newPointValue)) {
                                System.out.println("Piece at (" + originalXPos + "," +
                                        originalYPos + ") moved " +
                                        direction + " by 1 space");
                            }
                        }
                        break;
                    case "FF":
                        fastFlexible = new FastFlexible(name, colour, speed, point, direction);

                        //Check if the requested direction is valid
                        if (fastFlexible.move(direction, n)) {
                            //Get the new point value when it can be moved
                            newPointValue = (int) (fastFlexible.getPosition().getY() * 8 +
                                    fastFlexible.getPosition().getX());
                            //Check if the piece can be successfully moved
                            //If it moves, display the done message
                            if (MakeItMove(pointValue, newPointValue)) {
                                if (n == 1) {
                                    System.out.println("Piece at (" + originalXPos + "," +
                                            originalYPos + ") moved " +
                                            direction + " by 1 space");
                                } else {
                                    System.out.println("Piece at (" + originalXPos + "," +
                                            originalYPos + ") moved " +
                                            direction + " by " + n + " spaces");
                                }
                            }
                        }
                        break;
                }
            } else {
                System.out.println("Error: no piece at (" +
                        originalXPos + "," + originalYPos + ")");
            }
        } else {
            System.out.println("Error: no piece at (" +
                    originalXPos + "," + originalYPos + ")");
        }

    }

    //Display the game board, showing the name, color and type of each Piece
    //on the game board at its current location
    public void Display() {
        for (int i = 0; i < 64; i++) {
            if (i % 8 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%-12s", boardGame.get(i));
        }
        System.out.println();
    }

}
