package game.scenario;

import java.util.ArrayList;
import java.util.Scanner;

class inventory {
    static   Scanner input = new Scanner(System.in);

      static ArrayList<String> inv = new ArrayList<String>();
      public static  void print_inventory(){
            System.out.println(inv);
            System.out.println("Which one ? ");

      }


      public static void inventoryAdd(String args , ArrayList<String> temp){
            if(inv.size()<=4){
                  inv.add(args);
                  if(temp.contains(args))
                        temp.remove(args);
            }
      }




      public static void inventoryRemove(String args , ArrayList<String> temp){
            if(inv.size()<=4){
                  temp.add(args);
                  inv.remove(args);
            }
            
      }
}
