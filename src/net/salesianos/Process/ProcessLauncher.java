package net.salesianos.Process;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {

    public static Process createProcess(String fileName) {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp", "./bin",
                    "net.salesianos.Process.OrganiceInfoFile",
                    fileName);

            pb.redirectOutput(new File("./src/net/salesianos/Files/output/" + fileName + ".csv"));

            return pb.start();

        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso: " + fileName + ".: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Process categoryClasificationProcess(String fileName) {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp", "./bin",
                    "net.salesianos.Process.CategoryClasification",
                    fileName);

            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(
                    new File("./src/net/salesianos/Files/organizedFiles/FinalFile.csv")));

            return pb.start();

        } catch (IOException e) {
            System.out.println("Error al iniciar el proceso: " + fileName + ".: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
