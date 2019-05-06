package game.scenario;
import java.util.ArrayList;

class RoomC implements Base {

    ArrayList<String> tempC = new ArrayList();
    @Override
    public void printDescription() {
        print("You arrive to Room C .");
        print("Unfortunately door is locked maybe you can find key in other floor.");
        print_Act();
    }

    @Override
    public void print_Act() {
        print("Choose a action:");
        System.out.println("1. Use inventory:");
        System.out.println("2. Use elevator");
        System.out.println("__________________________________________");
    }

    @Override
    public Base interact(int args){

        if (args == 1) {
            inventory.print_inventory();
            String equip = input.nextLine();
                if (inventory.inv.contains(equip) && equip == "key") {
                    inventory.inventoryRemove("key", tempC);
                    return new RoomC_open();
                }
                else if (inventory.inv.contains(equip) && equip != "key"){
                    System.out.println("It doesn't work HERE!!!!");
                    return this;
                }
                else if (inventory.inv.contains(equip) == false){
                    System.out.println("Not Found");
                    return this;
                }

            }


        else if (args == 2){
            return new Elevator();
        }

        else {
            System.err.println("INVALID ARGUMENT!");
            return this;
        }
        return this;
}


    }











//______________________________________________


class RoomC_open implements Base{
    ArrayList<String> tempC_open = new ArrayList();
    public static boolean descript_flag = true;
    @Override
    public void printDescription() {
        if (descript_flag == true) {
            print("Door is open");
            print("You see that man's coffin and his pocket included:");
            print("A bill");
            print_Act();
        }
        else {
            print("The man are still angry......");
            print_Act_2();
        }
    }

    @Override
    public void print_Act(){
        print("Choose a action:");
        System.out.println("1. Use elevator");
        System.out.println("2. Talk to Man");
        System.out.println("3. Use invertory");
        System.out.println("__________________________________________");
    }
    private void print_Act_2(){
        print("The man are attacking you.....");
        print("Choose a Action:");
        System.out.println("1. Run to elevator");
        System.out.println("2. Use invertory");
        System.out.println("__________________________________________");
    }

    @Override
    public Base interact(int args) {
        if(args == 1)
            return new Elevator();
        else if (args == 2){
            man_dialog();
            descript_flag = false;
            print_Act_2();
            //STH need
        }
        else if (args == 3){
            return this;
        }
        else {
            System.err.println("INVALID ARGUMENT!");
            return this;
        }
        return this;
    }


    void man_dialog(){
        print("YOU: Hi man ,Good day,I have a problem");
        print("     In the downstairs there is a box ");
        print("     And a snake in it,");
        print("     I want to pick up drugs that are under snake");
        print("     may I borrow your shovel to kill the snake?");

        print("MAN:You do not have the right to kill my snake.");
        print("    You have to be killed instead of the snake");
        print("[Man attacks you...]");
    }
}