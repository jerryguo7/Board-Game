/* A FastPiece moves left or right a specified, arbitrary number of steps per move
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
public class FastPiece extends Piece {
    private String direction;

    //constructors
    public FastPiece (){

    }

    public FastPiece(String Name, String Colour, String Speed, Point Position, String direction) {
        super(Name, Colour, Speed, Position);
        this.direction = direction;
    }

    //getter and setter
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    //move method that moves the piece left or right by a
    //specified number of spaces.
    //Error message will be displayed if received invalid command
    public boolean move(String direction, int n){
        if (direction.equals("left")) {
            if ((getPosition().getX() - n) >= 0 && (getPosition().getX() - n) < 8) {
                getPosition().setLocation(getPosition().getX() - n, getPosition().getY());
                return true;
            } else {
                System.out.println("Error: the piece cannot be moved");
                return false;
            }
        } else if (direction.equals("right")) {
            if ((getPosition().getX() + n) >= 0 && (getPosition().getX() + n) < 8) {
                getPosition().setLocation(getPosition().getX() + n, getPosition().getY());
                return true;
            } else {
                System.out.println("Error: the piece cannot be moved");
                return false;
            }
        } else {
            System.out.println("Error: the piece cannot be moved");
            return false;
        }
    }


}
