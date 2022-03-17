package Machine;

import Food.Food;

public class FoodMaker {
    public boolean makeFood(Food food) {
        if (food.make()) {
            System.out.println("Done!");
            return true;
        }
        return false;
    }
}
