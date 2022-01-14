package treasurehuntregistration;

import java.io.Serializable;

public class Player implements Serializable {

    public int id;
    public int[] gamesJoined = {};

    public Player(int id) {
        this.id = id;
    }

}
