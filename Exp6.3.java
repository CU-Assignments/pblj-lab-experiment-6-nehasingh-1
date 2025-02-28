/*To develop a Java program that processes a large dataset of products using Streams class to:
  - Group products by category
  - Find the most expensive product in each category
  - Calculate the average price of all products*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;
class Product {
    private String name;
    private String category;
    private double price;
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }
}
public class Project1 {
    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
    }
    private static void runTest(List<Product> products) {
        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("Grouped Products:");
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        });
        System.out.println("\nMost Expensive Products by Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.map(Product::getName).orElse("No product")));

        System.out.println("\nAverage Price of All Products: " + averagePrice);
        System.out.println();
    }
    private static void testCase1() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("Shirt", "Clothing", 50),
                new Product("Jeans", "Clothing", 60),
                new Product("Sneakers", "Footwear", 100),
                new Product("Boots", "Footwear", 150)
        );
        runTest(products);
    }
    private static void testCase2() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("Tablet", "Electronics", 600)
        );
        runTest(products);
    }
    private static void testCase3() {
        List<Product> products = Arrays.asList(
                new Product("Sneakers", "Footwear", 150),
                new Product("Boots", "Footwear", 150),
                new Product("Sandals", "Footwear", 80)
        );
        runTest(products);
    }
    private static void testCase4() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200)
        );
        runTest(products);
    }
    private static void testCase5() {
        List<Product> products = new ArrayList<>();
        runTest(products);
    }
}
