package Project.game.senarios;

import java.util.ArrayList;
import java.util.Scanner;

class inventory {

      static Scanner input = new Scanner(System.in);

      static ArrayList<String> inv = new ArrayList<String>();

      public static void print_inventory() {
            System.out.println(inv);
            System.out.print("Which one ?(type the name): ");

      }

      public static void inventoryAdd(String args, ArrayList<String> temp) {
            if (inv.size() <= 4 && inventory.inv.contains(args) == false) {
                  inv.add(args);
                  if (temp.contains(args)) {
                        temp.remove(args);
                  }
            }
      }

      public static void inventoryRemove(String args, ArrayList<String> temp) {
            if (inv.size() <= 4) {
                  temp.add(args);
                  inv.remove(args);
            }

      }
}
