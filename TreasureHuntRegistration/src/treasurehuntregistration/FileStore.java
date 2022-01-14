package treasurehuntregistration;

import org.json.JSONObject;

import java.io.*;
import java.util.Scanner;

/**
 * Saves JSON in text file
 * JSON = {
 *   Game:[{...games}],
 * }
 */
//TODO: Danish

public class FileStore {

    private static FileStore instance = null;
    private String gamesFilename ="games.txt";
    private String playersFilename = "players.txt";

    private Scanner scanner;

    private FileStore() {

    }

    // Singleton
    public static FileStore getInstance(){
        if(instance == null){
            instance = new FileStore();
        }
        return instance;
    }

    public void test() {
//        try {
//            String s = "";
//            File file = new File(filename);
//            if(file.exists()){
//
//
//            } else {
//                System.out.println("File not found, creating new one");
//                file.createNewFile();
//
//            }
//            // Once done, print output
//            System.out.println("[FileStore.java/test] " + filename + " : " + s);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }

    // Load
    public Game[] getGameList() {
        try {
            String s = "";
            File file = new File(gamesFilename);
            if(file.exists()){
                FileInputStream fileInput = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(fileInput);
                Game[] games = (Game[]) reader.readObject();

                System.out.println("[FileStore.java/getGameList] Array: " + games);
            } else {
                System.out.println("[FileStore.java/getGameList] File not found, creating new one");
                file.createNewFile();
                Game[] games = {};
                FileOutputStream fileOutput = new FileOutputStream(file);
                ObjectOutputStream writer = new ObjectOutputStream(fileOutput);
                writer.writeObject(games);
                writer.close();

            }
            // Once done, print output
            System.out.println("[FileStore.java/getGameList] " + gamesFilename + " : " + s);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Game getGame() {
        return null;
    }

    // Write
    public void addGame(Game game) {
        try {
            JSONObject gameObject = new JSONObject(game);
            // Get the game list ->  array
            // Add gameObject at the end
            // Write to file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer(int id){
        return null;
    }

    public Player[] getPlayers() {
        return null;
    }

    public void addPlayer(Player player) {

    }
}


