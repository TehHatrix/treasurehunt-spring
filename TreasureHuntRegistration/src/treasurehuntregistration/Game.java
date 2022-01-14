package treasurehuntregistration;

import java.io.Serializable;

public class Game implements Serializable {
    public String name;
    public int maxOfPlayers;
    public int currentRegisteredPlayers;

    public Game() {

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
