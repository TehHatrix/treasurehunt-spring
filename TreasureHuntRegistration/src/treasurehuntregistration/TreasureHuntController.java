package treasurehuntregistration;

public class TreasureHuntController {

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
    public void updateGame(){
        // cari game registered, and update with the number of registered player.
    }


    //TODO: Syera
    public void unRegisterGame(Game game){
        for (Game g : fs.getGameList().values()) {
            if (g.id == game.id) {
                game.currentRegisteredPlayers --;
                fs.updateGame(game);
                System.out.println("Updated current number of players in Game's Database to " + g.currentRegisteredPlayers);
                fs.removePlayer(game.id);
                System.out.println("Removed game ID of " + g.id + " from Player's Database.");
            }   
        } 
        System.out.println();
    }

}
