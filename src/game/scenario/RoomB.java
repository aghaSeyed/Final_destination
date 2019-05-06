package game.scenario;
import java.util.ArrayList;

public class RoomB implements Base {

    public void printDescription() {
        print("you are in floor B");
        print("evry where is dark you touch a switch with your hands.");
        print("there is a big amount of Methan gas and you smell it, be careful");
        
        print_Act();
    }


    public void print_Act(){
        print("what do you want to do?(choose number):");
        System.out.println("1. Switch lamps");
        System.out.println("2. Use elevator");
        System.out.println("3. Use invertory");
    }


    public Base interact(int args){
        if (args == 1){
            print("BBooooooooMMMMB");
            System.err.println("The room is exploded...   you died.....");

            System.exit(0);  //for end the program
        }
        else if(args == 2)
            return new Elevator();
        else if (args == 3){
           // Some things needed
        }
return this;
    }

    }















//____________________________________________________________________

    class RoomB_Light implements Base{
        ArrayList<String> tempC = new ArrayList();
        public static boolean descript_flag = true;

        @Override
        public void printDescription(){
            print("There is box in front of you");
            print("You see a big dengrous snake inside of box which protect drugs ");
            print("And you have to gain drugs from this box");
            print_Act();
        }

        @Override
        public void print_Act() {
            print("Choose a action:");
            System.out.println("1. Go back to elevator");
            System.out.println("2. Use invertory");
            System.out.println("________________________________________");
        }


        @Override
        public Base interact(int args) {

            if (args == 1)
                return new Elevator();
            else if (args == 2){
                // sth needed
                  
            }
            return this;
        }
    }
