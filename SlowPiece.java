/* A SlowPiece moves left or right exactly one step per move
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
public class SlowPiece extends Piece {
    private String direction;

    //constructors
    public SlowPiece(){

    }

    public SlowPiece(String Name, String Colour, String Speed, Point Position, String direction) {
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

    //move method that moves the piece left or right by one space.
    //Error message will be displayed if received invalid command
    public boolean move(String direction){
        if (direction.equals("left")) {
            if ((getPosition().getX() - 1) >= 0 && (getPosition().getX() - 1) < 8) {
                getPosition().setLocation(getPosition().getX() - 1, getPosition().getY());
                return true;
            } else {
                System.out.println("Error: the piece cannot be moved");
                return false;
            }
        } else if (direction.equals("right")) {
            if ((getPosition().getX() + 1) >= 0 && (getPosition().getX() + 1) < 8) {
                getPosition().setLocation(getPosition().getX() + 1, getPosition().getY());
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
