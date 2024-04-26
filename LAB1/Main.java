import java.util.Scanner;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;





public class Main {
    static Instant StartInstant = Instant.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(StartInstant, ZoneId.of("UTC"));
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static String formattedDateTime = zonedDateTime.format(formatter);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Vehicle_Type = Vehicle_Type();
        //        User.Data_user(sc , formattedDateTime);
        if("Мотоцикл".equals(Vehicle_Type)){
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.inputData(sc);
        }
        else{
            Car car = new Car();
            car.inputData(sc);

        }
    }

    public static String Vehicle_Type() {

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}