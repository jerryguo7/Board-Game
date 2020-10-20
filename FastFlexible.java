/* A FastPiece moves up or down as well as right or left a specified, arbitrary number of steps per move
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
public class FastFlexible extends FastPiece {

    //constructors
    public FastFlexible(){

    }

    public FastFlexible(String Name, String Colour, String Speed, Point Position, String direction) {
        super(Name, Colour, Speed, Position, direction);
    }

    //move method that moves the piece up or down
    //as well as right or left by a specified number of spaces.
    //Error message will be displayed if received invalid command
    public boolean move(String direction, int n){
        switch (direction) {
            case "left":
                if ((getPosition().getX() - n) >= 0 && (getPosition().getX() - n) < 8) {
                    getPosition().setLocation(getPosition().getX() - n, getPosition().getY());
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "right":
                if ((getPosition().getX() + n) >= 0 && (getPosition().getX() + n) < 8) {
                    getPosition().setLocation(getPosition().getX() + n, getPosition().getY());
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "up":
                if ((getPosition().getY() - n) >= 0 && (getPosition().getY() - n) < 8) {
                    getPosition().setLocation(getPosition().getX(), getPosition().getY() - n);
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "down":
                if ((getPosition().getY() + n) >= 0 && (getPosition().getY() + n) < 8) {
                    getPosition().setLocation(getPosition().getX(), getPosition().getY() + n);
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            default:
                System.out.println("Error: the piece cannot be moved");
                return false;
        }
    }

}
