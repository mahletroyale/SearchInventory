
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inventory {

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> products = new ArrayList<>();

        try {
            FileReader file = new FileReader("inventory.csv");
            BufferedReader reader = new BufferedReader(file);

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                Product product = new Product(id, name, price);

                products.add(product);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
        }

        Collections.sort(products,
                Comparator.comparing(Product::getName));

        return products;
    }
}

