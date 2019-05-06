package game.scenario;

public class Elevator implements Base {
    @Override
    public void printDescription() {
        print("Now you are in elevator");
        print ("We have five floor.");
        print ("choose one of them to elevator take you there");
        print_Act();
    }

    @Override
    public void print_Act() {
        print("Use a floor:");
        System.out.println("0. 0(first room)");
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. D");
    }

    @Override
    public Base interact(int args) {
        if (args == 0)
            return new Room0();
        else if(args == 1)
            return new RoomA();
        else if (args == 2)
            return new RoomB();
        else if (args == 3)
            return new RoomC();
        else if (args == 4)
            return new RoomD();
        else{
            System.err.println("INVALID ARGUMENT!");
            return this;
        }
    }
}
