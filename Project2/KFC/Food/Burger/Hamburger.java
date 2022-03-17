package Food.Burger;

import Food.Food;

abstract class Hamburger extends Food {
    public boolean make() {
        System.out.println("Start Making Hamburger......");
        if (cook()) {
            return combination();
        }
        return false;
    }

    abstract public boolean cook();

    abstract public boolean combination();
}
