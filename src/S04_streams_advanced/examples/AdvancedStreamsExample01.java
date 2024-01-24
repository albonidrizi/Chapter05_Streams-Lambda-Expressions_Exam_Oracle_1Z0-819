/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S04_streams_advanced.examples;

import java.math.BigInteger;
import java.util.UUID;
import java.util.stream.Stream;

public class AdvancedStreamsExample01 {

    public static void main(String[] args) {
        // Metoda generate() merr një Supplier dhe krijon një stream të pafundme nga vlerat e kthyer nga furnizuesi
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        uuids.limit(10).forEach(System.out::println);


        // Versioni i parë i iterate() merr një vlerë mbjellëse dhe një operator unar dhe gjeneron një stream të pafundme vlerash
        // duke filluar me kthimin e mbjellësës, dhe pastaj duke aplikuar operatorin tek çdo element i mëparshëm, kështu që stream-i
        // do të përmbajë: mbjellës, f(mbjellës), f(f(mbjellës)), etj.
        Stream<BigInteger> powersOfTwo = Stream.iterate(BigInteger.ONE, n -> n.multiply(BigInteger.TWO));
        powersOfTwo.limit(20).forEach(System.out::println);


        // Versioni i dytë i iterate() merr një parameter shtesë, i cili është një predikat që tregon nëse ka një element tjetër
        // Kur predikata kthen false, stream-i përfundon
        // Tre parametrat janë pikërisht si tre pjesët e një for-loop
        Stream<Character> alphabet = Stream.iterate('A', letter -> letter <= 'Z', letter -> (char) (letter + 1));
        alphabet.forEach(System.out::print);

        // Mund të ndërtoni një stream duke krijuar një konstruktor dhe duke shtuar elemente në konstruktor
        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two");
        builder.add("three");
        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }
}
