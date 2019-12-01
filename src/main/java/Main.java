public class Main {
    public static final String FILENAME = "test.txt";

    public static void main(String[] args){
        ProductFileWriter productFileWriter = new ProductFileWriter();
        ProductConsoleReader productConsoleReader = new ProductConsoleReader();
        productFileWriter.writeMapToFile(productConsoleReader.createProductsFromConsole(), FILENAME);
    }
}
