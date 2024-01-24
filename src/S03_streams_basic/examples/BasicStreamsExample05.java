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
import java.util.stream.Collectors;

public class BasicStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // This is not a good way to get the elements of a stream into a list
//        List<String> foodProductNames = new ArrayList<>();
//        products.stream()
//                .filter(product -> product.getCategory() == Category.FOOD)
//                .map(Product::getName)
//                .forEach(foodProductNames::add);

        System.out.println("\n****************************\n");
        // Duke përdorur collect() mund të mbledhni elementet e një stream-i në një koleksion
        // Klasa Collectors përmban metoda fabrike për koleksione që krijojnë lloje të ndryshme të koleksioneve
        List<String> foodProductNames = products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(foodProductNames);

        System.out.println("\n****************************\n");
        // Collectors.joining(...) kthen një kolektor për të reduktuar elementet e stream-it në një string
        String categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .map(Category::name)
                .collect(Collectors.joining("; "));
        System.out.println(categories);
    }
}
