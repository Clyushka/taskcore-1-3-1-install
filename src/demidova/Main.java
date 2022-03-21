package demidova;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder("Install in folder: ");

        File gamesDir = new File("Games"); // C:\Users\USER\IdeaProjects\TaskCore-1-3-1-Install\Games
        log.append(gamesDir.getAbsolutePath() + "\\\n\n");

        if (gamesDir.exists()) {
            // Games/src/
            File srcDir = new File(gamesDir.getPath() + "\\src");
            log.append(createdDirLog(srcDir, srcDir.mkdir()));
            File mainDir = new File(srcDir.getPath() + "\\main");
            log.append(createdDirLog(mainDir, mainDir.mkdir()));
            // Games/src/main
            try {
                File mainJavaFile = new File(mainDir, "Main.java");
                log.append(createdFileLog(mainJavaFile, mainJavaFile.createNewFile()));

                File utilsJavaFile = new File(mainDir, "Utils.java");
                log.append(createdFileLog(utilsJavaFile, utilsJavaFile.createNewFile()));

            } catch (IOException e) {
                log.append(e.getLocalizedMessage());
                System.exit(0);
            }

            // Games/res/
            File resDir = new File(gamesDir.getPath() + "\\res");
            log.append(createdDirLog(resDir, resDir.mkdir()));
            File drawablesDir = new File(resDir.getPath() + "\\drawables");
            log.append(createdDirLog(drawablesDir, drawablesDir.mkdir()));
            File vectorsDir = new File(resDir.getPath() + "\\vectors");
            log.append(createdDirLog(vectorsDir, vectorsDir.mkdir()));
            File iconsDir = new File(resDir.getPath() + "\\icons");
            log.append(createdDirLog(iconsDir, iconsDir.mkdir()));

            // Games/savegames/
            File savegamesDir = new File(gamesDir.getPath() + "\\savegames");
            log.append(createdDirLog(savegamesDir, savegamesDir.mkdir()));

            // Games/temp/
            File tempDir = new File(gamesDir.getPath() + "\\temp");
            log.append(createdDirLog(tempDir, tempDir.mkdir()));
            File tempTxtFile = new File(tempDir, "temp.txt");
            try {
                log.append(createdFileLog(tempTxtFile, tempTxtFile.createNewFile()));
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }

            // write log to temp.txt
            try (Writer logOutputStream = new FileWriter(tempTxtFile, false)) {
                logOutputStream.write(log.toString());
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.exit(0);
            }

        } else {
            System.out.println("Директория <..>/Games/ отсутствует");
        }
    }

    public static String createdDirLog(File dir, boolean isCreated) {
        if (isCreated) {
            return dir.getPath() + "\\ was created at " + DTF.format(LocalDateTime.now()) + "\n";
        } else {
            return dir.getPath() + "\\ was NOT created \n";
        }
    }

    public static String createdFileLog(File file, boolean isCreated) {
        if (isCreated) {
            return file.getPath() + " was created at " + DTF.format(LocalDateTime.now()) + "\n";
        } else {
            return file.getPath() + " was NOT created \n";
        }
    }
}
