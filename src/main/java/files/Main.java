package files;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String FILENAME = "test.txt";

    public static void main(String[] args) {
        List<Product> productList = generateProducts();

        List<String> filteredNamesOfProduct = productList
                .stream()
                .filter(product -> product.getPrice() > 500)
                .sorted((product1, product2) -> product1.getName().compareTo(product2.getName()))
                .map(product -> product.getName())
                .peek(product -> System.out.println(product))
                .collect(Collectors.toList());


        System.out.println(productList);
        System.out.println(filteredNamesOfProduct);
    }

    public static List<Product> generateProducts() {
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product(1, "Logitec", 123));
        listOfProducts.add(new Product(2, "Qwerty", 645));
        listOfProducts.add(new Product(3, "A4Tech", 3));
        listOfProducts.add(new Product(4, "Fqwel", 7567));
        listOfProducts.add(new Product(5, "Fdgh", 2312));
        return listOfProducts;
    }
}
