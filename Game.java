import java.util.Scanner;

public class Game{
  public static void main(String[] args){  
    Scanner in = new Scanner(System.in);
    
    System.out.println("What is your name?");
    String user = in.nextLine();
    //set a player name
    
    Player gamer = new Player (user);
    //Player      
    
    System.out.println("Boss : "+user+" you were a good worker, I am sad you are leaving the company. Good luck on becoming a monk.");
    System.out.println("");
    //Game's intro    
    
    gamer.Story(gamer);
    //Game Stroy
  }
}