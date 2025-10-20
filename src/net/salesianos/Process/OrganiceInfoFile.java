package net.salesianos.Process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.salesianos.Object.Product;

public class OrganiceInfoFile {
    public static void main(String[] args) {

        String fileName = args[0];
        List<Product> products = new java.util.ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("./src/net/salesianos/files/input/" + fileName + ".csv"));) {

            String line = "";
            boolean firstLine = true;
            // Obtengo la informacion del fichero y la combierto a objetos Product

            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] attributes = line.split(",");

                products.add(new Product(Integer.parseInt(attributes[0]), attributes[1], attributes[2],
                        Float.parseFloat(attributes[3]), Float.parseFloat(attributes[4])));
            }

            // ordeno la lista por categoría

            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return p1.getCategoria().compareTo(p2.getCategoria());
                }
            });

            // escribo la lista ordenada en el fichero de salida
            for (Product p : products) {
                System.out
                        .println(p.getId() + "," + p.getNombre() + "," + p.getCategoria() + "," + p.getCantidad() + ","
                                + p.getPrecio());
            }

        } catch (Exception e) {
            System.err.println("Error al procesar el fichero: " + fileName + ".: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
