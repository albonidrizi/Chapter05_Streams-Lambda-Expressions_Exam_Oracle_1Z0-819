/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S04_streams_advanced.examples;

import S04_streams_advanced.ExampleData;
import S04_streams_advanced.Product;

import java.util.ArrayList;
import java.util.List;

public class AdvancedStreamsExample03 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();


        // Mund të zvogëlohen elementet e stream-it në një ArrayList me reduce(), por kjo është e pamjaftueshme sepse reduce()
        // është projektuar që kontejneri i rezultatit të jetë i pandryshueshëm; prandaj duhet të krijoni listat ndërmjetëse dhe
        // të kopjoni elementet midis tyre.
        List<String> productNames1 = products.stream().reduce(
                new ArrayList<>(),
                (list, product) -> {
                    ArrayList<String> newList = new ArrayList<>(list);
                    newList.add(product.getName());
                    return newList;
                },
                (list1, list2) -> {
                    ArrayList<String> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                });

        // Koleksioni është një reduktim i ndryshueshëm. Ky është shumë më efikas nëse keni një konteiner rezultati të ndryshueshëm
        // si një ArrayList, duke evituar shumicën e kopjimeve që duhet të bëhen kur përdorni reduce().
        List<String> productNames2 = products.stream().collect(
                ArrayList::new,
                (list, product) -> list.add(product.getName()),
                ArrayList::addAll);
    }
}
