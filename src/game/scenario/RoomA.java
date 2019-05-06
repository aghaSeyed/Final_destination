package game.scenario;
import java.util.ArrayList;

public class RoomA implements Base {

    ArrayList<String> tempA = new ArrayList();
    public static boolean descript_flag = true;
    @Override
    public void printDescription() {
        print("You arrive in floor A");
        print("You look around and see a body in front of you and a injured man in corner of room.");

        print_Act();
    }

    @Override
    public void print_Act(){
        print("what do you want to do?(choose number)");
        System.out.println("1. Use elevator");
        System.out.println("2. check the body for gaining some goods");
        System.out.println("3. Talk to injured man");
     }

    @Override
     public Base interact (int args){
        if (args == 1)
            return new Elevator();
        else if (args == 2){
            // view equipment of corps and add them to invertory
        }
        else if (args == 3){
            sick_dialog();
            return this;
        }
return this;
     }


     protected void sick_dialog(){
        print("___________________________________");
        print("ME: come on man!   whats up here?? ");
        print("    I recover my senses in this home. I want exit from this home...");
        print("    What happened to you");
         print("");
        print("MAN: If you want to exit from this house you must help me");
        print("     I'm going to give you a KEY to exit from this building if you would help me");
        print("ME: come on....");
        print("    how can I help you");
         print("");
        print("MAN: Go to floor B");
        print("There is a Box there");
        print("My drugs is in it");
        print("Bring them to me....");
        print("___________________________________");
     }

}


