package View;

import Controller.Controller;
import Model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Controller controller;

    public UI(Controller controller){
        this.controller = controller;
    }

    private void printMenu(){
        String menu="------Store------\n";
        menu+= "1. Display all products.\n";
        menu+= "2. Add product.\n";
        menu+= "3. Delete product.\n";
        menu+= "4. Update product.\n";
        menu+= "0. Exit.\n";
        menu+= "-----------------\n";
        menu+= "Please enter your option: ";
        System.out.println(menu);
    }

    private void printAll(){
        ArrayList<Product> products = controller.readFile();
        for(Product product: products){
            System.out.println(product.toString());
        }
    }

    private Product readProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product: ");
        String name = scanner.next();
        System.out.println("Enter the price of the product: ");
        Integer price = scanner.nextInt();
        System.out.println("Enter the quantity of the product: ");
        Integer quantity = scanner.nextInt();
        return new Product(name,price,quantity);
    }

    private String readName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product: ");
        String name = scanner.next();
        return name;
    }

    public void start(){
        try{
            boolean keepAlive=true;
            while(keepAlive){
                printMenu();
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                switch (option){
                    case 1:
                        printAll();
                        break;
                    case 2:
                        Product product = readProduct();
                        controller.addProduct(product);
                        break;
                    case 3:
                        String name = readName();
                        controller.deleteProduct(name);
                        break;
                    case 4:
                        String name2=readName();
                        Product newProduct = readProduct();
                        controller.updateProduct(name2,newProduct);
                        break;
                    case 0:
                        keepAlive=false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
