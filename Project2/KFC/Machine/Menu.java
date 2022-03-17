package Machine;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private static final Menu menu = new Menu();
    private static List<String> items;

    private Menu() {
        items = Arrays.asList("Chicken Burger", "Beef Burger", "Fish Burger", "Cola", "Coffee", "Sprite");
    }

    public static List<String> getItems() {
        return items;
    }

    public static Menu getMenu() {
        return menu;
    }
}
