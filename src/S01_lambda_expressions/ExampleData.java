package S01_lambda_expressions;/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ExampleData {

    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product(Category.FOOD, "Oranges", new BigDecimal("1.65")),
            new Product(Category.FOOD, "Gouda cheese", new BigDecimal("6.79")),
            new Product(Category.UTENSILS, "Plates", new BigDecimal("12.95")),
            new Product(Category.CLEANING, "Detergent", new BigDecimal("3.79")),
            new Product(Category.FOOD, "Soft drink", new BigDecimal("1.99")),
            new Product(Category.OFFICE, "Pencils", new BigDecimal("5.79")),
            new Product(Category.FOOD, "Rice", new BigDecimal("2.99")),
            new Product(Category.CLEANING, "Scourer", new BigDecimal("2.29")),
            new Product(Category.FOOD, "Milk", new BigDecimal("1.39")),
            new Product(Category.OFFICE, "Notebook", new BigDecimal("4.99")),
            new Product(Category.FOOD, "Tea", new BigDecimal("4.29")),
            new Product(Category.FOOD, "Tomato sauce", new BigDecimal("1.39")),
            new Product(Category.FOOD, "Peanut butter", new BigDecimal("2.39")),
            new Product(Category.FOOD, "Red bell pepper", new BigDecimal("0.99")),
            new Product(Category.UTENSILS, "Spoons", new BigDecimal("14.95")),
            new Product(Category.OFFICE, "Adhesive tape", new BigDecimal("5.39")),
            new Product(Category.CLEANING, "Dish brush", new BigDecimal("3.49")),
            new Product(Category.UTENSILS, "Knives", new BigDecimal("9.95")),
            new Product(Category.FOOD, "Brown bread", new BigDecimal("3.99")),
            new Product(Category.FOOD, "Potatoes", new BigDecimal("1.59")),
            new Product(Category.CLEANING, "Dishcloth", new BigDecimal("2.59")),
            new Product(Category.FOOD, "Apples", new BigDecimal("1.29")),
            new Product(Category.OFFICE, "Ballpoint pens", new BigDecimal("6.79")),
            new Product(Category.FOOD, "Spaghetti", new BigDecimal("2.79")),
            new Product(Category.UTENSILS, "Forks", new BigDecimal("14.95")),
            new Product(Category.UTENSILS, "Paper towel", new BigDecimal("3.69")),
            new Product(Category.FOOD, "Coffee", new BigDecimal("7.49")),
            new Product(Category.OFFICE, "Highlighter", new BigDecimal("2.29")),
            new Product(Category.FOOD, "Orange juice", new BigDecimal("3.49")),
            new Product(Category.FOOD, "Spring water", new BigDecimal("0.99")));

    public static List<Product> getProducts() {
        return new ArrayList<>(PRODUCTS);
    }
}
