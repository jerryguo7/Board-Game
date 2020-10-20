/* A SlowFlexible moves up or down as well as right or left exactly one step per move
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
public class SlowFlexible extends SlowPiece {

    //constructors
    public SlowFlexible (){

    }

    public SlowFlexible(String Name, String Colour, String Speed, Point Position, String direction) {
        super(Name, Colour, Speed, Position, direction);
    }

    //move method that moves the piece up or down as well as right or left by one space.
    //Error message will be displayed if received invalid command
    public boolean move(String direction){
        switch (direction) {
            case "left":
                if ((getPosition().getX() - 1) >= 0 && (getPosition().getX() - 1) < 8) {
                    getPosition().setLocation(getPosition().getX() - 1, getPosition().getY());
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "right":
                if ((getPosition().getX() + 1) >= 0 && (getPosition().getX() + 1) < 8) {
                    getPosition().setLocation(getPosition().getX() + 1, getPosition().getY());
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "up":
                if ((getPosition().getY() - 1) >= 0 && (getPosition().getY() - 1) < 8) {
                    getPosition().setLocation(getPosition().getX(), getPosition().getY() - 1);
                    return true;
                } else {
                    System.out.println("Error: the piece cannot be moved");
                    return false;
                }
            case "down":
                if ((getPosition().getY() + 1) >= 0 && (getPosition().getY() + 1) < 8) {
                    getPosition().setLocation(getPosition().getX(), getPosition().getY() + 1);
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
