package Machine;

import Food.Burger.BeefBurger;
import Food.Burger.ChickenBurger;
import Food.Burger.FishBurger;
import Food.Drink.Coffee;
import Food.Drink.Cola;
import Food.Drink.Sprite;
import Food.Food;

public class Processer {
    private final FoodMaker foodMaker = new FoodMaker();

    public boolean orderProcess(String items) {
        System.out.println("Processing Order......");
        String[] split = items.split(",");
        for (String item :
                split) {
            Food food;
            if (item.length() != 0) {
                // transform from food ID to food object
                switch (item.charAt(0)) {
                    case 'a': {
                        food = new ChickenBurger();
                        break;
                    }
                    case 'b': {
                        food = new BeefBurger();
                        break;
                    }
                    case 'c': {
                        food = new FishBurger();
                        break;
                    }
                    case 'd': {
                        food = new Cola();
                        break;
                    }
                    case 'e': {
                        food = new Coffee();
                        break;
                    }
                    case 'f': {
                        food = new Sprite();
                        break;
                    }
                    default:
                        return false;
                }

                // if food make not success
                if (!this.foodMake(food, item.length())) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean foodMake(Food food, int amount) {
        for (int i = 0; i < amount; i++) {
            if (!foodMaker.makeFood(food)) {
                return false;
            }
        }
        return true;
    }
}
