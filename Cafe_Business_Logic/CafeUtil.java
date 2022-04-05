import java.util.ArrayList;
public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (var i = 0; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems) {
        double sum = 0;
        for (double lineItem : lineItems) {
            sum += lineItem;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        int number = 0;
        for (String menuItem : menuItems) {
        
            System.out.println(number + " " + menuItem);
            number++;
        
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName + "!");
        customers.add(userName);
        System.out.println("Hi " + userName +"! there are " + (customers.size()-1) + " people ahead of you." );
        System.out.println(customers);
    }
}
