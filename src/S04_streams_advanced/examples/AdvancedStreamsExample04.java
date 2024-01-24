/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S04_streams_advanced.examples;

import S04_streams_advanced.Category;
import S04_streams_advanced.ExampleData;
import S04_streams_advanced.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Përdorimi i Collectors.toMap() për të llogaritur çmimin total të produkteve për kategori.
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,   // Key mapper function
                        Product::getPrice,      // Value mapper function
                        BigDecimal::add));      // Merge function
        System.out.println(totalPerCategory);
    }
}
