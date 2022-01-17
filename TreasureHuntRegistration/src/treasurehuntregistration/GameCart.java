package treasurehuntregistration;
import java.io.Serializable;
import java.util.HashMap;

public class GameCart implements Serializable {

//    public int id;
    //    public int[] gamesJoined = {};

    // int1 : gameID, int2 : players registered by this exact user
    public HashMap<Integer, Integer> gamesJoined;

    public GameCart() {
        gamesJoined =  new HashMap<>();
    }

    public HashMap<Integer, Integer> getGamesJoined() {
        return gamesJoined;
    }

    public void setGamesJoined(HashMap<Integer, Integer> gamesJoined) {
        this.gamesJoined = gamesJoined;
    }

    public void addGame(Game game, int players){
        this.gamesJoined.put(game.id,players);
    }

    public void updateGame(Game game, int players){
        // Check if game exist in joined game
        int id = game.id;
        if(gamesJoined.containsKey(id)){
            // Update the cart
            gamesJoined.replace(id, players);
        } else {
            // If not exist, just add a new one.
            addGame(game, players);
        }
    }

    public boolean removeGame(int id){
        // Check if id exists
        if(gamesJoined.containsKey(id)){
            gamesJoined.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
