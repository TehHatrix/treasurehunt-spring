package treasurehuntregistration;

public class TreasureHuntController {

    FileStore fs = FileStore.getInstance();

    //TODO: Wani
    public void listOverviewGames(){
        // Display Game database
//        System.out.println("\n------------------");
//        System.out.println(" AVAILABLE GAMES");
//        System.out.println("--------------------\n");
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("No.\t\tGame\t\tMax Player\tCurrent player");
//        System.out.println("----------------------------------------------------------------\n");
        for (Game i : fs.getGameList().values()) {
            System.out.println(i.id+ "\t\t"+ i.name + "\t\t" + i.maxOfPlayers+ "\t\t"+ i.currentRegisteredPlayers);
        }
    }

    //TODO: Wani
    public void listGamesRegistered(){
        // Display player database
//        System.out.println("\n------------------");
//        System.out.println(" AVAILABLE PLAYERS");
//        System.out.println("--------------------\n");
//        System.out.println("----------------------------------------------------------------");
//        System.out.println("Players\t\tGame Joined");
//        System.out.println("----------------------------------------------------------------\n");
        for (Player i : fs.getPlayers().values()) {
            System.out.print(i.id + "\t\t[ ");
            for(int j = 0 ; j < i.gamesJoined.length; j++){
                for (Game k : fs.getGameList().values()) {
                    if(k.id == i.gamesJoined[j]){
                        System.out.print(k.name+ " ");
                    }
                }
            }
            System.out.println("]");
        }
    }

    //TODO: Tom
    public void registerGame(){
        //cari game yang nak register, store to the player database, and update the game database (current registered players)


    }


    //TODO: Syaqil
    public void updateGame(){
        // cari game registered, and update with the number of registered player.
    }


    //TODO: Syera
    public void
    unRegisterGame(Game game){
        // check kalau player tu ada registration with any games tak?
        // Cari Game registered tu, and then tolak with number of registered players and remove list from player database


    }

}
