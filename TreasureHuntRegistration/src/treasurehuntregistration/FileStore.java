package treasurehuntregistration;

import java.io.File;
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
    private String filename ="database.txt";

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
        try {
            String s = "";
            File file = new File(filename);
            if(file.exists()){
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    s.concat(scanner.nextLine());
                }
            } else {

                System.out.println("File not found");
            }
            // Once done, print output
            System.out.println("[FileStore.java/test] " + filename + " : " + s);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // Load
    public Game[] getGameList() {
        try {
            File file = new File(filename);
            if(file.exists()){

            }
        } catch (Exception e) {

        }

        return null;
    }


    // Write
}


