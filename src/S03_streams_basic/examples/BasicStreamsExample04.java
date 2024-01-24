/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S03_streams_basic.examples;

import S03_streams_basic.Category;
import S03_streams_basic.ExampleData;
import S03_streams_basic.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class BasicStreamsExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        System.out.println("\n****************************\n");
        // findFirst() do të kthejë një Optional me elementin e parë në stream, ose një Optional të zbrazët
        // Kjo përdoret shpesh bashkë me filter() për të kërkuar një element sipas kritereve të caktuara
        Optional<Product> opt = products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                .findFirst();
        opt.ifPresent(System.out::println);

        System.out.println("\n****************************\n");
        // Nëse dëshironi vetëm të kontrolloni nëse stream-i përmban një element që përputhet me kriteret e kërkimit tuaj,
        // atëherë mund të përdorni anyMatch(), që do të kthejë një rezultat boolean
        // Ndryshe nga findFirst() dhe findAny(), ju nuk duhet të bëni filtrimin paraprakisht - anyMatch() merr një Predicate
        boolean foundOfficeProduct = products.stream()
                .anyMatch(product -> product.getCategory() == Category.OFFICE);
        System.out.println("Does the list contain at least one office product? " + foundOfficeProduct);

        System.out.println("\n****************************\n");
        // Për të kontrolluar nëse të gjithë elementet e stream-it përputhen me kritere të caktuara, përdorni allMatch()
        BigDecimal priceLimit = new BigDecimal("10.00");
        boolean allProductsAreCheap = products.stream()
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products cheap? " + allProductsAreCheap);

        System.out.println("\n****************************\n");
        // noneMatch() kthen të kundërtën e anyMatch()
        boolean allProductsAreExpensive = products.stream()
                .noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products expensive? " + allProductsAreExpensive);
    }
}
