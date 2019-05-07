package Repository;

import Model.Product;

import java.io.*;
import java.util.ArrayList;

public class Repository {
    private String filename;

    public Repository(String filename){
        this.filename = filename;
    }

    public void add(Product product){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.append(product.getName()+","+product.getPrice()+","+product.getQuantity()+System.getProperty("line.separator"));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String name){
        try {
            String currentLine;
            boolean found = false;
            File file = new File(filename);
            File temp = new File("temp.txt");
            file.setWritable(true);
            temp.setWritable(true);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
            while ((currentLine = reader.readLine()) != null) {
                String[] line = currentLine.split(",");
                if (line[0].equals(name)) {
                    found = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            /*System.out.println(file.exists());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
            System.out.println(file.canExecute());
            System.out.println(temp.exists());
            System.out.println(temp.canRead());
            System.out.println(temp.canWrite());
            System.out.println(temp.canExecute());*/
            reader.close();
            reader=null;
            writer.close();
            writer=null;
            System.gc();
            boolean del = file.delete();
            boolean ren = temp.renameTo(file);
            /*System.out.println(del);
            System.out.println(ren);*/
            if (!del) System.out.println("Cannot delete file.");
            if (!ren) System.out.println("Cannot overwrite file.");
            else if (!found) System.out.println("Product was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String name, Product newProduct) {
        try {
            String currentLine;
            boolean found = false;
            File file = new File(filename);
            File temp = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
            while ((currentLine = reader.readLine()) != null) {
                String[] line = currentLine.split(",");
                if (line[0].equals(name)) {
                    found = true;
                    writer.write(newProduct.getName() + "," + newProduct.getPrice() + "," + newProduct.getQuantity() + System.getProperty("line.separator"));
                }
                else {writer.write(currentLine + System.getProperty("line.separator"));}
            }
            reader.close();
            reader=null;
            writer.close();
            writer=null;
            System.gc();
            if (!file.delete()) System.out.println("Cannot delete file.");
            if (!temp.renameTo(file)) System.out.println("Cannot overwrite file.");
            else if (!found) System.out.println("Product was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> readFile(){
        ArrayList<Product> products = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            line = reader.readLine();
            while(line!=null){
                String[] attributes = line.split(",");
                Product product = new Product();
                product.setName(attributes[0]);
                product.setPrice(Integer.parseInt(attributes[1]));
                product.setQuantity(Integer.parseInt(attributes[2]));
                products.add(product);
                line = reader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }
}
