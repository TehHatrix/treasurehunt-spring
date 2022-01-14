package treasurehuntregistration;

import java.io.File;

public class FileStoreTest {

    public static void main(String[] args) {
        FileStore fs = FileStore.getInstance();

        fs.getGameList();
    }
}
