/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S01_lambda_expressions.examples;

import S01_lambda_expressions.Category;
import S01_lambda_expressions.ExampleData;
import S01_lambda_expressions.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample07 {

    // Një ndërfaqe funksionale për krijimin e produkteve
    interface ProductFactory {
        Product create(Category category, String name, BigDecimal price);
    }

    // Metodë statike për të verifikuar nëse një produkt është i shtrenjtë
    static boolean isExpensive(Product product) {
        return product.getPrice().compareTo(new BigDecimal("5.00")) >= 0;
    }

    public static void main(String[] args) {
        // Merrni një listë të produkteve nga ExampleData
        List<Product> products = ExampleData.getProducts();

        // Në vend të një shprehjeje lambda, mund të përdorni një referencë të metodes për të referuar në një metodë
        // që implementon ndërfaqen funksionale të përshtatshme.
        // products.forEach(product -> System.out.println(product));
        products.forEach(System.out::println);

        // Një referencë e metodes mund të referojë në një metodë statike, një metodë instancoje ose një konstruktor.

        // Referencë e metodes për një metodë statike.
        products.removeIf(LambdasExample07::isExpensive);

        // Ka dy lloje referencash të metodave që referojnë në një metodë instancoje:
        // - Product::getName referon në një metodë instancoje të klases Product, por jo për një objekt të caktuar të Product
        //   map() thirrë metoden getName() në objektin Product që merr
        // - System.out::println referon në një metodë instancoje të klases PrintStream, për një objekt të caktuar PrintStream;
        //   ai që e referon variabla System.out
        products.stream().map(Product::getName).forEach(System.out::println);

        // Një referencë e metodes me 'new' pas dy pikave të shenjon konstruktorin.
        ProductFactory factory = Product::new;
        Product blueberries = factory.create(Category.FOOD, "Blueberries", new BigDecimal("6.95"));
        System.out.println(blueberries);
    }
}

