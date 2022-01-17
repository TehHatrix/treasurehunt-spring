package treasurehuntregistration;


public class TreasureHuntController {

    FileStore fs = FileStore.getInstance();

    //TODO: Wani
    public void listOverviewGames(){
        // Display Game database
    }

    //TODO: Wani
    public void listGamesRegistered(){
        // Display player database

    }

    //TODO: Tom
    public void registerGame(){
        //cari game yang nak register, store to the player database, and update the game database (current registered players)


    }


    //TODO: Syaqil
    public void updateGame(Game game, int newNumOfPlayer){
        // cari game registered, and update with the number of registered player.
        for(Game g: fs.getGameList().values()) {
            if(g.id == game.id) {
                int maxPlayer = g.getMaxOfPlayers();
                if(newNumOfPlayer > maxPlayer) {
                    System.out.println("number of player exceeded the maximum number of player allowed");
                    break;
                } else {
                    game.currentRegisteredPlayers = newNumOfPlayer;
                    fs.updateGame(game);
                    System.out.println("updated number of registered player to : " + g.currentRegisteredPlayers);
                    break;
                }
            }
        }
    }


    //TODO: Syera
    public void
    unRegisterGame(Game game){
        // check kalau player tu ada registration with any games tak?
        // Cari Game registered tu, and then tolak with number of registered players and remove list from player database


    }

}
