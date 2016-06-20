import java.util.Scanner;

public class Player{
  
  
  BigTemple[] big_temple = new BigTemple[3];
  SmallTemple[] small_temple = new SmallTemple[3];
  
  
  int money;
  int zen;
  int turn;
  String name;
  
  
  public Player (String name){
    this.name=name;
  }  
  
  
  
  
  public void Story(Player gamer){
    Scanner in = new Scanner(System.in);   
    
    gamer.money = 100;
    gamer.zen = 0;
    gamer.turn = 0;
    
    while(gamer.money>0 && gamer.zen<100){  
      
      System.out.println("You have $"+gamer.money+" and "+gamer.zen+" Zen Points");
      System.out.println("");
      System.out.println("What would you like to do?");
      System.out.println("Meditate 0$ -> Press 1");
      System.out.println("Help Someone -10$ -> Press 2");
      System.out.println("Work at Company +$50, -30$ Zen -> Press 3");
      System.out.println("Purchase Temple -> Press 4");
      
      int act;
      act = in.nextInt();
      
      switch(act){
        case 1:
          Meditate(gamer);
          break;
        case 2:
          HelpSomeone(gamer);
          break;
        case 3:
          WorkAtCompany(gamer);
          break;
        case 4:
          PurchaseTemple(gamer);
          break;
        default:
          System.out.println("You can only choose 1~4");
          break;
      }
      //Choice of your act            
      Collecting(gamer);      
      //Collecing
    }   
    if(gamer.money>0 && gamer.zen>=100){
      System.out.println("congratulation!! you became a master monk in "+gamer.turn+" turns.");
      System.out.println("Your final rank was : Master monk");
    }
    else if(gamer.money<=0 && gamer.zen>=50){
      System.out.println("You ran out of money before becoming a master monk in "+gamer.turn+" turns.");
      System.out.println("Your final rank was : new monk");
    }
    else if(gamer.money<=0 && gamer.zen>=30){
      System.out.println("congratulation!! you became a master monk in "+gamer.turn+" turns.");
      System.out.println("Your final rank was : newcomer");
    }
    //Ending Story
  }
  
  
  
  
  public static void Meditate(Player gamer){
    gamer.zen = gamer.zen + 1;
    gamer.turn = gamer.turn + 1;
  }
  //Act 1 Metitate 
  
  
  
  
  public static void HelpSomeone(Player gamer){
    gamer.zen = gamer.zen+5;
    gamer.money = gamer.money-10;
    gamer.turn = gamer.turn+1;
  }
  //Act 2 Help Someone
  
  
  
  
  public static void WorkAtCompany(Player gamer){
    gamer.zen = gamer.zen-30;
    gamer.money = gamer.money+10;
    gamer.turn = gamer.turn+1;   
  }
  //Act 3 Work at Company
  
  
  
  
  public void PurchaseTemple(Player gamer){
    Scanner in = new Scanner(System.in);
    
    System.out.println("What do you want to call your temple?");
    String temple_name = in.nextLine();
    
    System.out.println("A big temple generates $15 and 5 zen each turn.");
    System.out.println("A small temple generates 3 zen each turn.");
    System.out.println("Do you want a big (-$70, press 1) or small (-$30, press 2) temple");    
    System.out.println("Each Temple can make only 3");
    
    int temple_act;
    temple_act = in.nextInt();    
    switch(temple_act){
      case 1:
        for(int i=0;i<big_temple.length;i++){
        if(big_temple[i]==null){
          big_temple[i]=new BigTemple(temple_name);
          gamer.money = gamer.money-70;
          break;
        }
        else if(big_temple[2] != null){
          System.out.println("You can make only 3 temples");
          break;
        }        
      }
        break;
      case 2:
        for(int i=0;i<small_temple.length;i++){
        if(small_temple[i]==null){
          small_temple[i]=new SmallTemple(temple_name);
          gamer.money = gamer.money-30; 
          break;
        }
        else if(small_temple[2] != null){
          System.out.println("You can make only 3 temples");
          break;
        }
      }        
        break;
      default:
        System.out.println("You can only choose 1~2");
        break; 
    }      
    gamer.turn = gamer.turn+1;       
  }
  //Act 4 Purchase Tmeple
  
  
  
  
  public void Collecting (Player gamer){
    
    System.out.println("");
    System.out.println("Collecting from all temples..");
    
    for(int i=0; i<big_temple.length; i++){
      if(gamer.big_temple[i] == null){
        break;
      }
      System.out.println("Collecting $15 and 5 zen from " + gamer.big_temple[i].name);
      gamer.money = gamer.money+15;
      gamer.zen = gamer.zen+5;
    }
    for(int i =0; i<small_temple.length; i++){
      if(gamer.small_temple[i] == null){
        break;
      }
      System.out.println("Collecting and 3 zen from " + gamer.small_temple[i].name);
      gamer.zen = gamer.zen + 3;
    }
    System.out.println("Done collecting from temples...");   
    System.out.println("");
  }
  //Collecting from Temples
}