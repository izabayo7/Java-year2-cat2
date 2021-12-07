import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to the car rentals app:\n");

            Date from = null; // variable to keep the starting date
            Date to = null; // variable to keep the ending date
            String customer_name = null; // variable to keep the customer name
            Pricing pricingEngine = new Pricing(); // instantiating the pricing class
            String[] carTypes = pricingEngine.getCarTypes(); // varibale carTypes to keep the available car types
            int choosedCartype; // variable to keep the choosed car type
            int times; // varibale to keep the number of times one want to borrow the selected cartype at the specified rental period

            Scanner input = new Scanner(System.in); // make a scanner which will help us to get user input
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); // set preferred date format

            // get the starting date
            System.out.println("Enter check-in date (dd/mm/yy):");
            String user_input = input.nextLine();
            if (null != user_input && user_input.trim().length() > 0) {
                from = format.parse(user_input);
            }
            // get the ending date
            System.out.println("Enter check-out date (dd/mm/yy):");
            user_input = input.nextLine();
            if (null != user_input && user_input.trim().length() > 0) {
                to = format.parse(user_input);
            }

            // get the customer names
            System.out.println("Enter your names:");
            customer_name = input.nextLine();

            String invoice = "   names          : "+customer_name;
            invoice+="\n   check-in date  : "+from;
            invoice+="\n   check-out date : "+to;

            int continueSelectingCars = 1; // variable to help us to track if user want to add more car types

            // allow user to borrow more than one vehicle types
            while(continueSelectingCars == 1) {

                System.out.println("Choose a car type:");
                for (int i = 0; i < carTypes.length; i++) {
                    System.out.println((i + 1) + ". " + carTypes[i] + "\n");
                }
                System.out.println("Enter your choice:");
                choosedCartype = input.nextInt();
                choosedCartype--;
                // allow user to borrow one vehicle type more than once for the same rental period
                System.out.println("Enter the number of times you want to borrow the " + carTypes[choosedCartype] + " for this rental period:");
                times = input.nextInt();
                Double price = pricingEngine.calculatePrice(from, to, choosedCartype);

                // add the vehicle and price to the invoice
                invoice += "\n   car type       : " + carTypes[choosedCartype];
                invoice += "\n   Price          : " + price * times;

                System.out.println("Do you want to add another car type ?");
                System.out.println(" 1. yes");
                System.out.println(" 2. no");
                continueSelectingCars = input.nextInt();
            }

//            System.out.print(invoice); // print the invoice
            // save the invoice in a file
            pricingEngine.saveInvoice(invoice);
            System.out.println("\nThank you for using this app !!");
        }
        catch (ParseException e){
            System.out.println(e);
        }
    }
}
