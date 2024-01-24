/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S01_lambda_expressions.examples;

import S01_lambda_expressions.ExampleData;
import S01_lambda_expressions.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LambdasExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Përdorimi i një try-with-resources për të siguruar se resurset e hapura (si FileWriter) do të mbyllen automatikisht
        try (FileWriter writer = new FileWriter("products.txt")) {
            // Përdorimi i forEach() për të shkruar çdo produkt në skedar
            products.forEach(product -> {
                try {
                    // Përdorimi i lambda shprehjes për të shkruar produktin në skedar
                    writer.write(product.toString() + "\n");
                } catch (IOException e) {
                    // Për shkak se accept() nuk deklaron shenja të kontrolluar (checked exceptions),
                    // kemi nevojë të trajtojmë IOException brenda shprehjes lambda
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException | RuntimeException e) {
            // Kapja e shenjave të kontrolluara ose RuntimeException që mund të shkaktohen në try-with-resources
            System.err.println("Ndodhi një përjashtim: " + e.getMessage());
        }
    }
}

