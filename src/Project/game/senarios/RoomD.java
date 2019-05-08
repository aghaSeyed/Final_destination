package Project.game.senarios;

import java.util.ArrayList;

public class RoomD implements Base {

      public static boolean first_view = true;
            public static boolean hack_done = false;

      static ArrayList<String> tempD = new ArrayList();

      RoomD() {
            tempD.add("key");
      }

      @Override
      public void printDescription() {
            if (hack_done == false) {
                  print("You are in floor D");
                  print("There is a computer , you look on the screen :");
                  print("If you can answer this question you would earn KEY");
                  print_Act();
            }
      }

      public boolean Box_Lock() {
            print("whats the output of this code");
            System.out.println("System.out.print(\"4\"+\"8\"+'h'+'8');");
            System.out.println("System.out.print('a'+ 1);");
            print("");
            System.out.print("Enter your answer: ");
            String ans = input.next();
            if ("48h898".equals(ans)) {
                  return true;
            } else {
                  print("Your answer is incorrect try again!");
                  return false;
            }

      }

      @Override
      public void print_Act() {
            print("Choose a action:");
            System.out.println("1. Go to elevator");
            System.out.println("2. Hack the system");
            System.out.println("__________________________________________");
      }

      @Override
      public Base interact(int args) {
            int counter_for_show_hint =0;
            if (args == 1) {
                  return new Elevator();
            } else if (args == 2) {
                  while (hack_done == false) {
                        counter_for_show_hint ++;
                        hack_done = Box_Lock();
                        if(counter_for_show_hint == 2){
                              System.out.println("________________________________________");
                              System.out.println("hint: \"System.out.print(\\\"4\\\"+\\\"8\\\"+'h'+'8');\" means connect the character.");
                              System.out.println("and \"System.out.print('a'+ 1);\" means sum of ASCCI code.");
                              System.out.println("________________________________________");
                        }
                        if(counter_for_show_hint >= 3){
                              System.out.println("________________________________________");
                              System.out.println("answer is : 48h898");
                              System.out.println("________________________________________");
                        }
                  }
                  print("YES, the computer lock is now opened");
                  print("You got key ...");
                  inventory.inventoryAdd("key", tempD);
                  System.out.println("Your inventory :" + inventory.inv);
                  print("You came back to elevator....");
                  print("...........");
                  return new Elevator();
            } else {
                  System.out.println("INVALID ARGUMENT!");
                  return this;
            }
      }
}
