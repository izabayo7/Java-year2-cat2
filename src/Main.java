import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to the car rentals app:\n");

            Date from = null;
            Date to = null;
            String customer_name = null;
            Pricing pricingEngine = new Pricing();
            String[] carTypes = pricingEngine.getCarTypes();
            int choosedCartype;
            int times;

            Scanner input = new Scanner(System.in);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Enter check-in date (dd/mm/yy):");
            String user_input = input.nextLine();
            if (null != user_input && user_input.trim().length() > 0) {
                from = format.parse(user_input);
            }
            System.out.println("Enter check-out date (dd/mm/yy):");
            user_input = input.nextLine();
            if (null != user_input && user_input.trim().length() > 0) {
                to = format.parse(user_input);
            }

            System.out.println("Enter your names:");
            customer_name = input.nextLine();

            String invoice = "   names          : "+customer_name;
            invoice+="\n   check-in date  : "+from;
            invoice+="\n   check-out date : "+to;

            int continueSelectingCars = 1;

            while(continueSelectingCars == 1) {

                System.out.println("Choose a car type:");
                for (int i = 0; i < carTypes.length; i++) {
                    System.out.println((i + 1) + ". " + carTypes[i] + "\n");
                }
                System.out.println("Enter your choice:");
                choosedCartype = input.nextInt();
                choosedCartype--;
                System.out.println("Enter the number of times you want to borrow the " + carTypes[choosedCartype] + " for this rental period:");
                times = input.nextInt();
                Double price = pricingEngine.calculatePrice(from, to, choosedCartype);


                invoice += "\n   car type       : " + carTypes[choosedCartype];
                invoice += "\n   Price          : " + price * times;

                System.out.println("Do you want to add another car type ?");
                System.out.println(" 1. yes");
                System.out.println(" 2. no");
                continueSelectingCars = input.nextInt();
            }

//            System.out.print(invoice);

            pricingEngine.saveInvoice(invoice);
            System.out.println("\nThank you for using this app !!");
        }
        catch (ParseException e){
            System.out.println(e);
        }
    }
}
