/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S04_streams_advanced.examples;

import S04_streams_advanced.ExampleData;
import S04_streams_advanced.Product;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;

public class AdvancedStreamsExample07 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();


        // DoubleStream është një stream që përmban vlera primitive double.
        // Në krahasim me Stream<Double>, kjo shmang mbulimin dhe shëndrrimin e vlerave primitive double në dhe nga objekte mbuluese Double.
        DoubleStream prices = products.stream()
                .mapToDouble(product -> product.getPrice().doubleValue());

        // Ka disa metoda që nuk janë të disponueshme në stream-et e rregullta, siç është sum().
        double total = prices.sum();
        System.out.printf("The sum of all product prices is $ %.2f%n", total);


        // Metoda summaryStatistics() ofron statistika për elementët në stream.
        // Shihni dokumentacionin API të stream-ave të specializuar për më shumë metoda.
        DoubleSummaryStatistics statistics = products.stream()
                .mapToDouble(product -> product.getPrice().doubleValue())
                .summaryStatistics();

        System.out.printf("Count  : %d%n", statistics.getCount());
        System.out.printf("Sum    : $ %.2f%n", statistics.getSum());
        System.out.printf("Minimum: $ %.2f%n", statistics.getMin());
        System.out.printf("Maximum: $ %.2f%n", statistics.getMax());
        System.out.printf("Average: $ %.2f%n", statistics.getAverage());
    }
}
