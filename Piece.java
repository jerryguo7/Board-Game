/* Piece class that defines a Piece object with Name, Colour, Speed and Position
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
public class Piece {
    private String Name, Colour, Speed;
    private Point Position;

    //constructors
    public Piece(){

    }

    public Piece(String name, String colour, String speed, Point position) {
        this.Name = name;
        this.Colour = colour;
        this.Speed = speed;
        this.Position = position;
    }

    //getters and setters
    public String getName() {
        return this.Name;
    }

    public String getColour() {
        return this.Colour;
    }

    public String getSpeed() {
        return this.Speed;
    }

    public Point getPosition() {
        return this.Position;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setColour(String colour) {
        this.Colour = colour;
    }

    public void setSpeed(String speed) {
        this.Speed = speed;
    }

    public void setPosition(Point position) {
        this.Position = position;
    }

    //toString method
    public String toString() {
        return "Piece{" +
                "Name='" + this.Name + '\'' +
                ", Colour='" + this.Colour + '\'' +
                ", Speed='" + this.Speed + '\'' +
                ", Position=" + this.Position +
                '}';
    }
}
