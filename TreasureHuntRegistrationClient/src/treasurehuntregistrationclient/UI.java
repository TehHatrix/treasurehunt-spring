package treasurehuntregistrationclient;

import org.springframework.context.ApplicationContext;

import java.util.Scanner;

//TODO: Wan

public class UI {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UI ui = new UI();

        //Display Main menu & Get User Input
        int userinput = ui.mainMenu();

        while(userinput > 0 && userinput <= 4){
            switch (userinput){
                case 1:

            }

        }
        //
    }

    public int mainMenu(){
        System.out.println("\n-------------------");
        System.out.println(" WELCOME TO Online Treasure Hunt, Player!");
        System.out.println("-------------------\n");

        System.out.println("1. View All Games");
        System.out.println("2. View Registered Games");
        System.out.println("3. Register Games");
        System.out.println("4. Unregister Games");
        System.out.println("5. Update Games");
        System.out.println("6. Exit");

        System.out.println("\nChoose an option:");

        return scanner.nextInt();
    }


    public void displayRegisteredGames() {
        //Get All Registered Games for the player from TreasureHuntController
        //Display Games
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE GAMES");
        System.out.println("--------------------\n");
        System.out
                .println("----------------------------------------------------------------");
        System.out.println("No.\t\tGAMES\t\t\tMAX PLAYERS\t\tNUMBER OF REGISTERED PLAYERS");
        System.out
                .println("----------------------------------------------------------------\n");
    }

    public void displayGames(){
        //Get All Games from TreasureHuntController
        //Display Games
        System.out.println("\n------------------");
        System.out.println(" AVAILABLE GAMES");
        System.out.println("--------------------\n");
        System.out
                .println("----------------------------------------------------------------");
        System.out.println("No.\t\tGAMES\t\t\tMAX PLAYERS\t\tNUMBER OF REGISTERED PLAYERS");
        System.out
                .println("----------------------------------------------------------------\n");

    }

    public void registerGame(){
        //Register Game using TreasureHuntController

    }
    public void unregisterGame(){
        //UnRegister using TreasureHuntController
    }

    public void updateRegisteration(){
        //Update Registration using TreasureHuntController
    }



	
}
