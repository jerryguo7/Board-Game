/* The GameDemo class will accept commands from a user to create Pieces
 * and move them on an 8 X 8 game board, and display the game board
 * <Jerry Guo> <2019.09.30>
 */
import java.awt.*;
import java.util.*;
public class GameDemo {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);

        try {
            //Declare and initialize
            StringTokenizer token;
            String name = "-", colour = "", speed = "",
                    speed2 = "", finalSpeed = "", direction = "";
            int xpos = 0,ypos = 0, step = 1;
            Point point = new Point(xpos,ypos);
            Piece piece;
            Board board = new Board(name, colour, finalSpeed, point,direction);
            board.Create(); //Create an empty board

            //Start the game and read the command
            System.out.println("Enter a command (type help for details):");
            String command = scan.next();
            //Loop exits when receive exit command
            while (!command.equals("exit")) {

                try {
                    //help command
                    if (command.equals("help")) {
                        System.out.println("Possible commands are as follows:\n" +
                                "create location [fast][flexible]: Creates a new piece.\n" +
                                "move location direction [spaces]: Moves a piece.\n" +
                                "print: Displays the board.\n" +
                                "help: Displays help.\n" +
                                "exit: Exits the program.");
                    }

                    //print command
                    if (command.equals("print")) {
                        board.Display();
                    }

                    //create command
                    if (command.equals("create")) {
                        //Read the whole command as one single string
                        //then use StringTokenizer to read each input
                        String line = scan.nextLine();
                        token = new StringTokenizer(line, " ");
                        xpos = Integer.parseInt((token.nextToken()));
                        ypos = Integer.parseInt((token.nextToken()));
                        point = new Point(xpos, ypos);

                        //Read if the speed is specified
                        while (token.hasMoreTokens()) {
                            speed = token.nextToken();
                            while (token.hasMoreTokens()) {
                                speed2 = token.nextToken();
                            }
                        }

                        //Translate the speed info
                        if (speed.equals("") && speed2.equals("")) {
                            finalSpeed = "S";
                        } else if (speed.equals("fast") && speed2.equals("")) {
                            finalSpeed = "F";
                        } else if (speed.equals("flexible") && speed2.equals("")) {
                            finalSpeed = "SF";
                        } else if (speed.equals("fast") && speed2.equals("flexible")) {
                            finalSpeed = "FF";
                        }

                        speed = "";
                        speed2 = ""; //Clear the value for the following command

                        //Get the name and the colour
                        System.out.println("Input a name for the new piece:");
                        name = scan.next();
                        System.out.println("Input a colour for the new piece:");
                        colour = scan.next();
                        piece = new Piece(name, colour, finalSpeed, point);
                        board.Add(piece); //Add the piece to the board

                    }

                    //move command
                    if (command.equals("move")) {
                        //Read the whole command as one single string
                        //then use StringTokenizer to read each input
                        String line = scan.nextLine();
                        token = new StringTokenizer(line, " ");
                        xpos = Integer.parseInt((token.nextToken()));
                        ypos = Integer.parseInt((token.nextToken()));
                        point = new Point(xpos, ypos);

                        //Read if the direction and step are specified
                        while (token.hasMoreTokens()) {
                            direction = token.nextToken();
                            while (token.hasMoreTokens()) {
                                step = Integer.parseInt((token.nextToken()));
                            }
                        }

                        board.Move(name, colour, finalSpeed, point, direction, step);

                        direction = "";
                        step = 1; //Clear the value for the following command
                    }
                } catch (Exception e) {
                    System.out.println("Invalid command. Please try again.");
                }

                //Read the new command
                System.out.println("\nEnter a command (type help for details):");
                command = scan.next();
            }
            System.out.println("Done."); //Done for the game
        } catch (Exception e) {
            System.out.println("Invalid input. Please start over.");
        }

    }
}
