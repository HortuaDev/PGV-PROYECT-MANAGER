import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.salesianos.Process.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        runProcess();

    }

    public static void runProcess() {

        File directory = new File("./src/net/salesianos/Files/input/");
        String[] files = directory.list();

        List<Process> processList = new ArrayList<>();

        for (String file : files) {
            String fileName = file.replace(".csv", "");

            processList.add(ProcessLauncher.createProcess(fileName));
        }

        for (Process process : processList) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Procesos terminados");
    }

}
