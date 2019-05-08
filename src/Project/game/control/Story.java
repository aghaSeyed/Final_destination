package Project.game.control;
import Project.game.senarios.*;
import java.util.Scanner;

public class Story {

    private Base current;

    public Story(){
        current = new Room0();
    }

    public void play(){
        Scanner input = new Scanner(System.in);

        while (!(current instanceof Win)){
            current.printDescription();
            int cmd = input.nextInt();
            current = current.interact(cmd);


            if (current instanceof Room0)
            Room0.first_view = false;
            else if (current instanceof RoomA)
            RoomA.first_view = false;
            else if (current instanceof RoomD)
                RoomD.first_view = false;


        }

        System.err.println("CONGRATULATIONS");
        System.err.println("YOU FINISH THE GAME....");
        //Play a music if it is possible
    }

}
