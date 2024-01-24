/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S01_lambda_expressions.examples;

import S01_lambda_expressions.ExampleData;
import S01_lambda_expressions.Product;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdasExample01 {

    public static void main(String[] args) {
        // Merrni një listë të produkteve nga ExampleData
        List<Product> products = ExampleData.getProducts();

        // Ndërfaqja Comparator e implementuar me një klasë anonime.
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });

        // Ndërfaqja Comparator e implementuar me një shprehje lambda.
        products.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

        // E njëjta gjë me një sintaksë më të zgjeruar:
        // - Mund të specifikoni opsionalisht tipin e parametrave
        // - Trupi mund të jetë një bllok mes { dhe } ose një shprehje e vetme
        products.sort((Product p1, Product p2) -> {
            return p1.getPrice().compareTo(p2.getPrice());
        });

        // Printo produktet pasi janë renditur
        for (Product product : products) {
            System.out.println(product);
        }


    }
}
