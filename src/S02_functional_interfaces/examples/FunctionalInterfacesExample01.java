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
import java.util.stream.Collectors;

public class FunctionalInterfacesExample01 {

    // Kaloni nëpër një listë të produkteve dhe ktheeni produktin e parë për të cilin predikata kthen vlerën e vërtetë.
    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate){

        for (Product p : products){
            if (predicate.test(p)){
                return Optional.of(p);
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {

        // 1 krijon nje metod per te gjetur gjith produktet,dhe per te filtruar nga parametrat qe do futni
        // 2 krijon nje list te gjith produkteve
        // 3 krijon nje predikat (kusht per te zgj cilet produkte don ti marish)
        // 4 krijon nje rezultat ku don ti marish keto produkte dhe e perdor metoden qe krijove
        //  duke futur si parametra e listes se produkteve dhe predikatit

        String name ="Spaghetti";

        List<Product> productList = ExampleData.getProducts();
        Predicate<Product> predicate = (p)-> p.getName().equals(name);

        findProduct(productList, predicate).map(Product::getPrice)
                .ifPresentOrElse(
                        price -> System.out.printf("The price %s is $ %.2f %n", name, price),
                        () -> System.out.printf("%s is not available %n", name)
                );


       // List<Product> result1 = productList.stream().filter(predicate).collect(Collectors.toList());
       // result1.forEach(System.out::println);
    }
}
