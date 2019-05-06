package game.control;
import game.scenario.*;

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
            Room0.descript_flag = false;
            else if (current instanceof RoomA)
            RoomA.descript_flag = false;
            else if (current instanceof RoomD)
                RoomD.descript_flag = false;


        }

        System.err.println("CONGRATULATIONS");
        System.err.println("YOU FINISH THE GAME....");
        //Play a music if it is possible
    }

}
