package Machine;


public class OrderingMachine extends Processer implements Order {
    private static final int MAX_ITEM = 26;
    private final int menuCount = Menu.getItems().size();

    public void showMenu() {
        // show menu
        System.out.println("------ KFC Menu ------");
        char count = 'a';
        System.out.print("Total items: " + menuCount + '\n');
        for (String item :
                Menu.getItems()) {
            System.out.print(count + ": " + item + '\n');
            count++;
        }
        System.out.println("Enter the front letter to select food:");
    }

    @Override
    public boolean buy(String items) {
        System.out.println("Order Received.");
        int[] temp = new int[MAX_ITEM];

        // classify items
        for (int i = 0; i < items.length(); i++) {
            temp[items.charAt(i) - 'a']++;
        }
        String order = "";
        char count = 'z';
        for (int i = MAX_ITEM - 1; i >= 0; i--) {
            if (temp[i] != 0 && i > menuCount + 1) {
                return false;
            }
            while (temp[i] != 0) {
                order = count + order;
                temp[i]--;
            }
            order = ',' + order;
            count--;
        }

        super.orderProcess(order);

        System.out.println("Order Finished!");

        return true;
    }
}
