package treasurehuntregistration;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.plugin2.message.GetAppletMessage;

import java.io.File;
import java.util.HashMap;

public class TreasureHuntController {

    private FileStore fs;
    private GameCart gc;

    public TreasureHuntController() {
    fs = FileStore.getInstance();
    gc = FileStore.gameCart;
    }

    public void initialiseGames(){
        fs.addGame(new Game(fs.generateID("game"), "New Game",5));
        fs.addGame(new Game(fs.generateID("game"), "Treasure Hunt",6));
        fs.addGame(new Game(fs.generateID("game"), "Pirate Game",5));
    }



    //TODO: Wani
    public void listOverviewGames(){
        // Display Game database
        for (Game i : fs.getGameList().values()) {
            System.out.println(i.id+ "\t\t"+ i.name + "\t\t" + i.maxOfPlayers+ "\t\t"+ i.currentRegisteredPlayers);
        }
    }

    //TODO: Wani
    public void listGamesRegistered() {
        // Display player database
        for (Integer i : gc.getGamesJoined().keySet()) {
            for (Game k : fs.getGameList().values()) {
                if(k.id == i){
                    System.out.println(k.id + "\t\t" + k.name+ "\t\t" + gc.getGamesJoined().get(i));
                }
            }
        }

    }

    //TODO: Tom
    public void registerGame(int gameID, int numberofPlayers){
        // Store ke Game Cart
                Game storedGame = fs.getGameList().get(gameID);
                storedGame.currentRegisteredPlayers += numberofPlayers;
                // check kalau current registered player < max player
                if (storedGame.currentRegisteredPlayers <= storedGame.getMaxOfPlayers()){
                    // Add to Game Cart
                    System.out.println(storedGame.getId());
                    System.out.println(storedGame.id);
                    gc.addGame(storedGame, numberofPlayers);
                    //Update the game database with the new registered players
                    fs.updateGame(storedGame);
                }
                else{
                    System.out.println("Number of players exceed Max Players!");
                    return;
                }
    }


    //TODO: Syaqil
    public void updateRegistration(int gameId, int newNumOfPlayer){
        // cari game registered, and update with the number of registered player.
        Game game = fs.getGameList().get(gameId);
        int maxPlayer = game.getMaxOfPlayers();
        if(newNumOfPlayer > maxPlayer) {
            System.out.println("number of player exceeded the maximum number of player allowed");
        } else {
            game.currentRegisteredPlayers = newNumOfPlayer;
            fs.updateGame(game);
            gc.updateGame(game, newNumOfPlayer);
            System.out.println("updated number of registered player to " + game.currentRegisteredPlayers);
        }
    }

    //TODO: Syera
    public void unRegisterGame(int gameID){
        // get current player in game cart and update it in Game db
        int playersToBeRemoved = gc.getGamesJoined().get(gameID);

        Game storedGame = fs.getGameList().get(gameID);
        storedGame.currentRegisteredPlayers -= playersToBeRemoved;
        fs.updateGame(storedGame);

        // remove input game id from Game Cart db
        gc.removeGame(gameID);
        System.out.println("Removed game ID of " + gameID + " from Game Cart");
    }
}

