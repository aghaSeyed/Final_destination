package Project.game.senarios;
import java.util.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public interface Base {
      Scanner input =new Scanner(System.in);
public void printDescription();
public Base interact(int args);
public void print_Act();
default void print(String s) {
      System.out.println(s); 
      try{
      //TimeUnit.SECONDS.sleep(1);
      }
      catch(Exception e){
            
      }
  }    


      default void cls() {
           for (int i = 0; i < 50; i++) {
                  System.out.println(" ");
            }
      }


}


