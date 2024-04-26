import com.mysql.cj.xdevapi.Client;

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
    static HashTable<String, ContactDetails> contacts = new HashTable<>(10);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Vehicle_Type = Vehicle_Type();
        User.Data_user(sc , formattedDateTime);
        if("мотоцикл".equalsIgnoreCase(Vehicle_Type)){
            Motorcycle motorcycle = new Motorcycle();
            motorcycle.inputData(sc);
            User.ToHashTable(contacts , Vehicle_Type , "0");
        }
        else{
            Car car = new Car();
            car.inputData(sc);
            User.ToHashTable(contacts , Vehicle_Type , car.getNumOfDoors());
        }

        System.out.println("All Clients");
        for(String key: contacts.ketSet()){
            System.out.println("Clients: " + key);
            ContactDetails details = contacts.get(key);
            System.out.println(details);
            System.out.println();
        }
    }

    public static String Vehicle_Type() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}