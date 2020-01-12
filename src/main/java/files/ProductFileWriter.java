package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ProductFileWriter {


    public void writeMapToFile(Map<Product, Integer> givenMap, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            for(Map.Entry<Product, Integer> entry : givenMap.entrySet()){
                bufferedWriter.append(entry.getKey().getId() + "," + entry.getKey().getName() + "," + entry.getKey().getPrice() + "\n");
            }
        }
        catch (IOException e){
            e.getStackTrace();
        }
    }
}
