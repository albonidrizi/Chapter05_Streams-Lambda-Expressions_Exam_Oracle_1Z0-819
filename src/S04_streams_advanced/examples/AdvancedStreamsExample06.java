/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S04_streams_advanced.examples;

import S04_streams_advanced.ExampleData;
import S04_streams_advanced.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExample06 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        // Particionimi është një rast i veçantë i grupimit, ku funksioni klasifikues është një Predikat
        // dhe elementet e stream-it ndahen në dy grupe.
        // Rezultati është një hartë me dy hyrje, me vlera booleane 'true' dhe 'false' si çelësat.
        Map<Boolean, List<Product>> partitionedProducts = products.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(priceLimit) < 0));

        System.out.println("Cheap products: ");
        partitionedProducts.get(true).forEach(System.out::println);

        System.out.println("Expensive products: ");
        partitionedProducts.get(false).forEach(System.out::println);
    }
}
