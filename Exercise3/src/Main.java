import Controller.Controller;
import Repository.Repository;
import View.UI;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository("file.txt");
        Controller controller = new Controller(repository);
        UI ui = new UI(controller);
        ui.start();
    }
}
