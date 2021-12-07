import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Pricing {
    private String[] carTypes = new String[]{"SEDAN", "COUPE", "MINIVAN"}; //keep the car types in an array of strings
    // keep the corresponding prices per car price in a two dimensional array
    private Integer[][] parkingPrices = {{10000, 5000, 15000, 9350, 8400, 8400}, {12000, 8500, 13500, 7460, 8400, 8000}, {7500, 350, 11000, 5600, 8400, 8000}};

    public Pricing() {
    }

    public String[] getCarTypes() {
        return carTypes;
    }

    public Integer[][] getParkingPrices() {
        return parkingPrices;
    }
    // function to calculate the price when given the dates and carTypeindex
    public Double calculatePrice(Date from, Date to, int carTypeIndex) {
        Double price = 0D; // variable to keep the total price
        Long currentDay = from.getTime(); // variable to keep the time we are on while adding the prices
        Long endingTime = to.getTime(); // variable to keep the endingtime

        // go from starting day to ending day calculating each days price and adding it to the total price
        while (currentDay <= endingTime) {
            int day = new Date(currentDay).getDay(); // get the day of this date
            Double vat = day == 3 ? 0.05 : 0.18; // set vat to 0.05 if the day is wednesday else 0.18
            /*
                get the bill for the current day from the parkingPrices array
                if the day is 0 (sunday) then the index will be 5 (remember wednesday was skipped in prices)
                else second index will be day-1
                keep in mind that the date.getDay() returns
                0 - sunday,1 - monday, 2 - tuesday, 3 - wednesday, 4- thursday, 5 - friday, 6- saturday
             */
            int bill = parkingPrices[carTypeIndex][day == 0 ? 5 : day - 1];

            // handle bills for wednesday
            if (day == 3) {
                // Wednesday is a bonus day for everyone on all car types and it is subject to 0.05 income tax on
                //each invoice to the customer based on the lowest price for the car type across all days of the
                //week (so we will use the lowest price accross all days in the given car type)
                bill = carTypeIndex == 0 ? 5000 :carTypeIndex == 1 ? 7460 : 350;
            }
            price += bill + bill*vat; // price =  price + (bill + bill*vat)

            // move to the next day
            currentDay = new Date(currentDay + 86400000).getTime();
        }


        return price;
    }
    // save the invoice to a file
    public void saveInvoice(String invoice){
        try {
            FileWriter myWriter = new FileWriter("invoice.txt");
            myWriter.write(invoice);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
