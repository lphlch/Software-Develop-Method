import Machine.OrderingMachine;

import java.util.Scanner;

public class Customer {

    public static void main(String[] args) {
        OrderingMachine orderingMachine = new OrderingMachine();
        orderingMachine.showMenu();
        Scanner scanner = new Scanner(System.in);
        String items = scanner.nextLine();

        orderingMachine.buy(items);
    }
}
