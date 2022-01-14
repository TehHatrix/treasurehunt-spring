package treasurehuntregistration;

public class FileStoreTest {

    public static void main(String[] args) {
        FileStore fs = FileStore.getInstance();
//        fs.addGame(new Game(fs.generateID("game"), "New Game"));
//        fs.addGame(new Game(fs.generateID("game"), "Treasure Hunt"));
//        fs.addPlayer(new Player(fs.generateID("player")));
        fs.removeGame(1);
        fs.removeGame(3);
        System.out.println(fs.getGameList().values());
        System.out.println(fs.getPlayers().values());
    }
}
