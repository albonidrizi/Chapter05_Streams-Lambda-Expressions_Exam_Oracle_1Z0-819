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

public class AdvancedStreamsExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Gruponi produktet sipas kategorisë. Funksioni i klasifikuesit që i kaloni groupingBy() përcakton se si të ndahen produktet në grupe.
        Map<Category, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));


        // Le të presupozojmë se dëshirojmë të marrim një hartë të emrave të produkteve për kategori (në vend të produkteve).
        // Duke mapuar produkte në emrat e produkteve me map(...), nuk do të funksionojë, sepse rezultati i operacionit map(...) është një stream i stringjeve.
        // Informacioni mbi kategoritë do të jetë hedhur larg, kështu që nuk mund të gruponi më sipas kategorive në koleksion.
//        Map<Category, List<String>> productNamesByCategory = products.stream()
//                .map(Product::getName)
//                .collect(Collectors.groupingBy(...));

        // Krijoni një Mapë të emrave të produkteve të grupuar sipas kategorisë.
        // Përdorim një kolektor në vijim, të krijuar nga Collectors.mapping(...), për të mapuar produktet e grupuara në emrat e produkteve.
        // Kujtoni se Collectors.mapping(...) merr një funksion mapimi dhe një kolektor tjetër në vijim për të përcaktuar se si të mblidhet rezultati i tij.
        Map<Category, List<String>> productNamesByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));

        // Print the product names for each category.
        productNamesByCategory.forEach((category, names) -> {
            System.out.println(category);
            names.forEach(name -> System.out.println("- " + name));
        });


        // Provë: Ky rresht llogarit çmimin total të produkteve për kategori, sikurse në shembullin e mëparshëm (AdvancedStreamsExample04),
        // por duke përdorur groupingBy() dhe disa kolektorë në vijim. Mund të shpjegoni saktësisht si funksionon kjo?
        // Përdorni dokumentacionin API të klases Collectors për të mësuar më shumë rreth metodave fabrikuese.
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getPrice, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }
}
