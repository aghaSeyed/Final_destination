package game.scenario;

public class RoomD implements Base {
    public static boolean descript_flag = true;
    @Override
    public void printDescription() {

        print("You are in floor D");
        print("There is a computer , you look on the screen :");
        print("If you can answer this question you would earn special key");
        print_Act();
    }



    public boolean Box_Lock(){
        print("whats thw output of this code");
        System.out.println("System.out.print(\"4\"+\"8\"+'h'+'8');");
        System.out.println("System.out.print('a'+ 1);");

        if(input.next()=="48h898")
            return true;
        else{
            print("Your answer is incorrect try again!" );
            return false;}

    }

    @Override
    public void print_Act() {
        print("Choose a action:");
        System.out.println("1. Go to elevator");
        System.out.println("2. Hack the system");
        System.out.println("__________________________________________");
    }

    private static boolean hack_done = false;
    @Override
    public Base interact(int args) {
        if (args == 1)
            return new Elevator();
        else if (args == 2){
            while (hack_done == false)
                hack_done = Box_Lock();
            print("YES, the computer lock is now opened");
            print("Come on and get this key...");
            //ADD key to inventory
        }

        else
        {
            System.err.println("INVALID ARGUMENT!");
            return this;
        }
        return this;
    }
}
