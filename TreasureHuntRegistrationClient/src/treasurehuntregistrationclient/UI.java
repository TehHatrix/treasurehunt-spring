package treasurehuntregistrationclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import treasurehuntregistration.TreasureHuntController;

import java.util.Scanner;

//TODO: Wan

public class UI {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    TreasureHuntController treasureHuntController = (TreasureHuntController) context.getBean("treasureHuntController");
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UI ui = new UI();
        //Display Main menu & Get User Input
        int userinput = ui.mainMenu();
        while(userinput > 0 && userinput <= 6){
            switch (userinput){
                case 1:
                    ui.displayOverviewGames();
                    break;
                case 2:
                    ui.displayRegisteredGames();
                    break;
                case 3:
                    ui.registerGame();
                    break;
                case 4:
                    ui.unregisterGame();
                    break;
                case 5:
                    ui.updateRegisteration();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
            userinput = ui.mainMenu();
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
        System.out.println("5. Update Registration Games");
        System.out.println("6. Exit");

        System.out.println("\nChoose an option:");

        return scanner.nextInt();
    }

    public void displayOverviewGames(){
        System.out.println(" AVAILABLE GAMES");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("ID.\t\tGame\t\tMax Player\tRegistered Players");
        System.out.println("----------------------------------------------------------------\n");
        treasureHuntController.listOverviewGames();
    }


    public void displayRegisteredGames() {
        System.out.println(" REGISTERED GAMES");
        System.out.println("--------------------\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Game ID\t\tGame Name\t\tNumber Of Players");
        System.out.println("----------------------------------------------------------------\n");
        //Get All Registered Games for the player from TreasureHuntController
        treasureHuntController.listGamesRegistered();
    }
    public void registerGame(){
        //Display Games in database
        displayOverviewGames();

        //Register Game using TreasureHuntController
        System.out.println("Please enter the game ID that you want to register.");
        int gameID = scanner.nextInt();
        System.out.println("Please enter the number of players that you want to register. ");
        int numberofplayers = scanner.nextInt();
        treasureHuntController.registerGame(gameID,numberofplayers);
    }


    public void unregisterGame(){
        displayRegisteredGames();
        //UnRegister using TreasureHuntController
        System.out.println("Please enter the game ID that you want to un-register.");
        int gameID = scanner.nextInt();
        treasureHuntController.unRegisterGame(gameID);
    }

    public void updateRegisteration(){
        displayRegisteredGames();
        //Update Registration using TreasureHuntController
        System.out.println("Please enter the game ID that you want to update.");
        int gameID = scanner.nextInt();
        System.out.println("Please enter the number of players that you want to update.");
        int numberofplayers = scanner.nextInt();
        treasureHuntController.updateRegistration(gameID,numberofplayers);
    }



	
}
