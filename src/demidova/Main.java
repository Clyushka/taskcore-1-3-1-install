package demidova;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File games_dir = new File ("Games"); // C:\Users\USER\IdeaProjects\TaskCore-1-3-1-Install\Games
        if (games_dir.exists()) {
            // Games/src/
            File src_dir = new File(games_dir.getPath() + "\\src");
            if (!src_dir.exists()) {
                src_dir.mkdir();
            }
            File main_dir = new File(src_dir.getPath() + "\\main");
            if (!main_dir.exists()) {
                main_dir.mkdir();
            }
            // Games/src/main
            try {
                new File(main_dir, "Main.java").createNewFile();
                new File(main_dir, "Utils.java").createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }

            // Games/res/
            File res_dir = new File(games_dir.getPath() + "\\res");
            if (!res_dir.exists()) {
                res_dir.mkdir();
            }
            new File(res_dir.getPath() + "\\drawables").mkdir();
            new File(res_dir.getPath() + "\\vectors").mkdir();
            new File(res_dir.getPath() + "\\icons").mkdir();

            // Games/savegames/
            new File(games_dir.getPath() + "\\savegames").mkdir();

            // Games/temp/
            File temp_dir = new File(games_dir.getPath() + "\\temp");
            if (!temp_dir.exists()) {
                temp_dir.mkdir();
            }
            try {
                new File(temp_dir, "temp.txt").createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }
        } else {
            System.out.println("Нет такой директории");
        }
    }
}
