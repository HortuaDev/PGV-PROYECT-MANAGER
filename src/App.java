import java.io.File;

import net.salesianos.Process.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        runProcess();

    }

    public static void runProcess() {

        File directory = new File("./src/net/salesianos/Files/input/");
        String[] files = directory.list();

        for (String file : files) {
            String fileName = file.replace(".csv", "");

            ProcessLauncher.createProcess(fileName);
        }

    }

}
