package Project.game.senarios;

import java.util.ArrayList;

public class RoomA implements Base {

      public static boolean first_view = true;
      static ArrayList<String> tempA = new ArrayList();

      RoomA() {
            tempA.add("gun");
            tempA.add("torch");
      }

      @Override
      public void printDescription() {
            //need to rapair
            print("You are in floor A");
            print("You look around and see a body in front of you and a injured man in corner of room.");
            print_Act();
      }

      @Override
      public void print_Act() {
            print("what do you want to do?");
            System.out.println("1. Use elevator");
            System.out.println("2. check the body for gaining some goods");
            if (inventory.inv.contains("drugs") == false) {
                  System.out.println("3. Talk to injured man");
            } else if (inventory.inv.contains("drugs") == true) {
                  System.out.println("3. Give drugs to injured man");
            }

            System.out.print("choose number: ");
      }

      @Override
      public Base interact(int args) {
            if (args == 1) {
                  return new Elevator();
            } else if (args == 2) {
                  System.out.println("Inventory add :" + tempA);
                  inventory.inventoryAdd("gun", tempA);
                  inventory.inventoryAdd("torch", tempA);
                  return this;
            } else if (args == 3) {
                  if (inventory.inv.contains("drugs") == false) {
                        injuredMan_dialog();
                  } else {
                        injuredMan_dialog();
                        inventory.inventoryRemove("drugs", tempA);
                        inventory.inventoryAdd("special key", tempA);
                  }
                  return this;
            }
            return this;
      }

      protected void injuredMan_dialog() {
            if (!inventory.inv.contains("drugs") && !tempA.contains("drugs")) {
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
            if (inventory.inv.contains("drugs")) {
                  print("MAN: Thank you...");
                  print("Take this Special key");
                  print("open the back door and go far away...");
                  System.out.println("Inventory add: [special key]");
            } else if (tempA.contains("drugs")) {
                  print("Why you still here,hurry up man ");
                  print("Dont't worry about me.");
            }
      }

}
