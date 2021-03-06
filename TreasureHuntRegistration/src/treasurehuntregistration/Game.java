package treasurehuntregistration;

import java.io.Serializable;

public class Game implements Serializable {
    public int id;
    public String name;
    //Added Max of players
    public int maxOfPlayers;
    public int currentRegisteredPlayers;

    public Game(int id,String name, int maxOfPlayers) {
        this.id = id;
        this.name = name;
        this.maxOfPlayers = maxOfPlayers;
        this.currentRegisteredPlayers = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentRegisteredPlayers() {
        return currentRegisteredPlayers;
    }

    public void setCurrentRegisteredPlayers(int currentRegisteredPlayers) {
        this.currentRegisteredPlayers = currentRegisteredPlayers;
    }

    public int getMaxOfPlayers() {
        return maxOfPlayers;
    }

    public void setMaxOfPlayers(int maxOfPlayers) {
        this.maxOfPlayers = maxOfPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
