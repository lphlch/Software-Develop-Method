package Food.Burger;

public class ChickenBurger extends Hamburger {

    @Override
    public boolean cook() {
        System.out.println("Cook ChickenBurger......");
        return true;
    }

    @Override
    public boolean combination() {
        System.out.println("Combination ChickenBurger......");
        return true;
    }
}
