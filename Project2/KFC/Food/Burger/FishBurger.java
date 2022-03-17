package Food.Burger;

public class FishBurger extends Hamburger {


    @Override
    public boolean cook() {
        System.out.println("Cook FishBurger......");
        return true;
    }

    @Override
    public boolean combination() {
        System.out.println("Combination FishBurger......");
        return true;
    }
}

