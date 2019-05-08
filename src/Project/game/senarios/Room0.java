package Project.game.senarios;

import java.util.Scanner;

public class Room0 implements Base {

      public static boolean first_view = true;

      @Override
      public void printDescription() {
            if (first_view == true) {
                  print("You are in a room that have 2 doors.");
                  print("On the first door written Exit ");
                  print("If you can open this door with Special KEY ,which you can find in other floor, you would win.");
                  print("And if you can't no good end expected you .");
            }
            print_Act();
      }

      @Override
      public void print_Act() {
            print("You are in first room");
            print("Choose a action:");
            System.out.println("1. Go to Exit door ");
            System.out.println("2. Use Elevator");
            System.out.println("__________________________________________");
      }

      public boolean elevator_lock() {
            print("TO open elevator you have to solve this question");
            print("Fill the blank with the appropriate answer");
            print("11*11=4");
            print("22*22=16");
            print("33*33=18");
            print("99*99=...");
            System.out.println("Enter your answer");
            String ans = input.next();
            if (ans.equals("18")) {
                  print("Your answer is correct");
                  print("The elevator's door is opened");
                  print("Now you can use elevator...");
                  return true;
            } else {
                  print("WRONG ANSWER!!!");
                  return false;
            }

      }

      @Override
      public Base interact(int args) {
            if (args == 1) {

                  if (inventory.inv.contains("special key")) {
                        print("Now you have Special KEY :)");
                        print("You used it and Open the Door");
                        return new Win();
                  } else {
                        print("Ooops!!!   the door is Locked!");
                        print("You need special key");
                        print("And you don't have it...");
                        return this;
                  }
            } else if (args == 2) {
                  boolean elevator_lock_isOpen = false;
                  int counter_for_show_hint = 0;
                  while (elevator_lock_isOpen == false) {
                        counter_for_show_hint ++;
                        if (first_view == true) {
                              elevator_lock_isOpen = elevator_lock();
                        } else {
                              break;
                        }
                        if(counter_for_show_hint >= 3){
                              System.out.println("________________________________________");
                              System.out.println("answer is : 18");
                              System.out.println("________________________________________");
                        }
                  }

            } else {
                  System.out.println("INVALID ARGUMENT");
                  return this;
            }
            first_view = false;
            return new Elevator();
      }
}
