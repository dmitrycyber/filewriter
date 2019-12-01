import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductConsoleReader {
    public Map<Product, Integer> createProductsFromConsole() {
        Map<Product, Integer> map = new TreeMap<>();
        boolean isExit = false;
        try(Scanner scanner = new Scanner(System.in)){
            do{
                try{
                    System.out.println("enter id:");
                    int id = scanner.nextInt();
                    System.out.println("enter name:");
                    String name = scanner.next();
                    System.out.println("enter price:");
                    int price = scanner.nextInt();
                    Product product = new Product(id, name, price);
                    map.put(product, price);
                    System.out.println("Do you want to exit?");
                    String s = scanner.next();
                    if (s.equals("yes")){
                        isExit = true;
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Are u sure???");
                    scanner.nextLine();
                }
            }
            while (!isExit);
        }
        return map;
    }
}
