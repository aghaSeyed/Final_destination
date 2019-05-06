package game.scenario;

import java.util.Scanner;

public class Room0 implements Base {

      public static boolean descript_flag = true;
      @Override
      public void printDescription() {
            if (descript_flag == true) {
                  print("You are in room that have 2 doors.");
                  print("On the first door written Exit ,You check the door and find out it is locked.");
                  print("If you can open this door with special key ,which you can find in other floor, you would win.");
                  print("And if you can't no good end expected you .");
                  descript_flag = false;
            }
            print_Act();
      }
      @Override
      public void print_Act(){
            print("Choose a action:");
            System.out.println("1. Go to backdoor ");
            System.out.println("2. Take Elevator");
            System.out.println("__________________________________________");
      }




      public boolean elevator_lock(){
            print("Fill the blank with the appropriate answer");

            print("11*11=4");
            print("22*22=16");
            print("33*33=18");
            print("99*99=...");

            int ans=input.nextInt();

            if(ans==18){
                  print("Your answer is correct");
                  print("The elevator door is opened");
                  print("Now you can use elevator...");
                  return true;
            }
            else{
                  print("WRONG ANSWER!!!");
                  return false;
            }


      }



      @Override
      public Base interact(int args) {
            if (args == 1) {
                  System.out.println("Ooops!!!   the door is Locked!");
                  print_Act();
                  return this;
            } else if (args == 2) {
                  boolean elevator_lock_open = false;
                  while (elevator_lock_open == false)
                        elevator_lock_open = elevator_lock();

                  return new Elevator();
            } else {
                  System.err.println("INVALID ARGUMENT");
                  return this;
            }
      }
}
