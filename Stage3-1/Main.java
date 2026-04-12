//Kobe Smith on 4/1/2026
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();

        Menu menu = new Menu(app);
        menu.start(app);
    }
}