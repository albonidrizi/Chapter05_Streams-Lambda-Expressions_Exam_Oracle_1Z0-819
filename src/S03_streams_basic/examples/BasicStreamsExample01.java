/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S03_streams_basic.examples;



import S03_streams_basic.ExampleData;
import S03_streams_basic.Product;

import java.util.List;
import java.util.stream.Stream;

public class BasicStreamsExample01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Streams janë të vonshëm - pa një operacion terminal, nuk bëhet asnjë punë
        // Kur thërrisni operacione ndërmjetëse në një stream, po ndërtoni vetëm "pipeline"-n;
        // ende nuk ka elemente që po rrjedhin nëpër të
        Stream<Product> stream = products.stream().map(product -> {
            System.out.println(product);
            return product;
        });

        // Kur thërrisni një operacion terminal, stream-i do të bëjë punën
        stream.forEach(product -> {});
    }
}
