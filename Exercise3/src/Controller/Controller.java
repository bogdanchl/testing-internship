package Controller;

import Model.Product;
import Repository.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    public void addProduct(Product product){
        repository.add(product);
    }

    public void deleteProduct(String name){
        repository.delete(name);
    }

    public void updateProduct(String name, Product product){
        repository.update(name,product);
    }

    public ArrayList<Product> readFile(){
        return repository.readFile();
    }
}
