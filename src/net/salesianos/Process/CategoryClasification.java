package net.salesianos.Process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.salesianos.Object.Product;

public class CategoryClasification {
    public static void main(String[] args) {
        String fileName = args[0];
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("./src/net/salesianos/files/output/" + fileName + ".csv"))) {

            String line = "";

            while ((line = br.readLine()) != null) {

                String[] attributes = line.split(",");

                products.add(new Product(Integer.parseInt(attributes[0]), attributes[1], attributes[2],
                        Float.parseFloat(attributes[3]), Float.parseFloat(attributes[4])));
            }

            // organiza los elementos dentro del array por categoria, que no se me olvide
            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return p1.getCategoria().compareTo(p2.getCategoria());
                };
            });

            for (Product p : products) {
                System.out
                        .println(p.getId() + "," + p.getNombre() + "," + p.getCategoria() + "," + p.getCantidad() + ","
                                + p.getPrecio());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
