/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S03_streams_basic.examples;

import S03_streams_basic.Category;
import S03_streams_basic.ExampleData;
import S03_streams_basic.Product;

import java.util.List;
import java.util.regex.Pattern;

public class BasicStreamsExample03 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        System.out.println("\n****************************\n");
        // Operacioni ndërmjetës filter() filtron elementet nga stream-i
        products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .forEach(System.out::println);

        System.out.println("\n****************************\n");

        // Operacioni ndërmjetës map() bën një transformim nga një-nga-një për çdo element
        products.stream()
                .map(product -> String.format("The price of %s is $ %.2f", product.getName(), product.getPrice()))
                .forEach(System.out::println);
        System.out.println("\n****************************\n");

        // Operacioni ndërmjetës flatMap() bën një transformim nga një-tek-N për çdo element
        // Funksioni që kalohet te flatMap() duhet të kthejë një Stream që përmban elementet e dalura
        // Stream-e që kthehen nga thirrjet e funksionit "flaten" në një stream të vetëm të dalje
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                .flatMap(product -> spaces.splitAsStream(product.getName()))
                .forEach(System.out::println);
        System.out.println("\n****************************\n");
    }
}
