/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S02_functional_interfaces.examples;

import S02_functional_interfaces.Category;
import S02_functional_interfaces.ExampleData;
import S02_functional_interfaces.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalInterfacesExample04 {


    // Kaloni nëpër një listë të produkteve dhe ktheni produktin e par për të cilin predikata kthen vlerën e vërtetë.
    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for (Product product : products) {
            if (predicate.test(product)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("2.00");

        // Dy predikata të thjeshta që mund të kombinohen duke përdorur metodat e kompozicionit funksional në interface Predicate.
        Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
        Predicate<Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;

        findProduct(products, isFood.and(isCheap)) // Combining the predicates with and(...)
                .map(product -> String.format("%s for $ %.2f", product.getName(), product.getPrice()))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("There are no cheap food products"));
    }
}
