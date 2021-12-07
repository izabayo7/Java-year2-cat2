import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Pricing {
    private String[] carTypes = new String[]{"SEDAN", "COUPE", "MINIVAN"};
    private Integer[][] parkingPrices = {{10000, 5000, 15000, 9350, 8400, 8400}, {12000, 8500, 13500, 7460, 8400, 8000}, {7500, 350, 11000, 5600, 8400, 8000}};

    public Pricing() {
    }

    public String[] getCarTypes() {
        return carTypes;
    }

    public Integer[][] getParkingPrices() {
        return parkingPrices;
    }

    public Double calculatePrice(Date from, Date to, int carTypeIndex) {
        Double price = 0D;
        Long currentDay = from.getTime();
        Long endingTime = to.getTime();

        while (currentDay <= endingTime) {
//            System.out.println(new Date(currentDay)+"\n");
            int day = new Date(currentDay).getDay();
            Double vat = day == 3 ? 0.05 : 0.18;
//            System.out.println(vat+"\n");
            int bill = parkingPrices[carTypeIndex][day == 0 ? 5 : day - 1];
            if (day == 3) {
                bill = carTypeIndex == 0 ? 5000 :carTypeIndex == 1 ? 7460 : 350;
            }
//            System.out.println(bill+"\n");
            price += bill + bill*vat;
//            System.out.println(price+"\n");
            currentDay = new Date(currentDay + 86400000).getTime();
        }


        return price;
    }
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
