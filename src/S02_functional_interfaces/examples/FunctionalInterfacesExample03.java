/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S02_functional_interfaces.examples;

import S02_functional_interfaces.ExampleData;
import S02_functional_interfaces.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample03 {

    // Kaloni nëpër një listë të produkteve dhe ktheeni produktin e parë për të cilin predikata kthen vlerën e vërtetë.
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

        String name = "Spaghetti";

        Function<Product, BigDecimal> productToPrice = Product::getPrice;
        Function<BigDecimal, String> priceToMessage = price -> String.format("The price of %s is $ %.2f%n", name, price);


        // Krijo një funksion të ri duke përdorur andThen(...) nga dy funksionet e mësipërme
        Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);

        // Alternativa: përdorni compose(...), e cila është e njëjta si andThen(...), me dallimin se renditja e funksioneve është e kundërta
        // Function<Product, String> productToMessage = priceToMessage.compose(productToPrice);

        findProduct(products, product -> product.getName().equals(name))
                .map(productToMessage)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.printf("%s is not available%n", name));
    }
}
