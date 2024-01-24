package S04_streams_advanced.exercises;

import S04_streams_advanced.Category;
import S04_streams_advanced.Product;

import java.util.List;
import java.util.Map;

public class AdvancedStreamsExercise02 {

    /**
     * Exercise 2: Count the number of products per category.
     *
     * @param products A list of products.
     * @return A Map containing categories as keys, and the number of product for each category as values.
     */
    public Map<Category, Long> countProductsPerCategory(List<Product> products) {
        // TODO: Group the products by category and count the number of products in each category.
        //
        // Hint: Remember how grouping works. It splits the input stream into multiple streams.
        // You can use a downstream collector to process the output streams of the grouping operation further.
        // For counting the number of products, look at the API documentation of class Collectors - there's a factory method that you can use.

//        return products.stream()...;

        throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
