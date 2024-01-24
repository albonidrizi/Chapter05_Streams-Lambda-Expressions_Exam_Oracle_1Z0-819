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
import java.util.Optional;

public class AdvancedStreamsExample02 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Versioni i parë i reduce() merr një BinaryOperator për të akumuluar elementët në një rezultat përfundimtar
        // Kthen një Optional; nëse stream-i është i zbrazët, rezultati është një Optional i zbrazët
        Optional<BigDecimal> opt = products.stream()
                .map(Product::getPrice)
                .reduce((result, element) -> result.add(element)); // Can also be written with a method reference: BigDecimal::add

        opt.ifPresentOrElse(
                total -> System.out.printf("The total value of all products is: $ %.2f%n", total),
                () -> System.out.println("There are no products"));


        // Versioni i dytë i reduce() merr një vlerë fillestare dhe një BinaryOperator
        // Kthen një vlerë në vend të një Optional; nëse stream-i është i zbrazët, rezultati do të jetë vlera fillestare
        BigDecimal total = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("The total value of all products is: $ %.2f%n", total);


        // Versioni i tretë i reduce() është më i përgjithshëm
        // Lloji i rezultatit të tij mund të jetë ndryshe nga lloji i elementeve në stream
        // Parametri i tretë është një funksion kombinues për të kombinuar rezultatet ndërmjetëse; kjo është e dobishme për shembull për një stream të paralelizuar,
        // ku thread-e të ndryshëm llogarisin rezultate ndërmjetëse që duhet të kombinohen në një rezultat final
        BigDecimal total2 = products.stream()
                .reduce(BigDecimal.ZERO, (result, product) -> result.add(product.getPrice()), BigDecimal::add);
        System.out.printf("The total value of all products is: $ %.2f%n", total2);
    }
}
