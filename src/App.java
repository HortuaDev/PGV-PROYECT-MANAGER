import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.salesianos.Object.Product;
import net.salesianos.Process.ProcessLauncher;

public class App {
    public static void main(String[] args) throws Exception {
        basicStructure();
        // runProcess();
        // organizeInformation();
        // showMenu();
    }

    public static void basicStructure() {

        File binDirectory = new File("./bin");

        if (!binDirectory.exists()) {
            binDirectory.mkdirs();
        }
        File outputDirectory = new File("./src/net/salesianos/Files/output/");

        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }
        File organizedFilesDirectory = new File("./src/net/salesianos/Files/organizedFiles/");
        if (!organizedFilesDirectory.exists()) {
            organizedFilesDirectory.mkdirs();
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "javac",
                    "-d", "./bin",
                    "./src/net/salesianos/Object/Product.java",
                    "./src/net/salesianos/Process/*.java",
                    "./src/App.java");

            pb.inheritIO();
            Process process = pb.start();
            process.waitFor(); // Esperar a que termine

            System.out.println("Compilación completada.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

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

    public static void organizeInformation() {

        File principalDirectory = new File("./src/net/salesianos/Files/output/");
        File[] files = principalDirectory.listFiles();
        File finalFile = new File("./src/net/salesianos/Files/organizedFiles/FinalFile.csv");

        if (finalFile.exists()) {
            finalFile.delete();
        }

        for (File file : files) {
            try {
                String fileName = file.getName().replace(".csv", "");
                Process process = ProcessLauncher.categoryClasificationProcess(fileName, finalFile);
                process.waitFor();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showMenu() {

        File finalFile = new File("./src/net/salesianos/Files/organizedFiles/FinalFile.csv");

        System.out.println("Contenido del fichero final: " + finalFile.getName());
        try (BufferedReader br = new BufferedReader(
                new FileReader(finalFile))) {
            List<Product> products = new ArrayList<>();
            String line = "";

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                products.add(new Product(Integer.parseInt(parts[0]), parts[1], parts[2],
                        Float.parseFloat(parts[3]), Float.parseFloat(parts[4])));
            }

            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return p1.getCategoria().compareTo(p2.getCategoria());
                };
            });

            String categoriaActual = "";

            for (Product product : products) {
                if (!product.getCategoria().equals(categoriaActual)) {
                    categoriaActual = product.getCategoria();
                    System.out.println("\n CATEGORiA: " + categoriaActual);
                    System.out.println("-----------------------------------------------------------");
                    System.out.printf("%-6s %-20s %-12s %-10s%n", "ID", "NOMBRE", "CANTIDAD", "PRECIO");
                    System.out.println("-----------------------------------------------------------");
                }

                System.out.printf("%-6d %-20s %-12.2f %-10.2f%n",
                        product.getId(),
                        product.getNombre(),
                        product.getCantidad(),
                        product.getPrecio());
            }

            System.out.println("===========================================================");

        } catch (Exception e) {
            System.err.println("Error al leer el fichero final: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
