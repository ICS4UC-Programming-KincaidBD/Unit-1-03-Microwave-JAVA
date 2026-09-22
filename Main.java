//A small microwave is being built just to reheat lunch items. 
//Ask the user which item they want to eat and the quantity (max 3 and they must all be the same items). 
//The engineers have figured out the correct time to heat 1 of each item. 
//It is also known that if you have 2 of them, you should increase the time by 50% and if you have 3 of them you increase it by 100%. 
//Calculate and display the amount of time it takes to heat each item given the quantity specified by the user. Use the following items:

//sub - 1 minute
//pizza - 45 seconds
//soup - 1 minute 45 seconds

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner object
        Scanner scanner = new Scanner(System.in);

        // prompt user for item and quantity
        System.out.print("Enter the item you want to heat (sub, pizza, soup): ");
        // globalize variables to be used in a try and catch blocck and still be able to use in if else statements
        String item;
        int quantity;
        try {
            item = scanner.nextLine().toLowerCase();
            System.out.print("enter the quantity (1-3): ");
            quantity = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("You have entered a unrecognized input");
            scanner.close();
            return;
        }

        // close scanner for no resource leak error
        scanner.close();

        // calculate heating time based on item and quantity
        int time = 0;
        if (item.equals("sub")) {
            time = 60; // 1 minute
        } else if (item.equals("pizza")) {
            time = 45; // 45 seconds
        } else if (item.equals("soup")) {
            time = 105; // 1 minute 45 seconds
        } else {
            System.out.println("not an available food");
            return;
        }

        // apply time multiplier
        if (quantity == 2) {
            time = (int) (time * 1.5);
        } else if (quantity == 3) {
            time = (int) (time * 2);
        }

        // display the result, convert the time to mins and secs
        int time_in_mins = time / 60;
        int time_in_secs = time % 60;
        System.out.printf("The heating time for %d %s(s) is %d minutes and %d seconds.", quantity, item, time_in_mins,
                time_in_secs);
        
    }
}
