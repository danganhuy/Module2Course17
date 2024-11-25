import sun.net.www.content.text.Generic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pen", 100, "aaa", "bbb"));
        products.add(new Product(2, "Pant", 250, "aaa", "bbb"));
        products.add(new Product(3, "Phone", 5980, "aaa", "bbb"));
        products.add(new Product(4, "Pendant", 4920, "aaa", "bbb"));

        writeDataToFile("file\\product.txt" , products);

        List<Product> products2 = readDataFromFile("file\\product.txt");
        for (Product product : products2) {
            System.out.println(product);
        }
    }

    public static void writeDataToFile(String path, List<Product> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
