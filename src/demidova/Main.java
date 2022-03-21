package demidova;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        File gamesDir = new File("Games"); // C:\Users\USER\IdeaProjects\TaskCore-1-3-1-Install\Games
        if (gamesDir.exists()) {
            // Games/src/
            File srcDir = new File(gamesDir.getPath() + "\\src");
            if (!srcDir.exists()) {
                srcDir.mkdir();
            }
            File mainDir = new File(srcDir.getPath() + "\\main");
            if (!mainDir.exists()) {
                mainDir.mkdir();
            }
            // Games/src/main
            try {
                new File(mainDir, "Main.java").createNewFile();
                new File(mainDir, "Utils.java").createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }

            // Games/res/
            File resDir = new File(gamesDir.getPath() + "\\res");
            if (!resDir.exists()) {
                resDir.mkdir();
            }
            new File(resDir.getPath() + "\\drawables").mkdir();
            new File(resDir.getPath() + "\\vectors").mkdir();
            new File(resDir.getPath() + "\\icons").mkdir();

            // Games/savegames/
            new File(gamesDir.getPath() + "\\savegames").mkdir();

            // Games/temp/
            File tempDir = new File(gamesDir.getPath() + "\\temp");
            if (!tempDir.exists()) {
                tempDir.mkdir();
            }
            try {
                new File(tempDir, "temp.txt").createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }
        } else {
            System.out.println("Нет такой директории");
        }
    }
}
