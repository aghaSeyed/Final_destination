package Project.game.senarios;

import Project.game.*;

public class Elevator implements Base {

      @Override
      public void printDescription() {
            System.out.println("__________________________________________");
            print("Now you are in elevator");
            print_Act();
      }

      @Override
      public void print_Act() {
            print("Choose a floor:");
            System.out.println("0. 0(first room)");
            System.out.println("1. A");
            System.out.println("2. B");
            System.out.println("3. C");
            System.out.println("4. D");
            System.out.print("Input number: ");
      }

      @Override
      public Base interact(int args) {
            if (args == 0) {
                  return new Room0();
            } else if (args == 1) {
                  return new RoomA();
            } else if (args == 2) {
                  return new RoomB();
            } else if (args == 3) {
                  if (RoomC_open.man_isDead == true) {
                        RoomC_open rco = new RoomC_open();
                        rco.printDescription();
                        return this;
                  } else if (RoomC_open.first_view == false) {
                        return new RoomC_open();
                  } else {
                        return new RoomC();
                  }
            } else if (args == 4) {
                  if (RoomD.hack_done == false) {
                        return new RoomD();
                  } else {
                        print("You Hacked the computer");
                        print("and you picked up the key");
                        print("There is nothing to do Here");
                        print("Come back to elevator");
                        System.out.println("_________________________");
                        return this;
                  }
            } else {
                  System.out.println("INVALID ARGUMENT!");
                  return this;
            }
      }
}
