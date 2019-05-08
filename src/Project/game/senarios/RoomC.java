package Project.game.senarios;

import java.util.ArrayList;

class RoomC implements Base {

      static ArrayList<String> tempC = new ArrayList();

      @Override
      public void printDescription() {
            print("You arrive to Room C .");
            print("Unfortunately door is locked maybe you can find key in other floor.");
            print_Act();
      }

      @Override
      public void print_Act() {
            print("Choose a action:");
            System.out.println("1. Use inventory:");
            System.out.println("2. Use elevator");
            System.out.println("__________________________________________");
      }

      @Override
      public Base interact(int args) {

            if (args == 1) {
                  inventory.print_inventory();
                  String equip = input.next();
                  if (inventory.inv.contains(equip) && "key".equals(equip)) {
                        inventory.inventoryRemove("key", tempC);
                        return new RoomC_open();
                  } else if (inventory.inv.contains(equip)) {
                        System.out.println("It doesn't work HERE!!!!");
                        return this;
                  } else if (inventory.inv.contains(equip) == false) {
                        System.out.println("Not Found");
                        return this;
                  }

            } else if (args == 2) {
                  return new Elevator();
            } else {
                  System.out.println("INVALID ARGUMENT!");
                  return this;
            }
            return this;
      }

}

class RoomC_open implements Base {

      static ArrayList<String> tempC_open = new ArrayList();

      RoomC_open() {
            tempC_open.add("flute");
      }

      public static boolean first_view = true;
      public static boolean man_isDead = false;
      public static boolean man_isAngry = false;

      @Override
      public void printDescription() {
            if (first_view == true && man_isDead == false) {
                  print("Door is open");
                  print("You see a man who has:");
                  print("A flute");
                  // first_view = false;
                  print_Act();
            } else {
                  if (man_isAngry == true && man_isDead == false) {
                        print("Man gets angry......");
                        print_Act();
                  } else if (man_isDead == true) {
                        print("You are in C Room");
                        print("the door is open");
                        print("and you killed man");
                        print("There is nothing here to do it...");
                        print("1. Come back to elevator");
                  }
            }
      }

      @Override
      public void print_Act() {
            if (man_isAngry == false && man_isDead == false) {
                  print("Choose a action:");
                  System.out.println("1. Use elevator");
                  System.out.println("2. Talk to Man");
                  System.out.println("3. Use invertory");
                  System.out.println("__________________________________________");
            } else {
                  print("The man is going to attack you.....");
                  print("Choose a Action:");
                  System.out.println("1. Run to elevator");
                  System.out.println("2. Use invertory");
                  System.out.println("__________________________________________");
            }
      }

      @Override
      public Base interact(int args) {
            if (args == 1) {
                  return new Elevator();
            } else if (args == 2) {
                  if (man_isDead == true) {
                        System.out.println("INVALID ARGUMENT!");
                        return this;
                  } else {
                        if (first_view == true) {
                              man_dialog();
                              first_view = false;
                              man_isAngry = true;
                              return this;
                        } else if (first_view == false) {
                              inventory.print_inventory();
                              String thing = input.next();
                              if (inventory.inv.contains(thing) && "gun".equals(thing)) {
                                    inventory.inventoryRemove("gun", tempC_open);
                                    man_isDead = true;
                                    man_dialog();
                                    System.out.println("Inventory add :" + tempC_open);
                                    inventory.inventoryAdd("flute", tempC_open);
                              } else if (inventory.inv.contains(thing)) {
                                    System.out.println("It Dosent't work here!!!!");
                                    return this;
                              } else {
                                    System.out.println("INVALID ARGUMENT!");
                                    return this;
                              }
                        }
                  }
            } else if (args == 3) {
                  if (man_isDead == true) {
                        System.out.println("INVALID ARGUMENT!");
                        return this;
                  }
                  else{
                  if (first_view == true) {
                        inventory.print_inventory();
                        String thing = input.next();
                        if (inventory.inv.contains(thing) && "gun".equals(thing)) {
                              man_isDead = true;
                              man_dialog();
                              inventory.inventoryAdd("flute", tempC_open);
                              return this;
                        } else if (inventory.inv.contains(thing)) {
                              System.out.println("It Dosent't work here!!!!");
                              return this;
                        } else {
                              System.out.println("INVALID ARGUMENT!");
                              return this;
                        }
                  } else if (first_view == false) {
                        System.out.println("INVALID ARGUMENT!");
                        return this;
                  }
            }
            }else {
                  System.out.println("INVALID ARGUMENT!");
                  return this;
            }
            return this;
      }

      private void man_dialog() {
            if (man_isDead == false) {
                  print("YOU: Hi man ,Good day,I have a problem");
                  print("     In the downstairs there is a box ");
                  print("     And a snake in it,");
                  print("     I want to pick up drugs that are under snake");
                  print("     may I borrow your flute to hypnotism the snake?");
                  print("MAN: Sorry dude , I wish I could but I dont want :).");
                  print("    get out of this room");
            } else {
                  print("You killed the man ...");
                  print("Now you picked up the flute");
            }
      }
}
