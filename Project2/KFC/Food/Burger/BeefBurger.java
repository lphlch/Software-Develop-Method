package Food.Burger;

public class BeefBurger extends Hamburger {

    @Override
    public boolean cook() {
        System.out.println("Cook BeefBurger......");
        return true;
    }

    @Override
    public boolean combination() {
        System.out.println("Combination BeefBurger......");
        return true;
    }
}

