/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S01_lambda_expressions.examples;

import S01_lambda_expressions.ExampleData;
import S01_lambda_expressions.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class LambdasExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        List<Product> cheapProducts = new ArrayList<>();

        // PRAKTIKË E KEQE! Modifikimi i cheapProducts brenda trupit të shprehjes lambda.
        // Në përgjithësi, shmangni efekte anësore si modifikimi i objekteve nga variablat e përfshira në lambda shprehje.
        products.forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });

        // Printo produktet e lira.
        cheapProducts.forEach(product -> System.out.println(product));
    }
}
