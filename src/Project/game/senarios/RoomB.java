package Project.game.senarios;

import java.util.ArrayList;

public class RoomB implements Base {
    @Override
    public void printDescription() {
        print("you are in floor B");
        print("every where is dark ----");
        print("there is a big amount of Methan gas and you smell it.");
        print("_______________________ BE CAREFUL __________________________");
        
        print_Act();
    }

    @Override
    public void print_Act(){
        print("what do you want to do?(choose number):");
        System.out.println("1. Switch lamps");
        System.out.println("2. Use elevator");
        System.out.println("3. Use invertory");
    }

    @Override
    public Base interact(int args){
        if (args == 1){
            print("BBooooooooMMMMB");
            System.out.println("The room was exploded...   you died.....");

            System.exit(0);  //for end the program
        }
        else if(args == 2)
            return new Elevator();
        else if (args == 3){
            inventory.print_inventory();
            String thing = input.next();
            if ("torch".equals(thing) && inventory.inv.contains(thing))
                return new RoomB_Light();
            else if (inventory.inv.contains(thing))
            {
                System.out.println("It dosen't work Here !!!");
                return this;
            }
            else{
                System.out.println("INVALID ARGUMENT!");
                return this;
            }
        }
        return this;
    }

    }
    class RoomB_Light implements Base{
        static ArrayList<String> tempB = new ArrayList();

        RoomB_Light(){
            tempB.add("drugs");
        }
        @Override
        public void printDescription(){
            print("There is box in front of you");
            print("You see a big dangerous snake inside of box which protect drugs ");
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
                inventory.print_inventory();
                String thing = input.next();
                if (inventory.inv.contains(thing) && "flute".equals(thing))
                {
                    print("You hypnotized snake...");
                    print("Caught the drugs... ");
                    System.out.println("Inventory add:" + tempB);
                    inventory.inventoryAdd("drugs",tempB);
                }
                else if (inventory.inv.contains(thing) && "gun".equals(thing)){
                    print("BBooooooooMMMMB");
                    print("The room fulled by Methan and by using gun you make a spark ..");
                    System.out.println("The room was exploded ,you died ...GAME OVER");
                    System.exit(0);
                }
                else if (inventory.inv.contains(thing)){
                    System.out.println("It Dosen't work Here !!");
                    return this;
                }
                else{
                    System.out.println("INVALID ARGUMENT!");
                    return this;
                }
            }
            return this;
        }
    }
