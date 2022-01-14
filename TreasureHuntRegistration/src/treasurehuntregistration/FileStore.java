package treasurehuntregistration;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Saves JSON in text file
 * JSON = {
 * Game:[{...games}],
 * }
 */
//TODO: Danish

public class FileStore {

    private static FileStore instance = null;
    // Defaults
    private int gameID = 1;
    private int playerID = 1;
    private String gamesFilename = "games.txt";
    private String playersFilename = "players.txt";
    private String idStore = "id.txt";

    private File gamesFile;
    private File playersFile;

    private Scanner scanner;

    private FileStore() {

        gamesFile = new File(gamesFilename);
        playersFile = new File(playersFilename);

        // initialize counters
        File file = new File(idStore);
        if (!file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                String s = Integer.toString(gameID) + ',' + Integer.toString(playerID);
                writer.write(s);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    // Singleton
    public static FileStore getInstance() {
        if (instance == null) {
            instance = new FileStore();
        }
        return instance;
    }

    /**
     * USE THIS TO GENERATE ID
     * @param type "game|player"
     * @return integer
     */
    public int generateID(String type) {
        // Get all id counters
        File file = new File(idStore);
        String[] idArray = {};
        int id = 0;
        try {
            Scanner idInput = new Scanner(file);
            if (file.exists()) {
                idArray = idInput.nextLine().split(",");
            } else {
                System.out.println("[FileStore.java/generateID] ID File not found");
            }

            switch (type) {
                case "game":
                    id = Integer.parseInt(idArray[0]);
                    idArray[0] = Integer.toString(id + 1);
                    break;
                case "player":
                    id = Integer.parseInt(idArray[1]);
                    idArray[1] = Integer.toString(id + 1);

                    break;
            }

            FileWriter writer = new FileWriter(file);
            writer.write(idArray[0] + ',' + idArray[1]);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Gets the games list
     * @return HashMap<id, Game>
     */
    public HashMap<Integer,Game> getGameList() {
        try {
            if (gamesFile.exists()) {
                FileInputStream fileInput = new FileInputStream(gamesFile);
                ObjectInputStream reader = new ObjectInputStream(fileInput);
                HashMap<Integer,Game> games = (HashMap<Integer, Game>) reader.readObject();
                // Debug logs
//                System.out.println("[FileStore.java/getGameList] Available Games:-");
//                for (int i = 0; i < games.size(); i++){
//                    System.out.println(games.values().toArray()[i]);
//                }
                return games;
            } else {
                System.out.println("[FileStore.java/getGameList] File not found, creating new one");
                gamesFile.createNewFile();
                HashMap<Integer,Game> games = new HashMap<>();
                FileOutputStream fileOutput = new FileOutputStream(gamesFile);
                ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
                writer.writeObject(games);
                writer.close();
//                System.out.println("[FileStore.java/getGameList] File created. Available Games:-");
//                for (Game game : games) {
//                    System.out.println(game.id + " " + game.name);
//                }
                return games;
            }
            // Once done, print output
//            System.out.println("[FileStore.java/getGameList] " + gamesFilename + " : " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds game into store
     * @param game Game Object
     */
    public void addGame(Game game) {
        try {
            // Get the game list ->  array
            HashMap<Integer,Game> storedGames = getGameList();
            FileOutputStream fileOutput = new FileOutputStream(gamesFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            storedGames.put(game.id,game);
            // Write to file
            writer.writeObject(storedGames);
            writer.close();
            System.out.println("[FileStore.java/addGame] Added game (ID:" + game.id + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates game. Just pass the updated game
     * @param game Game Object
     */
    public void updateGame(Game game) {
        try {
            // Get the game list ->  array
            HashMap<Integer,Game> storedGames = getGameList();
            FileOutputStream fileOutput = new FileOutputStream(gamesFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            storedGames.replace(game.id,game);
            // Write to file
            writer.writeObject(storedGames);
            writer.close();
            System.out.println("[FileStore.java/updateGame] Updated game (ID:" + game.id + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes game
     * @param gameID
     */
    public void removeGame(int gameID){
        try {
            // Get the game list ->  array
            HashMap<Integer,Game> storedGames = getGameList();
            FileOutputStream fileOutput = new FileOutputStream(gamesFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            storedGames.remove(gameID);
            // Write to file
            writer.writeObject(storedGames);
            writer.close();
            System.out.println("[FileStore.java/removeGame] Removed game (ID:" + gameID + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the list of all players
     * @return HashMap<id,Player>
     */
    public HashMap<Integer,Player> getPlayers() {
        try {
            if (playersFile.exists()) {
                FileInputStream fileInput = new FileInputStream(playersFile);
                ObjectInputStream reader = new ObjectInputStream(fileInput);
                HashMap<Integer,Player> players = (HashMap<Integer,Player>) reader.readObject();
                // Debug logs
//                System.out.println("[FileStore.java/getPlayers] Players:-");
//                for (int i = 0; i < players.size(); i++){
//                    System.out.println(players.values().toArray()[i]);
//                }
                return players;
            } else {
                System.out.println("[FileStore.java/getPlayers] File not found, creating new one");
                playersFile.createNewFile();
                HashMap<Integer,Player> players = new HashMap<>();
                FileOutputStream fileOutput = new FileOutputStream(playersFile);
                ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
                writer.writeObject(players);
                writer.close();
                return players;
            }
            // Once done, print output
//            System.out.println("[FileStore.java/getGameList] " + gamesFilename + " : " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds player
     * @param player Player Object
     */
    public void addPlayer(Player player) {
        try {
            // Get the game list ->  array
            HashMap<Integer,Player> playersList = getPlayers();
            FileOutputStream fileOutput = new FileOutputStream(playersFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            playersList.put(player.id, player);
            // Write to file
            writer.writeObject(playersList);
            writer.close();
            System.out.println("[FileStore.java/addPlayer] Added player (ID:" + player.id + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates player
     * @param player Player Object
     */
    public void updatePlayer(Player player) {
        try {
            // Get the game list ->  array
            HashMap<Integer,Player> playersList = getPlayers();
            FileOutputStream fileOutput = new FileOutputStream(playersFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            playersList.replace(player.id, player);
            // Write to file
            writer.writeObject(playersList);
            writer.close();
            System.out.println("[FileStore.java/updatePlayer] Updated player (ID:" + player.id + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes player
     * @param id
     */
    public void removePlayer(int id) {
        try {
            // Get the game list ->  array
            HashMap<Integer,Player> playersList = getPlayers();
            FileOutputStream fileOutput = new FileOutputStream(playersFile);
            ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
            // Add gameObject at the end
            playersList.remove(id);
            // Write to file
            writer.writeObject(playersList);
            writer.close();
            System.out.println("[FileStore.java/removePlayer] Removed player (ID:" + id + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


